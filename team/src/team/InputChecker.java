package team;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	public List<String> docheck(String propertyName, String value, int minLength, int maxLength, boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana, boolean availableHalfWidthDigits, boolean availableHalfWidthSymbols, boolean availableKatakana, boolean availableFullWidthSymbols){

		List<String> resultList = new ArrayList<String>();
		List<String> messageList = new ArrayList<String>();

		if(StringUtils.isEmpty(value)){
			resultList.add(propertyName + "を入力してください");
		}

		if(value.length() < minLength || value.length() > maxLength){
			resultList.add(propertyName + "は、" + minLength + "以上" + maxLength + "以下で入力してください");
		}

		String regularExpression = "";
		String errorExpression = "";

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigits || availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols){
			regularExpression += "[^";
		}

		if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigits) || !(availableHalfWidthSymbols) || !(availableKatakana) || !(availableHalfWidthSymbols)){
			errorExpression += "[^";
		}

		if(availableAlphabeticCharacters){
			regularExpression += "a-zA-Z";
			messageList.add( "半角英字");
		}else{
			errorExpression += "a-zA-Z";
		}

		if(availableKanji){
			regularExpression += "一-龯";
			messageList.add("漢字");
		}else{
			errorExpression += "一-龯";
		}

		if(availableHiragana){
			regularExpression += "ぁ-ん";
			messageList.add("ひらがな");
		}else{
			errorExpression += "ぁ-ん";
		}

		if(availableHalfWidthDigits){
			regularExpression += "0-9";
			messageList.add("半角数字");
		}else{
			errorExpression += "0-9";
		}

		if(availableHalfWidthSymbols){
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~";
			messageList.add("半角記号");
		}else{
			errorExpression += "@.,;:!#$%&'*+-/=?^_`{|}~";
		}

		if(availableKatakana){
			regularExpression += "ァ-ヺ";
			messageList.add("カタカナ");
		}else{
			errorExpression += "ァ-ヺ";
		}

		if(availableFullWidthSymbols){
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
			messageList.add("全角記号");
		}else{
			errorExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
		}

		String message = "";
		for(int i=0; i<messageList.size(); i++){
			if(i == 0){
				message += messageList.get(i).toString();
			}else{
				message += "、" + messageList.get(i).toString();
			}
		}

		if(errorExpression.equals("")){
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		}else if(value.matches(regularExpression) || !(value.matches(errorExpression)) && value.equals("")){
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		}
		return resultList;

	}

	public List<String> doPasswordCheck(String password, String reConfirmationPassward){
		List<String> resultList = new ArrayList<String>();
		if(!(password.equals(reConfirmationPassward))){
			resultList.add("入力されたパスワードが異なります。");
		}
		return resultList;
	}

}

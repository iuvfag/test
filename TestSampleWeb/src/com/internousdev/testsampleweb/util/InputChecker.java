package com.internousdev.testsampleweb.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	/**
	 * このプログラムは渡された値を正規表現か検証するもの
	 * doCheckに9つの引数を渡し、後半部分に当てはまる形式にtrueを入れる
	 * emailを判別したいのであれば英字、数字、記号を含むため下記のようになる
	 * 例(質問の内容、値、最小文字数、最大文字数、true, false, false, true, true)となる
	 * 結果はList形式で渡されることに注意
	 * このメソッドを呼び出す側も戻り値はList型で受け取ること
	 */

	public List<String> doCheck(String propertyName,  String value, int minLength, int maxLength, boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana, boolean availableHalfWidthDigit, boolean availableHalfWidthSymbols, boolean availableKatakana, boolean availableFullWidthSymbols){

		//検証した結果を入れるList
		List<String> stringList = new ArrayList<String>();
		//画面に表示したいメッセージを代入するList型変数
		List<String> characterTypeList = new ArrayList<String>();

		//入力欄が空かどうかを検証する
		if(StringUtils.isEmpty(value)){
			/**
			 * StringUtilは文字列が空欄でも例外が発生しない
			 * 文字列の判定など幅広く使えるメソッド
			 * 今回は空欄かどうかを判別するisEmptyを利用
			 */
			stringList.add(propertyName + "を入力して下さい。");
		}

		//入力欄が最小文字数以上、最大文字数以下かどうかを検証する
		if(value.length() < minLength || value.length() > maxLength){
			stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力して下さい。");
		}
		/**
		 * 渡されたvalueが最小文字数以下、あるいは最大文字数以上の場合は
		 * stringListにメッセージを追加
		 */

		//////////入力された文字のタイプから何を判別するか決める//////////
		String regularExpression = "";
		String errorExpression = "";

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols){
			regularExpression = "[^";
		}
		if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) || !(availableHalfWidthSymbols) || !(availableKatakana) || !(availableFullWidthSymbols)){
			errorExpression = "[^";
		}

		if(availableAlphabeticCharacters){
			regularExpression += "a-zA-Z";
			characterTypeList.add("半角英字");
		}else{
			errorExpression += "a-zA-Z";
		}

		if(availableKanji){
			regularExpression += "一-龯";
			characterTypeList.add("漢字");
		}else{
			errorExpression += "一-龯";
		}

		if(availableHiragana){
			regularExpression += "ぁ-ん";
			characterTypeList.add("ひらがな");
		}else{
			errorExpression += "ぁ-ん";
		}

		if(availableHalfWidthDigit){
			regularExpression += "0-9";
			characterTypeList.add("半角数字");
		}else{
			errorExpression += "0-9";
		}

		if(availableHalfWidthSymbols){
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~";
			characterTypeList.add("半角記号");
		}else{
			errorExpression += "@.,;:!#$%&'*+-/=?^_`{|}~";
		}

		if(availableKatakana){
			regularExpression += "ァ-ヺ";
			characterTypeList.add("カタカナ");
		}else{
			errorExpression += "ァ-ヺ";
		}

		if(availableFullWidthSymbols){
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
			characterTypeList.add("全角記号");
		}else{
			errorExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
		}

		if(!StringUtils.isEmpty(regularExpression)){
			regularExpression += "]+";
		}

		if(!StringUtils.isEmpty(errorExpression)){
			errorExpression += "]+";
		}
		///////////////////////ここまで/////////////////////


		//判別した結果に応じてエラーメッセージを返す
		String characterType = "";
		for(int i=0; i<characterTypeList.size(); i++){
			if(i == 0){
				characterType += characterTypeList.get(i).toString();
			}else{
				characterType += "、" + characterTypeList.get(i).toString();
			}
		}

		if(errorExpression.equals("")){
			if(value.matches(regularExpression)){
				stringList.add(propertyName + "は" + characterType + "で入力して下さい。");
			}
		}else{
			if(value.matches(regularExpression) || (!value.matches(errorExpression) && !value.equals(""))){
				stringList.add(propertyName + "は" + characterType + "で入力してください。");
			}
		}

		return stringList;


	}

	public List<String> doPasswordCheck(String password, String reConfirmationPassword){
		List<String> stringList = new ArrayList<String>();
		if(!(password.equals(reConfirmationPassword))){
			stringList.add("入力されたパスワードが異なります。");
		}
		return stringList;
	}

}

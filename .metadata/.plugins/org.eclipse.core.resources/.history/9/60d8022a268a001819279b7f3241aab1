package com.internousdev.testsampleweb.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	/**
	 * このプログラムは渡された値を正規表現化検証するもの
	 * doCheckに9つの引数を渡し、後半部分に当てはまる形式にtrueを入れる
	 * emailを判別したいのであれば英字、数字、記号を含むため以下のようになる
	 * 結果はList形式で渡されることに注意
	 */

	public List<String> doCheck(String propertyName,  String value, int minLength, int maxLength, boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana, boolean availableHalfWidthDigit, boolean availableHalfWidthSymbols, boolean availableKatakana, boolean availableFullWidthSymbols){

		//検証した結果を入れるList
		List<String> stringList = new ArrayList<String>();
		List<String> characterTypeList = new ArrayList<String>();

		//入力欄が空かどうかを検証する
		if(StringUtils.isEmpty(value)){
			/**
			 * StringUtilは文字列が空欄でも例外が発生しない
			 * 文字列の判定など幅広く使えるメソッド
			 * 今回は空欄かどうかを判別する
			 * isEnptyを利用する
			 */
			stringList.add(propertyName + "を入力して下さい。");
		}

		//入力欄が最小文字数以上、最大文字数以下かどうかを検証する
		if(value.length() < minLength || value.length() > maxLength){
			stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力して下さい。");
		}

		//////////入力された文字のタイプから何を判別するか決める//////////
		String regularExpression = "";
		String errorExpression = "";

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols){
			regularExpression = "[^";
		}
		if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) ||!(availableHalfWidthDigit) || !(availableHalfWidthSymbols) || !(availableKatakana) || !(availableFullWidthSymbols)){
			errorExpression = "[^";
		}

		if(availableAlphabeticCharacters){
			regularExpression += "a-zA-Z";
			characterTypeList.add("半角英字");
		}else{
			errorExpression += "a-zA-Z";
		}

		if(availableKanji){
			regularExpression += "";
		}


	}

}

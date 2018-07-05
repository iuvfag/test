package com.internousdev.template.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate(){
		Date date = new Date();
		/**
		 * 日付の取得、計算にはDateクラスを利用する
		 * インスタンス生成時点で現在の日時が返される
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		/**
		 * 日付を見やすく表示するためのクラス
		 * SimpleDateFormatを利用
		 */

		return simpleDateFormat.format(date);
		/**
		 * 見やすくフォーマットしたものを返す
		 */
	}

}

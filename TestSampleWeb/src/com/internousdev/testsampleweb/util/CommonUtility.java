package com.internousdev.testsampleweb.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtility {

	public String getRandomValue(){
		String value="";
		double d;
		for(int i=1; i<=16; i++){
			d = Math.random() * 10;
			value = value + ((int)d);
			/**
			 * .random()
			 * 0.0以上1.0未満の数字を生み出すメソッド
			 * それを10倍したものをvalueにプラスして返す
			 */
		}
		return value;
	}

	//渡されたString型の変数をひたすらカンマで区切っていくメソッド
	public String[] parseArrayList(String s){
		return s.split(", ",0);
		/**
		 * .split
		 * 文字列の区切りに利用するメソッド
		 * .split("区切り文字",分割する回数)と記述する
		 * 分割する回数を負の数に指定すると回数制限なく要素の数だけ分割を続ける
		 * (要素が空欄であっても続ける)
		 * 0を指定すると分割された後で項目が空の場合は分割はしなくなる
		 * (要素の空欄が続いて終わる場合はその空欄は無視される)
		 *
		 * 今回はコンマのある場所で区切って要素が空欄になるまでは分割を続ける
		 */
	}

	public <E> List<List<E>> devideList(List<E> list, int size){
		if(list == null || list.isEmpty() || size<=0){
			return null;
		}

		int block = list.size() / size + (list.size() % size > 0 ? 1 : 0);
		/**
		 * listの要素数をsizeで割った値が0以上
		 * (割り切れずに値が残ってしまう場合)
		 * の場合は1を、そうでない場合は0をプラス
		 */
		List<List<E>> devideList = new ArrayList<List<E>>(block);

		for(int i=0; i<block; i++){
			int start = i * size;
			int end = Math.min(start + size, list.size());
			devideList.add(new ArrayList<E>(list.subList(start, end)));
		}
		return devideList;

	}

}


public class TryAndError {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ



		//float形について
		float a1 = (float)10/3;
		System.out.println(a1);


		//String型における＝の使い方
		String b = "山田";

		if(b.equals("山田")){
			System.out.println(b + "さん");
		//String型で＝は使えないため、「.equals」で代用

		//if文
		int number = 88;
		if(number <= 100){
			if(number < 20){
				System.out.println("未成年");
			}else if(number == 77){
				System.out.println("喜寿");
			}else if(number == 88){
				System.out.println("米寿");
			}else{
				System.out.println("成人");
			}
		}


		//switch文
		int a = 1;

		switch(a){
		case 0:
			System.out.println("aは0に等しい");
			break;

		case 1:
			System.out.println("aは1に等しい");
			break;

		default:
			System.out.println("aは1でも0でもない");
		}


		//配列について
		String[] name = {"田中","高橋","斉藤"};
		System.out.println(name[2]);
		/*
		 * String[] name = new String[3];
		 *
		 * name[0] = "田中";
		 * name[1] = "高橋";
		 * name[2] = "斉藤";
		 *
		 * も同じ意味！！
		 */

		String[][] country = {
				{"日本","タイ"},
				{"アメリカ","ブラジル"},
				{"フランス","ロシア"}
		};

		System.out.println(country[0][1]);
		/*
		 * String country = new String[3][2];
		 *
		 * country[0][0] = "日本";
		 * country[0][1] = "タイ";
		 * country[1][0] = "アメリカ";
		 * country[1][1] = "ブラジル";
		 * country[2][0] = "フランス";
		 * country[2][1] = "ロシア";
		 *
		 * System.out.println[0][1];
		 *
		 * も同じ意味！！
		 */


		// 条件演算子
		int aa = 10;
		String bb =	aa >= 0 ? "プラス":"マイナス";
		//実行結果が文字列であるため、
		//String型の変数に入れないとエラーが起こる！
		System.out.println(bb);



		//do while文
		int s = 1;
		do{
			System.out.println(s);
			s--;
		}while(s > 1);
		//while内の条件がfalseであったとしても、
		//必ず1度は処理が行われる！



		}
	}

}

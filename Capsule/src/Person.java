
public class Person {

	private String name = null;
	private int age = 0;
	/*
	 * フィールド変数を定義
	 * ここがprivateとなっているため
	 * name,ageがクラス内にしか公開されない。
	 *
	 * コンストラクタ内のnameに代入された値がthis.nameに代入された場合、
	 * nameが外部から不可視となってしまう。
	 */



	public Person(){

	}

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	/*
	 * コンストラクタを定義
	 *インスタンス化する際の窓口
	 *カプセル化されている場合は＝左側のthis.が不可視になっているため、
	 *代入はできても外部への表示や外部からの変更はできない
	*/

	public String getName(){
		//publicなので外部から見れる
		return this.name;
		//this.nameを返す
	}
	//getter

	public void setName(String name){
		this.name = name;
	}
	//setter


	public int getAge(){
		return this.age;
	}

	public void setAge(int age){
		this.age = age;
	}

}

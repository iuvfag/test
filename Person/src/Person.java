//原本
public class Person {

	public String name = null;
	//String型の変数nameを用意、初期値としてnullを代入
	public int age = 0;
	//int型の変数ageを用意、初期値として0を代入
	public String phoneNumber = null;
	public String address = null;

	public Person(){

	}
	/*ほかにコンストラクタを定義する場合は、
	 * この「デフォルトコンストラクタ」を書いておく！
	 */

	public Person(String name, int age){
		this.name = name;
		this.age = age;
		/*最初に宣言したnameとageに新しくnameとageの代入
		 * このnameとageはtestクラスから渡される
		 *
		 */
	}

	public Person(String name){
		this.name = name;
		this.age = 0;
	}

	public Person(int age){
		this.name = "名前なし";
		this.age = age;
	}

	public Person(int age, String name){
		this.name = name;
		this.age = age;
	}

	public void talk(){
		System.out.println(this.name + "が話す");
	}

	public void walk(){
		System.out.println(this.name + "が歩く");
	}

	public void run(){
		System.out.println(this.name + "が走る");
	}

}


public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		/*殻の変数nameとageを呼び出し、
		 * それぞれに名前と年齢を代入
		 */

		System.out.println(taro.name);
		System.out.println(taro.age);

		taro.talk();
		taro.walk();
		taro.run();
		System.out.println();


		Person jiro = new Person("木村次郎",18);
		System.out.println(jiro.name);
		System.out.println(jiro.age);
		System.out.println();

		Person saburo = new Person("saburo");
		System.out.println(saburo.name);
		System.out.println(saburo.age);
		System.out.println();

		Person nobody = new Person(25);
		System.out.println(nobody.name);
		System.out.println(nobody.age);
		System.out.println();

		Person hanako = new Person(16,"鈴木花子");
		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println();


		Robot aibo = new Robot();
		aibo.name = "aibo";
		aibo.talk();
		aibo.walk();
		aibo.run();
		System.out.println();

		Robot asimo = new Robot();
		asimo.name = "asimo";
		asimo.talk();
		asimo.walk();
		asimo.run();
		System.out.println();

		Robot pepper = new Robot();
		pepper.name = "pepper";
		pepper.talk();
		pepper.walk();
		pepper.run();
		System.out.println();

		Robot doraemon = new Robot();
		doraemon.name = "ドラえもん";
		doraemon.talk();
		doraemon.walk();
		doraemon.run();
		System.out.println();

	}

}

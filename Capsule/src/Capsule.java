
public class Capsule {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Person taro = new Person("山田太郎",20);
		System.out.println(taro.getName());
		/*System.out.println(taro.name);とすると
		 * 不可視エラーが起こる
		 */
		System.out.println(taro.getAge());
		System.out.println();

		taro.setName("山田花子");
		taro.setAge(32);
		System.out.println(taro.getName());
		System.out.println(taro.getAge());

	}

}

import java.util.HashSet;
import java.util.Set;


public class SetSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Set<String> set = new HashSet<String>();

		//値のセットはaddメソッドを利用
		set.add("value1");
		set.add("value2");
		set.add("value3");
		set.add("value4");
		set.add("value5");

		set.add("value2");


		//拡張for文を利用
		for(String s : set){
			System.out.println(s);
		}

	}

}

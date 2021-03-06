
public class CheckLoadJDBC {

	public static void main(String[] args) throws InstantiationException,IllegalAccessException{
		// TODO 自動生成されたメソッド・スタブ

		String msg = "";

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/** Java リフレクション＝「実行時にプログラム自身の情報を取得/振る舞いを変更する仕組み」
			 * classクラスのforNameメソッド＝
			 * 「classクラスに定義されているメソッドの中から、
			 * 引数で指定されたオブジェクトを返す」
			 * Classクラス＝.classファイルをプログラム上にロードした際の型
			 * 今回はJDBCドライバを呼び出している
			 * newInstance()は普通のインスタンス化と同じ
			 */
			msg = "ドライバのロードに成功しました";
		}catch(ClassNotFoundException e){
			/**
			 * forNameメソッドを実行する際に必要な処理
			 * classが見つからなかった際の例外処理
			 */
			msg = "ドライバのロードに失敗しました";
		}
		System.out.println(msg);

	}

}

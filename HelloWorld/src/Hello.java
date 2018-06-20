import java.io.BufferedReader;//説明書のようなもの、BufferedReader自体はクラス
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello {

	public static void main(String[] args)throws IOException{
		// throws IOExceptionでエラーを防ぐ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ここでnewにを使ってbrにコピー、説明書を使って組み立てたイメージ
		System.out.println("入力してください");
		String t = br.readLine();
		/*.readLine();とは読み込み待ちのこと
		 * それを変数tに代入
		 */

		System.out.println(t);
		/*変数tを出力
		 * コンソール画面で文字が主導入力できるはず(普段はできない)
		 */


	}

}

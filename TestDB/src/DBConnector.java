import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * <p>MySQLに接続するためのユーティリティクラスです。<br>
 * ルートアカウントにてDBに接続されます。<p>
 */

/**
 *
 *
 */
public class DBConnector {
	/**
	 *JDBCドライバー名
	 */
	private static String driverName = "com.mysql.jdbc.Driver";
	/**
	 * データベース接続URL
	 */
	private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";
	/**
	 * データベース接続ユーザ名
	 *
	 */
	private static String user = "root";
	/**
	 * データベース接続パスワード
	 *
	 */
	private static String password = "mysql";


	public Connection getConnection(){
		/**
		 * 後に出てくるgetConnectionとは異なる
		 */
		Connection con = null;
		//接続を変数として宣言
		try{
			Class.forName(driverName);
			/**
			 * classクラスのforNameメソッド＝「引数で指定されたオブジェクトを返す」
			 * Classクラス＝.classファイルをプログラム上にロードした際の型
			 */

			con = (Connection) DriverManager.getConnection(url,user,password);
			/** DriveManagerクラスで用意されているgetConnectionメソッドを使用
			 * 渡された引数(url,user,passeord)を元にデータベースへの接続を試みる
			 */

		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//指定されたクラスに接続できなかった場合はエラーを表示

		}catch(SQLException e){
			e.printStackTrace();
			//SQLデータベースにアクセスできなかった場合はエラーを表示
		}
		return con;
	}


}

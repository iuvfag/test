import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestUserDAO {

	String name = "";
	String password = "";

	public void select(String name, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		/** DBConnectorクラスにあるgetConnectionメソッドを呼び出し、
		 * データベースに接続
		 * ここでのConnectionはjava内にあるクラス
		 * この文により今後のConnectionクラス内メソッドが使えるようになる
		 */

		String sql = "select * from test_table where user_name=? and password=?";
		//今回使用したいSQL文を変数sqlに代入

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			/** SQL文をデータベースに送るための文
			 * PreparedStatementとは「準備済み命令文」のこと
			 * 処理が早くなる上、検索条件などをパラメータかして使いまわすことができる
			 * 今回は「user_name」と「password」がそれにあたる
			 */
			ps.setString(1, name);
			ps.setString(2, password);
			/** setString()に入れられた文字をSQL用に変換する
			 * 最初のsetString()で引数nameを、
			 * 次のsetString()で次の引数passwordを
			 * それぞれ変換
			 */

			ResultSet rs = ps.executeQuery();
			/** 問い合わせの実行
			 * executeQueryでSQL文を実行
			 * 同時にResultSetでその結果を受け取る
			 * 実行の結果をrsに代入
			 * SQL文にSelectを使う場合にこの文を使用
			 */

			if(rs.next()){
				/**
				 *  ここでのif()は上記のSQL文の実行ができればという意味
				 *  ResultSetの結果は表形式であり、
				 *  初期状態では何もない行を示しているため
				 *  next()メソッドでカーソルを動かす
				 *  今回、問い合わせは1行のデータであるため
				 *  if（）「条件にあったものはあるか」を使用
				 */
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				/**
				 * 今回、得られる結果はString型であるため
				 * getStringを使用する
				 * ()内の名前はデータベースと一致させる
				 */
			}
		}catch(SQLException e){
			e.printStackTrace();
			/** prepareStatement、executeQueryに対応するエラー文
			 * この時点でエラーがおきた場合は表示
			 */
		}
	try{
		con.close();
		//接続をきるためのメソッド
		}catch(SQLException e){
		e.printStackTrace();
		//close()に対応する。切断においてエラーが起きれば表示
		}
	}
	/**
	 * 全体としては
	 * 外部クラスのDBConnector内のgetConnectionメソッドを呼び出して
	 * データベースに接続、JavaのConnectionクラスのメソッドも重ねて使用していくイメージ
	 *
	 * ①SQL文を書く、②SQL文のプリコンパイル、
	 * ③SQL文のパラメータへの任意の値の代入
	 * ④用途に合わせたクエリの実行とその結果に対する処理
	 * ⑤例外への対応処理
	 * ⑥接続のクローズと、それ例外への処理
	 *
	 */


	public void selectAll(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			/** 今回はこちらからの問い合わせに際して
			 * 送るデータはないためsetStringは不要
			 */

			while(rs.next()){
				/**
				 * すべてのカラムのデータを取得するため
				 * 今回はwhileでカーソルをまわし続ける
				 */
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
	}



	public void selectByName(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where user_name = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
	}



	public void selectByPassword(String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where password = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}

	}



	public void updateUserNameByUserName(String oldName, String newName){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "update test_table set user_name=? where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);
			int i = ps.executeUpdate();
			/** データの更新、削除、追加の場合はexecuteUpdate()を使用
			 * 今回は結果として「行数」が帰ってくる
			 * その結果を変数iに代入
			 * SQL文にupdate、delete、insertを使う場合に使用
			 */
			if(i>0){
				System.out.println(i + "件更新されました");
			}else{
				System.out.println("該当するデータはありませんでした");
			}
			//帰ってきた行数を元に更新されたかどうかを表示する
		}catch(SQLException e ){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
	}



	public void insert(int user_id, String name, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into test_table values(?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, name);
			ps.setString(3, password);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println(i + "件登録されました");
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
	}



	public void delete(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from test_table where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println(i + "件削除されました");
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


}

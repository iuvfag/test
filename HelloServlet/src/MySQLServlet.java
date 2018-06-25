

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MySQLServlet
 */
@WebServlet("/MySQLServlet")
public class MySQLServlet extends HttpServlet {


    public MySQLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>データベーステスト</title>");
		out.println("</head>");
		out.println("<body>");
		//JSP内でSystem.out.printlnを利用しても表示されない

		Connection conn = null;
		String url = "jdbc:mysql://localhost/testdb";
		String user = "root";
		String password = "mysql";
		//データベースに接続するために必要な情報をそれぞれ変数に代入しておく

		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			//データベースに接続する

			Statement stmt = conn.createStatement();
			/** 上の1文は、
			 * 問い合わせをしたり、その結果を取得するベースとなるもの
			 * PreparedStatementのほうが高速
			 */
			String sql = "select * from test_table";
			//実際に問い合わせたい内容をSQL文で書く
			ResultSet rs = stmt.executeQuery(sql);
			//問い合わせの結果を受け取りために必要な文

			while(rs.next()){
				/**
				 * 今回はデータベースのすべてのデータを取得したいため、
				 * while文を使用
				 */
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userPassword = rs.getString("password");
				/** getINT、getStringなどで取得した値をそれぞれ
				 * 変数に代入
				 *
				 */
				out.println("<p>");
				out.println("ユーザーID：" + userId + "、ユーザー名：" + userName + "、パスワード：" + userPassword);
				out.println("</p>");
			}

			rs.close();
			stmt.close();
			/**
			 * 問い合わせがすんだらStatement、ResultSet
			 * ともに接続を閉じておく
			 */

		}catch(ClassNotFoundException e ){
			out.println("ClassNotFoundException" + e.getMessage());
		}catch(SQLException e ){
			out.println("SQLEXception"+ e.getMessage());
		}catch(Exception e ){
			out.println("Exception" + e.getMessage() );

		//データベース接続における例外を処理する

		}finally{
			try{
				if(conn != null){
					conn.close();
					//接続に何か問題があった場合にも接続を切断するため
				}
			}catch(SQLException e ){
				out.println("SQLEception" + e.getMessage());
			}
		}

		out.println("</body>");
		out.println("</html>");


	}


}



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//文字化けを防ぐための文
		String username = request.getParameter("username");
		//送信されたデータを受け取る

		System.out.println(username);
		//System.out.pruntlnでは画面に表示されない

		PrintWriter out = response.getWriter();
		/**
		 * servletがクライアントに送り返すレスポンスを定義
		 * getWriterで文字列の送り返し
		 */
		out.println("<html><head></head><body><br>"+username+"さん、ようこそ！</body></html>");
	}

}

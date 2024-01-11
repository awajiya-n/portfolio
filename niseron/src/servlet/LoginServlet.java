package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckUserDAO;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// トップページからゲストログインした場合
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// ゲスト情報をインスタンス化しセッションへ格納
		String name = request.getParameter("name");
		if(name.equals("")) {
			name = "ゲスト";
		}
		String userType = "g";
		User user = new User(name,userType);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		// プレイコンフィグ画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/playerConfig.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// トップページからユーザーログインした場合

		// ユーザー情報を取得しインスタンス化
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String userType = request.getParameter("userType");
		User user = new User(name,pass,userType);

		// ユーザー登録確認のDAOを実行
		CheckUserDAO dao = new CheckUserDAO();
		user = dao.checkUser(user);

		// 検索結果によってフォワード先を変更
		// ユーザー登録が確認できなかった場合はエラー画面へフォワード
		if(user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}else {
		// ユーザー登録が確認できた場合はユーザー情報をスコープに保存しプレイコンフィグ画面へフォワード
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/playerConfig.jsp");
			dispatcher.forward(request, response);
		}

	}

}

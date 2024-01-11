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
import dao.SignUpDAO;
import model.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//初期登録画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ユーザー情報を取得しインスタンス化
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User();
		user.setName(name);
		user.setPass(pass);

		// ユーザー登録確認のDAOを実行
		CheckUserDAO checkUserDao = new CheckUserDAO();
		user = checkUserDao.checkUser(user);
		// 既に同じユーザー名・パスワードで登録がない場合は登録を実行
		if(user == null) {
			// ユーザー登録確認のDAOを実行
			user = new User();
			user.setName(name);
			user.setPass(pass);
			SignUpDAO signUpDao = new SignUpDAO();
			signUpDao.signUpUser(user);

			// ユーザー登録確認のDAOを実行
			checkUserDao = new CheckUserDAO();
			user = checkUserDao.checkUser(user);

			// 検索結果によってフォワード先を変更
			// ユーザー登録が確認できなかった場合はエラー画面へフォワード
			if(user == null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUpError.jsp");
				dispatcher.forward(request, response);
			}else {
			// ユーザー登録が確認できた場合は登録完了画面へフォワード
				HttpSession session = request.getSession();
				session.setAttribute("signUpUser", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUpComplete.jsp");
				dispatcher.forward(request, response);
			}
		// 登録があった場合はエラー画面へフォワード
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUpError.jsp");
			dispatcher.forward(request, response);
		}
	}

}

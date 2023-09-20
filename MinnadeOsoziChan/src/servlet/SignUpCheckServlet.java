package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Account;

@WebServlet("/SignUpCheckServlet")
public class SignUpCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String groupName = request.getParameter("groupName");
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String userId = request.getParameter("userId");
		String adminFlg = request.getParameter("adminFlg");

		//int型に戻す
		int ui = Integer.valueOf(userId);
		int af = Integer.valueOf(adminFlg);

		//登録する管理者の情報を設定
		Account ac = new Account(groupName,userName,userPass,ui,af);

		//セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("account",ac);

		//入力内容の確認画面へフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/signupcheck.jsp");
		dispatcher.forward(request,response);
	}

}

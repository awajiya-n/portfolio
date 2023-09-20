package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.LoginCheckLogic;
import model.entity.Account;
import model.entity.Login;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		//　リクエスト情報の受け取り
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String groupId = request.getParameter("group_id");
		String userPass = request.getParameter("user_pass");

		//　BOとの情報のやりとり
		Login login = new Login(groupId,userPass);
		LoginCheckLogic lcl = new LoginCheckLogic();
		Account ac = lcl.execute(login);

		//　BOの結果を受けた処理
		// CheckResultが0だった場合はエラー画面へ
		if(ac.getCheckResult() == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("account",ac);
			response.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/loginerror.jsp");
			dispatcher.forward(request, response);

		// CheckResultが1だった場合はユーザー画面へ
		} else if(ac.getCheckResult() == 1) {
			HttpSession session = request.getSession();
			//　login_flgの付与実施
			ac.setLoginFlg(1);
			session.setAttribute("account",ac);
			response.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/UserPageServlet");
			dispatcher.forward(request, response);

		// CheckResultが2だった場合は管理者画面選択へ
		} else if(ac.getCheckResult() == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("account",ac);
			response.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/adminlogin.jsp");
			dispatcher.forward(request, response);
		}

	}

}
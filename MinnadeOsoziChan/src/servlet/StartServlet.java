package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Account;


@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// スコープがあったら消去
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		List<Account> accountList =(List<Account>) session.getAttribute("accountList");
		if(account != null) {
			session.removeAttribute("account");
			session.removeAttribute("accountList");
		}

		//トップページへフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/start.jsp");
		dispatcher.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// スコープがあったら消去
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		List<Account> accountList =(List<Account>) session.getAttribute("accountList");
		if(account != null) {
			session.removeAttribute("account");
			session.removeAttribute("accountList");
		}

		//トップページへフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/start.jsp");
		dispatcher.forward(request, response);
	}

}

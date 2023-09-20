package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.TotalPointDAO;
import model.entity.Account;

@WebServlet("/SignUpRegistServlet")
public class SignUpRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//スコープから取得
		HttpSession session = request.getSession();
		Account ac =(Account) session.getAttribute("account");

		//利用管理者情報をSQLへ保存し、書き換えた情報をスコープに入れなおす
		AccountDAO dao = new AccountDAO();
		ac = dao.SetFirstAdmin(ac);
		session.setAttribute("account",ac);

		//TotalPointDAOでテーブル登録
		TotalPointDAO tpdao = new TotalPointDAO();
		tpdao.register(ac.getGroupId(), ac.getUserId());

		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/firstadmin.jsp");
		dispatcher.forward(request, response);


	}
}

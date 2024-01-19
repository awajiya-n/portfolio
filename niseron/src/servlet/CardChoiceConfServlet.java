package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardCheckConf
 */
@WebServlet("/CardChoiceConfServlet")
public class CardChoiceConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// カード選択準備画面へフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoiceReady.jsp");
					dispatcher.forward(request, response);
	}

}

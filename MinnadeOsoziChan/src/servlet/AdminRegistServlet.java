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

/**
 * Servlet implementation class AdminRegistServlet
 */
@WebServlet("/AdminRegistServlet")
public class AdminRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistServlet() {
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

		  String buttonValue = request.getParameter("flg");
		  HttpSession session = request.getSession();
  		  Account ac = (Account)session.getAttribute("account");


          // 追加ボタンが押された場合の処理
	        if ("admin".equals(buttonValue)) {

	    		//　login_flgの付与実施
	    		ac.setLoginFlg(0);

	        } else if ("user".equals(buttonValue)) {
	            // ユーザー画面ボタンが押された場合の処理
	        	ac.setLoginFlg(1);

	        }
    		session.setAttribute("account",ac);
    		response.setCharacterEncoding("UTF-8");
    		RequestDispatcher dispatcher =
    				request.getRequestDispatcher("/UserPageServlet");
    		dispatcher.forward(request, response);

	}

}

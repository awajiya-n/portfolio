package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Answer;
import model.RiddleLogic;

/**
 * Servlet implementation class RiddleServlet
 */
@WebServlet("/RiddleServlet")
public class RiddleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiddleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//インスタンスの保存とセッションスコープの作成
		Answer answer = new Answer();
		HttpSession session = request.getSession();
		session.setAttribute("answer", answer);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q1.jsp");
		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		Answer answer = (Answer) session.getAttribute("answer");
		RiddleLogic rl = new RiddleLogic();
		int next = answer.getNext();
		if (next == 2){
			answer.setQ1(request.getParameter("q1"));
			answer.setQ1Result(rl.AnswerQ1(request.getParameter("q1")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q2.jsp");
			dispatcher.forward(request, response);
		} else if(next == 3) {
			answer.setQ2(request.getParameter("q2"));
			answer.setQ2Result(rl.AnswerQ2(request.getParameter("q2")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q3.jsp");
			dispatcher.forward(request, response);
		} else if(next == 4) {
			answer.setQ3(request.getParameter("q3"));
			answer.setQ3Result(rl.AnswerQ3(request.getParameter("q3")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q4.jsp");
			dispatcher.forward(request, response);
		} else if(next == 5) {
			answer.setQ4(request.getParameter("q4"));
			answer.setQ4Result(rl.AnswerQ4(request.getParameter("q4")));
			boolean check = rl.CheckAnswer(answer.getQ1(),answer.getQ2(),answer.getQ3(),answer.getQ4());
			if(check) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lastq.jsp");
			dispatcher.forward(request, response);
			} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);			
			} 
		}else if(next == 6 && request.getParameter("q5").contains("wrong")){
			answer.setQ5Result("最終問題：不正解");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}else if(next == 6 && request.getParameter("q5").contains("correct")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allclear.jsp");
			dispatcher.forward(request, response);
		}
	}
		/*		doGet(request, response);*/
}

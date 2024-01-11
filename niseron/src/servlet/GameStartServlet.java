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
import dao.GetCardDAO;
import model.CardDate;
import model.GameConfig;
import model.User;

/**
 * Servlet implementation class GameStartServlet
 */
@WebServlet("/GameStartServlet")
public class GameStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 対戦相手設定画面からの処理
		// リクエスト情報から対戦モードの情報を取得
		String rivalMode = request.getParameter("rivalMode");

		// 対戦モードがユーザーだった場合
		if(rivalMode.equals("u"))
		{
			// リクエスト情報から対戦相手のユーザー情報を取得し対戦ユーザーログイン情報のインスタンスを作成
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String userType = request.getParameter("rivalMode");
			User rivalUser = new User(name,pass,userType);

			// 対戦ユーザーログイン情報を元にDAOを実行し、ユーザー情報の有無を確認
			CheckUserDAO checkDao = new CheckUserDAO();
			rivalUser = checkDao.checkUser(rivalUser);

			// ユーザー情報がなかった場合
			if(rivalUser == null)
			{
				// エラー画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
			// ユーザー情報があった場合
			else
			{
				// 名前が同じだった場合は名前に数字を付与
				HttpSession session = request.getSession();

				User user = (User)session.getAttribute("user");
				if(user.getName().equals(rivalUser.getName())) {
					user.setName(user.getName()+"1");
					rivalUser.setName(rivalUser.getName()+"2");
					session.setAttribute("user", user);
				}
				// ユーザー情報インスタンスをセッションへ保存
				session.setAttribute("rivalUser", rivalUser);

				// DAOを使用して対戦相手ユーザーのカード情報をインスタンスで取得し、セッションへ保存
				GetCardDAO getCardDao = new GetCardDAO();
				CardDate rivalCardDate = getCardDao.userCard(rivalUser);
				session.setAttribute("rivalCardDate", rivalCardDate);

				// ゲーム設定インスタンスをセッションから取り出し、対戦モード設定情報を追加、セッションへ保存
				GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig");
				gameConfig.setRivalMode(rivalMode);
				session.setAttribute("gameConfig", gameConfig);

				// ゲームモードによってフォワード先を変更する
				switch(gameConfig.getGameMode())
				{
				// ゲームモードがシンプルモードの場合はシンプルゲーム画面へフォワード
				case "s":
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameConfig.jsp");
					// 本来のフォワード先
					// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customGameStart.jsp");
					dispatcher.forward(request, response);
					break;
				// ゲームモードがカスタムモードの場合はカスタムゲーム画面へフォワード
				case "c":
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customGameConfig.jsp");
					// 本来のフォワード先
					// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customGameStart.jsp");
					dispatcher.forward(request, response);
					break;
				}
			}
		}
		// 対戦モードがゲストだった場合
		else if(rivalMode.equals("g"))
		{
			// 対戦相手ユーザー情報インスタンスをゲストで作成し、スコープへ保存
			String name = request.getParameter("name");
			if(name.equals("")) {
				name = "ゲスト";
			}
			String userType = "g";
			User rivalUser = new User(name,userType);

			// 名前が同じだった場合は名前に数字を付与
			HttpSession session = request.getSession();

			User user = (User)session.getAttribute("user");
			if(user.getName().equals(rivalUser.getName())) {
				user.setName(user.getName()+"1");
				rivalUser.setName(rivalUser.getName()+"2");
				session.setAttribute("user", user);
			}
			// ユーザー情報インスタンスをセッションへ保存
			session.setAttribute("rivalUser", rivalUser);

			// 対戦相手カード情報インスタンスをゲストで作成し、スコープへ保存
			CardDate rivalCardDate = new CardDate();
			session.setAttribute("rivalCardDate", rivalCardDate);

			// ゲーム設定インスタンスをセッションから取り出し、対戦モード設定情報を追加、セッションへ保存
			GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig");
			gameConfig.setRivalMode(rivalMode);
			session.setAttribute("gameConfig", gameConfig);

			// ゲームモードによってフォワード先を変更する
			switch(gameConfig.getGameMode())
			{
			// ゲームモードがシンプルモードの場合はシンプルゲーム画面へフォワード
			case "s":
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameConfig.jsp");
				// 本来のフォワード先
				// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customGameStart.jsp");
				dispatcher.forward(request, response);
				break;
			// ゲームモードがカスタムモードの場合はカスタムゲーム画面へフォワード
			case "c":
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customGameConfig.jsp");
				// 本来のフォワード先
				// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customGameStart.jsp");
				dispatcher.forward(request, response);
				break;
			}
		}
		// 対戦モードがCPUだった場合
		else if(rivalMode.equals("c"))
		{
			/* 未実装 */
		}
	}
}

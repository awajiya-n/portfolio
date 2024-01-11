package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GetCardDAO;
import model.GameConfig;
import model.User;
import model.CardDate;

/**
 * Servlet implementation class NumberCheckServlet
 */
@WebServlet("/CardCheckServlet")
public class CardCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ゲームモード選択時の処理
		// ユーザー情報のインスタンスをスコープより取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		// リクエスト情報からゲームモードを、ユーザー情報インスタンスよりユーザータイプを取得する
		String gameMode = request.getParameter("gameMode");
		String userType = user.getUserType();

		// ユーザーがゲストユーザー、ゲームモードがシンプルモードだった場合
		if(userType.equals("g") && gameMode.equals("s"))
		{
			// UserCardDateのコンストラクターを渡し値なしで実行し、カードデータインスタンスを作成、セッションに保存
			CardDate userCardDate = new CardDate();
			session.setAttribute("userCardDate", userCardDate);

			// GameConfigのコンストラクターを渡し値なしで実行し、ゲーム設定インスタンスを作成、セッションに保存
			GameConfig gameConfig = new GameConfig();
			gameConfig.setGameMode(gameMode);
			session.setAttribute("gameConfig", gameConfig);

			// 対戦相手設定画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rivalInfo.jsp");
			dispatcher.forward(request, response);
		}
		// ユーザーがゲストユーザー、ゲームモードがカスタムモードだった場合
		else if(userType.equals("g") && gameMode.equals("c"))
		{
			// UserCardDateのコンストラクターを渡し値なしで実行し、カードデータインスタンスを作成、セッションに保存
			CardDate userCardDate = new CardDate();
			session.setAttribute("userCardDate", userCardDate);

			// リクエスト情報から各サポートカードのON/OFF情報を取得し変数化
			String double_m = request.getParameter("double");
			String highlow_m = request.getParameter("highlow");
			String target_m = request.getParameter("target");
			String slash_m = request.getParameter("slash");
			String shuffle_m = request.getParameter("shuffle");
			String change_m = request.getParameter("change");

			// 取得したサポートカード設定情報をGameConfigのコンストラクターへ渡し、ゲーム設定インスタンスを作成
			GameConfig gameConfig = new GameConfig(double_m,highlow_m,target_m,slash_m,shuffle_m,change_m);
			gameConfig.setGameMode(gameMode);
			session.setAttribute("gameConfig", gameConfig);

			// 対戦相手設定画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rivalInfo.jsp");
			dispatcher.forward(request, response);
		}
		// ユーザーが登録ユーザー、ゲームモードがシンプルモードだった場合
		else if(userType.equals("u") && gameMode.equals("s"))
		{
			// ユーザー情報を元にGetCardDAOを実行し、ユーザーのカード情報をインスタンスで取得後、セッションへ保存
			GetCardDAO dao = new GetCardDAO();
			CardDate userCardDate = dao.userCard(user);
			session.setAttribute("userCardDate", userCardDate);

			// GameConfigのコンストラクターを渡し値なしで実行し、ゲーム設定インスタンスを作成、セッションに保存
			GameConfig gameConfig = new GameConfig();
			gameConfig.setGameMode(gameMode);
			session.setAttribute("gameConfig", gameConfig);

			// 対戦相手設定画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rivalInfo.jsp");
			dispatcher.forward(request, response);
		}
		// ユーザーが登録ユーザー、ゲームモードがカスタムモードだった場合
		else if(userType.equals("u") && gameMode.equals("c"))
		{
			// ユーザー情報を元にGetCardDAOを実行し、ユーザーのカード情報をインスタンスで取得後、セッションへ保存
			GetCardDAO dao = new GetCardDAO();
			CardDate userCardDate = dao.userCard(user);
			session.setAttribute("userCardDate", userCardDate);

			// リクエスト情報から各サポートカードのON/OFF情報を取得し変数化
			String double_m = request.getParameter("double");
			String highlow_m = request.getParameter("highlow");
			String target_m = request.getParameter("target");
			String slash_m = request.getParameter("slash");
			String shuffle_m = request.getParameter("shuffle");
			String change_m = request.getParameter("change");

			// 取得したサポートカード設定情報をGameConfigのコンストラクターへ渡し、ゲーム設定インスタンスを作成
			GameConfig gameConfig = new GameConfig(double_m,highlow_m,target_m,slash_m,shuffle_m,change_m);
			gameConfig.setGameMode(gameMode);
			session.setAttribute("gameConfig", gameConfig);

			// 対戦相手設定画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rivalInfo.jsp");
			dispatcher.forward(request, response);

		}

	}

}

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayResultDAO;
import method.CardChoiceMethod;
import method.NumberCheckMethod;
import model.CardDate;
import model.GameSetting;
import model.GuessResult;
import model.UseCard;
import model.User;

/**
 * Servlet implementation class GamePlayServlet
 */
@WebServlet("/GamePlayServlet")
public class GamePlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamePlayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//リクエストのフラグより数値を取得
		int next = Integer.parseInt(request.getParameter("flag"));

		//リクエストフラグによるフォワード先の割り振り
		//フラグが1だった場合はゲーム画面へ
		if(next==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameDisplay.jsp");
			dispatcher.forward(request, response);
		//フラグが2だった場合はゲーム準備画面へ
		}else if(next==2) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameReady.jsp");
			dispatcher.forward(request, response);
		//フラグが不正な場合はエラー画面へ
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//ターンプレイヤーが選択した数字と相手プレイヤーの数字の比較処理
		//セッションスコープの利用開始
		HttpSession session = request.getSession();
		//ゲームセッティングインスタンスの取得
		GameSetting gameSetting = (GameSetting)session.getAttribute("gameSetting");
		//各プレイヤーの使用カード情報インスタンスの取得
		UseCard userUseCard = (UseCard)session.getAttribute("userUseCard");
		UseCard rivalUseCard = (UseCard)session.getAttribute("rivalUseCard");
		//各プレイヤーのユーザー情報インスタンスを取得
		User user = (User)session.getAttribute("user");
		User rivalUser = (User)session.getAttribute("rivalUser");
		//各プレイヤーの所持カード情報インスタンスを取得
		CardDate userCardDate = (CardDate)session.getAttribute("userCardDate");
		CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate");

		//EAT・BITEカウントの変数準備
		int eatCount = 0;
		int biteCount = 0;

		//ターンプレイヤーと町プレイヤーのユーザー情報・選択カード情報・ユーザー所持カード情報の準備
		UseCard currentUseCard = null;
		UseCard waitUseCard = null;
		User currentUser = null;
		User waitUser = null;
		CardDate currentUserCardDate = null;
		CardDate waitUserCardDate = null;

		//ターンプレイヤーの選択した数字の取得
		int firstGuess = Integer.parseInt(request.getParameter("firstGuess"));
		int secondGuess = Integer.parseInt(request.getParameter("secondGuess"));
		int thirdGuess = Integer.parseInt(request.getParameter("thirdGuess"));


		//ターンごとの処理
		//奇数ターンだった場合は以下の処理を行う
		if(gameSetting.getTurnCount()%2 == 1) {
			//スタートプレイヤーがユーザープレイヤーだった場合
			if(gameSetting.getFirstPlayer().equals("user")) {
				//相手プレイヤーをライバルプレイヤーとして選択カードインスタンスに格納
				currentUseCard = userUseCard;
				currentUser = user;
				currentUserCardDate = userCardDate;
				waitUseCard = rivalUseCard;
				waitUser = rivalUser;
				waitUserCardDate = rivalCardDate;
			//スタートプレイヤーがユーザープレイヤーではなかった場合
			}else{
				//相手プレイヤーをユーザープレイヤーとして選択カードインスタンスに格納
				currentUseCard = rivalUseCard;
				currentUser = rivalUser;
				currentUserCardDate = rivalCardDate;
				waitUseCard = userUseCard;
				waitUser = user;
				waitUserCardDate = userCardDate;
			}
		//偶数ターンだった場合は以下の処理を行う
		}else if(gameSetting.getTurnCount()%2 == 0) {
			//スタートプレイヤーがユーザープレイヤーだった場合
			if(gameSetting.getFirstPlayer().equals("user")) {
				//相手プレイヤーをユーザープレイヤーとして選択カードインスタンスに格納
				currentUseCard = rivalUseCard;
				currentUser = rivalUser;
				currentUserCardDate = rivalCardDate;
				waitUseCard = userUseCard;
				waitUser = user;
				waitUserCardDate = userCardDate;
			//スタートプレイヤーがユーザープレイヤーではなかった場合
			}else{
				//相手プレイヤーをライバルプレイヤーとして選択カードインスタンスに格納
				currentUseCard = userUseCard;
				currentUser = user;
				currentUserCardDate = userCardDate;
				waitUseCard = rivalUseCard;
				waitUser = rivalUser;
				waitUserCardDate = rivalCardDate;
			}

		}

		//EATをCardChoiceMethodのeat関数を用いて算出
		eatCount =
			NumberCheckMethod.eat(waitUseCard.getFirstNumber(),firstGuess)
				+
			NumberCheckMethod.eat(waitUseCard.getSecondNumber(),secondGuess)
				+
			NumberCheckMethod.eat(waitUseCard.getThirdNumber(),thirdGuess);

		//BITEをCardChoiceMethodのbite関数を用いて算出
		biteCount =
			NumberCheckMethod.bite(waitUseCard.getSecondNumber(), waitUseCard.getThirdNumber(), firstGuess)
				+
			NumberCheckMethod.bite(waitUseCard.getFirstNumber(), waitUseCard.getThirdNumber(), secondGuess)
				+
			NumberCheckMethod.bite(waitUseCard.getFirstNumber(), waitUseCard.getSecondNumber(), thirdGuess);

		//判定結果を格納するインスタンスをスコープより取得
		GuessResult guessResult = (GuessResult)session.getAttribute("guessResult");

		//ターンごとの判定結果保存用ArrayListを準備
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
				result = guessResult.getResult();
		ArrayList<ArrayList<Integer>> guessNumber = new ArrayList<ArrayList<Integer>>();
				guessNumber = guessResult.getGuessNumber();

		//3EATの場合は勝利ページへ遷移
		if(eatCount == 3) {
			//判定結果履歴として予想した数値をArrayList型で判定結果インスタンスへ保存する
			ArrayList<Integer> turnGuessNumber = new ArrayList<Integer>();
			turnGuessNumber.add(firstGuess);
			turnGuessNumber.add(secondGuess);
			turnGuessNumber.add(thirdGuess);

			guessNumber.add(turnGuessNumber);

			guessResult.setResult(guessNumber);

			//判定結果履歴としてEATとBITEの数をArrayList型で判定結果インスタンスへ保存する
			ArrayList<Integer> turnResult = new ArrayList<Integer>();
			turnResult.add(eatCount);
			turnResult.add(biteCount);

			result.add(turnResult);

			guessResult.setResult(result);

			//判定結果インスタンスをスコープへ保存
			session.setAttribute("guessResult", guessResult);

			//対戦結果をユーザー情報へ反映
			User winner = currentUser;
			User loser = waitUser;
			UseCard winnerUseCard = currentUseCard;
			UseCard loserUseCard = waitUseCard;
			CardDate winnerCardDate = currentUserCardDate;
			CardDate loserCardDate = waitUserCardDate;

			if(winner.getUserType().equals("u")) {
				winnerCardDate = CardChoiceMethod.numberCardRaiser(winnerCardDate, winnerUseCard.getFirstNumber());
				winnerCardDate = CardChoiceMethod.numberCardRaiser(winnerCardDate, winnerUseCard.getSecondNumber());
				winnerCardDate = CardChoiceMethod.numberCardRaiser(winnerCardDate, winnerUseCard.getThirdNumber());
				winnerCardDate = CardChoiceMethod.numberCardRaiser(winnerCardDate, loserUseCard.getFirstNumber());
				winnerCardDate = CardChoiceMethod.numberCardRaiser(winnerCardDate, loserUseCard.getSecondNumber());
				winnerCardDate = CardChoiceMethod.numberCardRaiser(winnerCardDate, loserUseCard.getThirdNumber());

				PlayResultDAO pr = new PlayResultDAO();
				pr.WinCountRaiserSimple(winner, winnerCardDate);
				pr.WinCardRaiserSimple(winner, winnerCardDate);
			}

			if(loser.getUserType().equals("u")) {
				PlayResultDAO pr = new PlayResultDAO();
				pr.LoseCountRaiserSimple(loser, loserCardDate);
				pr.LoseCardReduserSimple(loser, loserCardDate);
			}

			//勝利画面ページへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameWin.jsp");
			dispatcher.forward(request, response);

		//3EATでない場合は試合続行
		}else{
			//今回のEATとBITEの結果を判定結果インスタンスへ保存
			guessResult.setEat(eatCount);
			guessResult.setBite(biteCount);

			//判定結果履歴として予想した数値をArrayList型で判定結果インスタンスへ保存する
			ArrayList<Integer> turnGuessNumber = new ArrayList<Integer>();
			turnGuessNumber.add(firstGuess);
			turnGuessNumber.add(secondGuess);
			turnGuessNumber.add(thirdGuess);

			guessNumber.add(turnGuessNumber);

			guessResult.setResult(guessNumber);

			//判定結果履歴としてEATとBITEの数をArrayList型で判定結果インスタンスへ保存する
			ArrayList<Integer> turnResult = new ArrayList<Integer>();
			turnResult.add(eatCount);
			turnResult.add(biteCount);

			result.add(turnResult);
			guessResult.setResult(result);

			//判定結果インスタンスをスコープへ保存
			session.setAttribute("guessResult", guessResult);

			//ゲーム設定インスタンスのターン数を1増やしスコープへ保存
			gameSetting.setTurnCount(gameSetting.getTurnCount()+1);
			session.setAttribute("gameSetting",gameSetting);

			//判定結果画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameResult.jsp");
			dispatcher.forward(request, response);

		}
	}
}


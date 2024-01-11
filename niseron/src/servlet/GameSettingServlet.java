package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import method.CardChoiceMethod;
import model.CardDate;
import model.GameSetting;
import model.GuessResult;
import model.UseCard;

/**
 * Servlet implementation class GameSettingServlet
 */
@WebServlet("/GameSettingServlet")
public class GameSettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//準備画面からカード選択画面へフォワード
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoice.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//セッションを開始
		HttpSession session = request.getSession();
		//リクエストからゲーム設定フラグを取得し変数へ保管
		int settingFlag = Integer.parseInt(request.getParameter("settingFlag"));

		//ゲーム設定フラグごとの処理の指示
		switch(settingFlag) {
			//ゲーム設定フラグが1だった場合はスタートプレイヤーの確定
			case 1:
				//ゲーム設定インスタンスの作成
				GameSetting gameSetting = new GameSetting();
				//リクエストから初手プレイヤー情報を取得
				String firstPlayer = request.getParameter("fristPlayer");
				//初手プレイヤー情報がrandomだった場合はランダムで初手プレイヤー情報を変更
				if(firstPlayer.equals("random")) {
					Random rand = new Random();
					int num = rand.nextInt(2);
						if(num == 0) {
							firstPlayer = "user";
						}else if(num == 1) {
							firstPlayer = "rival";
						}
				}
				//初手プレイヤー情報をインスタンスに保存しセッションスコープへ格納
				gameSetting.setFirstPlayer(firstPlayer);
				session.setAttribute("gameSetting", gameSetting);

				//ゲーム中使用するカードを保存するインスタンスの準備とセッションへの格納
				UseCard userUseCard = new UseCard();
				UseCard rivalUseCard = new UseCard();
				session.setAttribute("userUseCard", userUseCard);
				session.setAttribute("rivalUseCard", rivalUseCard);

				//カード選択準備画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoiceReady.jsp");
				dispatcher.forward(request, response);
				break;

			//ゲーム設定フラグが2だった場合は数字選択処理
			case 2:
				//セッションスコープからゲーム設定インスタンスの呼び出し
				gameSetting =(GameSetting)session.getAttribute("gameSetting");

				//カード選択カウントをゲーム設定インスタンスから取得し変数化
				int count = gameSetting.getCardChoiceCount();

				//ユーザーと対戦相手の使用カード情報を格納しているインスタンスをセッションスコープより取得
				userUseCard =(UseCard)session.getAttribute("userUseCard");
				rivalUseCard =(UseCard)session.getAttribute("rivalUseCard");

				//初手プレイヤーがユーザーだった時の処理
				if(gameSetting.getFirstPlayer().equals("user")) {
					//カード選択カウントにより処理を変更
					switch(count) {
					//カード選択カウントが1だった場合
					case 1:
						//リクエストから数字情報を取得
						int number = Integer.parseInt(request.getParameter("number"));
						//1番目の使用数字としてユーザー使用カードインスタンスへ格納しセッションスコープへ格納
						userUseCard.setFirstNumber(number);
						session.setAttribute("userUseCard", userUseCard);

						//ユーザー所持カードインスタンスを取得し、選択されたカード残数を減らした上でセッションスコープへ格納
						CardDate userCardDate = (CardDate)session.getAttribute("userCardDate");
						session.setAttribute("userCardDate", CardChoiceMethod.numberCardReduser(userCardDate,number));

						//カード選択カウントを1上昇させ、ゲーム設定インスタンスへ反映しセッションスコープへ格納
						count++;
						gameSetting.setCardChoiceCount(count);
						session.setAttribute("gameSetting", gameSetting);

						//カード選択画面へフォワード
						dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoice.jsp");
						dispatcher.forward(request, response);
						break;
					//カード選択カウントが2だった場合
					case 2:
						//リクエストから数字情報を取得
						number = Integer.parseInt(request.getParameter("number"));
						//2番目の使用数字としてユーザー使用カードインスタンスへ格納しセッションスコープへ格納
						userUseCard.setSecondNumber(number);
						session.setAttribute("userUseCard", userUseCard);

						//ユーザー所持カードインスタンスを取得し、選択されたカード残数を減らした上でセッションスコープへ格納
						userCardDate = (CardDate)session.getAttribute("userCardDate");
						session.setAttribute("userCardDate", CardChoiceMethod.numberCardReduser(userCardDate,number));

						//カード選択カウントを1上昇させ、ゲーム設定インスタンスへ反映しセッションスコープへ格納
						count++;
						gameSetting.setCardChoiceCount(count);
						session.setAttribute("gameSetting", gameSetting);

						//カード選択画面へフォワード
						dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoice.jsp");
						dispatcher.forward(request, response);
						break;
					//カード選択カウントが3だった場合
					case 3:
						//リクエストから数字情報を取得
						number = Integer.parseInt(request.getParameter("number"));
						//3番目の使用数字としてユーザー使用カードインスタンスへ格納しセッションスコープへ格納
						userUseCard.setThirdNumber(number);
						session.setAttribute("userUseCard", userUseCard);

						//ユーザー所持カードインスタンスを取得し、選択されたカード残数を減らした上でセッションスコープへ格納
						userCardDate = (CardDate)session.getAttribute("userCardDate");
						session.setAttribute("userCardDate", CardChoiceMethod.numberCardReduser(userCardDate,number));

						//カード選択カウントを1に戻し、ゲーム設定インスタンスへ反映
						count=1;
						gameSetting.setCardChoiceCount(count);

						//プレイヤーセッティングフラグごとの処理を変える
						//プレイヤーセッティングフラグが1の場合
						if(gameSetting.getPlayerSettingFlag()==1) {
							//初手プレイヤー情報を一時的に変更する
							gameSetting.setFirstPlayer("rival");
							//プレイヤーセッティングフラグを2に変更する
							gameSetting.setPlayerSettingFlag(2);
							//ゲーム設定・ユーザーカードデータの各インスタンスをセッションスコープへ格納
							session.setAttribute("gameSetting", gameSetting);
							session.setAttribute("userUseCard", userUseCard);

							//カード選択準備画面へフォワード
							dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoiceReady.jsp");
							dispatcher.forward(request, response);
						//プレイヤーセッティングフラグが2の場合
						}else if(gameSetting.getPlayerSettingFlag()==2) {
							//初手プレイヤー情報を元に戻す
							gameSetting.setFirstPlayer("rival");
							//ゲーム設定・ユーザーカードデータの各インスタンスをセッションスコープへ格納
							session.setAttribute("gameSetting", gameSetting);
							session.setAttribute("userUseCard", userUseCard);

							//ゲーム結果インスタンスを準備
							GuessResult guessResult = new GuessResult();
							session.setAttribute("guessResult", guessResult);

							//シンプルゲーム準備画面へフォワード
							dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameReady.jsp");
							dispatcher.forward(request, response);
						}
						break;
					}
					//初手プレイヤーが対戦相手だった時の処理
					}else if(gameSetting.getFirstPlayer().equals("rival")){
						//カード選択カウントにより処理を変更
						switch(count) {
						//カード選択カウントが1だった場合
						case 1:
							//リクエストから数字情報を取得
							int number = Integer.parseInt(request.getParameter("number"));
							//1番目の使用数字として対戦相手使用カードインスタンスへ格納しセッションスコープへ格納
							rivalUseCard.setFirstNumber(number);
							session.setAttribute("rivalUseCard", rivalUseCard);

							//対戦相手所持カードインスタンスを取得し、選択されたカード残数を減らした上でセッションスコープへ格納
							CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate");
							session.setAttribute("rivalCardDate", CardChoiceMethod.numberCardReduser(rivalCardDate,number));

							//カード選択カウントを1上昇させ、ゲーム設定インスタンスへ反映しセッションスコープへ格納
							count++;
							gameSetting.setCardChoiceCount(count);
							session.setAttribute("gameSetting", gameSetting);

							//カード選択画面へフォワード
							dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoice.jsp");
							dispatcher.forward(request, response);
							break;
						//カード選択カウントが2だった場合
						case 2:
							//リクエストから数字情報を取得
							number = Integer.parseInt(request.getParameter("number"));
							//2番目の使用数字として対戦相手使用カードインスタンスへ格納しセッションスコープへ格納
							rivalUseCard.setSecondNumber(number);
							session.setAttribute("rivalUseCard", rivalUseCard);

							//対戦相手所持カードインスタンスを取得し、選択されたカード残数を減らした上でセッションスコープへ格納
							rivalCardDate = (CardDate)session.getAttribute("rivalCardDate");
							session.setAttribute("rivalCardDate", CardChoiceMethod.numberCardReduser(rivalCardDate,number));

							//カード選択カウントを1上昇させ、ゲーム設定インスタンスへ反映しセッションスコープへ格納
							count++;
							gameSetting.setCardChoiceCount(count);
							session.setAttribute("gameSetting", gameSetting);

							//カード選択画面へフォワード
							dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoice.jsp");
							dispatcher.forward(request, response);
							break;
						//カード選択カウントが2だった場合
						case 3:
							//リクエストから数字情報を取得
							number = Integer.parseInt(request.getParameter("number"));
							//3番目の使用数字として対戦相手使用カードインスタンスへ格納しセッションスコープへ格納
							rivalUseCard.setThirdNumber(number);
							session.setAttribute("rivalUseCard", rivalUseCard);

							//対戦相手所持カードインスタンスを取得し、選択されたカード残数を減らした上でセッションスコープへ格納
							rivalCardDate = (CardDate)session.getAttribute("rivalCardDate");
							session.setAttribute("rivalCardDate", CardChoiceMethod.numberCardReduser(rivalCardDate,number));

							//カード選択カウントを1に戻し、ゲーム設定インスタンスへ反映
							count=1;
							gameSetting.setCardChoiceCount(count);

							//プレイヤーセッティングフラグごとの処理を変える
							//プレイヤーセッティングフラグが1の場合
							if(gameSetting.getPlayerSettingFlag()==1) {
								//初手プレイヤー情報を一時的に変更する
								gameSetting.setFirstPlayer("user");
								//プレイヤーセッティングフラグを2に変更する
								gameSetting.setPlayerSettingFlag(2);
								//ゲーム設定・対戦相手カードデータの各インスタンスをセッションスコープへ格納
								session.setAttribute("gameSetting", gameSetting);
								session.setAttribute("rivalUseCard", rivalUseCard);

								//シンプルゲーム準備画面へフォワード
								dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardChoiceReady.jsp");
								dispatcher.forward(request, response);
							//プレイヤーセッティングフラグが2の場合
							}else if(gameSetting.getPlayerSettingFlag()==2) {
								//初手プレイヤー情報を元に戻す
								gameSetting.setFirstPlayer("user");
								//ゲーム設定・対戦相手カードデータの各インスタンスをセッションスコープへ格納
								session.setAttribute("gameSetting", gameSetting);
								session.setAttribute("rivalUseCard", rivalUseCard);

								//ゲーム結果インスタンスを準備
								GuessResult guessResult = new GuessResult();
								session.setAttribute("guessResult", guessResult);

								//シンプルゲーム準備画面へフォワード
								dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/simpleGameReady.jsp");
								dispatcher.forward(request, response);
					}
					break;
				}
			}
			break;
		}
	}
}


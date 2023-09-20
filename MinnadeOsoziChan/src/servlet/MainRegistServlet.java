package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CleanedDateDAO;
import dao.LocationLevelDAO;
import dao.TotalPointDAO;
import model.bo.AddTPCalcLogic;
import model.bo.SetLLCalcLogic;
import model.entity.Account;
import model.entity.Location;
import model.entity.LocationLevel;
import model.entity.TotalPoint;



@WebServlet("/MainRegistServlet")
public class MainRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainRegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//locationlevelの更新処理
	//SetLLCalcLogicの処理
		//session(locationlevel)の取得
		HttpSession session = request.getSession();
		//スコープの利用準備
		ArrayList<LocationLevel> lllist = new ArrayList<>();
		//スコープの値を取得
		lllist = (ArrayList<LocationLevel>) session.getAttribute("locationLevel");
		//activeLocationIdの判別
		int activeLocationId = Integer.parseInt(request.getParameter("active-location-id"));
		//スコープの中から該当レコードを取得
		LocationLevel locationLevel = lllist.get(activeLocationId - 1);
		//BOの処理の準備
		int nowLLevel = locationLevel.getNowLLevel();
		Date uLateCleanedDate = locationLevel.getLateCleanedDate();
		Date nowDate = new Date();

		long difference = TimeUnit.DAYS.convert(nowDate.getTime() - uLateCleanedDate.getTime(), TimeUnit.MILLISECONDS);

		//session(location)の取得
		//スコープの利用準備
		ArrayList<Location> llist = new ArrayList<>();
		//スコープの値を取得
		llist = (ArrayList<Location>) session.getAttribute("location");
		//スコープの中から該当レコードを取得
		Location location = llist.get(activeLocationId - 1);
	//BOの処理の準備
		int frequency = location.getFrequency();
		//計算 + 戻り値の獲得
		SetLLCalcLogic llbo = new SetLLCalcLogic();
		int nowLevel = llbo.execute(nowLLevel, (int)difference, frequency);

	//LocationLevelDAOの処理
		//session(account)の取得
		Account account = (Account)session.getAttribute("account");
		int groupId = account.getGroupId();
		LocationLevelDAO llDAO = new LocationLevelDAO();

		long timeInMilliSecounds1 = nowDate.getTime();
		java.sql.Date dateNow1 = new java.sql.Date(timeInMilliSecounds1);

		int upDateNum = llDAO.updater(groupId, activeLocationId, 5, dateNow1);
//locationlevelの更新処理終了


//cleanedDateの登録処理  (: 追加機能)
		//CleanedDateDAOの処理
		//util.date→sql.dateへ変換
		//nowDate→util.date, dateNow→sql.date
		long timeInMilliSecounds = nowDate.getTime();
		java.sql.Date dateNow = new java.sql.Date(timeInMilliSecounds);

		int userId = account.getUserId();
		int cleanedPoint = location.getSetPoint();
		String doneName = account.getUserName();
		CleanedDateDAO cdDAO = new CleanedDateDAO();
		int upDateCDNum = cdDAO.register(groupId, activeLocationId, userId, doneName, dateNow, cleanedPoint);

//cleanedDateの登録処理終了

//totalpointの更新処理(:追加機能)
	//AddTPCalcLogicの処理
		//スコープの利用準備
		ArrayList<TotalPoint> tplist = new ArrayList<>();
		//スコープの値を取得
		tplist = (ArrayList<TotalPoint>) session.getAttribute("totalPoint");
		int activeUserId = account.getUserId();
		TotalPoint totalPoint = tplist.get(activeUserId -1 );
		//BOの処理の準備
		int tpoint = totalPoint.getTotalPoint();
		//獲得point定義 location→set_point
		int point = location.getSetPoint();
		//計算 + 戻り値の獲得
		AddTPCalcLogic atpbo = new AddTPCalcLogic();
		tpoint = atpbo.execute(tpoint, point);

	//TotalPointDAOの処理
		//int userId = account.getUserId();
		TotalPointDAO tpDAO = new TotalPointDAO();
		int upDateTPNum = tpDAO.updater(groupId, userId, tpoint);

//totalpointの更新処理終了


		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserPageServlet");
		dispatcher.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

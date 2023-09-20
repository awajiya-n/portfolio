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

import dao.AccountDAO;
import dao.CleanedDateDAO;
import dao.EventDAO;
import dao.LocationDAO;
import dao.LocationInfoDAO;
import dao.LocationLevelDAO;
import dao.TotalPointDAO;
import dao.TrophyDAO;
import model.entity.Account;
import model.entity.CleanedDate;
import model.entity.Event;
import model.entity.Location;
import model.entity.LocationInfo;
import model.entity.LocationLevel;
import model.entity.TotalPoint;
import model.entity.Trophy;


@WebServlet("/UserPageServlet")
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
//
//accountスコープの獲得
		HttpSession session = request.getSession();
		Account account = new Account();
		account = (Account)session.getAttribute("account");

//Login_Flgのリクエスト情報があった場合は処理を実施
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("Login_Flg")!=null) {
		account.setLoginFlg(Integer.parseInt(request.getParameter("Login_Flg")));
		}

//➀accountスコープからgroupId,LoginFlgを持ってくる
//		HttpSession session = request.getSession();
//		Account account = new Account();
//		account = (Account)session.getAttribute("account");
		int groupId = account.getGroupId();
		int loginFlg = account.getLoginFlg();

		if (loginFlg == 1) {
			//➁DAOの処理:getGroupInfo → sessionに保存

			//LocationDAO
				LocationDAO ldao = new LocationDAO();
				List<Location> llist = ldao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("location", llist);
			//LocationLevelDAO
				LocationLevelDAO lldao = new LocationLevelDAO();
				List<LocationLevel> lllist = lldao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("locationLevel", lllist);
			//CleanedDateDAO
				CleanedDateDAO cddao = new CleanedDateDAO();
				List<CleanedDate> cdlist = cddao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("cleanedDate", cdlist);
			//TrophyDAO
				TrophyDAO tdao = new TrophyDAO();
				List<Trophy> tlist = tdao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("trophy", tlist);
			//EventDAO
				EventDAO edao = new EventDAO();
				List<Event> elist = edao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("event", elist);
			//TotalPointDAO
				TotalPointDAO tpdao = new TotalPointDAO();
				List<TotalPoint> tplist = tpdao.getGroupInfo(groupId);
//				TotalPoint tp1 = new TotalPoint(1, 0, 0);
//				TotalPoint tp2 = new TotalPoint(1, 1, 0);
//				List<TotalPoint> tplist = new ArrayList<>();
//				tplist.add(tp1);
//				tplist.add(tp2);
				tplist = tpdao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("totalPoint", tplist);
			//LocationInfoDAO
				LocationInfoDAO lidao = new LocationInfoDAO();
				List<LocationInfo> lilist = lidao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("locationInfo", lilist);


		//➂forward
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
		} else {
			//玉井さん・白石さんの記述場所

			//➁DAOの処理:getGroupInfo → sessionに保存
			//AccountDAO
		    AccountDAO adao = new AccountDAO();
		    List<Account> alist = adao.getGroupInfo(groupId);
		    session.setAttribute("accountList", alist);
			//LocationDAO
				LocationDAO ldao = new LocationDAO();
				List<Location> llist = ldao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("location", llist);
			//CleanedDateDAO
				CleanedDateDAO cddao = new CleanedDateDAO();
				List<CleanedDate> cdlist = cddao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("cleanedDate", cdlist);
			//TrophyDAO
				TrophyDAO tdao = new TrophyDAO();
				List<Trophy> tlist = tdao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("trophy", tlist);
			//EventDAO
				EventDAO edao = new EventDAO();
				List<Event> elist = edao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("event", elist);
			//TotalPointDAO
				TotalPointDAO tpdao = new TotalPointDAO();
				List<TotalPoint> tplist = tpdao.getGroupInfo(groupId);
//				TotalPoint tp1 = new TotalPoint(1, 0, 0);
//				TotalPoint tp2 = new TotalPoint(1, 1, 0);
//				List<TotalPoint> tplist = new ArrayList<>();
//				tplist.add(tp1);
//				tplist.add(tp2);
				tplist = tpdao.getGroupInfo(groupId);
				//sessionスコープに保存
				session.setAttribute("totalPoint", tplist);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		doGet(request, response);
	}

}

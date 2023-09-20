package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.AccountDAO;
import model.entity.Account;

/**
 * Servlet implementation class FirstAdminRegistServlet
 */
@WebServlet("/FirstAdminRegistServlet")
public class FirstAdminRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstAdminRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //siraisi

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// JSONデータを受け取る
        StringBuilder jsonData = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }

        // JSONデータをArrayListに収納
        ArrayList<Map<String, Object>> dataList = new ArrayList<>();

		try {
			JSONArray jsonArray = new JSONArray(jsonData.toString());

		for (int i = 0; i < jsonArray.length(); i++) {
		    JSONObject jsonObject = jsonArray.getJSONObject(i);
		 // JSONデータをHashMapに格納
		    Map<String, Object> dataMap = new HashMap<>();
		    dataMap.put("userName", jsonObject.getString("userName"));
		    dataMap.put("userPass", jsonObject.getString("userPass"));
		    dataMap.put("admin_flg", jsonObject.getString("admin_flg"));

		    // HashMapをArrayListに追加
		    dataList.add(dataMap);}
		} catch (JSONException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//UserPageServletに渡す
		HttpSession session = request.getSession();
		Account ac = (Account)session.getAttribute("account");
		int groupId = ac.getGroupId();
		String groupName = ac.getGroupName();

	    //AccountDAOを使ってSQL登録
	    AccountDAO adao = new AccountDAO();
	    //adao(groupId,groupName,accountDate);←AccountDAOに追加してから
	    ac = adao.register(groupId, groupName, dataList, ac);

		//　login_flgの付与実施
		ac.setLoginFlg(0);
		session.setAttribute("account",ac);
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/UserPageServlet");
		dispatcher.forward(request, response);
        }
}

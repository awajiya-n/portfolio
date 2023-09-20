package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.entity.Account;
import model.entity.Login;

public class AccountDAO implements DbConnection{

	public Account findByLogin(Login login) {
		// account変数をnullで設定
		Account account = null;

		// SQLへ接続
		try(Connection conn = DriverManager.getConnection(URL,USER,PASS)){
			// SQL文の指示
			String sql ="SELECT GROUP_ID,GROUP_NAME,USER_ID,USER_NAME,USER_PASS,ADMIN_FLG FROM ACCOUNT WHERE GROUP_ID= ? AND USER_PASS= ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// リクエストをSQL文に反映
			pStmt.setString(1,String.valueOf(login.getGroupId()));
			pStmt.setString(2,login.getUserPass());

			// 結果を格納
			ResultSet rs = pStmt.executeQuery();

			// 結果が返ってきたときの処理
			if(rs.next()) {
				// 各値を変数へ格納
				int groupId = rs.getInt("GROUP_ID");
				// int groupId = Integer.parseInt(rs.getString("GROUP_ID"));
				String groupName = rs.getString("GROUP_NAME");
				int userId = rs.getInt("USER_ID");
				// int userId = Integer.parseInt(rs.getString("USER_ID"));
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				int adminFlg = rs.getInt("ADMIN_FLG");
				// account変数にインスタンス化して値を格納
				account = new Account(groupId,groupName,userId,userName,userPass,adminFlg);
			}
		// 例外処理
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("例外処理実施");
			return null;
		}
		// accountに格納された値（null or インスタンス）を返り値として返す
		return account;
	}


	public Account SetFirstAdmin(Account account) {

		// SQLへ接続
		try(Connection conn = DriverManager.getConnection(URL,USER,PASS)){
			// SQL文の指示
			String sql = "INSERT INTO account(GROUP_NAME,USER_ID,USER_NAME,USER_PASS,ADMIN_FLG )VALUES(?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の？に使用する値を設定
			pStmt.setString(1,account.getGroupName());
			pStmt.setInt(2,account.getUserId());
			pStmt.setString(3,account.getUserName());
			pStmt.setString(4,account.getUserPass());
			pStmt.setInt(5,account.getAdminFlg());

			//INSERTを実行
			pStmt.executeUpdate();

			// SQL文の指示
			sql = "SELECT GROUP_ID,GROUP_NAME,USER_ID,USER_NAME,USER_PASS,ADMIN_FLG FROM account WHERE GROUP_NAME= ? AND USER_NAME= ? AND USER_PASS=?";
			pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,account.getGroupName());
			pStmt.setString(2,account.getUserName());
			pStmt.setString(3,account.getUserPass());

			//SELECTを実行し、ResultSetを取得
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()){
				int groupId = rs.getInt("GROUP_ID");
				String groupName = rs.getString("GROUP_NAME");
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				int userId = rs.getInt("USER_ID");
				int adminFlg = rs.getInt("ADMIN_FLG");

				account.setGroupId(groupId);
				account.setGroupName(groupName);
				account.setUserName(userName);
				account.setUserPass(userPass);
				account.setUserId(userId);
				account.setAdminFlg(adminFlg);
			}
		}catch(SQLException e){
		e.printStackTrace();
		System.out.println("SQLエラー");
		return null;

		}
		return account;
	}

public Account register(int groupId, String groupName, ArrayList<Map<String, Object>> dataList, Account account){

	int i;
	for (i = 0; i < dataList.size(); i++) {
		Map<String, Object> data = dataList.get(i);
	    String name = (String) data.get("userName");
	    String password = (String) data.get("userPass");
	    int flag = (int) data.get("admin_flg");

	    // データの処理
	    System.out.println(name);
	    System.out.println(password);
	    System.out.println(flag);

	    try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
	        String sql = "INSERT INTO account(GROUP_ID, GROUP_NAME, USER_ID, USER_NAME, USER_PASS, ADMIN_FLG) VALUES(?, ?, ?, ?, ?, ?)";
	        PreparedStatement pStmt = conn.prepareStatement(sql);

	        // パラメータを設定
	        pStmt.setInt(1, groupId);
	        pStmt.setString(2, groupName);
	        pStmt.setInt(3, i + 1); // ユーザーID
	        pStmt.setString(4, name);
	        pStmt.setString(5, password);
	        pStmt.setInt(6, flag);

	        // クエリを実行
	        pStmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // SQLエラーの処理
	    }
	}
	return account;
	}

public List<Account> getGroupInfo(int groupId) {
	ArrayList<Account> list = new ArrayList<Account>();

	try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
		String sql = "SELECT * FROM account WHERE group_id = ? ";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setInt(1, groupId);

		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {
			   int group_id = rs.getInt("group_id");
			   String group_name = rs.getString("group_name");
			   int user_id = rs.getInt("user_id");
			   String user_name = rs.getString("user_name");
			   String user_pass = rs.getString("user_pass");
			   int admin_flg = rs.getInt("admin_flg");

			   Account account = new Account(group_id,group_name,user_id,user_name,user_pass,admin_flg);
			   list.add(account);
			}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}

//	LList lList = new LList(list);
//	return lList;
	return list;
}

}

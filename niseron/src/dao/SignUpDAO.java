package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class SignUpDAO {

	// 接続先情報を変数として準備
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/niseron";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public void signUpUser(User user){

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// INSERT文を準備し、初期登録時に入力した情報から必要情報を取得しSQL文へ反映する
			String sql = "INSERT INTO USER VALUES (null,?,?,0,0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,user.getName());
			pStmt.setString(2,user.getPass());

			// INSERT文を実行
			pStmt.executeUpdate();

			// 登録完了した情報からユーザーIDを抽出する
			CheckUserDAO checkUserDAO = new CheckUserDAO();
			User newUser = checkUserDAO.checkUser(user);
			Integer userId = Integer.valueOf(newUser.getUserId());
			String id = userId.toString();

			// INSERT文を準備し、初期カード数を設定
			sql = "INSERT INTO USER_CARD VALUES (?,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);

			// INSERT文を実行
			pStmt.executeUpdate();
		}
		// 実行時にエラーが発生した場合は何もしない
		catch (SQLException e)
		{
		e.printStackTrace();
		}
	}
}

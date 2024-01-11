package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class CheckUserDAO {

	// 接続先情報を変数として準備
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/niseron";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public User checkUser(User user){

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			// SELECT文を準備し、ログイン時の情報から必要情報を取得しSQL文へ反映する
			String sql = "SELECT USER_ID,NAME,WIN,LOSE FROM USER WHERE NAME = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,user.getName());
			pStmt.setString(2, user.getPass());

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果が取得できた場合はユーザー情報を検索結果より取得しインスタンスへ保存
			if(rs.next())
			{
				user.setUserId(rs.getInt("USER_ID"));
				user.setName(rs.getString("NAME"));
				user.setWinPoint(rs.getInt("WIN"));
				user.setLosePoint(rs.getInt("LOSE"));
			}
			// 結果が取得できなかった場合はユーザー情報をnullにする
			else
			{
				user = null;
			}

		}
		// 検索時にエラーが発生した場合はnullを返す
		catch (SQLException e)
		{
		e.printStackTrace();
		return null;
		}
		// 検索結果を格納したインスタンスを返す
		return user;
	}

}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDeleteDAO {

	// 接続先情報を変数として準備
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/niseron";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public void UserReset(User user) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// DELETE文でUSERテーブルからデータを削除する指示文を準備する
			String sql = "DELETE FROM USER WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());
			// UPDATE文を実行
			pStmt.executeUpdate();

			// DELETE文でUSERテーブルからデータを削除する指示文を準備する
			sql = "DELETE FROM USER_CARD WHERE USER_ID = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());
			// UPDATE文を実行
			pStmt.executeUpdate();

		}catch (SQLException e)
			{
			e.printStackTrace();
			}
	}
}

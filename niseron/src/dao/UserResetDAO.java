package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserResetDAO {

	// 接続先情報を変数として準備
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/niseron";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public void UserReset(User user) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// UPDATE文で各カードが1枚になる指示文を準備する
			String sql = "UPDATE USER_CARD SET NO_0 = 1,NO_1 = 1,NO_2 = 1,NO_3 = 1,NO_4 = 1,"
					+ "NO_5 = 1,NO_6 = 1,NO_7 = 1,NO_8 = 1,NO_9 = 1,"
					+ "DOUBLE_C = 1,HIGHLOW_C = 1,TARGET_C = 1,SLASH_C = 1,"
					+ "SHUFFLE_C = 1,CHANGE_C = 1 WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());
			// UPDATE文を実行
			pStmt.executeUpdate();

			// UPDATE文で勝利数と敗北数が0になる指示文を準備する
			sql = "UPDATE USER SET WIN = 0,LOSE = 0 WHERE USER_ID = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());
			pStmt.executeUpdate();

		}catch (SQLException e)
			{
			e.printStackTrace();
			}
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CardDate;
import model.User;

public class PlayResultDAO {

	// 接続先情報を変数として準備
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/niseron";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public void WinCountRaiserSimple(User user,CardDate CardDate) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// SELECT文を準備し、勝者の勝利カウントを取得する
			String sql = "SELECT WIN FROM USER WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());
			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			// 勝利数を変数に保存
			while(rs.next()) {
				int winCount = rs.getInt("WIN");
				// UPDATE文を用意し、勝利数を更新する
				sql = "UPDATE USER SET WIN = ? WHERE USER_ID = ?" ;
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,winCount+1);
				pStmt.setInt(2, user.getUserId());
				// UPDATE文を実行
				pStmt.executeUpdate();
			}

		}catch (SQLException e)
			{
			e.printStackTrace();
			}
	}

	public void WinCardRaiserSimple(User user,CardDate CardDate) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			// UPDATE文を用意し、所有カード数を更新する
			String sql = "UPDATE USER_CARD SET NO_0 = ?,NO_1 = ?,NO_2 = ?,NO_3 = ?,NO_4 = ?,NO_5 = ?,NO_6 = ?,NO_7 = ?,NO_8 = ?,NO_9 = ? WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,CardDate.getNo_0());
			pStmt.setInt(2,CardDate.getNo_1());
			pStmt.setInt(3,CardDate.getNo_2());
			pStmt.setInt(4,CardDate.getNo_3());
			pStmt.setInt(5,CardDate.getNo_4());
			pStmt.setInt(6,CardDate.getNo_5());
			pStmt.setInt(7,CardDate.getNo_6());
			pStmt.setInt(8,CardDate.getNo_7());
			pStmt.setInt(9,CardDate.getNo_8());
			pStmt.setInt(10,CardDate.getNo_9());
			pStmt.setInt(11,user.getUserId());

			// UPDATE文を実行
			pStmt.executeUpdate();
		}
		// 実行時にエラーが発生した場合は何もしない
		catch (SQLException e)
		{
		e.printStackTrace();
		}

	}

	public void LoseCountRaiserSimple(User user,CardDate CardDate) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// SELECT文を準備し、敗者の敗北カウントを取得する
			String sql = "SELECT LOSE FROM USER WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());
			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			// 敗北数を変数に保存
			while(rs.next()) {
				int loseCount = rs.getInt("LOSE");
				// UPDATE文を用意し、敗北数を更新する
				sql = "UPDATE USER SET LOSE = ? WHERE USER_ID = ?" ;
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,loseCount+1);
				pStmt.setInt(2, user.getUserId());
				// UPDATE文を実行
				pStmt.executeUpdate();
			}

		}catch (SQLException e)
		{
			e.printStackTrace();
		}
}

	public void LoseCardReduserSimple(User user,CardDate CardDate) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			// UPDATE文を用意し、所有カード数を更新する
			String sql = "UPDATE USER_CARD SET NO_0 = ?,NO_1 = ?,NO_2 = ?,NO_3 = ?,NO_4 = ?,NO_5 = ?,NO_6 = ?,NO_7 = ?,NO_8 = ?,NO_9 = ? WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,CardDate.getNo_0());
			pStmt.setInt(2,CardDate.getNo_1());
			pStmt.setInt(3,CardDate.getNo_2());
			pStmt.setInt(4,CardDate.getNo_3());
			pStmt.setInt(5,CardDate.getNo_4());
			pStmt.setInt(6,CardDate.getNo_5());
			pStmt.setInt(7,CardDate.getNo_6());
			pStmt.setInt(8,CardDate.getNo_7());
			pStmt.setInt(9,CardDate.getNo_8());
			pStmt.setInt(10,CardDate.getNo_9());
			pStmt.setInt(11,user.getUserId());

			// UPDATE文を実行
			pStmt.executeUpdate();
		}
		// 実行時にエラーが発生した場合は何もしない
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

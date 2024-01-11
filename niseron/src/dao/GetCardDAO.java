package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.CardDate;

public class GetCardDAO {
	// 接続先情報を変数として準備
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/niseron";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public CardDate userCard(User user){
		// 検索結果を格納するインスタンスを作成
		CardDate userCardDate = new CardDate();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			// SELECT文を準備し、ユーザー情報から必要情報を取得しSQL文へ反映する
			String sql = "SELECT NO_0,NO_1,NO_2,NO_3,NO_4,NO_5,NO_6,NO_7,NO_8,NO_9,"
						+ "DOUBLE_C,HIGHLOW_C,TARGET_C,SLASH_C,SHUFFLE_C,CHANGE_C "
						+ "FROM USER_CARD WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user.getUserId());

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// カード情報を検索結果より取得しインスタンスへ保存
			if(rs.next())
			{
				int no_0 = rs.getInt("NO_0");
				int no_1 = rs.getInt("NO_1");
				int no_2 = rs.getInt("NO_2");
				int no_3 = rs.getInt("NO_3");
				int no_4 = rs.getInt("NO_4");
				int no_5 = rs.getInt("NO_5");
				int no_6 = rs.getInt("NO_6");
				int no_7 = rs.getInt("NO_7");
				int no_8 = rs.getInt("NO_8");
				int no_9 = rs.getInt("NO_9");
				int double_c = rs.getInt("DOUBLE_C");
				int highlow_c = rs.getInt("HIGHLOW_C");
				int target_c = rs.getInt("TARGET_C");
				int slash_c = rs.getInt("SLASH_C");
				int shuffle_c = rs.getInt("SHUFFLE_C");
				int change_c = rs.getInt("CHANGE_C");

				userCardDate = new CardDate(no_0,no_1,no_2,no_3,no_4,no_5,no_6,no_7,no_8,no_9,double_c,
										highlow_c,target_c,slash_c,shuffle_c,change_c);

			}
		}
		// 検索時にエラーが発生した場合はnullを返す
		catch (SQLException e)
		{
		e.printStackTrace();
		return null;
		}
		// 検索結果を格納したインスタンスを返す
		return userCardDate;
	}
}

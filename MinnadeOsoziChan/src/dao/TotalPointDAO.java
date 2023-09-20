package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TotalPoint;

public class TotalPointDAO implements DbConnection{

	//ポイント情報(初期)登録:　ユーザー登録に基づいて追加したい
	public int register(int groupId, int userId) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO total_point VALUES(?, ?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);
			pStmt.setInt(2, userId);
			pStmt.setInt(3, 0);

			num = pStmt.executeUpdate();

			pStmt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	//ポイント更新用
	public int updater(int groupId, int userId, int totalPoint) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "UPDATE total_point SET total_point = ? WHERE group_id = ? AND user_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, totalPoint);
			pStmt.setInt(2, groupId);
			pStmt.setInt(3, userId);

			num = pStmt.executeUpdate();

			pStmt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	//ポイント情報取得用
	public List<TotalPoint> getGroupInfo(int groupId) {
			ArrayList<TotalPoint> list = new ArrayList<TotalPoint>();
	try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
		String sql = "SELECT * FROM total_point WHERE group_id = ? ";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setInt(1, groupId);

		ResultSet rs = pStmt.executeQuery();

		while (rs.next()) {
			int group_id = rs.getInt("group_id");
			int user_id = rs.getInt("user_id");
			int total_point = rs.getInt("total_point");

			TotalPoint totalPoint = new TotalPoint(group_id, user_id, total_point);
			list.add(totalPoint);
			}
		} catch (SQLException e) {
		    e.printStackTrace();
			return null;
}

//		TPList tPList = new TPList(list);
//		return tPList;
		return list;

	}
}
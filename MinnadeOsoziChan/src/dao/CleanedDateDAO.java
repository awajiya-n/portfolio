package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CleanedDate;

public class CleanedDateDAO implements DbConnection{

	//掃除情報の記録用(登録)

	public int register(int groupId, int activeLocationId, int userId, String doneName, Date nowDate, int cleanedPoint) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO cleaned_date VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);
			pStmt.setInt(2, activeLocationId);
			pStmt.setInt(3, userId);
			pStmt.setString(4, doneName);
			pStmt.setDate(5, nowDate);
			pStmt.setInt(6, cleanedPoint);

			num = pStmt.executeUpdate();

			pStmt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	//掃除情報の取得
	public List<CleanedDate> getGroupInfo(int groupId) {
		ArrayList<CleanedDate> list = new ArrayList<CleanedDate>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM cleaned_date WHERE group_id = ? ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int group_id = rs.getInt("group_id");
				int location_id = rs.getInt("location_id");
				int user_id = rs.getInt("user_id");
				String done_name = rs.getString("done_name");
				Date cleaned_date = rs.getDate("cleaned_date");
				int cleaned_point = rs.getInt("cleaned_point");

				CleanedDate cleanedDate = new CleanedDate(group_id, location_id, user_id, done_name, cleaned_date, cleaned_point);
				list.add(cleanedDate);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

//		CDList cDList = new CDList(list);
//		return cDList;
		return list;
	}

}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.LocationLevel;

public class LocationLevelDAO implements DbConnection {

	//掃除場所の掃除レベル情報の登録(追加)
	//(掃除情報初期登録に紐づいてレベル情報を追加するので多分使わない)
	public int register(int groupId, int activeLocationId, int nowLLevel, Date lateCleanedDate) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO location_level VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);
			pStmt.setInt(2, activeLocationId);
			pStmt.setInt(3, nowLLevel);
			pStmt.setDate(4, lateCleanedDate);

			num = pStmt.executeUpdate(sql);

			pStmt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}


	//掃除場所の掃除レベル情報の編集
		public int updater(int groupId, int activeLocationId, int nowLLevel, Date lateCleanedDate) {
			int num = 0;

			try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
				String sql = "UPDATE location_level SET now_llevel = ?, late_cleaned_date = ? WHERE group_id = ? AND location_id = ?";
				PreparedStatement pStmt = con.prepareStatement(sql);
				pStmt.setInt(1, nowLLevel);
				pStmt.setDate(2, lateCleanedDate);
				pStmt.setInt(3, groupId);
				pStmt.setInt(4, activeLocationId);

				num = pStmt.executeUpdate();

				pStmt.close();

			} catch(SQLException e) {
				e.printStackTrace();
			}
			return num;
		}


	//掃除場所レベル情報の取得
	public List<LocationLevel> getGroupInfo(int groupId) {
		ArrayList<LocationLevel> list = new ArrayList<LocationLevel>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM location_level WHERE group_id = ? ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				   int group_id = rs.getInt("group_id");
				   int location_id = rs.getInt("location_id");
				   int now_llevel = rs.getInt("now_llevel");
				   Date late_cleaned_date = rs.getDate("late_cleaned_date");
				   LocationLevel location_level = new LocationLevel(group_id, location_id, now_llevel, late_cleaned_date);
				   list.add(location_level);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

//		LLList lLList = new LLList(list);
//		return lLList;
		return list;
	}

}

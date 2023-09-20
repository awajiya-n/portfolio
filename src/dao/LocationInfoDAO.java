package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.LocationInfo;

public class LocationInfoDAO implements DbConnection {
	public List<LocationInfo> getGroupInfo (int groupId) {
		ArrayList<LocationInfo> list = new ArrayList<LocationInfo>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT L.group_id, L.location_id, L.character_id, L.room_photo_id, LL.now_llevel, room_png_path, C.char_detail_id, C.char_png_path, LCD.late_cleaned_date, LCD.done_name"
					+ " FROM location AS L"
					+ " LEFT JOIN location_level AS LL ON L.group_id = LL.group_id AND L.location_id = LL.location_id"
					+ " LEFT JOIN room_photo AS R ON L.room_photo_id = R.room_id"
					+ " LEFT JOIN chara AS C ON L.character_id = C.char_id AND LL.now_llevel = C.char_detail_id"
					+ " LEFT JOIN (SELECT A.group_id, A.location_id, A.user_id, A.done_name, A.cleaned_date AS late_cleaned_date FROM (SELECT *, row_number() over (PARTITION BY location_id ORDER BY cleaned_date DESC) AS num FROM cleaned_date WHERE group_id = ?) AS A WHERE A.num = 1) AS LCD"
					+ " ON L.group_id = LCD.group_id AND L.location_id = LCD.location_id"
					+ " WHERE L.group_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);
			pStmt.setInt(2, groupId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int group_id = rs.getInt("group_id");
				int location_id = rs.getInt("location_id");
				String room_png_path = rs.getString("room_png_path");
				int char_id = rs.getInt("character_id");
				int char_detail_id = rs.getInt("char_detail_id");
				String char_png_path = rs.getString("char_png_path");
				Date late_cleaned_date = rs.getDate("late_cleaned_date");
				String done_name = rs.getString("done_name");

				LocationInfo locationInfo = new LocationInfo(group_id, location_id, room_png_path, char_id, char_detail_id, char_png_path, late_cleaned_date, done_name);

				list.add(locationInfo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
//		LIList lIList = new LIList(list);
//		return lIList;
		return list;

	}

}

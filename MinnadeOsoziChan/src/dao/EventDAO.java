package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Event;


public class EventDAO implements DbConnection{

	//イベント情報の登録・追加用
	public int register(int groupId, Date startDate, Date endDate, String text) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO event_date VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1,  groupId);
			pStmt.setDate(2, startDate);
			pStmt.setDate(3, endDate);
			pStmt.setString(4, text);


			num = pStmt.executeUpdate();

			pStmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}


	//イベント情報の編集用
		//SQL文 要検討:WHEREでgroupidのみだと全て書き換えられる
		//追加機能の為後回し
		//→eventIdを作る
		public int updater(int groupId, Date startDate, Date endDate, String text) {
			int num = 0;

			try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
				String sql = "UPDATE event_date SET start_date = ?, end_date = ?, text = ? WHERE group_id = ?";
				PreparedStatement pStmt = con.prepareStatement(sql);
				pStmt.setDate(1, startDate);
				pStmt.setDate(2, endDate);
				pStmt.setString(3, text);
				pStmt.setInt(4,  groupId);

				num = pStmt.executeUpdate();

				pStmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return num;
		}


	//イベント情報取得用
	public List<Event> getGroupInfo(int groupId) {
		ArrayList<Event> list = new ArrayList<Event>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM event_date WHERE group_id = ? ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int group_id = rs.getInt("group_id");
				Date start_date = rs.getDate("start_date");
				Date end_date = rs.getDate("end_date");
				String text = rs.getString("text");

				Event event = new Event(group_id, start_date, end_date, text);
				list.add(event);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

//		EList eList = new EList(list);
//		return eList;
		return list;
	}

}

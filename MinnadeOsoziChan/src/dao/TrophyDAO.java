package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Trophy;

public class TrophyDAO implements DbConnection{

	//ごほうびリスト登録・追加用
	public int register(int groupId, int trophyId, String trophyName, int trophyPoint) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO trophy_point VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);
			pStmt.setInt(2, trophyId);
			pStmt.setString(3, trophyName);
			pStmt.setInt(4, trophyPoint);

			num = pStmt.executeUpdate(sql);

			pStmt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	//ごほうびリスト編集用
	public int updater(int groupId, int trophyId, String trophyName, int trophyPoint) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "UPDATE trophy SET trophy_name = ?, trophy_point = ? WHERE group_id = ? AND trophy_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, trophyName);
			pStmt.setInt(2, trophyPoint);
			pStmt.setInt(3, groupId);
			pStmt.setInt(4, trophyId);

			num = pStmt.executeUpdate(sql);

			pStmt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	//ごほうびリスト情報取得用
	public List<Trophy> getGroupInfo(int groupId) {
		ArrayList<Trophy> list = new ArrayList<Trophy>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM trophy WHERE group_id = ? ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int group_id = rs.getInt("group_id");
				int trophy_id = rs.getInt("trophy_id");
				String trophy_name  = rs.getString("trophy_name");
				int trophy_point = rs.getInt("trophy_point");

				Trophy trophy = new Trophy(group_id, trophy_id, trophy_name, trophy_point);
				list.add(trophy);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

//		TList tList = new TList(list);
//		return tList;
		return list;
	}

}

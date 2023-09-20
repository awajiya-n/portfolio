package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.Location;

public class LocationDAO implements DbConnection {


	//掃除場所情報の登録・追加用

		public int register(int groupId, int locationId, String locationName, int frequency, int characterId, int roomPhotoId, int setPoint) {
			int num = 0;

			try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
				String sql = "INSERT INTO location VALUES(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = con.prepareStatement(sql);
				pStmt.setInt(1, groupId);
				pStmt.setInt(2, locationId);
				pStmt.setString(3, locationName);
				pStmt.setInt(4, frequency);
				pStmt.setInt(5, characterId);
				pStmt.setInt(6, roomPhotoId);
				pStmt.setInt(7, setPoint);

				num = pStmt.executeUpdate();

				//掃除場所初期登録と同時にlocation_levelテーブルのレベル初期値を登録
				String sql2 = "INSERT INTO location_level VALUES(?, ?, ?, ?)";
				PreparedStatement pStmt2 = con.prepareStatement(sql2);
				pStmt2.setInt(1, groupId);
				pStmt2.setInt(2, locationId);
				pStmt2.setInt(3, 5);
				Date nowDate = new Date();
				//sql.Dateに変換
				long time = nowDate.getTime();
				java.sql.Date sqlDate = new java.sql.Date(time);
				pStmt2.setDate(4, sqlDate);

				pStmt2.executeUpdate();

				pStmt.close();

				pStmt2.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return num;

		}

	//掃除場所情報の編集用
	public int updater(int groupId, int locationId, String locationName, int frequency, int characterId, int roomPhotoId, int setPoint) {
		int num = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "UPDATE location SET location_name = ?, frequency = ?, character_id = ?, room_photo_id = ?, set_point = ? WHERE group_id = ? AND location_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, locationName);
			pStmt.setInt(2, frequency);
			pStmt.setInt(3, characterId);
			pStmt.setInt(4, roomPhotoId);
			pStmt.setInt(5, setPoint);
			pStmt.setInt(6, groupId);
			pStmt.setInt(7, locationId);

			num = pStmt.executeUpdate();

			pStmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;

	}

	//掃除場所情報取得用
	public List<Location> getGroupInfo(int groupId) {
		ArrayList<Location> list = new ArrayList<Location>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM location WHERE group_id = ? ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, groupId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				   int group_id = rs.getInt("group_id");
				   int location_id = rs.getInt("location_id");
				   String location_name = rs.getString("location_name");
				   int frequency = rs.getInt("frequency");
				   int charaId = rs.getInt("character_id");
				   int roomPhotoId = rs.getInt("room_photo_id");
				   int setPoint = rs.getInt("set_point");

				   Location location = new Location(group_id,location_id,location_name,frequency,charaId,roomPhotoId,setPoint);
				   list.add(location);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

//		LList lList = new LList(list);
//		return lList;
		return list;
	}
}

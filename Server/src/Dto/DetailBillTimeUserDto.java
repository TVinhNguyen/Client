package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.DetailBillTimeUser;

public class DetailBillTimeUserDto {
//lấy tất cả danh sách
	public static List<DetailBillTimeUser> getAllDetailBillTimeUser() throws SQLException
	{
		String query="select * from DetailBillTimeUser";
		List<DetailBillTimeUser> list=new ArrayList<DetailBillTimeUser>();
		try(Connection conn=DBConnection.getConnection();
			PreparedStatement statement=conn.prepareStatement(query)
				) {
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				int id=resultset.getInt("id");
				int idBillHistory=resultset.getInt("idBillHistory");
				int idTimeUserComputer=resultset.getInt("idTimeUserComputer");
				list.add(new DetailBillTimeUser(id, idBillHistory, idTimeUserComputer));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//cập nhật và thêm 
	public static String addEndUpdateDetailBillTimeUser(
	        int idDetailBillTimeUser,
	        int idBillHistory,
	        int idTimeUserComputer
	) {
	    String query = "INSERT INTO detailbilltimeuser (idBillHistory, idTimeUserComputer) VALUES (?, ?)";
	    boolean check = false;
	    try {
			for (var detail : getAllDetailBillTimeUser()) {
			    if (detail.getId() == idDetailBillTimeUser) {
			        query = "UPDATE detailbilltimeuser SET idBillHistory = ?, idTimeUserComputer = ? WHERE id = ?";
			        check = true;
			        break;
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, idBillHistory);
	        statement.setInt(2, idTimeUserComputer);
	        if (check) {
	            statement.setInt(3, idDetailBillTimeUser);
	        }
	        int result = statement.executeUpdate();
	        if (result > 0) {
	            return check ? "Cập nhật detailbilltimeuser thành công !!!" : "Thêm detailbilltimeuser thành công !!!";
	        } else {
	            return check ? "Cập nhật detailbilltimeuser không thành công !!!" : "Thêm detailbilltimeuser không thành công !!!";
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Có lỗi khi thêm hoặc cập nhật detailbilltimeuser !!!";
	    }
	}

}

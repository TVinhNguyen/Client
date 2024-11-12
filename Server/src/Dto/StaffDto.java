package Dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Staff;

public class StaffDto {
//lấy tất cả danh sách nhân viên
public static List<Staff> getAllStaffs()
{
	List<Staff> staffs=new ArrayList<Staff>();
	String query="select * from Staff";
	try(Connection connection=DBConnection.getConnection();
		PreparedStatement statement=connection.prepareStatement(query)) {
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			int idStaff=resultSet.getInt("idStaff");
			String nameStaff=resultSet.getString("nameStaff");
			String phoneStaff=resultSet.getString("phoneStaff");
			String nameAccount=resultSet.getString("nameAccount");
			String passwordAccount=resultSet.getString("passwordAccount");
			String addressStaff=resultSet.getString("addressStaff");
			Date timeStartWork=resultSet.getDate("timeStartWork");
			int dayWork=resultSet.getInt("dayWork");
			int idRole=resultSet.getInt("idRole");
			staffs.add(new Staff(idStaff, nameStaff, phoneStaff, nameAccount, passwordAccount, addressStaff,timeStartWork,dayWork, idRole));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return staffs;
}
//Thêm và cập nhật nhân viên
public static String addEndUpdateStaff(int idStaff, String nameStaff, String phoneStaff,
    String nameAccount, String passwordAccount, String addressStaff, Date timeStartWork, 
        int dayWork, int idRole) {
    String query = "INSERT INTO Staff (nameStaff, phoneStaff, nameAccount, passwordAccount, addressStaff, "
            + "timeStartWork, dayWork, idRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    boolean isUpdate = false;
    for (var staff : getAllStaffs()) {
        if (staff.getIdStaff() == idStaff) {
            query = "UPDATE Staff SET nameStaff = ?, phoneStaff = ?, nameAccount = ?, passwordAccount = ?, "
                    + "addressStaff = ?, timeStartWork = ?, dayWork = ?, idRole = ? WHERE idStaff = ?";
            isUpdate = true;
            break;
        }
    }
    try (Connection conn = DBConnection.getConnection(); 
         PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setString(1, nameStaff);
        statement.setString(2, phoneStaff);
        statement.setString(3, nameAccount);
        statement.setString(4, passwordAccount);
        statement.setString(5, addressStaff);
        statement.setDate(6, timeStartWork);
        statement.setInt(7, dayWork);
        statement.setInt(8, idRole);
        if (isUpdate) {
            statement.setInt(9, idStaff);
        }
        int result = statement.executeUpdate();
        if (result > 0) {
            return isUpdate ? "Cập nhật nhân viên thành công !!!" : "Thêm nhân viên thành công !!!";
        } else {
            return isUpdate ? "Cập nhật nhân viên không thành công !!!" : "Thêm nhân viên không thành công !!!";
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        return "Có lỗi khi thêm hoặc cập nhật nhân viên !!!";
    }
}

}

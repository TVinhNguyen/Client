package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Status;

public class StatusDto {
	//lấy tất cả giá trị
public static List<Status> getAllStatus()
{
	List<Status> list=new ArrayList<Status>();
	String query="select * from status";
	try(Connection conn=DBConnection.getConnection();
		PreparedStatement statement=conn.prepareStatement(query);	
			) {
		ResultSet resultset=statement.executeQuery();
		while(resultset.next())
		{
			int id=resultset.getInt("id");
			int idCustomer=resultset.getInt("idCustomer");
			int idComputer=resultset.getInt("idComputer");
			list.add(new Status(id, idCustomer, idComputer));
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
public static String addStatus(int idCustomer, int idComputer) {
    String query = "INSERT INTO status (idCustomer, idComputer) VALUES (?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {
        
        // Thiết lập các tham số cho câu lệnh SQL
        statement.setInt(1, idCustomer);
        statement.setInt(2, idComputer);
        
        // Thực thi câu lệnh
        int result = statement.executeUpdate();
        
        if (result > 0) {
            return "Thêm trạng thái thành công!";
        } else {
            return "Thêm trạng thái không thành công!";
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "Có lỗi khi thêm trạng thái!";
    }
}
public static String deleteStatus(int id) {
    String query = "DELETE FROM status WHERE id = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {
        
        // Thiết lập tham số cho câu lệnh SQL
        statement.setInt(1, id);
        
        // Thực thi câu lệnh
        int result = statement.executeUpdate();
        
        if (result > 0) {
            return "Xóa trạng thái thành công!";
        } else {
            return "Không tìm thấy trạng thái để xóa!";
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "Có lỗi khi xóa trạng thái!";
    }
}
//lấy status bằng idComputer
public static Status getStatusByIdComputer(int idComputer)
{
	for(Status x: getAllStatus())
	{
		if(x.getIdComputer()==idComputer)
		{
			return x;
		}
	}
	return null;
}
//lấy status bằng idCustomer
public static Status getStatusByIdCustomer(int idCustomer)
{
	for(Status x: getAllStatus())
	{
		if(x.getIdComputer()==idCustomer)
		{
			return x;
		}
	}
	return null;
}
}

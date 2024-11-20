package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.DetailBill;

public class DetailBillDto {
//lấy tất cả thông tin detailBillDto
	public static List<DetailBill> getAllDetailBills()
	{
		String query = "SELECT * FROM DetailBill";
        List<DetailBill> detailBills = new ArrayList<>();
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
             ) {
        	ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idDetail=resultSet.getInt("idDetail");
                int idBillHistory=resultSet.getInt("idBillHistory");
                int idProduct=resultSet.getInt("idProduct");
                int quantityProduct=resultSet.getInt("quantityProduct");
                Double sumMoneyProduct=resultSet.getDouble("sumMoneyProduct");
                detailBills.add(new DetailBill(idDetail, idBillHistory, idProduct, quantityProduct, sumMoneyProduct));
            }
        }
        catch (SQLException e) {
			e.printStackTrace();
		}
        return detailBills;
	}
	//lấy tổng tiền 
	public static Double sumBill(int idBill)
	{
		Double sum=0.0;
		for(var bill:getAllDetailBills())
		{
			if(bill.getIdBillHistory()==idBill)
			{
				sum+=bill.getSumMoneyProduct();
			}
		}
		return sum;
	}
	//thêm và cập nhật
	public static String addEndUpdateDetailBill(int idDetail, int idBillHistory, int idProduct, int quantityProduct, Double sumMoneyProduct) {
	    String query = "INSERT INTO DetailBill (idBillHistory, idProduct, quantityProduct, sumMoneyProduct) "
	                 + "VALUES (?, ?, ?, ?)";
	    boolean isUpdate = false;
	    for (var detail : getAllDetailBills()) {
	        if (detail.getIdDetail() == idDetail) {
	        
	            query = "UPDATE DetailBill SET idBillHistory = ?, idProduct = ?, quantityProduct = ?, sumMoneyProduct = ? "
	                  + "WHERE idDetail = ?";
	            isUpdate = true;
	            break;
	        }
	    }

	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)
	         ) {
	        statement.setInt(1, idBillHistory);
	        statement.setInt(2, idProduct);
	        statement.setInt(3, quantityProduct);
	        statement.setDouble(4, sumMoneyProduct);

	        if (isUpdate) {
	            statement.setInt(5, idDetail); 
	        }
	        int result = statement.executeUpdate();
	        if (result > 0) {
	            return isUpdate ? "Cập nhật chi tiết hóa đơn thành công !!!" : "Thêm chi tiết hóa đơn thành công !!!";
	        } else {
	            return isUpdate ? "Cập nhật chi tiết hóa đơn không thành công !!!" : "Thêm chi tiết hóa đơn không thành công !!!";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Có lỗi khi thêm hoặc cập nhật chi tiết hóa đơn !!!";
	    }
	}

}

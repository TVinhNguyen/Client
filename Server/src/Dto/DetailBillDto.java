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
}

package Dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Promotion;

public class PromotionDto {
//lấy tất cả khuyến mãi 
public static List<Promotion> getAllPromotions()
{
	List<Promotion> promotions=new ArrayList<Promotion>();
	String query="select * from Promotion";
    try(Connection conn=DBConnection.getConnection();
    	PreparedStatement statement=conn.prepareStatement(query)) {
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			int idPromotion=resultSet.getInt("idPromotion");
			String namePromotion=resultSet.getString("namePromotion");
			int applicableLevel=resultSet.getInt("applicableLevel");
			Date startDate=resultSet.getDate("startDate");
			Date endDate=resultSet.getDate("endDate");
			boolean statusPromotion=resultSet.getBoolean("statusPromotion");
			String nodePromotion=resultSet.getString("nodePromotion");
			promotions.add(new Promotion(idPromotion,namePromotion,applicableLevel,startDate,endDate,statusPromotion,nodePromotion));
		}
	} catch (Exception e) {
	   e.printStackTrace();
	}
    return promotions;
}
//Thêm và cập nhật Khuyến mãi 
public static String addEndUpdatePromotion(int idPromotion, String namePromotion, int applicableLevel,Date startDate,Date endDate,Boolean statusPromotion,String nodePromotion)
{
    String query="insert into Promotion (namePromotion, applicableLevel, startDate, endDate, statusPromotion, nodePromotion) "
    		+ "values (?, ?, ?, ?, ?, ?) ";
    boolean check=false;
    for(var promotion : getAllPromotions())
    {
    	if(promotion.getIdPromotion()==idPromotion)
    	{
    		 query = "UPDATE Promotion SET namePromotion = ?, applicableLevel = ?, startDate = ?, endDate = ?, "
                     + "statusPromotion = ?, nodePromotion = ? WHERE idPromotion = ?";
             check = true;
             break;
    	}
    }
    try(Connection conn=DBConnection.getConnection();
    	PreparedStatement statement=conn.prepareStatement(query)
    		) {
    	statement.setString(1, namePromotion);
    	statement.setInt(2, applicableLevel);
    	statement.setDate(3, startDate);
    	statement.setDate(4, endDate);
    	statement.setBoolean(5, statusPromotion);
    	statement.setString(6, nodePromotion);
    	if(check)
    	{
    		statement.setInt(7, idPromotion);
    	}
    	int result=statement.executeUpdate();
    	if(result>0)
    	{
    		return check ? "Cập nhật khuyến mãi thành công !!!" : "Thêm khuyến mãi thành công !!!";
    	}
    	else
    	{
    		return check ? "Cập nhật khuyến mãi không thành công !!!" : "Thêm khuyến mãi không thành công !!!";
    	}
		
	} catch (Exception e) {
		 e.printStackTrace();
	        return "Có lỗi khi thêm hoặc cập nhật khuyến mãi!!!";
	}
}
//kiểm tra id khuyến mãi lấy tên khuyễn mãi 
  public static String checkIdPromotionTakeNamePromotion(int idPromotion)
  {
	  try {
		for(var promotion:getAllPromotions())
		{
			if(promotion.getIdPromotion()==idPromotion)
			{
				return promotion.getNamePromotion();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return null;
  }
}

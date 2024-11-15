package Dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import DatabaseConnection.DBConnection;
import Model.BillHistory;

public class BillHistoryDto {
//lấy tất cả thông tin BillHistory
 public static List<BillHistory> getAllBillHistorys()
 {
	 List<BillHistory> billHistory=new ArrayList<BillHistory>();
	 String query="select * from BillHistory";
	 try(Connection conn=DBConnection.getConnection();
	     PreparedStatement statement=conn.prepareStatement(query)
			 ) {
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			int idBillHistory=resultSet.getInt("idBillHistory");
			int idCustomer=resultSet.getInt("idCustomer");
			int idStaff=resultSet.getInt("idStaff");
			int idComputer=resultSet.getInt("idComputer");
			int idPromotion=resultSet.getInt("idPromotion");
			Date datePaymentBill=resultSet.getDate("datePaymentBill");
			String formPaymentBill=resultSet.getString("formPaymentBill");
			Time timeUserComputer=resultSet.getTime("timeUserComputer");
			Double sumMoneyBill=resultSet.getDouble("sumMoneyBill");
			billHistory.add(new BillHistory(idBillHistory, idCustomer, idStaff, idComputer, idPromotion, datePaymentBill, formPaymentBill, timeUserComputer, sumMoneyBill));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return billHistory;
 }
//lấy tháng của tất cả các năm 
 public Map<Integer, Integer> getMonthsOfYear(int month) {
     Map<Integer, Integer> result = new LinkedHashMap<>();
     String query = "SELECT DISTINCT EXTRACT(YEAR FROM datePaymentBill) AS year, EXTRACT(MONTH FROM datePaymentBill) AS month " +
                    "FROM BillHistory " +
                    "WHERE EXTRACT(MONTH FROM datePaymentBill) = ? " +
                    "ORDER BY year, month";
     try (Connection conn = DBConnection.getConnection();
          PreparedStatement statement = conn.prepareStatement(query)) {
          statement.setInt(1, month);
          ResultSet resultSet = statement.executeQuery();
          while (resultSet.next()) {
             int extractedYear = resultSet.getInt("year");
             int extractedMonth = resultSet.getInt("month");
             result.put(extractedYear, extractedMonth); 
         }
     } catch (Exception e) {
         e.printStackTrace();
     }

     return result;
 }
//liệt kê tất cả các ngày và tính tổng tiền  
 public static Map<Date, Double> getTotalAmountByDate() {
	    Map<Date, Double> result = new TreeMap<>();
	    String query = "SELECT datePaymentBill, SUM(sumMoneyBill) AS totalAmount " +
	                   "FROM BillHistory " +
	                   "GROUP BY datePaymentBill " +
	                   "ORDER BY datePaymentBill";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            Date datePayment = resultSet.getDate("datePaymentBill");
	            double totalAmount = resultSet.getDouble("totalAmount");
         if (result.containsKey(datePayment)) {
	                result.put(datePayment, result.get(datePayment) + totalAmount);
	            } else {
	                result.put(datePayment, totalAmount);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}

//liệt kê tất cả các tháng và tông tiền của tất cả tháng 
 public static Map<String, Double> getTotalAmountByMonthYear() {
     Map<String, Double> result = new TreeMap<>();  
     String query = "SELECT YEAR(datePaymentBill) AS year, MONTH(datePaymentBill) AS month, SUM(sumMoneyBill) AS totalAmount " +
                    "FROM BillHistory " +
                    "GROUP BY YEAR(datePaymentBill), MONTH(datePaymentBill) " +
                    "ORDER BY year, month";
     try (Connection conn = DBConnection.getConnection();
          PreparedStatement statement = conn.prepareStatement(query)) {
         ResultSet resultSet = statement.executeQuery();
         while (resultSet.next()) {
             int year = resultSet.getInt("year");
             int month = resultSet.getInt("month");
             double totalAmount = resultSet.getDouble("totalAmount");
             String key = String.format("%02d/%d", month, year);
             if (result.containsKey(key)) {
                 result.put(key, result.get(key) + totalAmount);
             } else {
                 result.put(key, totalAmount);
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }

     return result;
 }

}

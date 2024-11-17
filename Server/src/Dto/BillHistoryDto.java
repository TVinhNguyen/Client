package Dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
			long timeUserComputer=resultSet.getLong("timeUserComputer");
			Double sumMoneyBill=resultSet.getDouble("sumMoneyBill");
			billHistory.add(new BillHistory(idBillHistory, idCustomer, idStaff, idComputer, idPromotion, datePaymentBill, formPaymentBill, timeUserComputer, sumMoneyBill));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return billHistory;
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

 //liệt kê tất cả các ngày và tính tổng khi gửi ngày tháng bắt đầu và kết thúc 
 public static Map<Date, Double> getTotalAmountByDateSearch(Date startDate, Date endDate) {
	    Map<Date, Double> result = new TreeMap<>();
	    String query = "SELECT datePaymentBill, SUM(sumMoneyBill) AS totalAmount " +
	                   "FROM BillHistory " +
	                   "WHERE datePaymentBill BETWEEN ? AND ? " +
	                   "GROUP BY datePaymentBill " +
	                   "ORDER BY datePaymentBill";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        // Thiết lập các tham số cho khoảng thời gian
	        statement.setDate(1, new java.sql.Date(startDate.getTime()));
	        statement.setDate(2, new java.sql.Date(endDate.getTime()));

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
 //liệt kê tất cả các thángvà tính tổng khi gửi ngày tháng bắt đầu và kết thúc 
 public static Map<String, Double> getTotalAmountByMonthYearSearch(java.sql.Date startDate, java.sql.Date endDate) {
	    Map<String, Double> result = new TreeMap<>();  
	    String query = "SELECT YEAR(datePaymentBill) AS year, MONTH(datePaymentBill) AS month, SUM(sumMoneyBill) AS totalAmount " +
	                   "FROM BillHistory " +
	                   "WHERE datePaymentBill BETWEEN ? AND ? " +  // Điều kiện cho thời gian bắt đầu và kết thúc
	                   "GROUP BY YEAR(datePaymentBill), MONTH(datePaymentBill) " +
	                   "ORDER BY year, month";
	    
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setDate(1, startDate);
	        statement.setDate(2, endDate);
	        
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
//Liệt kê tất cả các ngày và tính tổng số khách hàng
 public static Map<Date, Integer> getTotalCustomersByDate() {
	    Map<Date, Integer> result = new TreeMap<>();
	    String query = "SELECT datePaymentBill, COUNT(idCustomer) AS totalCustomers " +
	                   "FROM BillHistory " +
	                   "GROUP BY datePaymentBill " +
	                   "ORDER BY datePaymentBill";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            Date datePayment = resultSet.getDate("datePaymentBill");
	            int totalCustomers = resultSet.getInt("totalCustomers");

	            result.put(datePayment, result.getOrDefault(datePayment, 0) + totalCustomers);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}
//Liệt kê tất cả các ngày và tính tổng số khách hàng có ngày bắt đầu và ngày kết thúc
 public static Map<Date, Integer> getTotalCustomersByDate(Date startDate, Date endDate) {
	    Map<Date, Integer> result = new TreeMap<>();
	    
	    String query = "SELECT datePaymentBill, COUNT(idCustomer) AS totalCustomers " +
	                   "FROM BillHistory " +
	                   "WHERE datePaymentBill BETWEEN ? AND ? " + 
	                   "GROUP BY datePaymentBill " +
	                   "ORDER BY datePaymentBill";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        statement.setDate(1, new java.sql.Date(startDate.getTime()));  
	        statement.setDate(2, new java.sql.Date(endDate.getTime()));   

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            Date datePayment = resultSet.getDate("datePaymentBill");
	            int totalCustomers = resultSet.getInt("totalCustomers");
	            result.put(datePayment, result.getOrDefault(datePayment, 0) + totalCustomers);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}

//Liệt kê tất cả các tháng và tính tổng số người 
 public static Map<String, Integer> getTotalCustomersByMonth() {
	    Map<String, Integer> result = new TreeMap<>();
	    String query = "SELECT YEAR(datePaymentBill) AS year, MONTH(datePaymentBill) AS month, " +
	                   "COUNT(idCustomer) AS totalCustomers " +
	                   "FROM BillHistory " +
	                   "GROUP BY YEAR(datePaymentBill), MONTH(datePaymentBill) " +
	                   "ORDER BY YEAR(datePaymentBill), MONTH(datePaymentBill)";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int year = resultSet.getInt("year");
	            int month = resultSet.getInt("month");
	            int totalCustomers = resultSet.getInt("totalCustomers");
	            String monthYear = year + "-" + (month < 10 ? "0" + month : month);
	            result.put(monthYear, totalCustomers);
	        }
	    } catch (SQLException e) {
	        System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
	    }

	    return result;
	}
//Liệt kê tất cả các tháng và tính tổng số người có ngày bắt đầu và ngày kết thúc
 public static Map<String, Integer> getTotalCustomersByMonth(Date startDate, Date endDate) {
	    Map<String, Integer> result = new TreeMap<>();
	    
	    String query = "SELECT YEAR(datePaymentBill) AS year, MONTH(datePaymentBill) AS month, " +
	                   "COUNT(idCustomer) AS totalCustomers " +
	                   "FROM BillHistory " +
	                   "WHERE datePaymentBill BETWEEN ? AND ? " + 
	                   "GROUP BY YEAR(datePaymentBill), MONTH(datePaymentBill) " +
	                   "ORDER BY YEAR(datePaymentBill), MONTH(datePaymentBill)";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setDate(1, new java.sql.Date(startDate.getTime()));  
	        statement.setDate(2, new java.sql.Date(endDate.getTime()));   

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int year = resultSet.getInt("year");
	            int month = resultSet.getInt("month");
	            int totalCustomers = resultSet.getInt("totalCustomers");

	         
	            String monthYear = year + "-" + (month < 10 ? "0" + month : month);

	            result.put(monthYear, totalCustomers);
	        }
	    } catch (SQLException e) {
	        System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
	    }

	    return result;
	}
//lấy thông số máy sử dụng
 public static Map<Integer, Integer> getComputerUsageCount() {
	    Map<Integer, Integer> result = new HashMap<>();
	    String query = "SELECT idComputer, COUNT(idComputer) AS usageCount " +
	                   "FROM BillHistory " +
	                   "GROUP BY idComputer";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int idComputer = resultSet.getInt("idComputer");
	            int usageCount = resultSet.getInt("usageCount");
	            result.put(idComputer, usageCount);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}
//lấy thông số máy sử dụng có thời gian bắt đầu và kết thúc
 public static Map<Integer, Integer> getComputerUsageCount(Date startDate, Date endDate) {
	    Map<Integer, Integer> result = new HashMap<>();
	    String query = "SELECT idComputer, COUNT(idComputer) AS usageCount " +
	                   "FROM BillHistory " +
	                   "WHERE datePaymentBill >= ? AND datePaymentBill <= ? " +
	                   "GROUP BY idComputer";
	    
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setTimestamp(1, new java.sql.Timestamp(startDate.getTime()));
	        statement.setTimestamp(2, new java.sql.Timestamp(endDate.getTime()));
	        
	        ResultSet resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	            int idComputer = resultSet.getInt("idComputer");
	            int usageCount = resultSet.getInt("usageCount");
	            result.put(idComputer, usageCount);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}

}

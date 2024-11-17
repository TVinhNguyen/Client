package Dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import DatabaseConnection.DBConnection;
import Model.PayMent;

public class PayMentDto {
//lấy toàn bộ thông tin củ bảng
	public static List<PayMent> getAllPayMents()
	{
		 String query = "SELECT * FROM payment";
	        List<PayMent> paymentList = new ArrayList<>();
	        
	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                int idPayMent = resultSet.getInt("idPayMent");
	                String nameProduct = resultSet.getString("nameProduct");
	                double value = resultSet.getDouble("value");
	                String node = resultSet.getString("node");
	                Date importDate=resultSet.getDate("importDate");
	                paymentList.add(new PayMent(idPayMent, nameProduct, value, node,importDate));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return paymentList;
	}
	//Xóa thông tin của bảng
	public static String deletePaymentById(int idPayMent) {
        String query = "DELETE FROM payment WHERE idPayMent = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPayMent);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return "Xóa thành công";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi khi xóa dữ liệu";
        }

        return "Xóa không thành công";
    }
	//cập nhật và thêm thông tin mua sản phẩm
	 public static String addEndUpdatePayment(int idPayMent, String nameProduct, double value, String node,Date importDate) {
	        String query = "INSERT INTO payment (nameProduct, value, node) VALUES (?, ?, ?)";
	        boolean check = false;
	        for (PayMent payment : getAllPayMents()) {
	            if (payment.getIdPayMent() == idPayMent) {
	                query = "UPDATE payment SET nameProduct = ?, value = ?, node = ?, importDate = ? WHERE idPayMent = ?";
	                check = true;
	                break;
	            }
	        }
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement statement = conn.prepareStatement(query)) {
	            statement.setString(1, nameProduct);
	            statement.setDouble(2, value);
	            statement.setString(3, node);
	            statement.setDate(4, importDate);
	            if (check) {
	                statement.setInt(5, idPayMent); 
	            }

	            int result = statement.executeUpdate();
	            if (result > 0) {
	                return check ? "Cập nhật thông tin thành công !!!" : "Thêm thông tin thành công !!!";
	            } else {
	                return check ? "Cập nhật thông tin không thành công !!!" : "Thêm thông tin không thành công !!!";
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Có lỗi khi thêm hoặc cập nhật thông tin thanh toán !!!";
	        }
	    }
	//liệt kê tất cả các ngày và tính tổng tiền 
	 public static Map<Date, Double> getTotalValueByDate() {
		    Map<Date, Double> result = new TreeMap<>();
		    String query = "SELECT importDate, value FROM payment ORDER BY importDate";

		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement statement = conn.prepareStatement(query);
		         ResultSet resultSet = statement.executeQuery()) {

		        while (resultSet.next()) {
		            Date datePayment = resultSet.getDate("importDate");
		            double value = resultSet.getDouble("value");
		            if (result.containsKey(datePayment)) {
		                result.put(datePayment, result.get(datePayment) + value);
		            } else {
		                result.put(datePayment, value);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return result;
		}
	//liệt kê tất cả các tháng và tông tiền của tất cả tháng 
	 public static Map<String, Double> getTotalValueByMonth() {
		    Map<String, Double> result = new TreeMap<>();
		    String query = "SELECT YEAR(importDate) AS year, MONTH(importDate) AS month, SUM(value) AS totalAmount " +
		                   "FROM payment " +
		                   "GROUP BY YEAR(importDate), MONTH(importDate) " +
		                   "ORDER BY year, month";

		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement statement = conn.prepareStatement(query);
		         ResultSet resultSet = statement.executeQuery()) {

		        while (resultSet.next()) {
		            int year = resultSet.getInt("year");
		            int month = resultSet.getInt("month");
		            double totalAmount = resultSet.getDouble("totalAmount");
		            String formattedMonthYear = String.format("%02d/%d", month, year);
		            if (result.containsKey(formattedMonthYear)) {
		                result.put(formattedMonthYear, result.get(formattedMonthYear) + totalAmount);
		            } else {
		                result.put(formattedMonthYear, totalAmount);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return result;
		}
		//liệt kê tất cả các ngày và tính tổng tiền có thời gian bắt đầu và kết thúc
	 public static Map<Date, Double> getTotalValueByDate(Date startDate, Date endDate) {
		    Map<Date, Double> result = new TreeMap<>();
		    String query = "SELECT importDate, value FROM payment WHERE importDate BETWEEN ? AND ? ORDER BY importDate";

		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement statement = conn.prepareStatement(query)) {

		        statement.setDate(1, startDate);
		        statement.setDate(2, endDate);
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Date datePayment = resultSet.getDate("importDate");
		            double value = resultSet.getDouble("value");
		            result.put(datePayment, result.getOrDefault(datePayment, 0.0) + value);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return result;
		}
	//liệt kê tất cả các tháng và tông tiền của tất cả tháng có thời gian bắt đầu và kết thúc
	 public static Map<String, Double> getTotalValueByMonth(Date startDate, Date endDate) {
		    Map<String, Double> result = new TreeMap<>();
		    String query = "SELECT YEAR(importDate) AS year, MONTH(importDate) AS month, SUM(value) AS totalAmount " +
		                   "FROM payment " +
		                   "WHERE importDate BETWEEN ? AND ? " +
		                   "GROUP BY YEAR(importDate), MONTH(importDate) " +
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
		            String formattedMonthYear = String.format("%02d/%d", month, year);
		            result.put(formattedMonthYear, result.getOrDefault(formattedMonthYear, 0.0) + totalAmount);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return result;
		}

}

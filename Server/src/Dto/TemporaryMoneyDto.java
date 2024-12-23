package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.TemporaryMoney;

public class TemporaryMoneyDto {
    // Lấy tất cả dữ liệu từ bảng temporary_money
    public static List<TemporaryMoney> getAllTemporaryMoney() {
        List<TemporaryMoney> list = new ArrayList<>();
        String query = "SELECT * FROM temporarymoney";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCustomer = resultSet.getInt("idComputer");
                LocalDateTime timeOrder = resultSet.getTimestamp("timeOrder").toLocalDateTime();
                double money = resultSet.getDouble("money");

                list.add(new TemporaryMoney(id, idCustomer, timeOrder, money));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Thêm một bản ghi mới vào bảng temporary_money
    public static String addTemporaryMoney(int idComputer, LocalDateTime timeOrder, double money) {
        String query = "INSERT INTO temporarymoney (idComputer, timeOrder, money) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            
            statement.setInt(1, idComputer);
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(timeOrder));
            statement.setDouble(3, money);

            int result = statement.executeUpdate();

            if (result > 0) {
                return "Thêm dữ liệu tạm thời thành công!";
            } else {
                return "Thêm dữ liệu tạm thời không thành công!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Có lỗi khi thêm dữ liệu tạm thời!";
        }
    }

 // Xóa toàn bộ dữ liệu trong bảng temporarymoney
    public static String deleteAllTemporaryMoney() {
        String query = "DELETE FROM temporarymoney";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            int result = statement.executeUpdate();

            if (result > 0) {
                return "Xóa toàn bộ dữ liệu tạm thời thành công!";
            } else {
                return "Không có dữ liệu để xóa!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Có lỗi khi xóa toàn bộ dữ liệu tạm thời!";
        }
    }



    // Lấy danh sách dữ liệu tạm thời theo id
    public static TemporaryMoney getTemporaryMoneyById(int idcheck) {
        String query = "SELECT * FROM temporarymoney WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, idcheck);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int idComputer = resultSet.getInt("idComputer");
                    LocalDateTime timeOrder = resultSet.getTimestamp("timeOrder").toLocalDateTime();
                    double money = resultSet.getDouble("money");

                    return new TemporaryMoney(id, idComputer, timeOrder, money);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; 
    }

    //lấy id cuối bảng
    public static int getLastTemporaryMoneyId() {
        String query = "SELECT id FROM temporarymoney ORDER BY id DESC LIMIT 1";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

}

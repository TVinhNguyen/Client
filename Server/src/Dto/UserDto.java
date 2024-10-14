package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatabaseConnection.DBConnection;
import Model.UserAccount;

public class UserDto {
	// Thêm người dùng mới vào cơ sở dữ liệu
    public static void registerUser(UserAccount user) throws SQLException {
        String query = "INSERT INTO UserAccounts (username, password, balance) VALUES (?, ?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setDouble(3, user.getBalance());
            
            statement.executeUpdate();
        }
    }

    // Cập nhật số dư của người dùng
    public static void depositToUser(int accountId, double amount) throws SQLException {
        String query = "UPDATE UserAccounts SET balance = balance + ? WHERE accountId = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);
            
            statement.executeUpdate();
        }
    }
    // Lấy số dư của người dùng
    public static double getUserBalance(int accountId) throws SQLException {
        String query = "SELECT balance FROM UserAccounts WHERE accountId = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);  // Lấy theo accountId
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("balance");  // Trả về số dư
            }
        }
        return 0.0;  // Nếu không tìm thấy tài khoản, trả về 0
    }

    public static void deductFromUser(int accountId, double amount) throws SQLException {
        String query = "UPDATE UserAccounts SET balance = balance - ? WHERE accountId = ? AND balance >= ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, amount);  // Số tiền cần trừ
            statement.setInt(2, accountId);  // ID tài khoản
            statement.setDouble(3, amount);  // Kiểm tra nếu số dư đủ lớn

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Not enough balance to complete the transaction.");
            }
        }
    }

    public static UserAccount getUserById(int accountId) throws SQLException {
        String query = "SELECT * FROM UserAccounts WHERE accountId = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("accountId");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");

                return new UserAccount(id, username, password, balance);  // Trả về đối tượng UserAccount
            }
        }

        return null;  // Nếu không tìm thấy tài khoản, trả về null
    }
}

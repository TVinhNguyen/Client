package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.MenuItem;

public class MenuItemDto {
    public static List<MenuItem> getAllMenuItems() throws SQLException {
        String query = "SELECT * FROM MenuItems";
        List<MenuItem> menuItems = new ArrayList<>();
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("menuItemId");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                menuItems.add(new MenuItem(id, name, price));
            }
        }

        return menuItems;
    }
    // Lấy món ăn theo menuItemId
    public static MenuItem getMenuItemById(int menuItemId) throws SQLException {
        String query = "SELECT * FROM MenuItems WHERE menuItemId = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, menuItemId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("menuItemId");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                return new MenuItem(id, name, price);  // Trả về đối tượng MenuItem
            }
        }

        return null;  // Nếu không tìm thấy, trả về null
    }
}

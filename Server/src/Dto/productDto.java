package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Product;

public class productDto {
    public static List<Product> getAllProducts() throws SQLException {
        String query = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double priceProduct = resultSet.getDouble("priceProduct");
                byte[] imageProduct = resultSet.getBytes("imageProduct");
                int quantityProduct = resultSet.getInt("quantityProduct");
                boolean statusProduct=resultSet.getBoolean("statusProduct");
                int idCategory=resultSet.getInt("idCategory");
                products.add(new Product(idProduct,nameProduct,priceProduct,imageProduct,quantityProduct,statusProduct,idCategory));
            }
        }
        return products;
    }
    // Lấy sản phẩm theo menuItemId
    public static Product getMenuItemById(int menuItemId) throws SQLException {
        String query = "SELECT * FROM Product WHERE idProduct = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, menuItemId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double priceProduct = resultSet.getDouble("priceProduct");
                byte[] imageProduct = resultSet.getBytes("imageProduct");
                int quantityProduct = resultSet.getInt("quantityProduct");
                boolean statusProduct=resultSet.getBoolean("statusProduct");
                int idCategory=resultSet.getInt("idCategory");
                return new Product(idProduct,nameProduct,priceProduct,imageProduct,quantityProduct,statusProduct,idCategory);
            }
        }
        return null; 
    }
   //tắt thuộc tính sản phẩm
    public static String setStatusProduct(int idProduct,boolean newStatus)
    {
    	String query="update Product set statusProduct = ? where idProduct = ?";
    	try(Connection connection=DBConnection.getConnection();
    		PreparedStatement statement=connection.prepareStatement(query)) {
			statement.setBoolean(1,newStatus);
			statement.setInt(2, idProduct);
			int x=statement.executeUpdate();
			if(x>0)
			{
				return "Thành công loại bỏ sản phẩm !!!";
			}
			else
			{
				return "Loại bỏ không thành công !!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "Sản phẩm này không tồn tại";
    }
    //Thêm sản phẩm 
    public static String addProduct(String nameProduct, Double priceProduct, byte[] imageProduct, int quantityProduct, boolean statusProduct, int idCategory) {
        String query = "INSERT INTO Product (nameProduct, priceProduct, imageProduct, quantityProduct, statusProduct, idCategory) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nameProduct);
            statement.setDouble(2, priceProduct);
            statement.setBytes(3, imageProduct);
            statement.setInt(4, quantityProduct);
            statement.setBoolean(5, statusProduct);
            statement.setInt(6, idCategory);

            int x = statement.executeUpdate();
            return x > 0 ? "Thêm sản phẩm thành công !!!" : "Thêm sản phẩm thất bại !!!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Có lỗi xảy ra khi thêm sản phẩm";
        }
    }
    //cập nhật sản phẩm
    public static String updateProduct(int idProduct, String nameProduct, Double priceProduct, byte[] imageProduct, int quantityProduct, boolean statusProduct, int idCategory) {
        String query = "UPDATE Product SET nameProduct = ?, priceProduct = ?, imageProduct = ?, quantityProduct = ?, statusProduct = ?, idCategory = ? WHERE idProduct = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nameProduct);
            statement.setDouble(2, priceProduct);
            statement.setBytes(3, imageProduct);
            statement.setInt(4, quantityProduct);
            statement.setBoolean(5, statusProduct);
            statement.setInt(6, idCategory);
            statement.setInt(7, idProduct); 

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return "Cập nhật sản phẩm thành công !!!";
            } else {
                return "Cập nhật thất bại !!!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Có lỗi xảy ra khi cập nhật sản phẩm.";
        }
    }

}

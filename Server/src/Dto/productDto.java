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
//lấy tất cả sản phẩm
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
        catch (SQLException e) {
			e.printStackTrace();
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
 // Thêm hoặc cập nhật sản phẩm
    public static String addEndUpdateProduct(Integer idProduct, String nameProduct, Double priceProduct, byte[] imageProduct, int quantityProduct, boolean statusProduct, Integer idCategory) {
        if(idCategory==0)
        {
        	idCategory=null;
        }
    	boolean check = false;
        try {
        	for(var product:getAllProducts())
            {
            	if(product.getIdProduct()==idProduct)
            	{
            		check=true;
            		break;
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        String query = check
            ? "UPDATE Product SET nameProduct = ?, priceProduct = ?, imageProduct = ?, quantityProduct = ?, statusProduct = ?, idCategory = ? WHERE idProduct = ?"
            : "INSERT INTO Product (nameProduct, priceProduct, imageProduct, quantityProduct, statusProduct, idCategory) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nameProduct);
            statement.setDouble(2, priceProduct);
            statement.setBytes(3, imageProduct);
            statement.setInt(4, quantityProduct);
            statement.setBoolean(5, statusProduct);
            statement.setInt(6, idCategory);

            if (check) {
                statement.setInt(7, idProduct); 
            }

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return check ? "Cập nhật sản phẩm thành công !!!" : "Thêm sản phẩm thành công !!!";
            } else {
                return check ? "Cập nhật thất bại !!!" : "Thêm sản phẩm thất bại !!!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Có lỗi xảy ra khi " + (check ? "cập nhật" : "thêm") + " sản phẩm.";
        }
    }

 //lấy tên sản phẩm bằng id sản phẩm 
    public static String checkIdProductTakeNameProduct(int idProduct)
    {
    	try {
			for(var product : getAllProducts())
			{
				if(product.getIdProduct()==idProduct)
				{
					return product.getNameProduct();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    public static Product getProductById(int idProduct)
    {
    	try {
			for(var product : getAllProducts())
			{
				if(product.getIdProduct()==idProduct)
				{
					return product;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
//lấy giá sản phẩm bảng id sản phẩm
    public static Double checkIdProductTakePriceProduct(int idProduct)
    {
    	try {
			for(var product : getAllProducts())
			{
				if(product.getIdProduct()==idProduct)
				{
					return product.getPriceProduct();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    //cập nhật số lượng sản phẩm
    public static boolean updateProductQuantity(int idProduct, int newQuantity) throws SQLException {
        for(var product:productDto.getAllProducts())
        {
        	if(idProduct==product.getIdProduct())
        	{
        		newQuantity=product.getQuantityProduct()-newQuantity;
        		break;
        	}
        }
    	String query = "UPDATE Product SET quantityProduct = ? WHERE idProduct = ?";
        boolean isUpdated = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, newQuantity);
            statement.setInt(2, idProduct);
            int rowsAffected = statement.executeUpdate();
            isUpdated = rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
}

package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Category;

public class CategoryDto {
	//lấy tất cả danh sách tất cả loại sản phẩm
	 public static List<Category> getALLCategorys() 
	    {
	    	String Query="select * from Category";
	    	List<Category> categorys=new ArrayList<>();
	    	try(Connection connection = DBConnection.getConnection();
	    		PreparedStatement statement=connection.prepareStatement(Query);
	    		ResultSet resultSet=statement.executeQuery()) {
				while(resultSet.next())
				{
					int idCategory=resultSet.getInt("idCategory");
					String categoryProduct=resultSet.getString("categoryProduct");
				    categorys.add(new Category(idCategory, categoryProduct));
				}
			} catch (SQLException e) {
				e.getMessage();
			}
	    	return categorys;
	    }
	 //lấy tên loại sản phẩm
	public static String getNameCategoryProduct(int idCategory) {
		String query="select * from Category where idCategory = ?";
		 try(Connection connection =DBConnection.getConnection();
			 PreparedStatement statement=connection.prepareStatement(query) 
				 ) 
		 {
		statement.setInt(1, idCategory);
		try(ResultSet resultSet=statement.executeQuery()) {
			while(resultSet.next())
			{
				return resultSet.getString("categoryProduct");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	}
	//lấy id loại sản phẩm
	public static int getIdCategoryProduct(String categoryProduct)
	{
		String query="SELECT * FROM Category WHERE categoryProduct = ?";
		try(Connection connection=DBConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement(query)) {
			statement.setString(1, categoryProduct);
			try(ResultSet resultSet=statement.executeQuery()) {
			     while(resultSet.next())
				{
					return resultSet.getInt("idCategory");
				}
			} catch (Exception e) {
			   e.printStackTrace();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}

package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Customer;

public class CustomerDto {
//lấy tất cả thông tin khách hàng
	public static List<Customer> getAllCustomers()
	{
		List<Customer> customers=new ArrayList<Customer>();
		String query="select * from Customer";
		try(Connection conn=DBConnection.getConnection();
			PreparedStatement statement=conn.prepareStatement(query)) {
		    ResultSet resultSet=statement.executeQuery();
		    while(resultSet.next())
		    {
		    	int idCustomer=resultSet.getInt("idCustomer");
		    	String nameCustomer=resultSet.getString("nameCustomer");
		    	String phoneCustomer=resultSet.getString("phoneCustomer");
		    	String nameAccount=resultSet.getString("nameAccount");
		    	String passwordAccount=resultSet.getString("passwordAccount");
		    	int pointAccount=resultSet.getInt("pointAccount");
		    	Time remainTime=resultSet.getTime("remainTime");
		    	customers.add(new Customer(idCustomer, nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointAccount,remainTime ));
		    }
		    return customers;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//cập nhật và thêm khách hàng 
	public static String addEndUpdateCustomer(int idCustomer, String nameCustomer, String phoneCustomer, String nameAccount, String passwordAccount, int pointAccount, Time remainTime )
	{
		String query="insert into Customer (nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointAccount, remainTime) "
	    		+ "values (?, ?, ?, ?, ?, ?) ";
	    boolean check=false;
	    for(var customer: getAllCustomers())
	    {
	    	if(customer.getIdCustomer()==idCustomer)
	    	{
	    		 query = "UPDATE Customer SET nameCustomer = ?, phoneCustomer = ?, nameAccount = ?, passwordAccount = ?, "
	                     + "pointAccount = ?, remainTime = ? WHERE idCustomer = ?";
	             check = true;
	             break;
	    	}
	    }
	    try(Connection conn=DBConnection.getConnection();
	    	PreparedStatement statement=conn.prepareStatement(query)
	    		) {
	    	statement.setString(1, nameCustomer);
	    	statement.setString(2, phoneCustomer);
	    	statement.setString(3, nameAccount);
	    	statement.setString(4, passwordAccount);
	    	statement.setInt(5, pointAccount);
	    	statement.setTime(6, remainTime);
	    	if(check)
	    	{
	    		statement.setInt(7, idCustomer);
	    	}
	    	int result=statement.executeUpdate();
	    	if(result>0)
	    	{
	    		return check ? "Cập nhật khách hàng thành công !!!" : "Thêm khách hàng thành công !!!";
	    	}
	    	else
	    	{
	    		return check ? "Cập nhật khách hàng không thành công !!!" : "Thêm khách hàng không thành công !!!";
	    	}
			
		} catch (Exception e) {
			 e.printStackTrace();
		        return "Có lỗi khi thêm hoặc cập nhật khách hàng !!!";
		}
	}
}

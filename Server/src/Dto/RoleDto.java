package Dto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Role;

public class RoleDto {
	//lấy tất cả danh sách Role
public static List<Role> getAllRoles()
{
	List<Role> roles=new ArrayList<Role>();
	String query="select * from Role";
	try(Connection connection=DBConnection.getConnection();
		PreparedStatement statement=connection.prepareStatement(query);
		ResultSet resultSet=statement.executeQuery()) {
		
		while(resultSet.next())
		{
			int idRole=resultSet.getInt("idRole");
			String nameRole=resultSet.getString("nameRole");
			roles.add(new Role(idRole, nameRole));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return roles;
}
//lấy tên chức vụ qua id
public static String checkIDTakeNameRole(int idRole) {
    String query = "SELECT nameRole FROM Role WHERE idRole = ?";
    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
         statement.setInt(1, idRole);  
         try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String nameRole = resultSet.getString("nameRole"); 
                return nameRole;
            } else {
                return null;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
//lấy id chức vụ qua tên
public static int checkNameRoleTakeIDRole(String nameRole)
{
    for (var role : getAllRoles()) {
        if (role.getNameRole().equals(nameRole)) {
            return role.getIdRole();
        }
    }
    return -1;
}
}

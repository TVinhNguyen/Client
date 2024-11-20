package Controller;

import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

import Dto.StaffDto;
public class Login {
	
	
	public String hashPassword(String password) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashedBytes = md.digest(password.getBytes());
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashedBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	public Map<Integer, Integer> login(String username, String password) {
		Map<Integer, Integer> result = new TreeMap<>();
		try {
		        for (var staff : StaffDto.getAllStaffs()) {
		            if (username.equals(staff.getNameAccount()) && password.equals(staff.getPasswordAccount())) {		            	
		            	if (staff.getIdRole() == 1) {
		            		result.put(1, staff.getIdStaff());
			                return result;
		            	}else if (staff.getIdRole() == 2) {
		            		result.put(2, staff.getIdStaff());
				            return result;
		                }
		            	break;
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 result.put(0, 0);
	    return result;
	}
}

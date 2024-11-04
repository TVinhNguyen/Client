package Manager;

import java.util.List;

import Model.UserAccount;

public class CustomerManager {
    private List<UserAccount> customers;

    public void addCustomer(UserAccount customer) { customers.add(customer); }
    public void deleteCustomer(String id) { /* logic */ }
    public UserAccount findCustomer(String id) 
    { 
    	return null;
    }
}

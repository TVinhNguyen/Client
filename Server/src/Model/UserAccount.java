package Model;

public class UserAccount {
 	
	private String userId;
	private String username;
	private String password;
	private double balance;
	private int points;
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
		this.balance = 0.0; 
		this.points = 0;
	}
	public UserAccount(String userId,String username, String password,double balance, int points) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.balance = balance; 
		this.points = points;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return userId + "," + username + "," + password + "," + balance + "," + points ; 
    }
}

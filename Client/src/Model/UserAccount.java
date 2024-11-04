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
        this.balance = 0.0; // Bắt đầu với số dư 0
        this.points = 0;
    }
    public UserAccount(String userId,String username, String password,double balance, int points) {
    	this.userId = userId;
        this.username = username;
        this.password = password;
        this.balance = balance; // Bắt đầu với số dư 0
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void logout() { 
    	
    }
    public void deductBalance(double amount) { }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Account ID: " + userId + " deposited " + amount + " VND. Current balance: " + balance + " VND");
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Account ID: " + userId + " withdrew " + amount + " VND. Remaining balance: " + balance + " VND");
            return true;
        }
        System.out.println("Account ID: " + userId + " has insufficient balance.");
        return false;
    }

  
    public boolean login(String username, String password) {
        // Xác thực người dùng
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful for account ID: " + userId);
            return true;
        }
        System.out.println("Login failed for account ID: " + userId);
        return false;
    }
    public static UserAccount fromString(String data) {
        String[] parts = data.split(",");
        String accountId = parts[0];
        String username = parts[1];
        String password = parts[2];
        double balance = Double.parseDouble(parts[3]);
        int points = Integer.parseInt(parts[4]);
        return new UserAccount(accountId, username, password, balance , points);
    }
   

}

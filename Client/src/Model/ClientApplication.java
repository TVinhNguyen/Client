package Model;

public class ClientApplication {
	    public static void main(String[] args) {
	        // Khởi tạo đối tượng cần thiết
	        ClientConnection connection = new ClientConnection("Client_001");
	        UserAccount user = new UserAccount("user123", "password");
	        user.deposit(200.0); // Nạp tiền vào tài khoản
	        
	        Session timeManager = new Session();
	       
	    }
}


	
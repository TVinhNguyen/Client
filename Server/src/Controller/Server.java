// package Controller;
//
//import java.io.*;
//import java.net.*;
//import java.util.HashMap;
//import java.util.Map;
//
//import Controller_UI.controllerAdmin;
//import Controller_UI.controllerLogin;
//import Model.UserAccount;
//
//public class Server implements Runnable {
//    private static final int PORT = 7891; 
//    private static Map<String, UserAccount> userAccounts = new HashMap<>(); 
//    public controllerLogin controllerLogin;
//    
//    public static void registerUser(UserAccount account) {
//        userAccounts.put(account.getUserId(), account);
//        System.out.println("User registered: " + account.getUsername());
//    }
//    public static UserAccount getUserAccount(int accountId) {
//        return userAccounts.get(accountId);
//    }
//    public Server(controllerLogin controllerLogin) {
//    	this.controllerLogin  = controllerLogin;
//    }
//	@Override
//	public void run() {
//		 try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//	            System.out.println("Server is listening on port " + PORT);
//	            
//	            while (true) {
//	                Socket socket = serverSocket.accept(); 
//	                System.out.println("New client connected");
//	                new ClientHandler(socket).start();
//	               
//	            }
//	        } catch (IOException ex) {
//	            System.out.println("Server exception: " + ex.getMessage());
//	            ex.printStackTrace();
//	        }
//	}
//}

package Controller;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import Controller_UI.controllerLogin;
import Model.UserAccount;

public class Server implements Runnable {
    private static final int PORT = 7891; 
    private static final String MULTICAST_ADDRESS = "230.0.0.0"; 
    private static final int MULTICAST_PORT = 12345; 
    private static Map<String, UserAccount> userAccounts = new HashMap<>(); 
    public controllerLogin controllerLogin;

    public static void registerUser(UserAccount account) {
        userAccounts.put(account.getUserId(), account);
        System.out.println("User registered: " + account.getUsername());
    }

    public static UserAccount getUserAccount(int accountId) {
        return userAccounts.get(accountId);
    }

    public Server(controllerLogin controllerLogin) {
        this.controllerLogin = controllerLogin;
    }

    @Override
    public void run() {
        // Bắt đầu UDP Multicast trong một thread riêng
        startMulticast();

        // Lắng nghe các kết nối TCP
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Khởi động UDP Multicast để phát thông tin server.
     */
    private void startMulticast() {
        new Thread(() -> {
            try {
                InetAddress group = InetAddress.getByName(MULTICAST_ADDRESS);
                DatagramSocket udpSocket = new DatagramSocket();

                String serverIp = InetAddress.getLocalHost().getHostAddress(); // Lấy địa chỉ IP của server
                String multicastMessage = serverIp; // Định dạng thông điệp multicast

                System.out.println("UDP Multicast started on " + MULTICAST_ADDRESS + ":" + MULTICAST_PORT);

                while (true) {
                    byte[] buffer = multicastMessage.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, MULTICAST_PORT);
                    udpSocket.send(packet);
                    System.out.println("UDP Multicast: Sent server info: " + multicastMessage);
                    Thread.sleep(5000); // Gửi thông điệp mỗi 5 giây
                }
            } catch (Exception ex) {
                System.out.println("Multicast exception: " + ex.getMessage());
                ex.printStackTrace();
            }
        }).start();
    }
}


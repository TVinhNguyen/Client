package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Dto.MenuItemDto;
import Dto.UserDto;
import Model.ChatMessage;
import Model.MenuItem;
import Model.UserAccount;

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private ChatService chatService; // Thêm ChatService vào ClientHandler
    private static List<ClientHandler> clientHandlers = new CopyOnWriteArrayList<>(); // Danh sách để lưu ClientHandler

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.chatService = new ChatService(); // Khởi tạo ChatService

    }

    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            clientHandlers.add(this); // Thêm ClientHandler vào danh sách
            
            // Nhận lệnh từ client
            String command;
            while ((command = input.readLine()) != null) {
                System.out.println("Received command: " + command);
                // Xử lý lệnh tương ứng
                handleCommand(command);
            }
        } catch (IOException ex) {
            System.out.println("Client handler exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                clientHandlers.remove(this); // Gỡ bỏ ClientHandler khi client ngắt kết nối
                socket.close();
            } catch (IOException ex) {
                System.out.println("Socket close exception: " + ex.getMessage());
            }
        }
    }

    private void handleCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case "REGISTER_USER":
                String username = parts[1];
                String password = parts[2];
                try {
                    UserAccount newUser = new UserAccount(username, password);
                    UserDto.registerUser(newUser);
                    output.println("User registered: " + username);
                } catch (SQLException e) {
                    output.println("Error registering user: " + e.getMessage());
                }
                break;

            case "DEPOSIT":
                int accountId = Integer.parseInt(parts[1]);
                double amount = Double.parseDouble(parts[2]);
                try {
                    UserDto.depositToUser(accountId, amount);
                    output.println("Deposit successful. New balance: " + UserDto.getUserBalance(accountId));
                } catch (SQLException e) {
                    output.println("Error during deposit: " + e.getMessage());
                }
                break;

            case "GET_MENU":
                try {
                    List<MenuItem> menu = MenuItemDto.getAllMenuItems();
                    for (MenuItem item : menu) {
                        output.println(item.toString());
                    }
                    output.println("END"); // Dấu hiệu kết thúc
                } catch (SQLException e) {
                    output.println("Error retrieving menu: " + e.getMessage());
                }
                break;

            case "ORDER_FOOD":
                try {
                    accountId = Integer.parseInt(parts[1]);
                    int menuItemId = Integer.parseInt(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    double totalCost = MenuItemDto.getMenuItemById(menuItemId).getPrice() * quantity;
                    UserDto.deductFromUser(accountId, totalCost);
                    output.println("Order successful. Remaining balance: " + UserDto.getUserBalance(accountId));
                } catch (SQLException e) {
                    output.println("Order failed: " + e.getMessage());
                }
                break;
            case "SEND_MESSAGE":
                String sender = parts[1].split(":")[0]; // Tên người gửi
                String messageContent = parts[1].split(":")[1]; // Nội dung tin nhắn
                ChatMessage chatMessage = new ChatMessage(sender, messageContent);
                chatService.addMessage(chatMessage); // Lưu tin nhắn
                output.println("MESSAGE SENT: " + chatMessage); // Gửi phản hồi cho client
                break;

            case "GET_MESSAGES":
                for (ChatMessage message : chatService.getMessages()) {
                    output.println(message);
                }
                output.println("END"); // Dấu hiệu kết thúc
                break;
            case "CLEAR_MESSAGES":
                chatService.clearMessages(); // Xóa tin nhắn
                output.println("Messages cleared.");
                break;

         
        }
    }


}

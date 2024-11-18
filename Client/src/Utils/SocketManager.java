package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.UserService;
import Manager.ProductManager;
import Model.Product;

public class SocketManager extends Thread {
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;
    public static String responseServer = "";
    public UserService userService;
    public ProductManager productManager;
    private volatile boolean running = true; 

    public SocketManager() {
        try {
            socket = new Socket("localhost", 12345);
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userService = new UserService(output , input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String response;
        try {
            while (running && (response = input.readLine()) != null) {
                System.out.println("Server response: " + response);
                responseServer = response;
                handleCommand(response);
                
            }
        } catch (IOException e) {
            System.out.println("Error reading from server: " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    public void sendMessage(String message) {
        if (output != null) {
            output.println(message);
        }
    }

    public void close() {
        running = false; 
        try {
            if (socket != null) socket.close();
            System.out.println("Closed connection");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleCommand(String command) {
        String[] parts = command.split(".");
        String action = parts[0];

        switch (action) {
     
        case "LIST_PRODUCT":
            	 String jsonProduct = parts[1];
                 parseJsonToProducts(jsonProduct);
                 System.out.println("list");
            
             break;
        }
    }
    public void  parseJsonToProducts(String json) {
      

        json = json.trim();
        if (json.startsWith("[") && json.endsWith("]")) {
            json = json.substring(1, json.length() - 1); 
            String[] productJsons = json.split("\\},\\{"); 

            for (String productJson : productJsons) {
                productJson = productJson.replaceAll("^\\{", "").replaceAll("\\}$", "");
                String[] fields = productJson.split(",");

                int idProduct = 0;
                String nameProduct = "";
                double priceProduct = 0.0;
                int quantityProduct = 0;
                boolean statusProduct = false;
                int idCategory = 0;

                for (String field : fields) {
                    String[] keyValue = field.split(":", 2);
                    if (keyValue.length != 2) continue;

                    String key = keyValue[0].trim().replaceAll("\"", "");
                    String value = keyValue[1].trim();

                    switch (key) {
                        case "idProduct":
                            idProduct = Integer.parseInt(value);
                            break;
                        case "nameProduct":
                            nameProduct = value.replaceAll("^\"|\"$", "").replace("\\\"", "\"");
                            break;
                        case "priceProduct":
                            priceProduct = Double.parseDouble(value);
                            break;
                        case "quantityProduct":
                            quantityProduct = Integer.parseInt(value);
                            break;
                        case "statusProduct":
                            statusProduct = Boolean.parseBoolean(value);
                            break;
                        case "idCategory":
                            idCategory = Integer.parseInt(value);
                            break;
                        default:
                            break;
                    }
                }

                Product product = new Product(idProduct, nameProduct, priceProduct, null, quantityProduct, statusProduct, idCategory);
                ProductManager.getInstance().addProduct(product);
            }
        }

    }    
    private void cleanup() {
        try {
            if (input != null) input.close();
            if (output != null) output.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Controller_UI.ControllerLogin;
import Utils.SocketManager;

public class Client   {
	private static Client instance;
    private static boolean running = true; 
    public static ControllerLogin controllerLogin;
    public static List<String> receiMessage = new ArrayList<>();
    private static SocketManager socketManager;

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
            socketManager = new SocketManager();
            socketManager.start(); // Bắt đầu luồng
        }
        return instance;
    }
    public void sendMessage(String message) {
        if (socketManager != null) {
            socketManager.sendMessage(message);
        }
    }
    public String receiMessage() {
    	String kq =  SocketManager.responseServer;
    	SocketManager.responseServer = "";
    	return kq;
    }

    
}

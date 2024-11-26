package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandlerManager {
    private static ClientHandlerManager instance;
    private List<ClientHandler> clientHandlers = new CopyOnWriteArrayList<>();

    private ClientHandlerManager() {}

    public static synchronized ClientHandlerManager getInstance() {
        if (instance == null) {
            instance = new ClientHandlerManager();
        }
        return instance;
    }

    public void addClientHandler(ClientHandler clientHandler) {
        clientHandlers.add(clientHandler);
    }

    public void removeClientHandler(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }

    public List<ClientHandler> getAllClientHandlers() {
        return new ArrayList<>(clientHandlers);
    }

    public ClientHandler getClientHandlerByCustomerId(int customerId) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler.getCustomer() != null && 
                clientHandler.getCustomer().getIdCustomer() == customerId) {
                return clientHandler;
            }
        }
        return null;
    }
    public ClientHandler getClientHandlerByComputerId(int computerId) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler.getComputer() != null && 
                clientHandler.getComputer().getIdComputer() == computerId) {
                return clientHandler;
            }
        }
        return null;
    }
}

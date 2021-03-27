package serverside.service;

import serverside.interfaces.AuthenticationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private final int PORT = 8081;

    private List<ClientHandler> clientsList;
    private AuthenticationService authService;

    public AuthenticationService getAuthService() {
        return this.authService;
    }

    public MyServer() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            this.authService = new AuthenticationServiceImpl();
            authService.start();
            clientsList = new ArrayList<>();

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(this, socket);

            }

        } catch (IOException | SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void sendMessageToClients(String message) {
        for(ClientHandler c : clientsList) {
            c.sendMessage(message);
        }
    }

    public synchronized void subscribe(ClientHandler c) {
        clientsList.add(c);
        broadcastClientsList();
    }

    public synchronized void unSubscribe(ClientHandler c) {
        clientsList.remove(c);
        broadcastClientsList();
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler c : clientsList) {
            if (c.getName().equals(nick)) {
                return true;
            }
        }
        return false;

//        return clientsList.stream()
//                .anyMatch(a -> a.getName().equals(nick));
    }
    public synchronized void broadcastClientsList(){
        StringBuilder sb = new StringBuilder("/clients");
        for (ClientHandler c : clientsList) {
            sb.append(c.getName() + "");
        }
        sendMessageToClients(sb.toString());
    }
    public synchronized void sendMsgToClient (ClientHandler from, String nick, String massage){
        for (ClientHandler c : clientsList){
            if (c.getName().equals(nick)) {
                c.sendMessage("от " + from.getName() + ": " + massage);
                from.sendMessage("клиенту " + nick + ": " + massage);
                return;
            }
        }
    }
}
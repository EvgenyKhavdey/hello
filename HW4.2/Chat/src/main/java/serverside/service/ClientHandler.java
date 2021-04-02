package serverside.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    ExecutorService executorService;

    private String name;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            this.executorService = Executors.newSingleThreadExecutor();

            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        authentication();
                        readMessage();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        closeConnection();
                    }
                }
            });

            executorService.shutdown();

//            new Thread(() -> {
//                try {
//                    authentication();
//                    readMessage();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                } finally {
//                    closeConnection();
//                }
//
//            }).start();
        } catch (IOException e) {
            System.out.println("Server problem");
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String authStr = dis.readUTF();
            if (authStr.startsWith("/auth")) {
                String[] arr = authStr.split("\\s");
                String nick = myServer
                        .getAuthService()
                        .getNickByLoginAndPassword(arr[1], arr[2]);
                if (!nick.isEmpty()) {
                    if (!myServer.isNickBusy(nick)) {
                        sendMessage("/authok " + nick);
                        name = nick;
                        myServer.sendMessageToClients(nick + " Joined to chat");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMessage(name + " is busy");
                    }
                } else {
                    sendMessage("Wrong login/password");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return name;
    }

    private void readMessage() throws IOException {
        while (true) {
            String messageFromClient = dis.readUTF();
            if (messageFromClient.startsWith("/")) {
                if (messageFromClient.equals("/q")) {
                    sendMessage(messageFromClient);
                    return;
                }
                if (messageFromClient.startsWith("/w")){
                    String [] token = messageFromClient.split("\\s");
                    String nick = token[1];
                    String msg = messageFromClient.substring(4 + nick.length());
                    myServer.sendMsgToClient(this, nick, msg);
                }
                continue;
            }
            myServer.sendMessageToClients(name + ": " + messageFromClient);
        }
    }

    private void closeConnection() {
        myServer.unSubscribe(this);
        myServer.sendMessageToClients(name + " leave chat");
    }
}
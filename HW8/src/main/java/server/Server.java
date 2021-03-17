package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final String END_SESSION = "/finish";
    private static final String END_MESSAGE = "/eom";           // end of message

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static DataInputStream dis;
    private static DataOutputStream dos;
    private static final Scanner scanner = new Scanner(System.in, "IBM866");

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер стартанул. Ожидание клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(() -> {
               while (true) {

                   try {
                       String messageFromServer = "";
                       if (bufferedReader.ready()) {
                           messageFromServer = bufferedReader.readLine();
                       }

                       if (!messageFromServer.isEmpty()) {
                           dos.writeUTF(messageFromServer);
                           System.out.println(messageFromServer);
                       }

                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            });
            t1.setDaemon(true);
            t1.start();


            while(true) {
                String messageFromClient = dis.readUTF();
                if (messageFromClient.equalsIgnoreCase("/finish")) {
                    break;
                }
                System.out.println(messageFromClient);
            }
        } catch (IOException ignored) {
            System.out.println("Соединение разорвано.");
        }
        finally {
            close();
        }
    }

    private static void close() {
        scanner.close();
        if(serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(dis != null) {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(dos != null) {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

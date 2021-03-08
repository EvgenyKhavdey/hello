package serverside;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServerApp {
    public static void main(String[] args){

        Socket socket = null;
        try(ServerSocket serverSocket = new ServerSocket(8181)) {
            System.out.println("Server start");
            socket = serverSocket.accept();
            System.out.println("Client ready");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            new Thread(() ->{
                while (true) {
                    String sc = scanner.nextLine();
                    try {
                        dos.writeUTF(sc);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true){
                String clientMessage = dis.readUTF();
                System.out.println(clientMessage);

                if(clientMessage.equalsIgnoreCase("/q")){
                    dos.writeUTF(clientMessage);
                    closeConnection(socket, dis, dos);
                    break;
                }
            }
            scanner.close();

        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    private static void closeConnection(Socket s, DataInputStream dis, DataOutputStream dos){
        try {
            dos.flush();
        } catch (IOException ignored) {
        }

        try {
            dis.close();
        } catch (IOException ignored) {
        }

        try {
            dos.close();
        } catch (IOException ignored) {
        }

        try {
            s.close();
        } catch (IOException ignored) {
        }
    }
}

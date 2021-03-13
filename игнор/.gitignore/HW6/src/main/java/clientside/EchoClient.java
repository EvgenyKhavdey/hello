package clientside;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class EchoClient extends JFrame {

    private final static String IP_ADDRESS = "Localhost"; //127.0.0.1 ip address
    private final static int SERVER_PORT = 8181;

    private JTextField msgInputField;
    private JTextArea chatArea;

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    public EchoClient(){
        try{
            connection();
        }catch (IOException ignored){
            ignored.printStackTrace();
        }
        prepareGUI();
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EchoClient();
        });
    }

    private void connection() throws IOException{
        socket = new Socket(IP_ADDRESS, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        new Thread(() ->{
            while (true){
                try{
                    String serverMessage = dis.readUTF();
                    if (serverMessage.equalsIgnoreCase("/q")){
                        break;
                    }
                    chatArea.append(serverMessage + "\n");
                }catch (IOException ignored){
                    ignored.printStackTrace();
                }
            }
            closeConnection();
        }).start();
    }

    private void sendMessageToServer(){
        if(!msgInputField.getText().trim().isEmpty()){
            try {
                String massageTOServer = msgInputField.getText();
                dos.writeUTF(massageTOServer);
                if(!massageTOServer.equalsIgnoreCase("/q")){
                    chatArea.append(massageTOServer + "\n");
                }
                msgInputField.setText(" ");
            }catch (IOException ignored){
            }
        }
    }

    public void prepareGUI() {

        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);

        btnSendMsg.addActionListener(e ->{
            sendMessageToServer();
        });

        msgInputField.addActionListener(e -> {
            sendMessageToServer();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try{
                    dos.writeUTF("/q");
                } catch (IOException ignored){
                }
            }
        });

        setVisible(true);
    }

    private void closeConnection(){
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
            socket.close();
        } catch (IOException ignored) {
        }
    }
}

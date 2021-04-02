import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.BoxLayout.X_AXIS;

public class MyWindow extends JFrame {
    public MyWindow() {
    setTitle("My Chat");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(200, 200, 400, 600);
    setAlwaysOnTop(true);

    JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

    JTextArea chatArea = new JTextArea();
        chatArea.setToolTipText("Окно чата");

        mainPanel.add(chatArea, BorderLayout.CENTER);
        chatArea.setEditable(false);

    JScrollPane scroll = new JScrollPane(chatArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 57, 947, 407);
        mainPanel.add(scroll);

    JTextField nameField = new JTextField();
        nameField.setText("Enter your name");
        mainPanel.add(nameField, BorderLayout.NORTH);

    JTextField field2 = new JTextField();
        field2.setText("Введите свое имя: ");
        mainPanel.add(field2, BorderLayout.NORTH);

    JPanel mainPanel2 = new JPanel();
        mainPanel2.setLayout(new BorderLayout());


    JTextField field = new JTextField();

        mainPanel2.add(field, BorderLayout.CENTER);

    JButton button = new JButton("Отправить");
        mainPanel2.add(button, BorderLayout.EAST);
        mainPanel.add(mainPanel2, BorderLayout.SOUTH);


        field.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            StringBuilder sb = new StringBuilder();
            if ((e.getKeyCode() == 10) && (!field.getText().equals(" "))) {
                sb.append(chatArea.getText()).append(" \n ").append(field2.getText()).append(": ")
                        .append(field.getText());
                field.setText("");
                chatArea.setText(sb.toString());
                field.setText("");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    });

        button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            if (!field.getText().equals("")) {
                sb.append(chatArea.getText())
                        .append(" \n ").append(field2.getText()).append(": ")
                        .append(field.getText());
                field.setText("");
                chatArea.setText(sb.toString());
                field.setText("");
            }
        }
    });


    add(mainPanel);
    setVisible(true);
}
}

package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    public Window() {
        setTitle("ЧАТ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 600);
        setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JButton btn1 = new JButton("Enter");

        JPanel firstButtonPanel = new JPanel();
        JTextField field = new JTextField();
        JTextField field2 = new JTextField();
        field2.setEnabled(false);

        mainPanel.add(field, BorderLayout.SOUTH);
        mainPanel.add(field2, BorderLayout.CENTER);
        btn1.setSize(new Dimension(20, 50));
        firstButtonPanel.add(btn1);

        mainPanel.add(firstButtonPanel, BorderLayout.LINE_END);
        String text = "";

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(field.getText());
                field2.setText(field.getText() + "\n");
                field.setText("");
            }
        });

        add(mainPanel);

        setVisible(true);
    }

}

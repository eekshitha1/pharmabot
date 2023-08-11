package pharmabot;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExitFrame extends JFrame {

    JFrame frm3;
    JLabel l;
    private JButton btnNewButton_1;

    public ExitFrame() {
        // Create the frame for ExitFrame
        frm3 = new JFrame("");
        frm3.getContentPane().setBackground(Color.CYAN);
        frm3.setSize(600, 600);
        frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm3.setVisible(true);
        frm3.setResizable(false);
        frm3.getContentPane().setLayout(null);
       

        // Create a label to display a thank you message
        l = new JLabel("THANK YOU..\r\n");
        l.setBounds(111, 166, 429, 211);
        l.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l.setPreferredSize(new Dimension(500, 500));
        frm3.getContentPane().add(l);

        // Create an "EXIT" button to close the application
        JButton btnNewButton = new JButton("EXIT");
        btnNewButton.setBackground(Color.CYAN);
        btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton.setBounds(469, 507, 81, 25);
        frm3.getContentPane().add(btnNewButton);

        // Create a "BACK" button to go back to the previous frame (ChatFrame)
        btnNewButton_1 = new JButton("BACK");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChatFrame obj2 = new ChatFrame();
                obj2.show();
            }
        });
        btnNewButton_1.setBackground(Color.CYAN);
        btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
        btnNewButton_1.setBounds(24, 509, 86, 25);
        frm3.getContentPane().add(btnNewButton_1);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    new ExitFrame();
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
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

public class WelcomeFrame extends JFrame {

    // Declare JFrame and JLabel variables
    JFrame frm1;
    JLabel jlbl;

    public WelcomeFrame() {
        // Create the main frame
        frm1 = new JFrame("");
        frm1.setSize(600, 600);
		frm1.getContentPane().setBackground(Color.CYAN);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm1.setVisible(true);
        frm1.setResizable(false);
        frm1.getContentPane().setLayout(null);
        


        // Create and customize a label for the welcome message
        jlbl = new JLabel("WELCOME TO PHARMABOT");
        jlbl.setBounds(127, 13, 383, 500);
        jlbl.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        jlbl.setPreferredSize(new Dimension(350, 500));
        frm1.getContentPane().add(jlbl);

        // Create and customize a button
        JButton jbtn1 = new JButton("GO");
        jbtn1.setBounds(483, 519, 81, 33);
        jbtn1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
        jbtn1.setBackground(Color.CYAN);

        // Add action listener to the button
        jbtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Create an instance of ChatFrame (presumably another frame)
                ChatFrame obj = new ChatFrame();
                obj.show();
            }
        });
        frm1.getContentPane().add(jbtn1);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    // Create an instance of WelcomeFrame to start the application
                    new WelcomeFrame();
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
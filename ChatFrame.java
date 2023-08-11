package pharmabot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class ChatFrame extends JFrame {

    private JTextField txtEnter = new JTextField();
    private JTextArea txtChat = new JTextArea();
    Set<String> s;
    String fon;
    int siz = 16;
    String[] fonts = {"Arial", "TimesNewRoman", "Cambria", "Serif"};

    public ChatFrame() {
        // Initialize the set with predefined keywords
        s = new TreeSet<String>();
        s.add("medicine");
        s.add("symptoms");
        s.add("precautions");
        s.add("disease");

        // Load additional keywords from the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");  //give your jdbc connection string
            Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("select * from pharma");
            while (rs.next()) {
                s.add(rs.getString(1));
                s.add(rs.getString(2));
                s.add(rs.getString(3));
                s.add(rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("BOT");

        // Set up the text field for user input
        txtEnter.setBounds(2, 539, 490, 30);
        txtEnter.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                // Implement the auto-complete functionality
                if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_DELETE||evt.getKeyCode()==KeyEvent.VK_SPACE)
                {
                   
                }
        		else if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        		{
        			txtEnter.setText("");
        		}
                else
                {   
        		String text=txtEnter.getText();
        		String[] check=text.split(" ");
        		int check_length=check.length;
        		  String to_check=check[check_length-1];
        		  System.out.println(to_check);
                int to_check_len=to_check.length();
                
                for(String data:s)
                {
                    String check_from_data="";
                    for(int i=0;i<to_check_len;i++)
                    {
                        if(to_check_len<=data.length())
                        {
                            check_from_data = check_from_data+data.charAt(i);
                        }
                    }
                    if(check_from_data.equals(to_check))
                    {
                    	int n=to_check.length();
                    	txtEnter.setText(txtEnter.getText()+data.substring(n));
                    	//System.out.println(txtEnter.getText());
                    	txtEnter.setSelectionStart(text.length());
                    	txtEnter.setSelectionEnd(text.length()+data.length());
                       break;
                    }
                }
                }
            }
        });

        // Handle user input when Enter is pressed
        txtEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    // Handle user queries and database interactions
                    String uText = txtEnter.getText();
            	txtEnter.setText("");
                txtChat.append("You: " + uText + "\n");
               
            	   Class.forName("com.mysql.jdbc.Driver");
            	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",""); //give your jdbc connection string
            	   Statement stmt1 = con.createStatement();
            	   ResultSet rs1=stmt1.executeQuery("select * from pharma");
            	   int c=0;
            	   if(uText.contains("hi")){
            		   c=c+1;
                       botSay("Hello Iam Pharmabot,how can I help you?");
                   }
                   else if(uText.contains("how are you")){
                       int decider = (int) (Math.random()*2+1);
                       if(decider == 1){
                    	   c=c+1;
                           botSay("I'm doing well, thanks");
                       }
                       else if(decider == 2){
                    	   c=c+1;
                           botSay("Not too bad");
                       }
                   }
                   
            	   while(rs1.next())
            	   {
            		   String dis=rs1.getString(1);
            		   String med=rs1.getString(2);
            		   String symp=rs1.getString(3);
            		   String pre=rs1.getString(4);
            		   
            		   if(uText.contains("medicine"))
            		   {
            			   if (uText.contains(dis))
            			   {
            				   c=c+1;
            				   botSay(med);
            			   }
            		   }
            		   else if(uText.contains("symptoms"))
            		   {
            			   if(uText.contains(dis))
            			   {
            				   c=c+1;
            				   botSay(symp);
            			   }
            		   }
            		   else if(uText.contains("disease"))
            		   {
            			   if(uText.contains(symp))
            			   {
            				   c=c+1;
            				   botSay(dis);
            			   }
            			   else if(uText.contains(med))
            			   {
            				   c=c+1;
            				   botSay(dis);
            			   }
            		   }
            		   else if(uText.contains("precautions"))
            		   {
            			   if(uText.contains(dis))
            			   {
            				   c=c+1;
            				   botSay(pre);
            			   }
            				   
            		   }  
            	   }
            	   if(c==0)
            	   {
            		   int decider = (int) (Math.random()*3+1);
                       if(decider == 1){
                           botSay("I didn't get that");
                       }
                       else if(decider == 2){
                           botSay("Please rephrase that");
                       }
                       else if(decider == 3){
                           botSay("???");
                       }
            	   }
            	   con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                txtEnter.setText(""); // Clear the text field after processing
            }
        });

        // Set up the chat area
        txtChat.setBounds(0, 28, 594, 509);
        txtChat.setEditable(false);
        getContentPane().setLayout(null);

        // Add components to the frame
        getContentPane().add(txtEnter);
        getContentPane().add(txtChat);

        // "END CHAT" button
        JButton jbtn1 = new JButton("END CHAT");
        jbtn1.setBounds(489, 539, 105, 28);
        jbtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open another frame (ExitFrame) when the button is clicked
                ExitFrame obj = new ExitFrame();
                obj.show();
            }
        });
        jbtn1.setFont(new Font("Tahoma", Font.BOLD, 13));
        jbtn1.setForeground(new Color(0, 0, 0));
        getContentPane().add(btnNewButton);

        // Dropdown list for font selection
        JComboBox comboBox = new JComboBox(fonts);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fon = comboBox.getSelectedItem().toString();
                txtChat.setFont(new Font(fon, Font.PLAIN, siz));
            }
        });
        comboBox.setBackground(Color.WHITE);
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(2, 0, 99, 25);
        getContentPane().add(comboBox);

        // Dropdown list for font size selection
        Integer[] size = {18, 20, 22, 24};
        JComboBox comboBox_1 = new JComboBox(size);
        comboBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                siz = comboBox_1.getSelectedItem().hashCode();
                txtChat.setFont(new Font(fon, Font.PLAIN, siz));
            }
        });
        comboBox_1.setBackground(Color.WHITE);
        comboBox_1.setSelectedIndex(0);
        comboBox_1.setBounds(102, 0, 47, 25);
        getContentPane().add(comboBox_1);

        // "CLEAR" button to clear the chat area
        JButton jbtn2 = new JButton("CLEAR");
        jbtn2.setFont(new Font("Tahoma", Font.BOLD, 13));
        jbtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtChat.setText(""); // Clear the chat area
            }
        });
       jbtn2.setBounds(507, 0, 87, 25);
        getContentPane().add(btnNewButton_1);
    }

    public void botSay(String s) {
        txtChat.append("BOT: " + s + "\n"); // Display BOT's response in the chat area
    }

    public static void main(String[] args) {
        new ChatFrame();
    }
}
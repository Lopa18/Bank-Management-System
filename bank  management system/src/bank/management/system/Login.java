
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
        JButton signin,signup,clear;
        JTextField cardTextField;
        JPasswordField pinTextField;
        
    Login(){
        
        setTitle("AUTOMATIC TELLER MACHINE");
        
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //        JLabel label=new JLabel(i1);
        Image i2=i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
         label.setBounds(160,60,90,90);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(270,90,500,40);
        text.setFont(new Font("Osward",Font.BOLD,35));
        add(text);
        
        JLabel cardno=new JLabel("Card No. : ");
        cardno.setBounds(160,180,150,40);
        cardno.setFont(new Font("Raleway",Font.BOLD,25));
        add(cardno);
        
//        JTextField cardTextField=new JTextField();
        cardTextField=new JTextField();
        cardTextField.setBounds(300,190,200,25);
        cardTextField.setFont(new Font("Arial",Font.BOLD,12));
        add(cardTextField);
        
         JLabel pin=new JLabel("PIN : ");
        pin.setBounds(160,230,150,40);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,240,200,25);
        pinTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(pinTextField);
        
        signin=new JButton("SIGN IN");
        signin.setBounds(300, 300, 100, 30);
        add(signin);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(420, 300, 100, 30);
        add(signup);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        
        clear=new JButton("CLEAR");
        clear.setBounds(300, 340, 220, 30);
        add(clear);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        
        
        //frame
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
     
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==clear){ 
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==signin){
            Connect c=new Connect();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            
            String query="select * from login where Cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            
            try{
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transacation(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin ");
               }
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args) {
        new Login();
    }
    
}

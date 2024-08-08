package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
        JButton back;
        String pinnumber;
        
        BalanceEnquiry(String pinnumber){
            this.pinnumber=pinnumber;
            setLayout(null);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            add(image);
            
            back=new JButton("BACK");
            back.setBounds(355,520,150,30);
            back.addActionListener(this);
            image.add(back);
            
            Connect c=new Connect();
            int balance=0;
            try{
               ResultSet rs= c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
               
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                       
                   }else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               }catch(Exception e){
                System.out.println(e);
            }
            
            JLabel text=new JLabel("Your Currenet Account balance is Rs "+balance);
            image.add(text);
            text.setBounds(170,300,400,30);
            text.setForeground(Color.white);

            setUndecorated(true);
            setVisible(true);
            setSize(900,900);
            setLocation(300,0);
            
        }
        
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Transacation(pinnumber).setVisible(true);
        }
        
        
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

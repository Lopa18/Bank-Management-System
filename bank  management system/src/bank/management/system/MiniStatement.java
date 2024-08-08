package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class MiniStatement extends JFrame {
    
    
    MiniStatement(String pinnumber){
       
        setTitle("Account Statement");
         setLayout(null);
         
         JLabel mini=new JLabel();
         add(mini);
         
         JLabel bank=new JLabel("State Bank Of India");
         add(bank);
         bank.setBounds(150,20,150,20);
         
         JLabel card=new JLabel();
         add(card);
         card.setBounds(20,80,300,20);
        
         JLabel balance=new JLabel();
         add(balance);
         balance.setBounds(20,400,300,20);
         
         try{
             
             Connect c=new Connect();
             ResultSet rs=c.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
             
             while(rs.next()){
                card.setText("Card Number :"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
             }
             
         }catch(Exception e){
             System.out.println(e);
         }
         
         
         try{ 
             Connect c=new Connect();
             int bal=0;
             ResultSet rs=c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
             
             while(rs.next()){
                 mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
             
                  if(rs.getString("type").equals("Deposit")){
                       bal+=Integer.parseInt(rs.getString("amount"));
                       
                   }else{
                       bal-=Integer.parseInt(rs.getString("amount"));
                   }
             
             }
             balance.setText("Your current account balance is Rs"+bal);
         }catch(Exception e){
             System.out.println(e);
         }
         
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args) {
         new MiniStatement("");
    }
}

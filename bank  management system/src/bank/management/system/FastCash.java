package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        image.add(text);
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        
        deposit=new JButton("Rs 100");
        image.add(deposit);
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        
        withdrawl=new JButton("Rs 500");
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355,415,150,30);
        
        fastcash=new JButton("Rs 1000");
        image.add(fastcash);
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        
        ministatement=new JButton("Rs 2000");
        image.add(ministatement);
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        
        pinchange=new JButton("Rs 5000");
        image.add(pinchange);
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        
        balanceenquiry=new JButton("Rs 10000");
        image.add(balanceenquiry);
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        
        exit=new JButton("Back");
        image.add(exit);
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transacation(pinnumber).setVisible(true);
        }else {
            
            String amount=((JButton)ae.getSource()).getText().substring(3);//Rs 500
            Connect c=new Connect();
            
            try{
               ResultSet rs= c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                       
                   }else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               
               Date date=new Date();
               String query="insert into bank values('"+pinnumber+"','"+date+"','"+withdrawl+"','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+ amount+" Debited Successfully.");
               
                setVisible(false);
                new Transacation(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
    
}

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transacation extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    Transacation(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);
        
        JLabel text=new JLabel("Please select your Transcation");
        image.add(text);
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        
        deposit=new JButton("Deposit");
        image.add(deposit);
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        
        withdrawl=new JButton("Cash Withdraw");
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355,415,150,30);
        
        fastcash=new JButton("Fast Cash");
        image.add(fastcash);
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        
        ministatement=new JButton("Mini Statement");
        image.add(ministatement);
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        
        pinchange=new JButton("Pin Change");
        image.add(pinchange);
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        
        balanceenquiry=new JButton("Balance Enquiry");
        image.add(balanceenquiry);
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transacation("");
    }
    
}

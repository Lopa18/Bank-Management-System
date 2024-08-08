package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
        SignupThree(String formno){
            this.formno=formno;
            setLayout(null);
            
            JLabel l1=new JLabel("Page 3: Account Details");
            add(l1);
            l1.setFont(new Font("Raleway",Font.BOLD,22));
            l1.setBounds(280,40,400,40);
            
            JLabel type=new JLabel("Account Type : ");
            add(type);
            type.setFont(new Font("Raleway",Font.BOLD,18));
            type.setBounds(100,140,200,30);
            
            r1=new JRadioButton("Saving Account");
            add(r1);
            r1.setFont(new Font("Ralway",Font.BOLD,16));
            r1.setBounds(100,180,150,20);
            r1.setBackground(Color.white);
            
            r2=new JRadioButton("Fixed Deposit Account");
            add(r2);
            r2.setFont(new Font("Ralway",Font.BOLD,16));
            r2.setBounds(350,180,250,20);
            r2.setBackground(Color.white);
            
            r3=new JRadioButton("Current Account");
            add(r3);
            r3.setFont(new Font("Ralway",Font.BOLD,16));
            r3.setBounds(100,220,150,20);
            r3.setBackground(Color.white);
            
            r4=new JRadioButton("Recurring Deposit Account");
            add(r4);
            r4.setFont(new Font("Ralway",Font.BOLD,16));
            r4.setBounds(350,220,250,20);
            r4.setBackground(Color.white);
            
            ButtonGroup groupaccount=new ButtonGroup();
            groupaccount.add(r1);
            groupaccount.add(r2);
            groupaccount.add(r3);
            groupaccount.add(r4);
            
            JLabel card=new JLabel("Card Number : ");
            add(card);
            card.setFont(new Font("Raleway",Font.BOLD,18));
            card.setBounds(100,280,200,30);
            
            JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
            add(number);
            number.setFont(new Font("Raleway",Font.BOLD,18));
            number.setBounds(330,280,300,30);
            
            JLabel carddetail=new JLabel("Your 16 digit Card Number");
            add(carddetail);
            carddetail.setFont(new Font("Raleway",Font.BOLD,12));
            carddetail.setBounds(100,300,300,30);
            
            JLabel pin=new JLabel("PIN : ");
            add(pin);
            pin.setFont(new Font("Raleway",Font.BOLD,18));
            pin.setBounds(100,350,200,30);
            
            JLabel pnumber=new JLabel("XXXX");
            add(pnumber);
            pnumber.setFont(new Font("Raleway",Font.BOLD,18));
            pnumber.setBounds(330,350,300,30);
            
            JLabel pindetail=new JLabel("Your 4 digit Password");
            add(pindetail);
            pindetail.setFont(new Font("Raleway",Font.BOLD,12));
            pindetail.setBounds(100,370,300,30);
            
            JLabel services=new JLabel("Services Required :");
            add(services);
            services.setFont(new Font("Raleway",Font.BOLD,18));
            services.setBounds(100,425,200,30);
            
            c1=new JCheckBox("ATM CARD");
            add(c1);
            c1.setFont(new Font("Ralway",Font.BOLD,16));
            c1.setBounds(100,465,200,30);
            c1.setBackground(Color.white);
            
            c2=new JCheckBox("Internet Banking");
            add(c2);
            c2.setFont(new Font("Ralway",Font.BOLD,16));
            c2.setBounds(350,465,200,30);
            c2.setBackground(Color.white);
            
            c3=new JCheckBox("Mobile Banking");
            add(c3);
            c3.setFont(new Font("Ralway",Font.BOLD,16));
            c3.setBounds(100,505,200,30);
            c3.setBackground(Color.white);
            
            c4=new JCheckBox("EMAIL & SMS Alerts");
            add(c4);
            c4.setFont(new Font("Ralway",Font.BOLD,16));
            c4.setBounds(350,505,250,30);
            c4.setBackground(Color.white);
            
            c5=new JCheckBox("Cheque Book");
            add(c5);
            c5.setFont(new Font("Ralway",Font.BOLD,16));
            c5.setBounds(100,540,200,30);
            c5.setBackground(Color.white);
            
            c6=new JCheckBox("E-Statement");
            add(c6);
            c6.setFont(new Font("Ralway",Font.BOLD,16));
            c6.setBounds(350,540,200,30);
            c6.setBackground(Color.white);
            
            c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge . ");
            add(c7);
            c7.setFont(new Font("Ralway",Font.BOLD,12));
            c7.setBounds(100,580,600,30);
            c7.setBackground(Color.white);
            
            submit=new JButton("Submit");
            add(submit);
            submit.setBackground(Color.black);
            submit.setForeground(Color.white);
            submit.setFont(new Font("Ralway",Font.BOLD,14));
            submit.setBounds(250,630,100,30);
            submit.addActionListener(this);
            
            cancel=new JButton("Cancel");
            add(cancel);
            cancel.setBackground(Color.black);
            cancel.setForeground(Color.white);
            cancel.setFont(new Font("Ralway",Font.BOLD,14));
            cancel.setBounds(420,630,100,30);
            cancel.addActionListener(this);
            
            
            getContentPane().setBackground(Color.white);
            setSize(850,820);
            setLocation(350,0);
            setVisible(true);
    
        }
        
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Reccuring Deposit Account";
            }
            
            Random random=new Random();//util package
            String cardnumber="" +Math.abs((random.nextLong() % 90000000L)+78952000000000L);
            
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility=" ATM Card";
            }else if(c2.isSelected()){
                facility=" Internet Banking";
            }else if(c3.isSelected()){
                facility=" Mobile banking";
            }else if(c4.isSelected()){
                facility=" EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                facility=" Cheque Book";
            }else if(c6.isSelected()){
                facility="E-Statement";
            }
            
            
            try{
               
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else{
                    Connect c=new Connect();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                     String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                   
                     c.s.executeUpdate(query1);
                     c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number :"+cardnumber+"\n Pin: "+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                    new Login().setVisible(true);
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
        
        
    public static void main(String[] args) {
        new SignupThree("");
    }
}

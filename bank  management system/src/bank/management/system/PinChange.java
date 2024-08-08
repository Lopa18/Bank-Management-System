package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); //javax.swing.* package
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT); //java.awt.* package
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        image.add(text);
        text.setBounds(250,280,500,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        
        JLabel pintext=new JLabel("NEW PIN :");
        image.add(pintext);
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.white);
        
        pin=new JPasswordField();
        image.add(pin);
        pin.setFont(new Font("Ralway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        
         JLabel repintext=new JLabel("Re-Enter NEW PIN :");
        image.add(repintext);
        repintext.setBounds(165,360,180,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.white);
        
        repin=new JPasswordField();
        image.add(repin);
        repin.setFont(new Font("Ralway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        
        change=new JButton("CHANGE");
        image.add(change);
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        
        back=new JButton("BACK");
        image.add(back);
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        
        setUndecorated(true);
        setVisible(true);
        setSize(900,900);
        setLocation(300,0); 
    }
    
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
       if(ae.getSource()==change){
        try{
           String npin=pin.getText();
           String rpin=repin.getText();
           
           if(!npin.equals(repin)){
               JOptionPane.showMessageDialog(null,"Entered PIN doesnot match");
               return;
               
           }
           if(!npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter New PIN");
               return;
           }
           
             if(!rpin.equals("")){
               JOptionPane.showMessageDialog(null, "Please re-enter New PIN");
               return;
           }
             
            Connect c=new Connect();
            String query1="update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String query2="update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String query3="update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
           
            c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
              
              JOptionPane.showMessageDialog(null, "PIN changed  Successfully");
              
              setVisible(false);
              new Transacation(rpin).setVisible(true);
              
              
        }catch(Exception e){
            System.out.println(e);
        }
       }else{
           setVisible(false);
           new Transacation(pinnumber).setVisible(true);
       }
    }
    
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

   
    
}

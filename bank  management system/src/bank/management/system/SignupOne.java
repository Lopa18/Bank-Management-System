
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField
    ,stateTextField,pincodeTextField;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    JButton next;
    
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO : "+random);
        add(formno);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(140,20,600,40);
        
        JLabel personaldetails=new JLabel("page 1: Personal Details");
        add(personaldetails);
        personaldetails.setFont(new Font("Raleway",Font.BOLD,20));
        personaldetails.setBounds(240,80,400,30);
        
        JLabel name=new JLabel("Name :");
        add(name);
        name.setFont(new Font("Raleway",Font.BOLD,17));
        name.setBounds(100,140,100,30);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name :");
        add(fname);
        fname.setFont(new Font("Raleway",Font.BOLD,17));
        fname.setBounds(100,190,200,30);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth :");
        add(dob);
        dob.setFont(new Font("Raleway",Font.BOLD,17));
        dob.setBounds(100,230,200,30);
        
        dateChooser=new JDateChooser();
        add(dateChooser);
        dateChooser.setBounds(300,230,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        
        JLabel gender=new JLabel("Gender :");
        add(gender);
        gender.setFont(new Font("Raleway",Font.BOLD,17));
        gender.setBounds(100,280,200,30);
        
        male=new JRadioButton("Male");
        add(male);
        male.setBounds(300,280,100,30);
        male.setBackground(Color.white);
        
        female=new JRadioButton("Female");
        add(female);
        female.setBounds(450,280,100,30);
        female.setBackground(Color.white);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Id :");
        add(email);
        email.setFont(new Font("Raleway",Font.BOLD,17));
        email.setBounds(100,330,200,30);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,330,400,30);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status :");
        add(marital);
        marital.setFont(new Font("Raleway",Font.BOLD,17));
        marital.setBounds(100,380,200,30);
        
        married=new JRadioButton("Married");
        add(married);
        married.setBounds(300,380,100,30);
        married.setBackground(Color.white);
        
        unmarried=new JRadioButton("UnMarried");
        add(unmarried);
        unmarried.setBounds(400,380,100,30);
        unmarried.setBackground(Color.white);
        
        other=new JRadioButton("Other");
        add(other);
        other.setBounds(500,380,100,30);
        other.setBackground(Color.white);
        
        ButtonGroup maritalgroup =new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
         
        JLabel address=new JLabel("Addrress :");
        add(address);
        address.setFont(new Font("Raleway",Font.BOLD,17));
        address.setBounds(100,430,200,30);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,430,400,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City :");
        add(city);
        city.setFont(new Font("Raleway",Font.BOLD,17));
        city.setBounds(100,480,200,30);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,480,400,30);
        add(cityTextField);
        
        JLabel state=new JLabel("State :");
        add(state);
        state.setFont(new Font("Raleway",Font.BOLD,17));
        state.setBounds(100,530,200,30);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,530,400,30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("PinCode :");
        add(pincode);
        pincode.setFont(new Font("Raleway",Font.BOLD,17));
        pincode.setBounds(100,580,200,30);
        
         pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,580,400,30);
        add(pincodeTextField);
        
        
        next=new JButton("Next");
        add(next);
        next.setBounds(600,630,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        setSize(800,750);
        setVisible(true);
        setLocation(350,40);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno=""+random; //long
        String name=nameTextField.getText();//setText getText(),we are using so we get the value of those textfield
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();//getUiComponent(),it read the textfield so we upcasted it by writing JTextField
        String email=emailTextField.getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="UnMarried";
        }else if(other.isSelected()){
            marital="Others";
        }
        
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pincodeTextField.getText();
        
        try{
           if(name.equals("")){
               JOptionPane.showConfirmDialog(null, "Name is required");         
           } else {
               Connect c=new Connect();
               String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+email+"','"+gender+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
               c.s.executeUpdate(query);
               
               
               setVisible(false);
               new SignupTwo(formno).setVisible(true);
               
               
           }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    public static void main(String[] args) {
         new SignupOne();
    }
}


package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox religionComboBox,categoryComboBox,incomeComboBox,qualificationComboBox,occupationComboBox;
    JTextField panTextField,aadharTextField;      
    JRadioButton eyes,eno,syes,sno;
    JButton next;
    String formno;
    
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM --PAGE 2");
        
        
        JLabel addtionaldetails=new JLabel("page 2: Addtionaldetails Details");
        add(addtionaldetails);
        addtionaldetails.setFont(new Font("Raleway",Font.BOLD,20));
        addtionaldetails.setBounds(240,80,400,30);
        
        JLabel religion=new JLabel("Religion :");
        add(religion);
        religion.setFont(new Font("Raleway",Font.BOLD,17));
        religion.setBounds(100,140,100,30);
        
        String valReligion[]={"Hindu","Muslim","Christian","Sikh","Others"};
        religionComboBox=new JComboBox(valReligion);
        religionComboBox.setBounds(300,140,400,30);
        add(religionComboBox);
        religionComboBox.setBackground(Color.white);
        
        
        JLabel category =new JLabel("Category :");
        add(category);
        category.setFont(new Font("Raleway",Font.BOLD,17));
        category.setBounds(100,190,200,30);
        
       String valCategory[]={"General","OBC","SC","ST","Others"};
        categoryComboBox=new JComboBox(valCategory);
        categoryComboBox.setBounds(300,190,400,30);
        add(categoryComboBox);
        categoryComboBox.setBackground(Color.white);
        
        JLabel income=new JLabel("Income :");
        add(income);
        income.setFont(new Font("Raleway",Font.BOLD,17));
        income.setBounds(100,230,200,30);
        
        String valincome[]={"0","less than 150000","less than 250000","less than 500000","upto 10,00000"};
        incomeComboBox=new JComboBox(valincome);
        incomeComboBox.setBounds(300,230,400,30);
        add(incomeComboBox);
        incomeComboBox.setBackground(Color.white);
        
        
        JLabel qualification=new JLabel("Qualification :");
        add(qualification);
        qualification.setFont(new Font("Raleway",Font.BOLD,17));
        qualification.setBounds(100,280,200,30);
        
        String valqualification[]={"Non Graduation","Graduation","Post Graduation","Doctrate","Others"};
        qualificationComboBox=new JComboBox(valqualification);
        qualificationComboBox.setBounds(300,280,400,30);
        add(qualificationComboBox);
        qualificationComboBox.setBackground(Color.white);
        
        JLabel occupation=new JLabel("Occupation :");
        add(occupation);
        occupation.setFont(new Font("Raleway",Font.BOLD,17));
        occupation.setBounds(100,330,200,30);
        
        String valoccupation[]={"Salaried","Self Employed","Bussiness","Student","Retired","Other"};
        occupationComboBox=new JComboBox(valoccupation);
        occupationComboBox.setBounds(300,330,400,30);
        add(occupationComboBox);
       occupationComboBox.setBackground(Color.white);
        
       
        JLabel pan=new JLabel("PanCard Number :");
        add(pan);
        pan.setFont(new Font("Raleway",Font.BOLD,17));
        pan.setBounds(100,380,200,30);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,380,400,30);
        add(panTextField);
        
        JLabel aadhar=new JLabel("Aadhar Number :");
        add(aadhar);
        aadhar.setFont(new Font("Raleway",Font.BOLD,17));
        aadhar.setBounds(100,430,200,30);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,430,400,30);
        add(aadharTextField);
        
        JLabel seniorcitizen=new JLabel("Senior Citizen :");
        add(seniorcitizen);
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,17));
        seniorcitizen.setBounds(100,480,200,30);
        
        syes=new JRadioButton("Yes");
        add(syes);
        syes.setBounds(300,480,100,30);
        syes.setBackground(Color.white);
        
        sno=new JRadioButton("No");
        add(sno);
        sno.setBounds(400,480,100,30);
        sno.setBackground(Color.white);
        
        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel existingaccount=new JLabel("Existing account :");
        add(existingaccount);
        existingaccount.setFont(new Font("Raleway",Font.BOLD,17));
        existingaccount.setBounds(100,530,200,30);
        
        eyes=new JRadioButton("Yes");
        add(eyes);
        eyes.setBounds(300,530,100,30);
        eyes.setBackground(Color.white);
        
        eno=new JRadioButton("No");
        add(eno);
        eno.setBounds(400,530,100,30);
        eno.setBackground(Color.white);
        
        ButtonGroup existgroup=new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);
        
        
        next=new JButton("Next");
        add(next);
        next.setBounds(600,580,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        
//        getContentPane().setBackground(Color.white);
        setSize(800,750);
        setVisible(true);
        setLocation(350,40);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
         String sreligion=(String)religionComboBox.getSelectedItem();
         String scategory=(String)categoryComboBox.getSelectedItem(); 
         String sincome=(String)incomeComboBox.getSelectedItem();
         String squalification=(String)qualificationComboBox.getSelectedItem();
         String soccupation=(String)occupationComboBox.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
           seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        
        String pancard=panTextField.getText();
        String aadharcard=aadharTextField.getText();
       
        
        try{
               Connect c=new Connect();
               String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+seniorcitizen+"','"+existingaccount+"','"+pancard+"','"+aadharcard+"')";
               c.s.executeUpdate(query);
               
               setVisible(false);
               new SignupThree(formno).setVisible(true);
          
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    public static void main(String[] args) {
         new SignupTwo("");
    }
}

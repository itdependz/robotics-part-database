import java.io.*;
import java.util.*;
import java.lang.Thread;
import java.util.stream.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class launchPage extends JFrame implements ActionListener{
  public JButton registerTeam = new JButton("Register Team");
  public JLabel welcomeLabel = new JLabel("Welcome to the Robotics Inventory Mangement System (RIMS)");
  public JLabel teamNumberLabel = new JLabel("What is your team number?");
  public JTextField teamNumberField = new JTextField(4);

 



  public void launchPage(){
    JPanel panel = new JPanel(new GridLayout(3,1));
    panel.add(welcomeLabel);
    panel.add(teamNumberLabel);
    panel.add(teamNumberField);
    panel.add(registerTeam);

    add(panel, BorderLayout.CENTER);

    registerTeam.addActionListener(this);
    setTitle("ROBOTICS INVENTORY MANAGEMENT SYSTEM");
  }

  public void actionPerformed(ActionEvent e){
    try{
      String teamNumString = teamNumberField.getText();
      login obj = new login();
      obj.loadDB();
      if(obj.checkRegisteredTeam(Integer.parseInt(teamNumString))==true){
        File newInventory = new File("./secrets/team" + teamNumString + ".csv");
        newInventory.createNewFile();
        File secretStuff = new File("./secrets/secrets" + teamNumString + ".txt");
        secretStuff.createNewFile();
        System.out.println("Creating your new inventory for team " + teamNumString +"...");
        Thread.sleep(2000);
        System.out.println("Your inventory space has been created! Sending you to login page...");
        loginForm login = new loginForm();
        login.setVisible(true);
        this.setVisible(false);
      }
      else{
        Thread.sleep(2000);
        System.out.println("Inventory already created, sending you to login page...");
      }
    } catch(IOException | InterruptedException ex){
      ex.printStackTrace();
    }
  }

        public static void main(String arg[])  
      {  
          try  
          {  
              //create instance of the CreateLoginForm  
              launchPage form = new launchPage();  
              form.setSize(300,100);  //set size of the frame  
              form.setVisible(true);  //makes form visible to the user  
          }  
          catch(Exception e)  
          {     
              //handle exception   
              JOptionPane.showMessageDialog(null, e.getMessage());  
          }  
      } 
  }

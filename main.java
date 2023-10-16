import java.io.*;
import java.util.*;
import java.lang.Thread;
public class main{

    public static void clearConsole() throws IOException, InterruptedException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Robotics Inventory Mangement System (RIMS)");

        //check  if the team has already created their inventory space
        System.out.print("What is your team number? ");
        int teamNumber = input.nextInt();
        login obj = new login();
        obj.loadDB();
        if(obj.checkRegisteredTeam(teamNumber)==true){
            File newInventory = new File("./secrets/team" + Integer.toString(teamNumber) + ".csv");
            newInventory.createNewFile();
            File secretStuff = new File("./secrets/secrets" + Integer.toString(teamNumber) + ".txt");
            secretStuff.createNewFile();
            System.out.println("Creating your new inventory for team " + Integer.toString(teamNumber) + "...");
            Thread.sleep(2000);
            System.out.println("Your inventory space has been created! Sending you to login page...");
        }
        else{
            Thread.sleep(2000);
            System.out.println("Inventory already created, sending you to login page...");
        }
        obj.uploadtoDB();
        Thread.sleep(2000);
        clearConsole();

        //ask if they are a student or a mentor
        System.out.println("Welcome team " + Integer.toString(teamNumber));
        String personType = "";
        System.out.println("Are you a Student or Mentor?");
        personType = input.next();
        while(!personType.toLowerCase().equals("mentor") && !personType.toLowerCase().equals("student")){
        System.out.println("Wasnt able to understand... Are you a student or a mentor?");
        personType = input.next();
        }

        //check to see if they alredy have login credentials or not
        if(personType.toLowerCase().equals("student")){
            if(obj.checkForCrendtials(teamNumber)==false){
                System.out.println("It looks like you dont have any login credentials created. Ask your mentor to create the credentials for you");
                System.exit(0);
            }
            else{
                System.out.println("Welcome student of team " + Integer.toString(teamNumber));
                System.out.println("What is your password?");
                String password = "";
                while(obj.validateStudentCredentials(password, teamNumber)!=true){
                password = input.next();
                if(obj.validateStudentCredentials(password, teamNumber)==true){
                    System.out.println("You successfully logged in!");
                    Thread.sleep(2000);
                    break;
                }
                else{
                    System.out.println("Incorrect password, try again");
                }
            }
            }
            }
        else{
           if(obj.checkForCrendtials(teamNumber)==false){
                System.out.println("It looks like your team does not have any credentials created. Lets create  them now...");
                Thread.sleep(2000);
                clearConsole();
                System.out.println("What do you want the mentor password to be? Make sure you remember it!");
                String mentorPass = input.next();
                System.out.println("What do you want the student password to be?");
                String studentPass = input.next();
                obj.createCredentials(mentorPass,studentPass, teamNumber);
                System.out.println();
                System.out.println("creating your teams credentials now...");
                Thread.sleep(2000);
                System.out.println("Credentials Succesfully created! Restart program to login as normal.");
            }
            else{
                System.out.println("Welcome mentor of team " + Integer.toString(teamNumber));
                System.out.println("What is your password?");
                String password = "";
                while(obj.validateMentorCredentials(password, teamNumber)){
                password = input.next();
                if(obj.validateMentorCredentials(password, teamNumber)==true){
                    System.out.println("You successfully logged in!");
                    Thread.sleep(2000);
                    break;
                }   
                else{
                    System.out.println("Incorrect password, try again");
                } 
                }
            }

        }
    }
}
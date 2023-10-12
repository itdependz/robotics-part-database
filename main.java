import java.io.*;
import java.util.*;
import java.lang.Thread;
public class main{
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Robotics Inventory Mangement System (RIMS)");

        //check  if the team has already created their inventory space
        System.out.print("What is your team number? ");
        int teamNumber = input.nextInt();
        login obj = new login();
        obj.loadDB();
        if(obj.checkRegisteredTeam(teamNumber)==true){
            File newInventory = new File("./secrets/team" + Integer.toString(teamNumber));
            newInventory.createNewFile();
            System.out.println("Creating your new inventory for team " + Integer.toString(teamNumber) + "...");
            Thread.sleep(2000);
            System.out.println("Your inventory space has been created!");
        }
        else{
            System.out.println("Inventory already created, sending you to login page...");
        }
        obj.uploadtoDB();

        //ask if they are a student or a mentor

    }
}
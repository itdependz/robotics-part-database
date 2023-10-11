import java.io.*;
import java.util.*;
public class main{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Robotics Inventory Mangement System (RIMS)");

        //ask if they are a mentor or student
        System.out.print("What is your team number? ");
        int teamNumber = input.nextInt();
        login obj = new login();
        obj.loadDB();
        obj.checkRegisteredTeam(teamNumber);
        obj.uploadtoDB();
    }
}
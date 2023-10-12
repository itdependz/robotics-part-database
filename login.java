import java.io.*;
import java.util.*;
public class login{
   private String registeredTeams = "";

   public void login(){

   }

   public boolean checkRegisteredTeam(int team) throws IOException{
    String teamString = Integer.toString(team);
    if(registeredTeams.indexOf(teamString)>-1){
        return false;
    }
    else{
        if(registeredTeams.equals("")){
            registeredTeams = teamString;
        }
        else{
         registeredTeams = registeredTeams + " " + teamString;
         return true;
        }
        return false;
    }
   }

   //Only use this method to debug!
   public String registeredTeamsPrint(){
    return(registeredTeams);
   }

   public void uploadtoDB() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("./secrets/registeredTeams.txt"));
    writer.write(registeredTeams);
    
    writer.close();
}

    public String loadDB() throws IOException{
        File file = new File("./secrets/registeredTeams.txt");
        Scanner reader = new Scanner(file);
        if(reader.hasNextLine()){
        registeredTeams = reader.nextLine();
        }
        return registeredTeams;
    }


    public boolean checkForCrendtials(int team) throws IOException{
        File file = new File("./secrets/secrets" + Integer.toString(team)+ ".txt");
        Scanner reader = new Scanner(file);
        if(reader.hasNextLine()){
            return true;
        }
        return false;
    }

    public void createCredentials(String mentorpass, String studentpass, int team)throws IOException{
    BufferedWriter writer = new BufferedWriter(new FileWriter("./secrets/secrets" + Integer.toString(team) + ".txt"));
    writer.write(mentorpass);
    writer.newLine();
    writer.write(studentpass);
    
    writer.close();
    }
   }
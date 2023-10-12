import java.io.*;
import java.util.*;
public class login{
   private String registeredTeams = "";

   public void login(){

   }

   public boolean checkRegisteredTeam(int team) throws IOException{
    String teamString = Integer.toString(team);
    if(registeredTeams.indexOf(teamString)>-1){
        return true;
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
   }
public class login{
   private String registeredTeams = "";

   public void login(){

   }

   public boolean checkRegisteredTeam(int team){
    String teamString = Integer.toString(team);
    if(registeredTeams.indexOf(teamString)>-1){
        return true;
    }
    return false;
   }

}
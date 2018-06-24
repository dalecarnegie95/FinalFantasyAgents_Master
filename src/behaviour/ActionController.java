package behaviour;

public class ActionController {
   
    private static final ActionController INSTANCE = new ActionController();;
    
    public static ActionController getInstance(){
            return INSTANCE;
    }

    String proximo = "Mage";

    public boolean getActionTurn(String agentName){
       /* try {
            Thread.sleep(5000);
            if(agentName.equals("Mage")){
                proximo = "Ranger";
                return true;
            }
            if(agentName.equals("Ranger")){
                proximo = "Warrior";
                return true;
            }
            if(agentName.equals("Warrior")){
                proximo = "Mage";
                return true;
            }
            if(agentName.equals("Boss")){
                proximo = "Mage";
                return true;
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }*/
        return true;
    }
    
}

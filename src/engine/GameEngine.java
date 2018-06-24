package engine;

import agents.Controller;

public class GameEngine {
    
    private static GameEngine INSTANCE;
    
    public static GameEngine getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GameEngine();
        }
        return INSTANCE;
    }
    
    public void startUp(){
        Controller controller = new Controller();
        controller.createAgents();
        controller.startAgents();
    }
    
}

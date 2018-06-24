package agents;

import behaviour.RangerBehaviour;
import jade.core.Agent;

public class Ranger extends Agent{
    
    public static int life = 100;
    public static int atackdamage = 40;
    public static int defense = 35;
    public static int esperaMili = 1000;
    public static int flechas = 30;
    
    @Override
    protected void setup(){        
        Controller.AGENT_LIST.add(this);
        addBehaviour(new RangerBehaviour(this));   
    }
    
    @Override
    protected void takeDown() {
        System.out.println("Agente Ranger Finalizado");
    }
    
}

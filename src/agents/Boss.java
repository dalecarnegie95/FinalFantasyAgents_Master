package agents;

import agents.Controller;
import behaviour.BossBehaviour;
import jade.core.Agent;

public class Boss extends Agent{
    //.
    public static int life = 1000;
    public static int atackdamage = 40;
    public static int defense = 35;
    public static int esperaMili = 1000;
    
    @Override
    protected void setup(){
        Controller.AGENT_LIST.add(this);
        addBehaviour(new BossBehaviour(this));
    }
    
    @Override
    protected void takeDown() {
        System.out.println("Agente Chefão Boss Finalizado");
    }
}

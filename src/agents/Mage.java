package agents;

import behaviour.MageBehaviour;
import jade.core.Agent;

public class Mage extends Agent{
    
    public static int life = 100;
    public int atackdamage = 40;
    public static int defense = 35;
    public static int esperaMili = 1000;
        
    @Override
    protected void setup(){
        Controller.AGENT_LIST.add(this);
        addBehaviour(new MageBehaviour(this));
    }

    public int getAtackdamage() {
        return atackdamage;
    }

    public void setAtackdamage(int atackdamage) {
        this.atackdamage = atackdamage;
    }

    @Override
    protected void takeDown() {
        System.out.println("Agente Mage Finalizado");
    }
    
    
    
    
    
}

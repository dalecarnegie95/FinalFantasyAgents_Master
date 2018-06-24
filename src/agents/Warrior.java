package agents;

import behaviour.WarriorBehaviour;
import jade.core.Agent;

public class Warrior extends Agent{
    
    public static int life = 100;
    public static int atackdamage = 40;
    public static int defense = 35;
    public static int esperaMili = 1000;
    
    @Override
    protected void setup(){
        Controller.AGENT_LIST.add(this);
        addBehaviour(new WarriorBehaviour(this));
    }

     
    @Override
    protected void takeDown() {
        System.out.println("Agente Warrior Finalizado");
    }
    
    
}

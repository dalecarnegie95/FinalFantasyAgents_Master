package behaviour;

import engine.JFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.ThreadLocalRandom;

public class WarriorBehaviour extends CyclicBehaviour {

    ActionController ac = ActionController.getInstance();
    static Thread t;

    public WarriorBehaviour(Agent a) {
        super(a);
    }

    @Override
    public void action() {

        if (t == null || !t.isAlive()) {
            t = new Thread() {
                public void run() {
                    try {
                        if (sleepInicial()) {
                            AtacaBoss("warrior", "espada");
                        }
                    } catch (Exception v) {
                        System.out.println(v);
                    }
                }
            };
            t.start();
        }

        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            String content = msg.getContent();
            String[] partes = content.split("\\|");
            String quemAtaca = partes[0];
            String arma = partes[1];
            if (quemAtaca.equals("Boss")) {
                int vidaARetirar = 0;

                vidaARetirar = ThreadLocalRandom.current().nextInt(0, 30 + 1);
                if (vidaARetirar == 0) {
                    System.out.println("Warrior: " + content + " Errouuu");
                } else {
                    JFrame.setWarriorlife(vidaARetirar);
                    System.out.println("Warrior: " + content + " -" + vidaARetirar);
                    if (JFrame.getWarriorlife() <= 0) {
                        System.out.println("Warrior: Morri!");
                        t.interrupt();
                        this.getAgent().doSuspend();
                    }
                }
            }
        }

    }

    private void sleep() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private boolean sleepInicial() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(700, 6000 + 1));
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        return true;
    }

    void AtacaBoss(String quemAtaca, String arma) {
        ACLMessage MensagemParaEnviar = new ACLMessage(ACLMessage.CONFIRM);
        MensagemParaEnviar.addReceiver(new AID("Boss", AID.ISLOCALNAME));
        MensagemParaEnviar.setLanguage("Portugues");
        //MensagemParaEnviar.setOntology(mensagem.getOntology());
        MensagemParaEnviar.setContent(quemAtaca + "|" + arma);
        myAgent.send(MensagemParaEnviar);
    }

}

/*
    @Override
    public void action() {
        for (Agent agent : Controller.AGENT_LIST) {
            // ac.setActionTurn(getAgent().getAID().getLocalName());
            if (agent.getAID().getLocalName().toLowerCase().equals("boss")) {              

                    if (agent.getState() != 4) {

                        int vidaARetirar = 0;

                        vidaARetirar = ThreadLocalRandom.current().nextInt(3, 45 + 1);
                        if (vidaARetirar == 0) {
                            System.out.println("Warrior:Errouuuu");
                            continue;
                        }
                        System.out.println("Warrior:tentando tirar " + vidaARetirar + " de vida do boss");
                        if (((Boss) agent).life > 0) {

                            //System.out.println("toma seu " + agent.getAID().getLocalName() + " viado");
                            if (((Boss) agent).life > vidaARetirar) {
                                ((Boss) agent).life -= vidaARetirar;
                            } else {
                                ((Boss) agent).life -= 0;
                                ((Boss) agent).doSuspend();
                                break;
                            }
                        }
                        /*
                if(agent.getState() == 4){                    
                    agent.doActivate();
                    ((Mage) agent).life = 50;
                }
                    }                

            }
        }
        ((Warrior) this.getAgent()).esperaMili = ThreadLocalRandom.current().nextInt(700, 6000 + 1);
           // System.out.println("Warrior:esperando " + ((Warrior) this.getAgent()).esperaMili + " milisegundos para carregar");
            sleep(((Warrior) this.getAgent()).esperaMili);            


    }
    *

    void sleep(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (Exception ex) {

        }
    }*/

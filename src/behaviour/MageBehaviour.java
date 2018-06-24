package behaviour;

import engine.JFrame;
import jade.core.AID;
import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.ThreadLocalRandom;

public class MageBehaviour extends CyclicBehaviour {

    ActionController ac = ActionController.getInstance();
    static Thread t;

    public MageBehaviour(Agent a) {
        super(a);
    }

    @Override
    public void action() {

        if (t == null || !t.isAlive()) {
            t = new Thread() {
                public void run() {
                    try {
                        if (sleepInicial()) {
                            AtacaBoss("mage", "magia");
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
                    System.out.println("Mage: " + content + " Errouuu");
                } else {
                    JFrame.setMagelife(vidaARetirar);
                    System.out.println("Mage: " + content + " -" + vidaARetirar);
                    if (JFrame.getMagelife() <= 0) {
                        System.out.println("Mage: Morri!");
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
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10000 + 1));
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

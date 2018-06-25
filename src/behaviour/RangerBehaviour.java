package behaviour;

import engine.JFrame;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.ThreadLocalRandom;

public class RangerBehaviour extends CyclicBehaviour {

    static Thread t;

    public RangerBehaviour(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        if (t == null || !t.isAlive()) {
            t = new Thread() {
                @Override
                public void run() {
                    try {
                        if (sleepInicial()) {
                            for (int i = 0; i < ThreadLocalRandom.current().nextInt(3, 20 + 1); i++) {
                                AtacaBoss("ranger", "flexa");
                                sleep(300);
                            }
                        }
                    } catch (Exception v) {
                        System.out.println(v);
                    }
                }
            };
            t.start();
        }

        if (JFrame.getRangerlife() <= 0) {
            JFrame.jLabel_ranger.setVisible(false);
            JFrame.jProgressBar_rangerLife.setVisible(false);
            System.out.println("Range: Morri!");
            t.interrupt();
            this.getAgent().doSuspend();
        } else {

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
                        System.out.println("Ranger: " + content + " Errouuu");
                    } else {
                        JFrame.setRangerlife(vidaARetirar);
                        System.out.println("Ranger: " + content + " -" + vidaARetirar);
                    }
                }
            }
        }

    }

    private boolean precisoDeCura() {
        if (JFrame.getRangerlife() <= 10) {
            pedirCura();
            return true;
        } else {
            return false;
        }
    }

    private void pedirCura() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Mage", AID.ISLOCALNAME));
        msg.setLanguage("Portugues");
        msg.setOntology("Sistema de Batalha");
        msg.setContent("Preciso de Cura!");
        System.out.println("RANGER PRECISA DE CURA");
        myAgent.send(msg);
    }

    private void atacar() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Boss", AID.ISLOCALNAME));
        msg.setLanguage("Portugues");
        msg.setOntology("Sistema de Batalha");
        msg.setContent("Ataque");
        myAgent.send(msg);
    }

    private void sleep(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private boolean sleepInicial() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 4000 + 1));
        } catch (InterruptedException ex) {
            System.out.println("ggggg" + ex);
        }
        return true;
    }

    /*
    @Override
    public boolean done() {
        int vida = 0;
        if (vida == 0){
         //  myAgent.doDelete();
           return true;
        }
        return true;
    }*/
    void AtacaBoss(String quemAtaca, String arma) {
        ACLMessage MensagemParaEnviar = new ACLMessage(ACLMessage.CONFIRM);
        MensagemParaEnviar.addReceiver(new AID("Boss", AID.ISLOCALNAME));
        MensagemParaEnviar.setLanguage("Portugues");
        //MensagemParaEnviar.setOntology(mensagem.getOntology());
        MensagemParaEnviar.setContent(quemAtaca + "|" + arma);
        myAgent.send(MensagemParaEnviar);
        //JFrame.setRangerLog(MensagemParaEnviar.getContent());
        JFrame.setRangerAnimation();
    }

}

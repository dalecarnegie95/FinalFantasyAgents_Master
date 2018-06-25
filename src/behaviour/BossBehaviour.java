package behaviour;

import engine.JFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.ThreadLocalRandom;

public class BossBehaviour extends CyclicBehaviour {

    static Thread t;

    public BossBehaviour(Agent a) {
        super(a);
    }

    @Override
    public void action() {

        if (t == null || !t.isAlive()) {
            t = new Thread() {
                public void run() {
                    try {
                        if (sleepInicial()) {
                            int heroiParaAtacar = 0;

                            heroiParaAtacar = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                            if (heroiParaAtacar == 1) {
                                AtacaHeroi("Mage");
                            } else if (heroiParaAtacar == 2) {
                                AtacaHeroi("Ranger");
                            } else if (heroiParaAtacar == 3) {
                                AtacaHeroi("Warrior");
                            }
                        }
                    } catch (Exception v) {
                        System.out.println(v);
                    }
                }
            };
            t.start();
        }

        if (JFrame.getBosslife() <= 0) {
            JFrame.jLabel_boss.setVisible(false);
            JFrame.jProgressBar_bossLife.setVisible(false);
            System.out.println("Boss: Morri!");
            t.interrupt();
            this.getAgent().doSuspend();
        } else {
            ACLMessage msg = myAgent.receive();
            if (msg != null) {
                String content = msg.getContent();
                String[] partes = content.split("\\|");
                String quemAtaca = partes[0];
                String arma = partes[1];
                if (arma.equals("flexa")) {
                    int vidaARetirar = 0;
                    vidaARetirar = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                    if (vidaARetirar == 0) {
                        System.out.println("Boss: " + content + " Errouuu");
                    } else {
                        JFrame.setBosslife(vidaARetirar);
                        System.out.println("Boss: " + content + " -" + vidaARetirar);
                    }
                } else if (arma.equals("magia")) {
                    int vidaARetirar = 0;

                    vidaARetirar = ThreadLocalRandom.current().nextInt(0, 50 + 1);
                    if (vidaARetirar == 0) {
                        System.out.println("Boss: " + content + " Errouuu");

                    } else {
                        JFrame.setBosslife(vidaARetirar);
                        System.out.println("Boss: " + content + " -" + vidaARetirar);
                    }
                } else if (arma.equals("espada")) {
                    int vidaARetirar = 0;

                    vidaARetirar = ThreadLocalRandom.current().nextInt(3, 45 + 1);
                    if (vidaARetirar == 0) {
                        System.out.println("Boss: " + content + " Errouuu");

                    } else {
                        JFrame.setBosslife(vidaARetirar);
                        System.out.println("Boss: " + content + " -" + vidaARetirar);
                    }
                }
            }
        }

    }

    void AtacaHeroi(String atacarQuem) {
        ACLMessage MensagemParaEnviar = new ACLMessage(ACLMessage.CONFIRM);
        MensagemParaEnviar.addReceiver(new AID(atacarQuem, AID.ISLOCALNAME));
        MensagemParaEnviar.setLanguage("Portugues");
        //MensagemParaEnviar.setOntology(mensagem.getOntology());
        MensagemParaEnviar.setContent("Boss|" + "espada");
        myAgent.send(MensagemParaEnviar);
        //JFrame.setBossLog(MensagemParaEnviar.getContent());
        JFrame.setBossAnimation();
    }

    private boolean sleepInicial() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000 + 1));
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        return true;
    }

    /*   @Override
    public boolean done() {
        int vida = 0;
        if (vida == 0){
         //  myAgent.doDelete();
           return true;
        }
        return false;
    }*/
}

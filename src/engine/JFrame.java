package engine;

import java.awt.BorderLayout;
import javax.swing.JProgressBar;

public class JFrame extends javax.swing.JFrame {

    public JFrame(){
        initComponents();
        setTitle("Final Fantasy Agents");
	setSize(1136,675);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
        setLayout(new BorderLayout());
        
        initAgentLife();
    }
    
    private void initAgentLife(){
        jProgressBar_bossLife.setValue(1100);
        jProgressBar_mageLife.setValue(100);
        jProgressBar_rangerLife.setValue(100);
        jProgressBar_warriorLife.setValue(100);
    }
    
    public static void setBosslife(int life){
        jProgressBar_bossLife.setValue(jProgressBar_bossLife.getValue() - life);
    }
    
    public static void setMagelife(int life){
        jProgressBar_mageLife.setValue(jProgressBar_mageLife.getValue() - life);
    }
    
    public static void setRangerlife(int life){
        jProgressBar_rangerLife.setValue(jProgressBar_rangerLife.getValue() - life);
    }
    
    public static void setWarriorlife(int life){
        jProgressBar_warriorLife.setValue(jProgressBar_warriorLife.getValue() - life);
    }
    
    public static int getMagelife(){
        return jProgressBar_mageLife.getValue();
    }
    public static int getRangerlife(){
        return jProgressBar_rangerLife.getValue();
    }
    public static int getWarriorlife(){
        return jProgressBar_warriorLife.getValue();
    }
       public static int getBosslife(){
        return jProgressBar_bossLife.getValue();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar_mageLife = new javax.swing.JProgressBar();
        jLabel_mage = new javax.swing.JLabel();
        jProgressBar_warriorLife = new javax.swing.JProgressBar();
        jLabel_warrior = new javax.swing.JLabel();
        jProgressBar_rangerLife = new javax.swing.JProgressBar();
        jLabel_ranger = new javax.swing.JLabel();
        jProgressBar_bossLife = new javax.swing.JProgressBar();
        jLabel_boss = new javax.swing.JLabel();
        jLabel_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jProgressBar_mageLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_mageLife.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(jProgressBar_mageLife);
        jProgressBar_mageLife.setBounds(140, 10, 146, 14);

        jLabel_mage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mage.png"))); // NOI18N
        getContentPane().add(jLabel_mage);
        jLabel_mage.setBounds(160, -10, 110, 230);

        jProgressBar_warriorLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_warriorLife.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(jProgressBar_warriorLife);
        jProgressBar_warriorLife.setBounds(40, 190, 146, 14);

        jLabel_warrior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warrior.png"))); // NOI18N
        getContentPane().add(jLabel_warrior);
        jLabel_warrior.setBounds(30, 210, 180, 210);

        jProgressBar_rangerLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_rangerLife.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(jProgressBar_rangerLife);
        jProgressBar_rangerLife.setBounds(180, 430, 146, 14);

        jLabel_ranger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ranger.png"))); // NOI18N
        getContentPane().add(jLabel_ranger);
        jLabel_ranger.setBounds(150, 450, 140, 180);

        jProgressBar_bossLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_bossLife.setForeground(new java.awt.Color(51, 255, 51));
        jProgressBar_bossLife.setMaximum(1100);
        getContentPane().add(jProgressBar_bossLife);
        jProgressBar_bossLife.setBounds(620, 10, 380, 14);

        jLabel_boss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boss.png"))); // NOI18N
        getContentPane().add(jLabel_boss);
        jLabel_boss.setBounds(610, 0, 540, 630);

        jLabel_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpeg"))); // NOI18N
        getContentPane().add(jLabel_background);
        jLabel_background.setBounds(0, 0, 1136, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> { 
            new JFrame().setVisible(true);
        });
        GameEngine ga = GameEngine.getInstance();
        ga.startUp();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_background;
    private javax.swing.JLabel jLabel_boss;
    private javax.swing.JLabel jLabel_mage;
    private javax.swing.JLabel jLabel_ranger;
    private javax.swing.JLabel jLabel_warrior;
    public static javax.swing.JProgressBar jProgressBar_bossLife;
    public static javax.swing.JProgressBar jProgressBar_mageLife;
    public static javax.swing.JProgressBar jProgressBar_rangerLife;
    public static javax.swing.JProgressBar jProgressBar_warriorLife;
    // End of variables declaration//GEN-END:variables
}

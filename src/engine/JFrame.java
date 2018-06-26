package engine;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class JFrame extends javax.swing.JFrame {
    
    JFrame JFrameInstance = this;
    
    public JFrame(){
        initComponents();
        setTitle("Final Fantasy Agents");
	setSize(1136,675);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
        setLayout(new BorderLayout());
        
        
        jLabel_bossDamage.setVisible(false);
        jLabel_mageDamage.setVisible(false);
        jLabel_warriorDamage.setVisible(false);
        jLabel_rangerDamage.setVisible(false);
        
        jLabel_kunai.setVisible(false);
        
        initAgentLife();
        
    }
    
    public JFrame getInstance(){
        return JFrameInstance;
    }
    
    private void initAgentLife(){
        jProgressBar_bossLife.setValue(1100);
        jProgressBar_bossLife.setStringPainted(true);
        jProgressBar_rangerLife.setValue(100);
        jProgressBar_mageLife.setValue(100);
        jProgressBar_warriorLife.setValue(100);
    }
    
    public static void setBosslife(int life){
        jProgressBar_bossLife.setValue(jProgressBar_bossLife.getValue() - life);
    }
    
    public static void setMagelife(int life){
        jProgressBar_rangerLife.setValue(jProgressBar_rangerLife.getValue() - life);
    }
    
    public static void setRangerlife(int life){
        jProgressBar_mageLife.setValue(jProgressBar_mageLife.getValue() - life);
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
    
    public static void updateKunaiAnimation(){
        jLabel_kunai.setVisible(true);
        for (int i = 0; i < 60; i++) {
            jLabel_kunai.setBounds(280 + i * 5, 100, 70, 30);
            sleep(5L);
        }
        jLabel_kunai.setVisible(false);
    }
    
    public static void updateMageAnimation(ImageIcon icon, int vai_pra_frente){
        jLabel_mage.setIcon(icon);
        jLabel_mage.setBounds(110 + vai_pra_frente * 3, 450, 200, 180);
        sleep(120L);
        /*
       jLabel_mage.setBounds(115, 450, 140, 180);
       sleep(300L);
       jLabel_mage.setBounds(120, 450, 140, 180);
       sleep(300L);
       jLabel_mage.setBounds(110, 450, 140, 180);
        */
    }
    
    public static void updateWarriorAnimation(ImageIcon icon, int vai_pra_frente){
        jLabel_warrior.setIcon(icon);
        jLabel_warrior.setBounds(30 + vai_pra_frente * 3, 210, 180, 210);
        sleep(70L);
        /*
        jLabel_warrior.setBounds(35, 210, 180, 210);
        sleep(300L);
        jLabel_warrior.setBounds(40, 210, 180, 210);
        sleep(300L);
        jLabel_warrior.setBounds(30, 210, 180, 210);
        */
    }
    
    public static void updateRangerAnimation(ImageIcon icon, int vai_pra_frente){
        jLabel_ranger.setIcon(icon);
        jLabel_ranger.setBounds(140 + vai_pra_frente * 3, -10, 130, 230);
        sleep(70L);
       /*
       jLabel_ranger.setBounds(145, -10, 110, 230);
       sleep(300L);
       jLabel_ranger.setBounds(150, -10, 110, 230);
       sleep(300L);
       jLabel_ranger.setBounds(140, -10, 110, 230);
       */
    }
    
    public static void setBossAnimation(){
       jLabel_boss.setBounds(605, 0, 510, 630);
       sleep(300L);
       jLabel_boss.setBounds(600, 0, 510, 630);
       sleep(300L);
       jLabel_boss.setBounds(610, 0, 510, 630);
    }
    
    public static void updateBossDamageAnimation(int damage){
        jLabel_bossDamage.setVisible(true);
        jLabel_bossDamage.setText(String.valueOf(damage));
        jLabel_bossDamage.setBounds(750, 240, 120, 50);
        sleep(100L);
        jLabel_bossDamage.setBounds(750, 230, 120, 50);
        sleep(100L);
        jLabel_bossDamage.setBounds(750, 220, 120, 50);
        sleep(100L);
        jLabel_bossDamage.setBounds(750, 210, 120, 50);
        sleep(100L);
        jLabel_bossDamage.setBounds(750, 200, 120, 50);
        sleep(100L);
        jLabel_bossDamage.setBounds(750, 190, 120, 50);
        sleep(100L);
        jLabel_bossDamage.setVisible(false);
    }
    
    public static void updateMageDamageAnimation(int damage){
        jLabel_mageDamage.setVisible(true);
        jLabel_mageDamage.setText(String.valueOf(damage));
        jLabel_mageDamage.setBounds(150, 540, 110, 50);
        sleep(100L);
        jLabel_mageDamage.setBounds(150, 530, 110, 50);
        sleep(100L);
        jLabel_mageDamage.setBounds(150, 520, 110, 50);
        sleep(100L);
        jLabel_mageDamage.setBounds(150, 510, 110, 50);
        sleep(100L);
        jLabel_mageDamage.setBounds(150, 500, 110, 50);
        sleep(100L);
        jLabel_mageDamage.setBounds(150, 490, 110, 50);
        sleep(100L);
        jLabel_mageDamage.setVisible(false);
    }
    
    public static void updateWarriorDamageAnimation(int damage){
        jLabel_warriorDamage.setVisible(true);
        jLabel_warriorDamage.setText(String.valueOf(damage));
        jLabel_warriorDamage.setBounds(50, 330, 120, 50);
        sleep(100L);
        jLabel_warriorDamage.setBounds(50, 320, 120, 50);
        sleep(100L);
        jLabel_warriorDamage.setBounds(50, 310, 120, 50);
        sleep(100L);
        jLabel_warriorDamage.setBounds(50, 300, 120, 50);
        sleep(100L);
        jLabel_warriorDamage.setBounds(50, 290, 120, 50);
        sleep(100L);
        jLabel_warriorDamage.setBounds(50, 280, 120, 50);
        sleep(100L);
        jLabel_warriorDamage.setVisible(false);
    }
    
    public static void updateRangerDamageAnimation(int damage){
        jLabel_rangerDamage.setVisible(true);
        jLabel_rangerDamage.setText(String.valueOf(damage));
        jLabel_rangerDamage.setBounds(140, 90, 110, 50);
        sleep(100L);
        jLabel_rangerDamage.setBounds(140, 80, 110, 50);
        sleep(100L);
        jLabel_rangerDamage.setBounds(140, 70, 110, 50);
        sleep(100L);
        jLabel_rangerDamage.setBounds(140, 60, 110, 50);
        sleep(100L);
        jLabel_rangerDamage.setBounds(140, 50, 110, 50);
        sleep(100L);
        jLabel_rangerDamage.setBounds(140, 40, 110, 50);
        sleep(100L);
        jLabel_warriorDamage.setVisible(false);
    }
    
    private static void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_kunai = new javax.swing.JLabel();
        jLabel_rangerDamage = new javax.swing.JLabel();
        jProgressBar_rangerLife = new javax.swing.JProgressBar();
        jLabel_ranger = new javax.swing.JLabel();
        jLabel_warriorDamage = new javax.swing.JLabel();
        jProgressBar_warriorLife = new javax.swing.JProgressBar();
        jLabel_warrior = new javax.swing.JLabel();
        jLabel_mageDamage = new javax.swing.JLabel();
        jProgressBar_mageLife = new javax.swing.JProgressBar();
        jLabel_mage = new javax.swing.JLabel();
        jLabel_bossDamage = new javax.swing.JLabel();
        jProgressBar_bossLife = new javax.swing.JProgressBar();
        jLabel_boss = new javax.swing.JLabel();
        jLabel_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel_kunai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kunai.png"))); // NOI18N
        getContentPane().add(jLabel_kunai);
        jLabel_kunai.setBounds(280, 100, 70, 30);

        jLabel_rangerDamage.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel_rangerDamage.setForeground(new java.awt.Color(255, 255, 0));
        jLabel_rangerDamage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_rangerDamage.setText("DAMAGE");
        getContentPane().add(jLabel_rangerDamage);
        jLabel_rangerDamage.setBounds(140, 110, 110, 50);

        jProgressBar_rangerLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_rangerLife.setForeground(new java.awt.Color(51, 102, 0));
        jProgressBar_rangerLife.setStringPainted(true);
        getContentPane().add(jProgressBar_rangerLife);
        jProgressBar_rangerLife.setBounds(130, 10, 146, 17);

        jLabel_ranger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ranger_idle_1.png"))); // NOI18N
        getContentPane().add(jLabel_ranger);
        jLabel_ranger.setBounds(140, -10, 110, 230);

        jLabel_warriorDamage.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel_warriorDamage.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_warriorDamage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_warriorDamage.setText("DAMAGE");
        getContentPane().add(jLabel_warriorDamage);
        jLabel_warriorDamage.setBounds(60, 330, 120, 50);

        jProgressBar_warriorLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_warriorLife.setForeground(new java.awt.Color(0, 102, 0));
        jProgressBar_warriorLife.setStringPainted(true);
        getContentPane().add(jProgressBar_warriorLife);
        jProgressBar_warriorLife.setBounds(40, 190, 146, 17);

        jLabel_warrior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warrior_idle_1.png"))); // NOI18N
        getContentPane().add(jLabel_warrior);
        jLabel_warrior.setBounds(30, 210, 180, 210);

        jLabel_mageDamage.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel_mageDamage.setForeground(new java.awt.Color(0, 255, 102));
        jLabel_mageDamage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_mageDamage.setText("DAMAGE");
        getContentPane().add(jLabel_mageDamage);
        jLabel_mageDamage.setBounds(150, 550, 110, 50);

        jProgressBar_mageLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_mageLife.setForeground(new java.awt.Color(51, 102, 0));
        jProgressBar_mageLife.setStringPainted(true);
        getContentPane().add(jProgressBar_mageLife);
        jProgressBar_mageLife.setBounds(130, 440, 146, 17);

        jLabel_mage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ranger.png"))); // NOI18N
        getContentPane().add(jLabel_mage);
        jLabel_mage.setBounds(110, 450, 140, 180);

        jLabel_bossDamage.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel_bossDamage.setForeground(new java.awt.Color(255, 51, 0));
        jLabel_bossDamage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_bossDamage.setText("DAMAGE");
        getContentPane().add(jLabel_bossDamage);
        jLabel_bossDamage.setBounds(750, 250, 120, 50);

        jProgressBar_bossLife.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar_bossLife.setForeground(new java.awt.Color(51, 102, 0));
        jProgressBar_bossLife.setMaximum(1100);
        jProgressBar_bossLife.setOpaque(true);
        jProgressBar_bossLife.setStringPainted(true);
        getContentPane().add(jProgressBar_bossLife);
        jProgressBar_bossLife.setBounds(620, 10, 380, 17);

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
    public static javax.swing.JLabel jLabel_boss;
    public static javax.swing.JLabel jLabel_bossDamage;
    public static javax.swing.JLabel jLabel_kunai;
    public static javax.swing.JLabel jLabel_mage;
    public static javax.swing.JLabel jLabel_mageDamage;
    public static javax.swing.JLabel jLabel_ranger;
    public static javax.swing.JLabel jLabel_rangerDamage;
    public static javax.swing.JLabel jLabel_warrior;
    public static javax.swing.JLabel jLabel_warriorDamage;
    public static javax.swing.JProgressBar jProgressBar_bossLife;
    public static javax.swing.JProgressBar jProgressBar_mageLife;
    public static javax.swing.JProgressBar jProgressBar_rangerLife;
    public static javax.swing.JProgressBar jProgressBar_warriorLife;
    // End of variables declaration//GEN-END:variables
}

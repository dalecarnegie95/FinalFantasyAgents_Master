package agents;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.core.Runtime;
import jade.wrapper.StaleProxyException;
import java.util.ArrayList;

public class Controller {

    static Runtime RUNTIME;
    static Profile PROFILE;
    static AgentController MAGE_CONTROLLER;
    static AgentController RANGER_CONTROLLER;
    static AgentController WARRIOR_CONTROLLER;
    static AgentController BOSS_CONTROLLER;
    static AgentContainer AGENT_CONTAINER;
    public static ArrayList<Agent> AGENT_LIST = new ArrayList<Agent>();

    public Controller() {
        RUNTIME = Runtime.instance();
        PROFILE = new ProfileImpl();
        PROFILE.setParameter(Profile.PLATFORM_ID, "FinalFantasy");
        PROFILE.setParameter(Profile.CONTAINER_NAME, "Container");
        PROFILE.setParameter(Profile.GUI, "true");
        AGENT_CONTAINER = RUNTIME.createMainContainer(PROFILE);
    }

    public void createAgents() {
        try {
            MAGE_CONTROLLER = AGENT_CONTAINER.createNewAgent("Mage", "agents.Mage", null);
            RANGER_CONTROLLER = AGENT_CONTAINER.createNewAgent("Ranger", "agents.Ranger", null);
            WARRIOR_CONTROLLER = AGENT_CONTAINER.createNewAgent("Warrior", "agents.Warrior", null);
            BOSS_CONTROLLER = AGENT_CONTAINER.createNewAgent("Boss", "agents.Boss", null);
        } catch (StaleProxyException ex) {
            System.out.println("Controller.createAgents: " + ex);
        }
    }

    public void startAgents() {
        try {
            MAGE_CONTROLLER.start();
            RANGER_CONTROLLER.start();
            WARRIOR_CONTROLLER.start();
            BOSS_CONTROLLER.start();
        } catch (StaleProxyException ex) {
            System.out.println("Controller.startAgents: " + ex);
        }
    }

}

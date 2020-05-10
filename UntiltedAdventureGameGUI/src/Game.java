import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame kirb;
    Container kirbo;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Gothic", Font.ITALIC, 98);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font smallerFont = new Font("Times New Roman", Font.PLAIN, 10);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP;
    int chest = 1;
    int mana = 10;
    int potion;
    int magic;
    int horn = 0;
    boolean potionChecker = false;
    String weapon, position;

    TitleScreenHandler kirby = new TitleScreenHandler();
    ChoiceHandler choices = new ChoiceHandler();

    public static void main(String[] args) {

        new Game();
    }

    public Game() {
        kirb = new JFrame();
        kirb.setSize(1020, 720);
        kirb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kirb.getContentPane().setBackground(Color.black);
        kirb.setLayout(null);
        kirb.setVisible(true);
        kirbo = kirb.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 800, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("『Morio Ventures』");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(400, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START GAME");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(kirby); //recognizes click
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        kirbo.add(titleNamePanel);
        kirbo.add(startButtonPanel);
    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        kirbo.add(mainTextPanel);

        mainTextArea = new JTextArea("");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //wraps text if too long
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        kirbo.add(choiceButtonPanel);

        choice1 = new JButton("Option 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choices);
        choice1.setActionCommand("o1");

        choice2 = new JButton("Option 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choices);
        choice2.setActionCommand("o2");

        choice3 = new JButton("Option 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choices);
        choice3.setActionCommand("o3");

        choice4 = new JButton("Option 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choices);
        choice4.setActionCommand("o4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        kirbo.add(playerPanel);
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }

    public void playerSetup() {
        playerHP = 70;
        monsterHP = 100;
        weapon = "Rusty Sword";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText(" " + playerHP);

        morioStart();
    }

    public void morioStart() {
        position = "morioStart";
        choice3.setVisible(true);
        choice4.setVisible(true);
        playerHP = 70;
        weapon = "Rusty Sword";
        chest = 1;
        magic = 0;
        potionChecker = false;
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText(" " + playerHP);
        mainTextArea.setText("Hello.\nWelcome to combat with GUI Ver. 1.7. \nEnjoy your stay and all that.");

        choice1.setText("Continue.");
        choice2.setText("Exit.");
        choice3.setText("");
        choice4.setText("");
    }

    public void morioExit() {
        position = "morioExit";
        System.exit(0);
    }

    public void morioWelcome() {
        position = "morioWelcome";
        mainTextArea.setText("You awake outside of a town gate.");

        choice1.setText("Continue.");
        choice2.setText("Go Back.");
        choice3.setText("");
        choice4.setText("");
    }

    public void morioWelcome2() {
        position = "morioWelcome2";
        mainTextArea.setText("Guard: Hello there Stranger. You must be new here." +
                "\nWell, welcome to the town of Morio.");

        choice1.setText("Continue.");
        choice2.setText("Back.");
        choice3.setText("");
        choice4.setText("");
    }

    public void morioWelcome3() {
        position = "morioWelcome3";
        mainTextArea.setText("Guard: Unfortunately we cannot allow anyone into our town currently." +
                "\nWe currently have a dragon invasion. \nNow if that problem can be solved then we'd " +
                "let more people into the town.");

        choice1.setText("Leave Town.");
        choice2.setText("Charge at the Guard.");
        choice3.setText("Back.");
        choice4.setText("");
    }

    public void chargeGuard() {
        position = "chargeGuard";
        mainTextArea.setText("Guard: What is wrong with you?\n\n The Guard smacked you down. \n(You took 5 damage.)" +
                "\nGuard: Please do not try that again.");
        playerHP = playerHP - 5;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("'Ow.'");
        choice2.setText("");
        choice3.setText("");
    }

    public void morioRoad() {
        position = "morioRoad";
        mainTextArea.setText("You have left town. Where should we go now? \nNorth is back to town.");
        choice1.setText("Go North.");
        choice2.setText("Go South.");
        choice3.setText("Go East.");
        choice4.setText("Go West.");
        if(horn >0){
            choice4.setVisible(false);
        }
    }

    public void south() {
        position = "south";
        mainTextArea.setText("Upon heading down the path you're met with a wooden chest.");
        choice1.setText("Open it.");
        choice2.setText("Go back.");
        choice3.setText("...");
        choice4.setText("...");
    }

    public void south2() {
        position = "south2";
        if (chest == 1) {
            mainTextArea.setText("When you open the chest you find 10 potions and a sword."+
                    "\n\n(You obtain x10 potions.)" +
                    "\n(You obtain Sun Sword.)");
            //playerHP = playerHP + 5;
            //hpLabelNumber.setText("" + playerHP);
            potion = potion + 10;
            weapon = "Sun Sword";
            weaponLabelName.setText("" + weapon);
            chest = chest - 1;
            potionChecker = true;

            choice1.setText("Go back.");
            choice2.setText("...");
            choice3.setText("...");
            choice4.setText("...");
        } else {
            mainTextArea.setText("You've already opened this chest.");
            choice1.setText("Go back.");
            choice2.setText("...");
            choice3.setText("...");
            choice4.setText("...");
        }
    }

    public void east() {
        position = "east";
        mainTextArea.setText("You head into the forest and find a magic staff.\n" +
                "Magic should come in handy.");
        magic = 1;
        choice1.setText("Go Back.");
        choice2.setText("...");
        choice3.setText("...");
        choice4.setText("...");
    }

    public void west() {
        position = "west";
        if(monsterHP <= 0){
            mainTextArea.setText("You have slayed the Dragon King.\n There is nothing for you here.");
            choice1.setText("Fight.");
            choice2.setText("Go Back.");
            choice3.setText("...");
            choice4.setText("...");
        }
        else
        mainTextArea.setText("You find encounter the Dragon King.");

        choice1.setText("Fight.");
        choice2.setText("Go Back.");
        choice3.setText("...");
        choice4.setText("...");
    }

    public void boss() {
        position = "boss";
        mainTextArea.setText("Monster HP: " + monsterHP + "\nWhat will you do?");
        if (magic == 1 && potionChecker == true) {
            choice1.setText("Attack.");
            choice2.setText("Magic.");
            choice3.setText("Heal.");
            choice4.setText("Flee.");
        }
        if(magic == 1 && potionChecker == false){
            choice1.setText("Attack.");
            choice2.setText("Magic.");
            choice3.setText("Not Unlocked.");
            choice4.setText("Flee.");
        }
         if(magic == 0 && potionChecker == true){
             choice1.setText("Attack.");
             choice2.setText("Not Unlocked.");
             choice3.setText("Heal.");
             choice4.setText("Flee.");
         }
        if(magic == 0 && potionChecker == false){
            choice1.setText("Attack.");
            choice2.setText("Not Unlocked");
            choice3.setText("Not Unlocked.");
            choice4.setText("Flee.");
        }
    }

    public void playerAttack() {
        position = "playerAttack";

        int playerDamage = 0;

        if (weapon.equals("Rusty Sword")) {
            playerDamage = new java.util.Random().nextInt(10);
        }
        if (weapon.equals("Sun Sword")) {
            playerDamage = new java.util.Random().nextInt(20);
        }

        mainTextArea.setText("You attacked the Dragon and dealt " + playerDamage + " damage.");
        monsterHP = monsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack() {
        position = "monsterAttack";
        int monsterDmg = 0;
        monsterDmg = new java.util.Random().nextInt(10);

        if (monsterDmg == 0) {
            mainTextArea.setText("You successfully dodged the attack.");
        } else {
            mainTextArea.setText("The monster attacked you and dealt " + monsterDmg + " damage.");
            playerHP = playerHP - monsterDmg;
            hpLabelNumber.setText("" + playerHP);

        }
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void victory() {
        position = "victory";

        mainTextArea.setText("You slayed the Dragon King.\nYou take the Dragon's horn with you as proof of the deed.");
        horn = 1;

        choice1.setText("Go back.");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void death() {
        position = "death";
        mainTextArea.setText("You have fallen in combat.\n\n\nGAME OVER.");

        choice1.setText("Try again.");
        choice2.setText("Quit.");
        choice3.setText("");
        choice4.setText("");

        choice3.setVisible(false);
        choice4.setVisible(false);

    }

    public void playerMagic() {
        position = "playerMagic";

        int magicDamage = 0;
        if(mana <= 0){
            mainTextArea.setText("You are out of mana!");
            magicDamage = 0;
            monsterHP = monsterHP - 0;
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        else {
            magicDamage = new java.util.Random().nextInt(25);

            mainTextArea.setText("You currently have " + mana + "\nYou attacked the Dragon and dealt " + magicDamage + " damage.");
            mana = mana - 2;
            monsterHP = monsterHP - magicDamage;

            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void playerHeal(){
        position = "playerHeal";
        if(potion <= 10){
            mainTextArea.setText("You currently have " + potion + ".\n You use a potion and heal 20 HP.");
            playerHP = playerHP + 20;
            hpLabelNumber.setText("" + playerHP);
            potion = potion - 1;
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        else{
            mainTextArea.setText("You are out of potions!");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void ending() {
        position = "ending";
        mainTextArea.setText("Wow, you killed the Dragon KING???\nThank you so much.\n" +
                "Welcome to Morio, you've more than earned your keep.");
        choice1.setText("End");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void morioEnd() {
        position = "morioEnd";
        mainTextArea.setText("Guard: Hello there Stranger. You must be new here." +
                "\nWell, welcome to the town of Morio.");

        choice1.setText("Continue.");
        choice2.setText("Back.");
        choice3.setText("");
        choice4.setText("");
    }

    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            createGameScreen();

        }
    }

    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            String yourChoice = actionEvent.getActionCommand();

            switch (position) {
                case "morioStart":
                    switch (yourChoice) {
                        case "o1":
                            morioWelcome();
                            break;
                        case "o2":
                            morioExit();
                            break;
                        case "o3":
                        case "o4":
                            break;
                    }
                    break;
                case "morioWelcome":
                    switch (yourChoice) {
                        case "o1":
                            morioWelcome2();
                            break;
                        case "o2":
                            morioStart();
                            break;
                    }
                    break;
                case "morioWelcome2":
                    switch (yourChoice) {
                        case "o1":
                            morioWelcome3();
                            break;
                        case "o2":
                            morioWelcome();
                            break;
                    }
                    break;
                case "morioWelcome3":
                    switch (yourChoice) {
                        case "o1":
                            morioRoad();
                            break;
                        case "o2":
                            chargeGuard();
                            break;
                        case "o3":
                            morioWelcome2();
                            break;
                        case "o4":
                            break;
                    }
                    break;
                case "chargeGuard":
                    switch (yourChoice) {
                        case "o1":if (playerHP < 1) {
                            death();
                        } else {
                            morioWelcome3();
                        }
                            break;
                        case "o2":
                        case "o3":
                        case "o4":
                            break;
                    }
                    break;
                case "morioRoad":
                    switch (yourChoice) {
                        case "o1":
                            if (horn > 0) {
                                morioEnd();
                            }
                            else {
                                morioWelcome3();
                                break;
                            }
                            break;
                        case "o2":
                            south();
                            break;
                        case "o3":
                            east();
                            break;
                        case "o4":
                            if(horn > 0){
                                choice4.setVisible(false);
                                break;
                            }
                            else{
                                west();
                            }
                            break;
                    }
                    break;
                case "south":
                    switch (yourChoice) {
                        case "o1":
                            south2();
                            break;
                        case "o2":
                            morioRoad();
                            break;
                        case "o3":
                        case "o4":
                            break;
                    }
                    break;
                case "south2":
                    switch (yourChoice) {
                        case "o1":
                            morioRoad();
                            break;
                        case "o2":
                        case "o3":
                        case "o4":
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "o1":
                            morioRoad();
                            break;
                        case "o3":
                        case "o2":
                        case "o4":
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "o1":
                            boss();
                            break;
                        case "o2":
                            morioRoad();
                            break;
                        case "o3":
                            break;
                        case "o4":
                            break;
                    }
                    break;
                case "boss":
                    switch (yourChoice) {
                        case "o1":
                            playerAttack();
                            break;
                        case "o2":
                            if (magic > 0) {
                                playerMagic(); break;
                            }
                            break;
                        case "o3":
                            if(potion > 0){
                                playerHeal(); break;
                            }
                            break;
                        case "o4":
                            morioRoad();
                            break;
                    }
                    break;
                case "playerAttack":
                    switch (yourChoice) {
                        case "o1":
                            if (monsterHP < 1) {
                                victory(); break;
                            } else {
                                monsterAttack();
                                break;
                            }
                    }
                    break;
                case "playerMagic":
                    switch (yourChoice) {
                        case "o1":
                            if(mana <= 0){
                                boss(); break;
                            }
                            if (monsterHP < 1) {
                                victory(); break;
                            } else {
                                monsterAttack();
                                break;
                            }
                        case "o2":
                            break;
                    }
                    break;
                case "playerHeal":
                    switch(yourChoice){
                        case "o1":
                            if(potion <= 0){
                                boss();
                                break;
                            }
                            if(potionChecker == false){
                                boss(); break;
                            }
                            if(playerHP <= 0){
                                death(); break;
                            }
                            else{
                                monsterAttack();
                                break;
                            }
                        case "o2":
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourChoice) {
                        case "o1":
                            if (playerHP < 1) {
                                death();
                            } else {
                                boss();
                            }
                            break;
                    }
                    break;
                case "death":
                    switch (yourChoice) {
                        case "o1":
                            morioStart();
                            break;
                        case "o2":
                            morioExit();
                            break;
                    }
                    break;
                case "victory":
                    switch (yourChoice) {
                        case "o1":
                            morioRoad();
                            break;
                    }
                    break;
                case "ending":
                    switch (yourChoice) {
                        case "o1":
                            morioExit();
                            break;
                    }
                    break;
                case "morioEnd":
                    switch (yourChoice) {
                        case "o1":
                            ending();
                    }
            }
        }
    }
}


package org.rpgMain;

import org.rpgMain.Armor.Armor;
import org.rpgMain.Character.Character;
import org.rpgMain.Floor.Floor;

import java.util.Scanner;


public class Main {
    // 0. Character Type [(1) Cat, (2) Demon, (3) Human]
    // 1. Weapon Type [Magical, Physical, Either]
    // 2. Current Level [Each level requires 100*Current Level experience to level up (lvl 2 requires 100*1 exp)]
    // 3. Current EXP
    // 4. Current Health [Health is 10*current level hp]
    // 5. Current Floor
    // 6. Permanent Status [Strengthened, Quickened, Fortified]
    //                      STR+          SPD+       REG+
    // 7. Temporary Status [Paralysis, Poisoned, Asleep]
    // 8. Event [Bonus XP, Increased Accuracy, Extra Money]
    //           EXP+      ACC+                GLD+
    // 9. Weapon Stats [Accuracy|Penetration]
    // 10. Helmet Stats [Accuracy|Penetration]
    // 11. Chest Stats [Accuracy|Penetration]
    // 12. Pants Stats [Accuracy|Penetration]
    // 13. Boots Stats [Accuracy|Penetration]
    // 14. Current Gold
    static String[] gameState;
    static boolean alive;
    static Character playerCharacter;
    static CharacterBuilder characterBuilder;
    static ArmorBuilder armorBuilder;
    static FloorBuilder floorBuilder;
    static Armor[] armorSet;
    static int[] potions;

    /**
     * Asks the player for an input and creates the character.
     * @return a CharacterBuilder object
     */
    private static Character selectCharacter() {
        //Ask which class the player will play as
        boolean characterNotSelected = true;
        int characterSelection = 0;
        while(characterNotSelected) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please choose your class:\n" +
                    "1: Cat || 2: Demon || 3: Human");
            String value = input.nextLine();

            if(!value.equals("")) {
                try {
                    switch (Integer.parseInt(value)) {
                        case 1:
                            characterSelection = 1;
                            characterNotSelected = false;
                            break;
                        case 2:
                            characterSelection = 2;
                            characterNotSelected = false;
                            break;
                        case 3:
                            characterSelection = 3;
                            characterNotSelected = false;
                            break;
                        default:
                            System.out.println("Incorrect choice.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect choice..");
                }
            } else
                System.out.println("Incorrect choice...");
        }
        return characterBuilder.generateCharacter(characterSelection);
    }

    /**
     * Provides a list of buff options to choose from.
     */
    private static void purchaseBuffs() {
        System.out.println("\nChoose a buff (10,000 each):\n" +
                "1: Strengthened || 2: Quickened || 3: Fortified || 4: Return");
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        if(!shopValue.equals("")) {
            try {
                if(Integer.parseInt(gameState[14]) < 10000) {
                    System.out.println("You do not have enough gold! :(");
                    enterShop();
                }
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        gameState[6] = "STR+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 10000);
                        break;
                    case 2:
                        gameState[6] = "SPD+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 10000);
                        break;
                    case 3:
                        gameState[6] = "REG+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 10000);
                        break;
                    case 4:
                        enterShop();
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }

    /**
     * Provides a list of potion options to choose from.
     */
    private static void purchasePotions() {
        System.out.println("\nChoose a potion (200 each):\n" +
                "1: Health || 2: Elixir || 3: Love Potion #9 || 4: Return");
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        if(!shopValue.equals("")) {
            try {
                if(Integer.parseInt(gameState[14]) < 200) {
                    System.out.println("You do not have enough gold! :(");
                    enterShop();
                }
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        potions[0]++;
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 200);
                        break;
                    case 2:
                        potions[1]++;
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 200);
                        break;
                    case 3:
                        System.out.println("Butterfly in the sky.");
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 200);
                        break;
                    case 4:
                        enterShop();
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }

    /**
     * Provides a list of scroll options to choose from.
     */
    private static void purchaseScrolls() {
        System.out.println("\nChoose a scroll (100,000 each):\n" +
                "1: Bonus XP || 2: Bonus Accuracy || 3: Bonus Gold || 4: Exit Shop");
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        if(!shopValue.equals("")) {
            try {
                if(Integer.parseInt(gameState[14]) < 100000) {
                    System.out.println("You do not have enough gold! :(");
                    enterShop();
                }
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        gameState[8] = "EXP+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 100000);
                        break;
                    case 2:
                        gameState[8] = "ACC+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 100000);
                        break;
                    case 3:
                        gameState[8] = "GLD+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 100000);
                        break;
                    case 4:
                        enterShop();
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }


    private static void enterShop() {
        System.out.println("\nChoose what to do:\n" +
                "1: Buffs || 2: Potions || 3: Scrolls || 4: Exit Shop");
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        if(!shopValue.equals("")) {
            try {
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        purchaseBuffs();
                        break;
                    case 2:
                        purchasePotions();
                        break;
                    case 3:
                        purchaseScrolls();
                        break;
                    case 4:
                        returnHome();
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }

    /**
     * Returns the player to the origin floor and resets a few values.
     */
    private static void returnHome() {
        //Update Game State
        //Set the level
        playerCharacter.setLevel();
        gameState[2] = String.valueOf(playerCharacter.getLevel());
        //Set current exp
        gameState[3] = String.valueOf(playerCharacter.getExperience());
        //Set Current Health
        playerCharacter.setHealth();
        gameState[4] = String.valueOf(playerCharacter.getHealth());
        //Set Armor stats
        gameState[9] = armorSet[0].getAccuracy() + "|" + armorSet[0].getPenetration();
        gameState[10] = armorSet[1].getAccuracy() + "|" + armorSet[1].getPenetration();
        gameState[11] = armorSet[2].getAccuracy() + "|" + armorSet[2].getPenetration();
        gameState[12] = armorSet[3].getAccuracy() + "|" + armorSet[3].getPenetration();
        gameState[13] = armorSet[4].getAccuracy() + "|" + armorSet[4].getPenetration();

        //Show Character info
        System.out.println(playerCharacter.getImage() + "          Health: "
                + playerCharacter.getHealth());
        System.out.println("Status: " + armorSet[0].getImage() + "\n" +
                "Gold: " + gameState[14] + " || Buff: " + gameState[6]
                + " || Debuff: " + gameState[7]);

        //Get input from the player
        System.out.println("\nChoose what to do:\n" +
                "1: Enter Tower || 2: Enter Shop || 3: Use Item || 4: Exit Game");
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        System.out.println();

        if(!value.equals("")) {
            try {
                switch (Integer.parseInt(value)) {
                    case 1:
                        return;
                    case 2:
                        enterShop();
                        break;
                    case 3:
                        //TODO: use item
                        break;
                    case 4:
                        System.out.println("Thank you for to playing my game");
                        System.exit(0);
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }

    /**
     * General method mediating player interaction with the floor.
     */
    private static void encounterFloor() {
        Floor floor = floorBuilder.generateFloor(gameState);
        System.out.println("#########################################################################\n" +
                           "     Floor: " + gameState[5] + "\n");
        System.out.println("You have encountered an evil creature! \n");

        boolean floorCleared = false;
        while(!floorCleared) {
            //Print the interaction window
            System.out.println("Enemy Health: " + floor.getCharacter().getHealth());
            System.out.println(floor.getCharacter().getEnemyImage());
            System.out.println(playerCharacter.getImage() + "          Health: "
                    + playerCharacter.getHealth());
            System.out.println("Status: " + armorSet[0].getImage() + "\n" +
                    "Gold: " + gameState[14] + " || Buff: " + gameState[6]
                    + " || Debuff: " + gameState[7]);

            //Get input from the player
            System.out.println("\nChoose what to do:\n" +
                    "1: Attack || 2: Run || 3: Use Item");
            Scanner input = new Scanner(System.in);
            String value = input.nextLine();
            System.out.println();

            if(!value.equals("")) {
                try {
                    switch (Integer.parseInt(value)) {
                        case 1:
                            //Calculate player damage to the enemy
                            int playerDamage = playerCharacter.doDamage(gameState);
                            floor.doDamage(playerDamage);
                            if(playerDamage == 0)
                                System.out.println("The evil creature dodges the attack!");
                            else
                                System.out.println("The evil creature takes " + playerDamage + " damage!\n");

                            //Check if the floor is cleared
                            if(floor.getClearedStatus()) {
                                floorCleared = true;
                                //Update the floor Number
                                gameState[5] = String.valueOf(Integer.parseInt(gameState[5])+1);
                                //Update experience
                                gameState[3] = String.valueOf(Integer.parseInt(gameState[3]) + floor.getExperienceGain());
                                playerCharacter.gainExperience(Integer.parseInt(gameState[3]));
                                //Get ze gold
                                gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) + floor.getGoldGain());
                                int rewardChance = floor.clearFloor();
                            } else {
                                //If the enemy is not killed, player takes damage
                                int enemyDamage = floor.getCharacter().doDamage(gameState);
                                playerCharacter.setHealth(-1*enemyDamage);
                                if(enemyDamage == 0)
                                    System.out.println("You dodge the attack!\n\n\n");
                                else
                                    System.out.println("You take " + enemyDamage + " damage!\n\n\n");
                                //If the player died
                                if(playerCharacter.getHealth() <= 0) {
                                    alive = false;
                                    System.out.println("You have died!!!\n" +
                                            "GAME OVER");
                                }
                                //Update the game state
                                gameState[4] = String.valueOf(playerCharacter.getHealth());
                            }
                            break;
                        case 2:
                            returnHome();
                            break;
                        case 3:
                            //nothing atm
                            break;
                        default:
                            System.out.println("Incorrect choice.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect choice..");
                }
            } else
                System.out.println("Incorrect choice...");
        }
    }


    /**
     * main.
     * @param args I'm a pirate
     */
    public static void main(String[] args) {
        //Initialize the game state
        gameState = new String[15];
        gameState[5] = "1";

        //Initialize the builders
        characterBuilder = new CharacterBuilder();
        floorBuilder = new FloorBuilder();
        armorBuilder = new ArmorBuilder();

        //Select character and add it to the game state
        alive = true;
        playerCharacter = selectCharacter();
        gameState[0] = playerCharacter.getCharacterNumber();
        //Set the weapon type
        gameState[1] = playerCharacter.getDamageType();

        //Set Starting gold
        gameState[14] = "0";
        //Set permanent status
        gameState[6] = "none";
        //Set temporary status
        gameState[7] = "none";
        //Set Event
        gameState[8] = null;
        // 0. Health Potion: # remaining
        // 1.  Potion: # remaining
        potions = new int[2];

        //Create the armor set
        //(0) Weapon, (1) Helmet, (2) Chest, (3) Pants, (4) Boots
        armorSet = new Armor[5];
        for(int i = 0; i < armorSet.length; i++)
            armorSet[i] = armorBuilder.generateItem(gameState, i+1);

        //Start at home
        returnHome();

        //The game loop
        while(alive){
            encounterFloor();
        }



        System.out.println(playerCharacter.getImage());
    }
}
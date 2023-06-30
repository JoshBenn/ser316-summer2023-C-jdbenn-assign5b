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
    static Shop shop;
    static DisplayOutput displayOutput;
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
     * Returns the player to the origin floor and resets a few values.
     */
    public static void returnHome() {
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

        displayOutput.generateMainDisplay(gameState, armorSet, playerCharacter);

        //Get input from the player
        System.out.println("\nChoose what to do:\n" +
                "1: Enter Tower || 2: Enter Shop || 3: Use Item || 4: Exit Game");
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        System.out.println();
        while (alive) {
            if (!value.equals("")) {
                try {
                    switch (Integer.parseInt(value)) {
                        case 1:
                            encounterFloor();
                            break;
                        case 2:
                            shop.enterShop(gameState, potions);
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
            displayOutput.generateBattleDisplay(gameState, armorSet, playerCharacter, floor.getCharacter());

            //Get input from the player
            String[] options = {"Attack", "Return Home", "Use Item", "Exit Game"};
            displayOutput.generateOptionsMenu("Choose what to do", options);
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
        displayOutput = new DisplayOutput();
        shop = new Shop();

        //Select character and add it to the game state
        alive = true;
        playerCharacter = selectCharacter();
        gameState[0] = playerCharacter.getCharacterNumber();
        //Set the weapon type
        gameState[1] = playerCharacter.getDamageType();

        //Set Starting gold
        gameState[14] = "0";
        //Set permanent status
        gameState[6] = "None";
        //Set temporary status
        gameState[7] = "None";
        //Set Event
        gameState[8] = null;
        // 0. Health Potion
        // 1. Elixir Potion
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

        }



        System.out.println(playerCharacter.getImage());
    }
}
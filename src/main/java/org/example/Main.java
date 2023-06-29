package org.example;

import java.util.Scanner;

public class Main {
    // 0. Character Type [(1) Cat, (2) Demon, (3) Human]
    // 1. Weapon Type [Magical, Physical, Either]
    // 2. Current Level [Each level requires 100*Current Level experience to level up (lvl 2 requires 100*1 exp)]
    // 3. Current EXP
    // 4. Current Health [Health is 10*current level hp]
    // 5. Current Floor
    // 6. Permanent Status [Strengthened, Quickened, Fortified]
    // 7. Temporary Status [Paralysis, Poisoned, Asleep]
    // 8. Event [Bonus XP, Increased Accuracy, Extra Money]
    // 9. Weapon Stats [Accuracy|Penetration]
    // 10. Helmet Stats [Accuracy|Penetration]
    // 11. Chest Stats [Accuracy|Penetration]
    // 12. Pants Stats [Accuracy|Penetration]
    // 13. Boots Stats [Accuracy|Penetration]
    static String[] gameState;
    static boolean alive;
    static CharacterBuilder character;

    /**
     * Asks the player for an input and creates the character.
     * @return a CharacterBuilder object
     */
    private static CharacterBuilder selectCharacter() {
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
                    switch (Integer.valueOf(value)) {
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
                    System.out.println("Incorrect choice.");
                }
            } else
                System.out.println("Incorrect choice.");
        }
        return new CharacterBuilder(characterSelection);
    }

    private static void encounterFloor() {
        FloorBuilder floor = new FloorBuilder(Integer.valueOf(gameState[5]));

        boolean choiceNotMade = true;
        while(choiceNotMade) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose what to do:\n" +
                    "1: Attack || 2: Return Home || 3: None");
            String value = input.nextLine();

            if(!value.equals("")) {
                try {
                    switch (Integer.valueOf(value)) {
                        case 1:
                            //do damage
                            break;
                        case 2:
                            //return to top floor
                            break;
                        case 3:
                            //nothing atm
                            break;
                        default:
                            System.out.println("Incorrect choice.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect choice.");
                }
            } else
                System.out.println("Incorrect choice.");
        }
    }



    public static void main(String[] args) {
         gameState = new String[14];

        //Select character and add it to the game state
        character = selectCharacter();
        alive = true;
        //Initialize the game state
        gameState[0] = character.getCharacterNumber();
        //Set the weapon type
        gameState[1] = character.getCharacter().getDamageType();
        //Set current level
        gameState[2] = String.valueOf(character.getCharacter().getLevel());
        //Set current exp
        gameState[3] = String.valueOf(character.getCharacter().getExperience());
        //Set Current Health
        gameState[4] = String.valueOf(character.getCharacter().getHealth());
        //Set current floor
        gameState[5] = "1";
        //Set permanent status
        gameState[6] = null;
        //Set temporary status
        gameState[7] = null;
        //Set Event
        gameState[8] = null;
        //Set weapon stats
        gameState[9] = "0|0";
        //Set Helmet stats
        gameState[10] = "0|0";
        //Set Chest stats
        gameState[11] = "0|0";
        //Set Pants stats
        gameState[12] = "0|0";
        //Set Boots stats
        gameState[13] = "0|0";

        //The game loop
        while(alive){
            encounterFloor();
        }



        System.out.println(character.getImage());
    }


}
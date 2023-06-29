package org.example;

import java.util.Scanner;

public class Main {
    // 0. Character Type [(1) Cat, (2) Demon, (3) Human]
    // 1. Weapon Type [Physical or Magical]
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



    public static void main(String[] args) {
         gameState = new String[14];

        //Select character and add it to the game state
        CharacterBuilder character = selectCharacter();
        gameState[0] = character.getCharacterNumber();


        System.out.println(character.getImage());
    }
}
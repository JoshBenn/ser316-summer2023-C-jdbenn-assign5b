package org.rpgMain;

import java.util.Random;

/**
 * General character builder class.
 * Builds a character for the player or the floor.
 */
public class CharacterBuilder {
    private Character tempCharacter;

    /**
     * Generates a random character.
     * @return randomly generated character
     */
    public Character generateCharacter() {
        Random random = new Random();
        return generateCharacter(random.nextInt(3)+1);
    }

    /**
     * Generates the chosen character type.
     * @param selection (1) Cat, (2) Demon, (3) Human
     */
    public Character generateCharacter(int selection) {
        switch(selection) {
            case 1:
                tempCharacter = new Cat();
                break;
            case 2:
                tempCharacter = new Demon();
                break;
            case 3:
                tempCharacter = new Human();
                break;
        }
        return tempCharacter;
    }
}

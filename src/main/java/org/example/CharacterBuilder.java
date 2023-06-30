package org.example;

/**
 * General character builder class.
 * Builds a character for the player or the floor.
 */
public class CharacterBuilder {
    private Character character;

    /**
     * General Constructor for the characterbuilder class.
     * @param selection
     */
    public CharacterBuilder(int selection) {
        switch(selection) {
            case 1:
                character = new Cat();
                break;
            case 2:
                character = new Demon();
                break;
            case 3:
                character = new Human();
                break;
        }
    }

    /**
     * Returns the character created by the characterBuilder.
     * @return Character tempCharacter
     */
    public Character getCharacter() {return this.character;}

}

package org.example;

public class CharacterBuilder {
    private Character character;

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

    public String getCharacterNumber() {
        return character.getCharacterNumber();
    }


    public String getImage() {
        return character.getImage();
    }
}

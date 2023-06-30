package org.rpgMain;

import java.util.Random;

public class ArmorBuilder {
    private Armor tempItem;

    public Armor generateItem(String[] gameState) {
        Random random = new Random();
        return generateItem(gameState, random.nextInt(5) + 1);
    }

    public Armor generateItem(String[] gameState, int itemType) {
        switch(itemType) {
            case 1:
                tempItem = new Weapon(gameState);
                break;
            case 2:
                tempItem = new Helmet(gameState);
                break;
            case 3:
                tempItem = new Chest(gameState);
                break;
            case 4:
                tempItem = new Pants(gameState);
                break;
            case 5:
                tempItem = new Boots(gameState);
                break;
        }
        return tempItem;
    }
}

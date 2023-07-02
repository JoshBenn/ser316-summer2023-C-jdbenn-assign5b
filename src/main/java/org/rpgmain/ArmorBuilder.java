package org.rpgmain;

import java.util.Random;
import org.rpgmain.armor.*;


/**
 * General builder class for armor pieces.
 */
public class ArmorBuilder {
    private Armor tempItem;

    /**
     * Generates a random armor item.
     * @param gameState state of the game
     * @return armor item
     */
    public Armor generateItem(String[] gameState) {
        Random random = new Random();
        return generateItem(gameState, random.nextInt(5) + 1);
    }

    /**
     * Generates a specific armor item.
     * @param gameState state of the game
     * @param itemType item to be generated
     * @return generated item
     */
    public Armor generateItem(String[] gameState, int itemType) {
        switch (itemType) {
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
            default:
                System.out.println("Wrong value");
                break;
        }
        return tempItem;
    }
}

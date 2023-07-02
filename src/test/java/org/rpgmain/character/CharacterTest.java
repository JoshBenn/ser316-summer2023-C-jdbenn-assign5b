package org.rpgmain.character;

import org.junit.Assert;
import org.junit.Test;
import org.rpgmain.ArmorBuilder;
import org.rpgmain.armor.Armor;


public class CharacterTest {
    String[] gameState = {"3", "Either", "1", "0", "10", "1", "None", "None", "None",
        null, null, null, null, null, null};
    ArmorBuilder armorBuilder = new ArmorBuilder();
    Armor[] armorSet = new Armor[5];

    /**
     * Tests the damage calculation for cats.
     */
    @Test
    public void catDoDamageTest() {
        Character testCat = new Cat();
        for (int i = 0; i < armorSet.length; i++) {
            armorSet[i] = armorBuilder.generateItem(gameState, i + 1);
            gameState[i + 9] = armorSet[i].getAccuracy() + ":" + armorSet[i].getPenetration();
        }

        Assert.assertEquals(8, testCat.doDamage(gameState));
    }

    /**
     * Tests the damage calculation for demons.
     */
    @Test
    public void demonDoDamageTest() {
        Character testDemon = new Demon();
        for (int i = 0; i < armorSet.length; i++) {
            armorSet[i] = armorBuilder.generateItem(gameState, i + 1);
            gameState[i + 9] = armorSet[i].getAccuracy() + ":" + armorSet[i].getPenetration();
        }

        Assert.assertEquals(8, testDemon.doDamage(gameState));
    }

    /**
     * Tests the damage calculation for humans.
     */
    @Test
    public void humanDoDamageTest() {
        Character testHuman = new Human();
        for (int i = 0; i < armorSet.length; i++) {
            armorSet[i] = armorBuilder.generateItem(gameState, i + 1);
            gameState[i + 9] = armorSet[i].getAccuracy() + ":" + armorSet[i].getPenetration();
        }

        Assert.assertEquals(5, testHuman.doDamage(gameState));
    }
}

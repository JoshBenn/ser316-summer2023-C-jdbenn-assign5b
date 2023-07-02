package org.rpgmain;

import org.junit.Assert;
import org.junit.Test;
import org.rpgmain.armor.Armor;

/**
 * Tests armorBuilder and the subsequent armor classes.
 */
public class ArmorBuilderTest {
    // create a fake gameState to work with -- Human class at level 1
    String[] gameState = {"3", "Either", "1", "0", "10", "1", "None", "None", "None",
            null, null, null, null, null, null};

    /**
     * Test random Armor generation.
     */
    @Test
    public void testRandomArmorGeneration() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState);
        Assert.assertTrue(
                testArmor.getArmorType().equals("Weapon")
                        || testArmor.getArmorType().equals("Helmet")
                        || testArmor.getArmorType().equals("Chest Piece")
                        || testArmor.getArmorType().equals("Pair of Pants")
                        || testArmor.getArmorType().equals("Pair of Boots"));
    }

    /**
     * Test specific Armor generation -- Weapon.
     */
    @Test
    public void testWeaponGeneration() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 1);
        Assert.assertEquals("Weapon", testArmor.getArmorType());
    }

    /**
     * Test specific Armor generation -- Helmet.
     */
    @Test
    public void testHelmetGeneration() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 2);
        Assert.assertEquals("Helmet", testArmor.getArmorType());
    }

    /**
     * Test specific Armor generation -- Chest.
     */
    @Test
    public void testChestGeneration() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 3);
        Assert.assertEquals("Chest Piece", testArmor.getArmorType());
    }

    /**
     * Test specific armor generation -- Pants.
     */
    @Test
    public void testPantsGeneration() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 4);
        Assert.assertEquals("Pair of Pants", testArmor.getArmorType());
    }

    /**
     * Test specific armor generation -- boots.
     */
    @Test
    public void testBootsGeneration() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 5);
        Assert.assertEquals("Pair of Boots", testArmor.getArmorType());
    }

    /**
     * Tests the lower bounds of armor generation.
     */
    @Test
    public void testLowerBounds() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 0);
        Assert.assertNull(testArmor);
    }

    /**
     * Tests the upper bounds of armor generation.
     */
    @Test
    public void testUpperBounds() {
        ArmorBuilder armorBuilder = new ArmorBuilder();
        Armor testArmor = armorBuilder.generateItem(gameState, 6);
        Assert.assertNull(testArmor);
    }
}

package org.rpgmain.floor;

import org.junit.Assert;
import org.junit.Test;
import org.rpgmain.character.Character;

public class FloorTest {
    /**
     * Test the damage to normal floor mobs.
     */
    @Test
    public void testNormalDoDamage() {
        Floor testNormalFloor = new NormalFloor(1);
        int damage = 1;
        testNormalFloor.doDamage(damage);
        Assert.assertEquals(2 - damage, testNormalFloor.getCharacter().getHealth());
    }

    /**
     * Test the damage to medium floor mobs.
     */
    @Test
    public void testMediumDoDamage() {
        Floor testMediumFloor = new MediumFloor(5);
        int damage = 1;
        testMediumFloor.doDamage(damage);
        Assert.assertEquals((2 * 5 * 2) - damage, testMediumFloor.getCharacter().getHealth());
    }

    /**
     * Test the damage to boss floor mobs.
     */
    @Test
    public void testBossDoDamage() {
        Floor testBossFloor = new BossFloor(10);
        int damage = 1;
        testBossFloor.doDamage(damage);
        Assert.assertEquals((3 * 10 * 2) - damage, testBossFloor.getCharacter().getHealth());
    }

    /**
     * Test the cleared status for normal floor after mob killed.
     */
    @Test
    public void testNormalClearedStatus() {
        Floor testNormalFloor = new NormalFloor(1);
        testNormalFloor.doDamage(100);
        Assert.assertTrue(testNormalFloor.getClearedStatus());
    }

    /**
     * Test the cleared status for medium floor after mob killed.
     */
    @Test
    public void testMediumClearedStatus() {
        Floor testMediumFloor = new MediumFloor(5);
        testMediumFloor.doDamage(100);
        Assert.assertTrue(testMediumFloor.getClearedStatus());
    }

    /**
     * Test the cleared status for boss floor after mob killed.
     */
    @Test
    public void testBossClearedStatus() {
        Floor testBossFloor = new BossFloor(10);
        testBossFloor.doDamage(100);
        Assert.assertTrue(testBossFloor.getClearedStatus());
    }

    /**
     * Test the experience return after clearing a normal floor.
     */
    @Test
    public void testNormalGetExperienceGain() {
        Floor testNormalFloor = new NormalFloor(1);
        testNormalFloor.doDamage(100);
        int experience = 10;
        Assert.assertEquals(experience, testNormalFloor.getExperienceGain());
    }

    /**
     * Test the experience return after clearing a medium floor.
     */
    @Test
    public void testMediumGetExperienceGain() {
        Floor testMediumFloor = new MediumFloor(5);
        testMediumFloor.doDamage(100);
        int experience = 5 * 10 * 2;
        Assert.assertEquals(experience, testMediumFloor.getExperienceGain());
    }

    /**
     * Test the experience return after clearing a boss floor.
     */
    @Test
    public void testBossGetExperienceGain() {
        Floor testBossFloor = new BossFloor(10);
        testBossFloor.doDamage(100);
        int experience = 10 * 10 * 3;
        Assert.assertEquals(experience, testBossFloor.getExperienceGain());
    }

    /**
     * Test the gold return after clearing a normal floor.
     */
    @Test
    public void testNormalGetGoldGain() {
        Floor testNormalFloor = new NormalFloor(1);
        testNormalFloor.doDamage(100);
        int gold = 100;
        Assert.assertEquals(gold, testNormalFloor.getGoldGain());
    }

    /**
     * Test the gold return after clearing a medium floor.
     */
    @Test
    public void testMediumGetGoldGain() {
        Floor testMediumFloor = new MediumFloor(5);
        testMediumFloor.doDamage(100);
        int gold = 5 * 100 * 2;
        Assert.assertEquals(gold, testMediumFloor.getGoldGain());
    }

    /**
     * Test the gold return after clearing a boss floor.
     */
    @Test
    public void testBossGetGoldGain() {
        Floor testBossFloor = new BossFloor(10);
        testBossFloor.doDamage(100);
        int gold = 10 * 100 * 3;
        Assert.assertEquals(gold, testBossFloor.getGoldGain());
    }
}

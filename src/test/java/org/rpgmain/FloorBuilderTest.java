package org.rpgmain;

import org.junit.Assert;
import org.junit.Test;
import org.rpgmain.floor.Floor;

/**
 * Test floorBuilder and the subsequent floor classes being generated.
 */
public class FloorBuilderTest {
    // create a fake gameState to work with -- Human class at level 1
    String[] gameState = {"3", "Either", "1", "0", "10", "1", "None", "None", "None",
        null, null, null, null, null, null};

    /**
     * Test normal floor generation.
     */
    @Test
    public void testNormalFloorGeneration() {
        gameState[5] = "1";
        FloorBuilder floorBuilder = new FloorBuilder();
        Floor testFloor = floorBuilder.generateFloor(gameState);
        Assert.assertTrue(testFloor.getFloorType() == 1
                            && (
                            testFloor.getCharacter().getCharacterNumber().equals("1")
                            || testFloor.getCharacter().getCharacterNumber().equals("2")
                            || testFloor.getCharacter().getCharacterNumber().equals("3")));
    }

    /**
     * Test medium floor generation.
     */
    @Test
    public void testMediumFloorGeneration() {
        gameState[5] = "5";
        FloorBuilder floorBuilder = new FloorBuilder();
        Floor testFloor = floorBuilder.generateFloor(gameState);
        Assert.assertTrue(testFloor.getFloorType() == 2
                && (
                testFloor.getCharacter().getCharacterNumber().equals("1")
                || testFloor.getCharacter().getCharacterNumber().equals("2")
                || testFloor.getCharacter().getCharacterNumber().equals("3")));
    }

    /**
     * Test boss floor generation.
     */
    @Test
    public void testBossFloorGeneration() {
        gameState[5] = "10";
        FloorBuilder floorBuilder = new FloorBuilder();
        Floor testFloor = floorBuilder.generateFloor(gameState);
        Assert.assertTrue(testFloor.getFloorType() == 3
                && (
                testFloor.getCharacter().getCharacterNumber().equals("1")
                || testFloor.getCharacter().getCharacterNumber().equals("2")
                || testFloor.getCharacter().getCharacterNumber().equals("3")));
    }
}

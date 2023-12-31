package org.rpgmain;

import org.rpgmain.floor.*;

/**
 * General class to build a floor object.
 */
public class FloorBuilder {
    private Floor tempFloor;
    //Small = 1, Medium = 2, Boss = 3

    /**
     * Generates a new floor type based on the floorNumber.
     * @param gameState the state of the game
     */
    public Floor generateFloor(String[] gameState) {
        int floorNumber = Integer.parseInt(gameState[5]);
        if (floorNumber % 10 == 0)
            tempFloor = new BossFloor(floorNumber);
        else if (floorNumber % 5 == 0)
            tempFloor = new MediumFloor(floorNumber);
        else
            tempFloor = new NormalFloor(floorNumber);
        return tempFloor;
    }
}

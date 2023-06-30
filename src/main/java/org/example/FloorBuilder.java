package org.example;

/**
 * General class to build a floor object.
 */
public class FloorBuilder {
    private final Floor floor;
    //Small = 1, Medium = 2, Boss = 3

    /**
     * General constructor
     * @param floorNumber requires the current floor number
     */
    public FloorBuilder(int floorNumber) {
        if(floorNumber%10 == 0)
            floor = new BossFloor(floorNumber);
        else if(floorNumber%5 == 0)
            floor = new MediumFloor(floorNumber);
        else
            floor = new NormalFloor(floorNumber);
    }

    /**
     * Gets the floor object created by this class.
     * @return floor object
     */
    public Floor getFloor() { return this.floor; }
}

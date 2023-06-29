package org.example;

import java.util.Random;

public class FloorBuilder {
    private Floor floor;
    //Small = 1, Medium = 2, Boss = 3

    public FloorBuilder(int floorNumber) {
        if(floorNumber%10 == 0)
            floor = new BossFloor(floorNumber);
        else if(floorNumber%5 == 0)
            floor = new MediumFloor(floorNumber);
        else
            floor = new NormalFloor(floorNumber);
    }

    public Floor getFloor() {return this.floor;}
}

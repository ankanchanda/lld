package lld.StrategyDesignPattern.WithStrategyPattern;

import lld.StrategyDesignPattern.WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
    
    private DriveStrategy driveStrategyObj;

    // this is known as constructor injection
    Vehicle(DriveStrategy driveStrategyObj){
        this.driveStrategyObj = driveStrategyObj;
    }

    public void drive(){
        this.driveStrategyObj.drive();
    }
}

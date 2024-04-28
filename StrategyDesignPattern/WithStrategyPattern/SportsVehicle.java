package lld.StrategyDesignPattern.WithStrategyPattern;

import lld.StrategyDesignPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    
    SportsVehicle(){
        super( new SportsDriveStrategy());
    }
    
}

package lld.StrategyDesignPattern.WithStrategyPattern;

import lld.StrategyDesignPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    
    OffRoadVehicle(){
        super( new SportsDriveStrategy());
    }
}

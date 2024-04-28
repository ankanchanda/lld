package lld.StrategyDesignPattern.WithStrategyPattern;

import lld.StrategyDesignPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{
    
    PassengerVehicle(){
        super( new NormalDriveStrategy());
    }
}

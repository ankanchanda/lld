package lld.StrategyDesignPattern.WithStrategyPattern;

import lld.StrategyDesignPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    
    GoodsVehicle(){
        super( new NormalDriveStrategy());
    }
}

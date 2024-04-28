package lld.StrategyDesignPattern.WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{
    
    @Override
    public void drive() {
        // different drive logic
        System.out.println("sports drive capability");
    }
}

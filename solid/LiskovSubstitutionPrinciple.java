package lld.solid;

interface Bike {
    void turnOnEngine();
    void accelerate();    
}

// extends the capability of Bike - follows LiskovSubstitutionPrinciple
class MotorCycle implements Bike{

    boolean isEngineOn = false;
    int speed = 0;

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        speed += 10;
    }
    
}

// limits the capability of Bike by throwing error for turnOnEngine - doesn't follow Liskov Substitution Principle
class Cycle implements Bike{

    @Override
    public void turnOnEngine() {
        throw new AssertionError("Cycle has no engine");
    }

    @Override
    public void accelerate() {
        // do something
    }

}

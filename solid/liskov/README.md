## Liskov Substitution Principle

If you have a parent class and a child class, you should be able to substitute the object without breaking the code

- Parent
    - Child1
    - Child2
    - Child3

Let's say I have a parent obj as `Parent parentObj = new Child1()` which is working fine, now if I replace with `new Child2()` this program shouldn't break

Refer to: 
- <a href="Vehicle.java">Vehicle.java</a> (parent class)
    - <a href="MotorCycle.java">MotorCycle.java</a> (child1)
    - <a href="Car.java">Car.java</a> (child2)
    - <a href="Bicycle.java">Bicycle.java</a> (child3)
        - limits the capability of Vehicle(parent class) since hasEngine is overrirde and returns null.

How to solve?
- in the parent class put only the generic method which are common for all
    - in the Vehicle class the generic method is `getNumberOfWheels()` so it will be the only method there
    - take out specific one `hasEngine()`
- create another class `EngineVehicle` which extends Vehicle and has certain method which are specific to this.
- now you can extend EngineVehicle through MotorCycle and Car and override the methods to change the definition
- and Cycle can extend Vehicle Class which has the method and need not to be worried for method which aren't useful to this.

Refer to Solution:

- <a href="solution/Vechicle.java">Vehicle.java</a>
    - <a href="solution/EngineVehicle.java">EngineVehicle.java</a>
        - <a href="solution/MotorCycle.java">MotorCycle.java</a>
        - <a href="solution/Car.java">Car.java</a>
    - <a href="solution/Bicycle.java">Bicycle.java</a>
package lld.DecoratorDesignPattern;

public class Mushroom extends ToppingDecorator{

    BasePizza pizza;

    Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 15;
    }
    
}

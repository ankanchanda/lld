package lld.solid;

interface RestaurantEmployee {
    void washDishes();
    void serveCustomer();
    void cookFood();
}

// doesn't follow Interface Segmented Principle
class Waiter implements RestaurantEmployee{

    @Override
    public void washDishes() {
        //not my job
    }

    @Override
    public void serveCustomer() {
        System.out.println("serving the customer");
    }

    @Override
    public void cookFood() {
        // not my job
    }
    
}

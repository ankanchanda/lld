package lld.solid;

interface WaiterInterface {
    void serveCustomer();
    void takeOrder();
}

interface ChefInterface {
    void cookFood();
    void decideMenu();
}

class Waiter implements WaiterInterface{

    @Override
    public void serveCustomer() {
        System.out.println("Serving the customer");
    }

    @Override
    public void takeOrder() {
        System.out.println("taking the ordder");
    }
    
}

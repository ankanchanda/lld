package lld.ObserverDesignPattern.Observer;

import lld.ObserverDesignPattern.Observable.StocksObservable;

public class MobileAlertObserver implements NotificationAlertObserver{

    String username;
    StocksObservable stocksObservableObject;

    public MobileAlertObserver(String username, StocksObservable stocksObservableObject){

        this.stocksObservableObject = stocksObservableObject;
        this.username = username;
    }

	@Override
	public void update() {

        sendMessageOnMobile(username, "product is in stock, hurry up!");
	}

    private void sendMessageOnMobile(String username, String msg){

        System.out.println("Message sent to: " + username);
        // send the message to end user
    }
    
}

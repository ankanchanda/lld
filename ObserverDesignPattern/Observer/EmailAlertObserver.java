package lld.ObserverDesignPattern.Observer;

import lld.ObserverDesignPattern.Observable.StocksObservable;

public class EmailAlertObserver implements NotificationAlertObserver {

    String emailId;
    StocksObservable stocksObservableObj;

    public EmailAlertObserver(String emailId, StocksObservable stocksObservableObj){
        this.emailId = emailId;
        this.stocksObservableObj = stocksObservableObj;
    }

	@Override
	public void update() {
		sendMail(emailId, "Product in stock, hurry up!");
	}

    private void sendMail(String emailId, String message){
        System.out.println("Email sent to: " + emailId);
        // send the actual email to end user
    }
    
}

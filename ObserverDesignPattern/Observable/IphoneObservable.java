package lld.ObserverDesignPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import lld.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class IphoneObservable implements StocksObservable{

    public List<NotificationAlertObserver> observerList;
    public int stockCount;

    public IphoneObservable(){
        observerList = new ArrayList<>();
        stockCount = 0;
    }

	@Override
	public void add(NotificationAlertObserver observer) {
		observerList.add(observer);
	}

	@Override
	public void remove(NotificationAlertObserver observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifySubscribers() {
		for(NotificationAlertObserver observer: observerList){
            observer.update();
        }
	}

	@Override
	public void setStockCount(int newStockAdded) {
        if(stockCount == 0){
            notifySubscribers();
        }
        stockCount += newStockAdded;
	}

	@Override
	public int getStockCount() {
		return stockCount;
	}
    
}

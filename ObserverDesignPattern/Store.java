package lld.ObserverDesignPattern;

import lld.ObserverDesignPattern.Observable.IphoneObservable;
import lld.ObserverDesignPattern.Observable.StocksObservable;
import lld.ObserverDesignPattern.Observer.EmailAlertObserver;
import lld.ObserverDesignPattern.Observer.MobileAlertObserver;
import lld.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        
        StocksObservable iphoneStocksObservable = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailAlertObserver("xyz1@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserver("xyz2@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserver("xyz_username", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        iphoneStocksObservable.setStockCount(10);
        iphoneStocksObservable.setStockCount(100);
    }
}

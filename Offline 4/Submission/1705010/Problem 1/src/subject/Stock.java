package subject;

import observer.Observer;

import java.io.IOException;
import java.util.ArrayList;

public class Stock implements Subject {

    private ArrayList observers;

    private String name;
    private int count;
    private float price;

    public Stock(String name,int count,float price)
    {
        this.name = name;
        this.count = count;
        this.price = price;
        this.observers = new ArrayList<Observer>();
    }

    public String getName() {
        return name;
    }

    public void increasePrice(float amount) {
        this.price += amount;
    }

    public void decreasePrice(float amount) {
        this.price -= amount;
    }

    public void changeCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int idx = observers.indexOf(o);

        if(idx>=0)
        {
            observers.remove(idx);
        }
    }

    @Override
    public void notifyObservers(String text) {
        for(int i=0;i<observers.size();i++)
        {
            Observer observer = (Observer)observers.get(i);

            try {
                observer.update(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class  Observable {

    private List<Observer> observers;

    protected Observable() {
        this.observers = new ArrayList<>();

    }

    public void registerObserver(Observer observer) {
        Objects.requireNonNull(observer,"Observer absent");
        observers.add(observer);
    }


    public void notifyObservers(Object arg) {
        for(Observer obs :observers){
            obs.update(this,arg);
        }

    }
}

package Observable_Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Observable.
 */
public abstract class Observable {

    private final List<Observer> observers;


    /**
     * Instantiates a new Observable.
     */
    protected Observable(){
        this.observers=new ArrayList<>();
    }

    /**
     * Register observer.
     *
     * @param observer the observer
     */
    public void registerObserver(Observer observer){
        Objects.requireNonNull(observer,"Observer absent");
        observers.add(observer);

    }


    /**
     * Notify observers.
     *
     * @param arg the arg
     */
    public void notifyObservers(Object arg){
        for(Observer obs :observers){
            obs.update(this,arg);
            //System.out.println("updated");
        }


    }



}

package com.demo.travelcardsystem.entity;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
     List<Observer<TravelCard>> observerCollection = new ArrayList<>();
     void notifyAllObservers();
     void registerObserver(Observer<TravelCard> observer);
}

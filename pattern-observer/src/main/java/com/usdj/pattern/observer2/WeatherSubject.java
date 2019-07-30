package com.usdj.pattern.observer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:46
 * @Description:
 */
public abstract class WeatherSubject {

	public List<Observer> observers = new ArrayList<>();

	public void attache(Observer observer){
		observers.add(observer);
	}

	public void detach(Observer observer){
		observers.remove(observer);
	}

	protected abstract void notifyObservers();
}

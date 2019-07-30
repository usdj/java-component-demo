package com.usdj.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gerrydeng
 * @date 2019-07-30 14:16
 * @Description: 目标对象，它知道观察它的观察者，并提供注册和删除观察者的接口
 */
public class WeatherSubject {

	/**
	 * 保存注册的观察者对象
	 */
	private List<Observer> observers = new ArrayList<>();

	public void attach(Observer observer){
		observers.add(observer);
	}

	public void detach(Observer observer){
		observers.remove(observer);
	}

	/**
	 * 通知所有注册的观察者对象
	 */
	protected void notifyObservers(String content){
//		observers.forEach(observer -> {
//			observer.update(this);
//		});
		// 推模型
		observers.forEach(observer -> {
			observer.update(content);
		});
	}
}

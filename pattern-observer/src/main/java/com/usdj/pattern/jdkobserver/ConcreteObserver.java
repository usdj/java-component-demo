package com.usdj.pattern.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:32
 * @Description:
 */
public class ConcreteObserver implements Observer {

	private String observerName;

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(observerName + "收到推过来的" + arg);
		System.out.println(observerName + "收到消息，主动去目标中拉，拉到：" + ((ConcreteWeatherSubject)o).getContent());
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
}

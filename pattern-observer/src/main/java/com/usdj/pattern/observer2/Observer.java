package com.usdj.pattern.observer2;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:49
 * @Description:
 */
public interface Observer {

	void update(WeatherSubject weatherSubject);

	void setObserverName(String observerName);

	String getObserverName();
}

package com.usdj.pattern.observer2;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:57
 * @Description:
 */
public class ConcreteObserver implements Observer {

	private String observerName;

	private String weatherContent;

	private String remindThing;
	@Override
	public void update(WeatherSubject weatherSubject) {
		weatherContent = ((ConcreteWeatherSubject)weatherSubject).getWeatherContent();
		System.out.println(observerName + "收到" + weatherContent + "," + remindThing);
	}

	@Override
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public String getObserverName() {
		return observerName;
	}

	public String getWeatherContent() {

		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
}

package com.usdj.pattern.observer2;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:51
 * @Description:
 */
public class ConcreteWeatherSubject extends WeatherSubject {

	private String weatherContent;

	@Override
	protected void notifyObservers() {
		for (Observer observer : observers){
			if ("下雨".equals(this.getWeatherContent())){
				if ("Girl".equals(observer.getObserverName())){
					observer.update(this);
				}
				if ("Mum".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
			if ("下雪".equals(this.getWeatherContent())){
				if ("Mum".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
		}

	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}
}

package com.usdj.pattern.observer;

/**
 * @author gerrydeng
 * @date 2019-07-30 14:17
 * @Description: 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 */
public class ConcreteWeatherSubject extends WeatherSubject {

	private String weatherContent;


	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		// 拉模型
//		this.notifyObservers();
		// 推模型
		this.notifyObservers(weatherContent);
	}
}

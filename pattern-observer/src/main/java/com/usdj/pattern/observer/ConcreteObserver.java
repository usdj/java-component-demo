package com.usdj.pattern.observer;

/**
 * @author gerrydeng
 * @date 2019-07-30 14:20
 * @Description: 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 */
public class ConcreteObserver implements Observer {

	/**
	 * 观察者的状态
	 */
	private String observerName;

	/**
	 * 天气内容，从目标处获取
	 */
	private String weatherContent;

	/**
	 * 提醒的内容：A约会，B购物
	 */
	private String remindThing;


	/**
	 * 获取目标类的状态同步到观察者的状态中
	 * 拉模型
	 * @param weatherSubject
	 */

	@Override
	public void update(WeatherSubject weatherSubject) {
		weatherContent = ((ConcreteWeatherSubject) weatherSubject).getWeatherContent();
		System.out.println(observerName + "收到" + weatherContent + "," + remindThing);
	}

	/**
	 * 推模型
	 * @param content
	 */
	@Override
	public void update(String content) {
		weatherContent = content;
		System.out.println(observerName + "收到" + weatherContent + "," + remindThing);

	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
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

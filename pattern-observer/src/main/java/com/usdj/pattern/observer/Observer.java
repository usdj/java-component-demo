package com.usdj.pattern.observer;

/**
 * @author gerrydeng
 * @date 2019-07-30 14:18
 * @Description: 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {
	/**
	 * 更新接口,传入目标对象，方便获取相应的目标对象的状态
	 * @param weatherSubject
	 */
	void update(WeatherSubject weatherSubject);

	void update(String content);
}

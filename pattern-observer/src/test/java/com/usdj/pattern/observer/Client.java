package com.usdj.pattern.observer;

/**
 * @author gerrydeng
 * @date 2019-07-30 14:44
 * @Description:
 */
public class Client {

	public static void main(String[] args) {
		// 1.创建目标
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();

		// 2.创建观察者
		ConcreteObserver concreteObserverA = new ConcreteObserver();
		concreteObserverA.setObserverName("DemoA");
		concreteObserverA.setRemindThing("Dating");

		ConcreteObserver concreteObserverB = new ConcreteObserver();
		concreteObserverB.setObserverName("DemoB");
		concreteObserverB.setRemindThing("Shopping");

		// 3.注册观察者
		weather.attach(concreteObserverA);
		weather.attach(concreteObserverB);

		// 4.目标发布天气
		weather.setWeatherContent("明天天气晴朗");
	}
}

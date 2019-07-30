package com.usdj.pattern.observer2;

/**
 * @author gerrydeng
 * @date 2019-07-30 16:02
 * @Description: 下雨时才通知girl,下雨和下雪都通知Mum
 */
public class Client {

	public static void main(String[] args) {
		ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("Girl");
		observerGirl.setRemindThing("Dating");
		ConcreteObserver observerMum = new ConcreteObserver();
		observerMum.setObserverName("Mum");
		observerMum.setRemindThing("Shopping");
		weatherSubject.attache(observerGirl);
		weatherSubject.attache(observerMum);
		weatherSubject.setWeatherContent("下雪");
	}
}

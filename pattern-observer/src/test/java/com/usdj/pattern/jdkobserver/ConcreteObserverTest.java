package com.usdj.pattern.jdkobserver;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:35
 * @Description:
 */
public class ConcreteObserverTest {
	public static void main(String[] args) {
		ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
		ConcreteObserver girl = new ConcreteObserver();
		girl.setObserverName("Girl");
		ConcreteObserver mum = new ConcreteObserver();
		mum.setObserverName("Mum");
		subject.addObserver(girl);
		subject.addObserver(mum);

		subject.setContent("好天气");
	}

}
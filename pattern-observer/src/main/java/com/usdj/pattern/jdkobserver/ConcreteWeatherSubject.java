package com.usdj.pattern.jdkobserver;

import java.util.Observable;

/**
 * @author gerrydeng
 * @date 2019-07-30 15:29
 * @Description: 天气目标的实现类
 */
public class ConcreteWeatherSubject extends Observable {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		// 注意通知之前，Observer模式要先setChanged()
		this.setChanged();
		// 主动通知，推方式
		this.notifyObservers(content);
		// 拉方式
//		this.notifyObservers();
	}
}

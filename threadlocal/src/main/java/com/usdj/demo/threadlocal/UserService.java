package com.usdj.demo.threadlocal;

/**
 * @Author gerrydeng
 * @Date 2020/2/10 9:16 PM
 * @Version 0.1
 * @Description: user service
 */
public class UserService {

	/**
	 * 当前线程添加用户信息后并获取显示
	 */
	public void addUser() {
		System.out.println(Thread.currentThread().getName() + "添加了用户信息" + UserUtils.get());
	}
}

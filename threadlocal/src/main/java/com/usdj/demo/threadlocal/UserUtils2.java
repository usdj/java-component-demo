package com.usdj.demo.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Author gerrydeng
 * @Date 2020/2/10 9:13 PM
 * @Version 0.1
 * @Description: ThreadLocal get set用户信息,使用阿里TTL
 */
public class UserUtils2 {

	private static final TransmittableThreadLocal<User> context = new TransmittableThreadLocal<>();

	/**
	 * 保存用户信息
	 * @param user
	 */
	public static void set(User user) {
		context.set(user);
	}

	/**
	 * 获取当前线程中用户信息
	 * @return user
	 */
	public static User get() {
		return context.get();
	}
}

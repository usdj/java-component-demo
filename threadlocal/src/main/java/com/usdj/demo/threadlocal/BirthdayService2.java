package com.usdj.demo.threadlocal;

import com.alibaba.ttl.TtlRunnable;

import java.time.LocalDate;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author gerrydeng
 * @Date 2020/2/10 9:16 PM
 * @Version 0.1
 * @Description: 测试类,使用阿里TTL
 */
public class BirthdayService2 {

	/**
	 * 原子类，作为用户ID
	 */
	private static final AtomicInteger creator = new AtomicInteger(1);

	/**
	 * 测试用户数据
	 */
	private static final LocalDate[] birthdays = {
			LocalDate.of(1991,1,1),
			LocalDate.of(1992,1,2),
			LocalDate.of(1993,1,3),
			LocalDate.of(1994,1,4),
			LocalDate.of(1995,1,5),
			LocalDate.of(1996,1,6),
			LocalDate.of(1997,1,7),
			LocalDate.of(1998,1,8),
			LocalDate.of(1999,1,9),
			LocalDate.of(2000,1,10)
	};

	/**
	 * 数据长度
	 */
	private static final int birthdayLength = birthdays.length;

	/**
	 * 初始构造用户
	 * @param name
	 * @return
	 */
	private static User initUser(String name){
		User user = new User();
		user.setUserId(creator.getAndIncrement());
		user.setName(name);
		user.setBirthday(birthdays[user.getUserId() % birthdayLength]);
		return user;
	}


	/**
	 * 声明一个简单线程池，20个线程
	 */
	private static final AtomicInteger threadIdCreator = new AtomicInteger(1);
	private static ExecutorService pool = Executors.newFixedThreadPool(20, (runnable) ->
			new Thread(runnable, "pool-" + threadIdCreator.getAndIncrement())
	);

	/**
	 * 启用线程池模拟添加并获取当前线程的用户信息
	 * @param args
	 */
	public static void main(String[] args) {
		UserService2 userService = new UserService2();
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				UserUtils2.set(initUser(Thread.currentThread().getName()));
				//使用线程池进行调用
				pool.execute(TtlRunnable.get(userService::addUser));
			}, "callService-" + i).start();
		}
	}

}

package com.usdj.currency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gerrydeng
 * @date 2019-07-29 20:13
 * @Description: 展示lock的方法
 */
public class LockExample15 {



	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.lock();
		lock.unlock();
		lock.tryLock();
//		lock.tryLock(10, TimeUnit.SECONDS);
	}
}

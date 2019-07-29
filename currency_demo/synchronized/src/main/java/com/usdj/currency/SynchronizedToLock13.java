package com.usdj.currency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gerrydeng
 * @date 2019-07-29 19:55
 * @Description:
 */
public class SynchronizedToLock13 {
	Lock lock = new ReentrantLock();

	public synchronized void method1(){
		System.out.println("Synchronized形式的锁");
	}

	public void method2(){
		lock.lock();
		try {
			System.out.println("lock形式的锁");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) {
		SynchronizedToLock13 synchronizedToLock13 =
				new SynchronizedToLock13();
		synchronizedToLock13.method1();
		synchronizedToLock13.method2();
	}
}

package com.usdj.currency;

/**
 * @author gerrydeng
 * @date 2019-07-29 16:46
 * @Description: 同时访问一个类的不同的普通同步方法
 */
public class SynchronizedDifferentMethod7 implements Runnable {
	static SynchronizedDifferentMethod7 instance = new SynchronizedDifferentMethod7();

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1")){
			method1();
		} else {
			method2();
		}
	}

	public synchronized void method1(){
		System.out.println("同步方法1：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "同步方法1运行结束");
	}

	public synchronized void method2(){
		System.out.println("同步方法2：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "同步方法2运行结束");
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(instance,"t1");
		Thread t2 = new Thread(instance,"t2");
		t1.start();
		t2.start();

	}
}

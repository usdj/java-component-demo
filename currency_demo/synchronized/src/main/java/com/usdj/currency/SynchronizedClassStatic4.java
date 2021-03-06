package com.usdj.currency;

/**
 * @author gerrydeng
 * @date 2019-07-29 16:16
 * @Description:
 */
public class SynchronizedClassStatic4 implements Runnable{

	static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
	static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

	@Override
	public void run() {
		method();
	}

	public static synchronized void method(){
		System.out.println("类锁第一种形式：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(instance1);
		Thread t2 = new Thread(instance2);
		t1.start();
		t2.start();
		while (t1.isAlive() || t2.isAlive()) {

		}
		System.out.println("Done");
	}
}

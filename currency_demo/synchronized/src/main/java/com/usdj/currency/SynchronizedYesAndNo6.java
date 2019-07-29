package com.usdj.currency;

/**
 * @author gerrydeng
 * @date 2019-07-29 16:38
 * @Description: 同时访问同步和非同步方法
 */
public class SynchronizedYesAndNo6 implements Runnable{
	static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();
	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1")){
			method1();
		} else {
			method2();
		}
	}

	public synchronized void method1(){
		System.out.println("同步方法：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "同步方法运行结束");
	}

	public void method2(){
		System.out.println("非同步方法：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "非同步方法运行结束");
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(instance,"t1");
		Thread t2 = new Thread(instance,"t2");
		t1.start();
		t2.start();

	}
}

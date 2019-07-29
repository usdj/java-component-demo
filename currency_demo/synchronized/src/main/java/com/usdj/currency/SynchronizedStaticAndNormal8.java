package com.usdj.currency;

/**
 * @author gerrydeng
 * @date 2019-07-29 16:51
 * @Description:
 */
public class SynchronizedStaticAndNormal8 implements Runnable{

	static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1")){
			method1();
		} else {
			method2();
		}
	}

	public synchronized static void method1(){
		System.out.println("静态同步方法1：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "静态同步方法1运行结束");
	}

	public synchronized void method2(){
		System.out.println("非静态同步方法2：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "非静态同步方法2运行结束");
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(instance,"t1");
		Thread t2 = new Thread(instance,"t2");
		t1.start();
		t2.start();

	}
}

package com.usdj.currency;

/**
 * @author gerrydeng
 * @date 2019-07-29 15:49
 * @Description: 对象锁实例1，代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{

	static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		while (t1.isAlive() || t2.isAlive()){

		}
		System.out.println("Done");
	}

	Object lock1 = new Object();
	Object lock2 = new Object();

	@Override
	public void run() {
//		synchronized (this){
		synchronized (lock1){
			System.out.println("我是Lock1，名称：" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "Lock1运行结束");
		}

		synchronized (lock2){
			System.out.println("我是Lock2，名称：" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "Lock2运行结束");
		}

	}
}

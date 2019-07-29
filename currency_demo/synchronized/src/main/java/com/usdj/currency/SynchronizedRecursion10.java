package com.usdj.currency;

/**
 * @author gerrydeng
 * @date 2019-07-29 19:40
 * @Description: 可重入粒度测试，递归调用本方法
 */
public class SynchronizedRecursion10 {
	int a = 0;

	public static void main(String[] args) {
		SynchronizedRecursion10 synchronizedRecursion10 =
				new SynchronizedRecursion10();
		synchronizedRecursion10.method1();
	}

	/**
	 * 验证同一方法的可重入性
	 */
	private synchronized void method1() {
		System.out.println("method1, a = " + a);
		if (a == 0){
			a++;
			method1();
		}
	}
}

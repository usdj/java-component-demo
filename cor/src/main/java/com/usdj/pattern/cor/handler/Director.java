package com.usdj.pattern.cor.handler;

/**
 * @author gerrydeng
 * @date 2019-07-30 13:29
 * @Description:
 */
public class Director extends PriceHandler {
	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.4){
			System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discount);
		} else {
			successor.processDiscount(discount);
		}
	}
}

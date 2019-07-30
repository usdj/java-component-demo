package com.usdj.pattern.cor;

import com.usdj.pattern.cor.handler.PriceHandler;
import com.usdj.pattern.cor.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * @author gerrydeng
 * @date 2019-07-30 13:32
 * @Description:
 */
public class Customer {

	private PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.setPriceHandler());
		Random random = new Random();
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + ":");
			customer.requestDiscount(random.nextFloat());
		}
	}
}

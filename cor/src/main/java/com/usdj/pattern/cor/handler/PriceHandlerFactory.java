package com.usdj.pattern.cor.handler;

/**
 * @author gerrydeng
 * @date 2019-07-30 13:44
 * @Description:
 */
public class PriceHandlerFactory {
	public static PriceHandler setPriceHandler() {
		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler man = new Manager();
		PriceHandler dir = new Director();
		PriceHandler vp = new VicePresident();
		PriceHandler ceo = new CEO();

		sales.setSuccessor(lead);
		lead.setSuccessor(man);
		man.setSuccessor(dir);
		dir.setSuccessor(vp);
		vp.setSuccessor(ceo);
		return sales;
	}
}

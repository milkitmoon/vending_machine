package com.milkit.app.vending.machine.display.impl;

import java.util.List;
import java.util.Map;

import com.milkit.app.vending.machine.VandingMachine;
import com.milkit.app.vending.machine.currency.Currency;
import com.milkit.app.vending.machine.currency.CurrencyEnum;
import com.milkit.app.vending.machine.currency.CurrencyFeeder;
import com.milkit.app.vending.machine.display.AbstractDisplayImpl;
import com.milkit.app.vending.machine.product.Product;
import com.milkit.app.vending.machine.product.ProductManager;

public class ADisplayImpl extends AbstractDisplayImpl {

	@Override
	public String showMain(VandingMachine vandingMachine) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("###########################################################\n");
		builder.append("# 투입 가능 통화 입니다.\n");
		builder.append("# 아래 금액단위로만 금액을 투입할 수 있습니다.\n");
		builder.append("###########################################################\n");
		builder.append("# 동전 : ").append(getCurrencyListStr(vandingMachine.getCoinFeeder())).append("\n");
		builder.append("# 지폐 : ").append(getCurrencyListStr(vandingMachine.getBillFeeder())).append("\n");
		builder.append("###########################################################\n");
		builder.append("# 판매 상품목록입니다. (").append(getProductListRangeStr(vandingMachine.getProductManager())).append(") 중 선택해 주세요\n");
		builder.append("###########################################################\n");
		builder.append(getProductListStr(vandingMachine.getProductManager(), vandingMachine.getCurrAmount()));
		builder.append("###########################################################\n");
		builder.append("# 사용방법\n");
		builder.append("###########################################################\n");
		builder.append("# 금액을 투입하시려면 금액을 다음과 같이 숫자로 입력해 주세요. (").append(getSimpleCurrencyListStr(vandingMachine)).append(")\n");
		builder.append("# 상품을 구매하시려면 다음의 상품코드를 입력하시면 됩니다. (").append(getProductListRangeStr(vandingMachine.getProductManager())).append(")\n");
		builder.append("# 구매가 완료되셨으면 'y'를 눌러주세요 (y)\n");
		builder.append("# 구매를 취소하시려면 'c'를 눌러주세요 (c)\n");
		builder.append("# 프로그램을 종료하시려면 'x'를 눌러주세요 (x)\n");
		builder.append("###########################################################\n");
		builder.append("# 구매하신 상품 : ").append(getPurchaseProductStr(vandingMachine.getProductManager())).append("\n");
		builder.append("# 현재 남은금액 : ").append(CurrencyEnum.WON.getMark()).append(String.format("%,d", vandingMachine.getCurrAmount())).append("\n\n");
		builder.append("원하시는 값을 입력해 주세요 : ");
		
		return builder.toString();
	}



	@Override
	public String showCancel() {
		return "구매를 취소하셨습니다. 투입금액 및 구매상품을 초기화 합니다.\n\n\n";
	}
	
	@Override
	public String showTerminate() {
		return "프로그램을 종료합니다. ^^v\n\n";
	}


	@Override
	public String showInvalidCurrencyException() {
		return "지원하지 않는 통화입니다. 다른 통화를 투입해 주세요 !!";
	}

	@Override
	public String showPutCurrency(int currency) {
		return CurrencyEnum.WON.getMark()+currency+" 이 투입되었습니다.";
	}


	@Override
	protected String getPossibleBuyStr() {
		return "구입가능";
	}
	@Override
	protected String getOverdrawingStr() {
		return "잔액부족";
	}

	@Override
	public String showInvalidProductException() {
		return "판매하지 않는 상품입니다. 다른 상품코드를 입력해 주세요 !!";
	}

	@Override
	public String showOverdrawingException() {
		return "상품을 구매하기 위한 잔액이 부족합니다. 금액을 더 투입해 주세요 !!";
	}

	@Override
	public String showPutProduct(String productNM) {
		return productNM+" 상품을 구매하였습니다.";
	}

	@Override
	public String showComplete(ProductManager productManager, int currAmount) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n###########################################################\n");
		builder.append("# 감사합니다. 구매를 완료하셨습니다 !\n");
		builder.append("###########################################################\n");
		builder.append("# 구매하신 상품 : ").append(getPurchaseProductStr(productManager)).append("\n");
		builder.append("# 거스름돈 금액 : ").append(CurrencyEnum.WON.getMark()).append(String.format("%,d", currAmount)).append("\n");
		builder.append("###########################################################\n\n");

		return builder.toString();
	}

}

package com.designpattern.strategy;

public class StretegyClient {
public static void main(String[] args) {
	ShopingCard card=new ShopingCard();
	Product product1=new Product("laptop","234qwe",40000);
	Product product2=new Product("iphone","234qqe",70000);
	Product product3=new Product("friz","0089we",25000);
	card.addPruduct(product1);
	card.addPruduct(product2);
	card.addPruduct(product3);
	card.payment(new CreditCardPaymentMethod(123,"234asd","vinita deo",04-04-2024));
}
}

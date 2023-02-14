package com.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShopingCard {
private List<Product> productList;

public ShopingCard() {
	super();
	productList=new ArrayList<>();
}

public List<Product> getProductList() {
	return productList;
}

public void setProductList(List<Product> productList) {
	this.productList = productList;
}
public void addPruduct(Product product) {
	productList.add(product);
	
}
public void removePruduct(Product product) {
	productList.remove(product);
	
}
public int countTotalPrice() {
	return productList.stream().map(p->p.getPrice()).reduce(0, Integer::sum);
}
public void payment(PaymentMethod paymentMethod) {
	paymentMethod.pay(countTotalPrice());//strategy design 
}
}

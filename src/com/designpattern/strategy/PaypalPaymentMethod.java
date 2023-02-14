package com.designpattern.strategy;

public class PaypalPaymentMethod implements PaymentMethod {
private String email;
private String password;

	public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

	public PaypalPaymentMethod(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount+"pay using paypal method");
	}

}

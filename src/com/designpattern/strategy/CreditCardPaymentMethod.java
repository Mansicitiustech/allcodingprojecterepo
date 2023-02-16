package com.designpattern.strategy;

import java.util.Date;

public class CreditCardPaymentMethod implements PaymentMethod{
private int cardNo;
private String cuv;
private String cardHolderName;
private int dateOfExpired;


	public CreditCardPaymentMethod(int cardNo, String cuv, String cardHolderName, int dateOfExpired) {
	super();
	this.cardNo = cardNo;
	this.cuv = cuv;
	this.cardHolderName = cardHolderName;
	this.dateOfExpired = dateOfExpired;
}


	public int getCardNo() {
		return cardNo;
	}


	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}


	public String getCuv() {
		return cuv;
	}


	public void setCuv(String cuv) {
		this.cuv = cuv;
	}


	public String getCardHolderName() {
		return cardHolderName;
	}


	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	

	public int getDateOfExpired() {
		return dateOfExpired;
	}


	public void setDateOfExpired(int dateOfExpired) {
		this.dateOfExpired = dateOfExpired;
	}


	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount+"pay using credit card");
	}

}

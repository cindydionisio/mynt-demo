package com.example.delivery.response;

public class Cost {
	private Double price;
	private String usedVoucher;
	private Double discountedPrice;
	private boolean isReject = true;
	
	public void setPrice(Double price) { this.price = price; }
	public Double getPrice() { return this.price; }
	
	public void setUsedVoucher(String voucher) { this.usedVoucher = voucher; }
	public String getUsedVoucer() { return this.usedVoucher; }
	
	public void setDiscountedPrice(Double price) { this.discountedPrice = price; }
	public Double getDiscountedPrice() { return this.discountedPrice; }
	
	public void setIsReject(boolean isReject) { this.isReject = isReject;}
	public boolean getIsReject() { return this.isReject; }
	
}

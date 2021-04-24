package com.example.delivery.voucher.response;

import java.util.Date;

public class VoucherDiscount {
	private String code;
	private Double discount;
	private Date expiry;
	
	public void setCode(String code) { this.code = code; }
	public String getCode() { return this.code; }
	
	public void setDiscount(Double discount) { this.discount = discount; }
	public Double getDiscount() { return this.discount; }
	
	public void setExpiry(Date expiry) { this.expiry = expiry; }
	public Date getExpiry() {return this.expiry; }
}

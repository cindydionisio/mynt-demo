package com.example.delivery.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class ApplicationProperties {

	@Value("${app.priority_1.multiplicand}")
	private Float priority1Multiplicand;
	
	@Value("${app.priority_2.multiplicand}")
	private Float priority2Multiplicand;
	
	@Value("${app.priority_3.multiplicand}")
	private Float priority3Multiplicand;
	
	@Value("${app.priority_4.multiplicand}")
	private Float priority4Multiplicand;
	
	@Value("${app.priority_5.multiplicand}")
	private Float priority5Multiplicand;
	
	@Value("${app.voucher_url}")
	private String voucherUrl;
	
	@Value("${app.voucher_apikey}")
	private String voucherApiKey;
	
	public Float getPriority1Multiplicand() { return this.priority1Multiplicand; }
	
	public Float getPriority2Multiplicand() { return this.priority2Multiplicand; }
	
	public Float getPriority3Multiplicand() { return this.priority3Multiplicand; }
	
	public Float getPriority4Multiplicand() { return this.priority4Multiplicand; }
	
	public Float getPriority5Multiplicand() { return this.priority5Multiplicand; }
	
	public String getVoucherUrl() { return this.voucherUrl; }
	
	public String getVoucherApiKey() { return this.voucherApiKey; }

}

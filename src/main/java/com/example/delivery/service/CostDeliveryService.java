package com.example.delivery.service;


import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.example.delivery.request.ParcelDelivery;
import com.example.delivery.response.Cost;
import com.example.delivery.voucher.response.VoucherDiscount;

public interface CostDeliveryService {
	
	public Cost getCost(ParcelDelivery parcelDelivery);
	
	public default Double getVolume(ParcelDelivery parcelDelivery) {
		if(parcelDelivery.getHeight() != null && parcelDelivery.getWidth() !=null && parcelDelivery.getLength() != null) {
			return parcelDelivery.getHeight() * parcelDelivery.getWidth() * parcelDelivery.getLength();
		}
		return null;
	}
	
	public default Double getDiscount(String url, String apiKey, String voucher) {
		if(voucher != null && voucher.length() > 0 ) {
			RestTemplate restTemplate = new RestTemplate();

			String requestUrl = url + voucher +"?key=" + apiKey;
			
			try {
				VoucherDiscount vdiscount = restTemplate.getForObject(requestUrl, VoucherDiscount.class);
				
				/*make sure the voucher is not Expired*/
				if(vdiscount != null && !vdiscount.getExpiry().before(new Date())) {
					return vdiscount.getDiscount();
				}
			}
			catch(Exception ex) {
				/*url returns invalid*/
				System.out.println("Invalid code: " + voucher);
			}
			
		}
		return 0D;
	}
	
}

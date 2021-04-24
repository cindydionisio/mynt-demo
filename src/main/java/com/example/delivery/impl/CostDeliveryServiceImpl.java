package com.example.delivery.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.delivery.properties.ApplicationProperties;
import com.example.delivery.request.ParcelDelivery;
import com.example.delivery.response.Cost;
import com.example.delivery.service.CostDeliveryService;
import com.example.delivery.util.ApplicationUtil;

@Service
public class CostDeliveryServiceImpl implements CostDeliveryService{
	@Autowired
	ApplicationProperties applicationProperties;

	@Override
	public Cost getCost(ParcelDelivery parcelDelivery) {
		Double volume = this.getVolume(parcelDelivery);
		Double weight = parcelDelivery.getWeight();
		
		Cost cost = new Cost();
		cost.setUsedVoucher(parcelDelivery.getVoucher());

		if(weight != null) {
			
			/*Priority 1*/
			if(weight > 50) {
				cost.setPrice(applicationProperties.getPriority1Multiplicand() * weight);
			}
			
			/*Priority 2*/
			else if(weight > 10) {
				cost.setPrice(applicationProperties.getPriority2Multiplicand() * weight);
			}
			
			else {
				if(volume != null) {
					/*Priority 3*/
					if(volume < 1500) {
						cost.setPrice(applicationProperties.getPriority3Multiplicand() * volume);
					}
					
					/*Priority 4*/
					else if(volume < 2500) {
						cost.setPrice(applicationProperties.getPriority4Multiplicand() * volume);
					}
					
					/*Priority 4*/
					else {
						cost.setPrice(applicationProperties.getPriority5Multiplicand() * volume);
					}
				}
			}
		}
		
		if(cost.getPrice() != null) {
			Double rawDiscount = this.getDiscount(applicationProperties.getVoucherUrl(), applicationProperties.getVoucherApiKey(), parcelDelivery.getVoucher());
			Double discountedPrice = cost.getPrice() - rawDiscount;
			
			cost.setDiscountedPrice(ApplicationUtil.roundValue(discountedPrice, 2));
			cost.setIsReject(false);
		}
		return cost;
		
	}
	
}

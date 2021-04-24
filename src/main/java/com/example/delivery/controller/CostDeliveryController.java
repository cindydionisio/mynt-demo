package com.example.delivery.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.request.ParcelDelivery;
import com.example.delivery.response.Cost;
import com.example.delivery.service.CostDeliveryService;


@RestController
@RequestMapping(value = "/cost-delivery")
public class CostDeliveryController {
	@Autowired
	CostDeliveryService costDeliveryService;
	
	/**
	 * @param ParcelDelivery 
	 * @return Cost
	 */
	@GetMapping("/parcel")
	public ResponseEntity<Object> computeCost(HttpServletRequest  httprequest,ParcelDelivery parcelDelivery) {
		Cost cost = costDeliveryService.getCost(parcelDelivery);
		if(cost != null) {
			return new ResponseEntity<>(cost, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}

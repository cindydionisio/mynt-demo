package com.example.delivery.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*Use this generic class so we can re-use*/
public class ApplicationUtil {
	
	private ApplicationUtil() {}
	
	public static Double roundValue(Double value, int places) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
	}
}

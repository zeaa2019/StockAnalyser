/**
 * This class converts a USD value to a given currency
 * @author zainab abdulsalam
 *
 */
package project;

import java.util.HashMap;

public class CurrencyConvertor {
/**
 * 
 * @param currencyTo the currency that the value will be converted to
 * @param value the USD value that will be converted to a given currency
 * @return conversionResult the result of the conversion performed
 */
	public float convert(String currencyTo, Float value) {
		
		HashMap<String, Double> currencyRates = new HashMap<String, Double>();
						
		 currencyRates.put("JPY: Japanese yen",	0.00928592);		
		 currencyRates.put("GBP: Pound sterling", 1.24256);		
		 currencyRates.put("CHF: Swiss franc", 1.04900);	
		 currencyRates.put("AUD: Australian dollar", 0.614480);
		 currencyRates.put("CAD: Canadian dollar", 0.711451);
		 currencyRates.put("CNY: Chinese yuan renminbi", 0.140832);	
		 currencyRates.put("EUR: Euros", 1.11054);
		 currencyRates.put("HKD: Hong Kong dollar", 0.128992);
		 currencyRates.put("INR: Indian rupee", 0.0132491);
		 currencyRates.put("NZD: New Zealand dollar", 0.601218);
		 currencyRates.put("ZAR: South African rand", 0.0558539);
		 currencyRates.put("AED: Dirhams", 	0.272294);
		 
		 Float conversionResult = null;
		 
		 conversionResult = Float.valueOf((float) (value / currencyRates.get(currencyTo)));
		 conversionResult = (float) (Math.round(conversionResult* 100.0) / 100.0);
		 
		 return conversionResult;
	}
}

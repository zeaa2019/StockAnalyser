/**
 * This class imports all the stock data used in the Stock Analyser using the Intrinio API
 * @author zainab abdulsalam
 *
 */
package project;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.threeten.bp.LocalDate;

import com.intrinio.api.SecurityApi;
import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.ApiKeyAuth;
import com.intrinio.models.ApiResponseSecurityStockPrices;
import com.intrinio.models.RealtimeStockPrice;

public class Importer {

/**
 * @param identifierCode a unique tag given to each stock
 * @param start the start date of the period which you would like to get data in
 * @param end the end date of the period which you would like to get data in
 * @return stockPrices a list of close stock prices
 */
  public ArrayList<Float> getStockClosePrice(String identifierCode, LocalDate start, LocalDate end) {
	  
	    ApiClient defaultClient = Configuration.getDefaultApiClient();
	    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
	    auth.setApiKey("OjNhNzM0YWI1NjE3ZGE3MWQxZmQ5YTE2NzNkZmQ3OWI0");

	    SecurityApi securityApi = new SecurityApi();
	    Float stockPrice = null;
	    ArrayList<Float> stockPrices = new ArrayList<Float>();
	    String frequency = null; // String | Return stock prices in the given frequency
	    Integer pageSize = 100; // Integer | The number of results to return
	    String nextPage = null; // String | Gets the next page of data from a previous API call

	    try {
	      ApiResponseSecurityStockPrices result = securityApi.getSecurityStockPrices(identifierCode, start, end, frequency, pageSize, nextPage);
	      for (int i = 0; i <= result.getStockPrices().size() - 1; i++) {
	      stockPrice = result.getStockPrices().get(i).getAdjClose().floatValue();
	      stockPrices.add(stockPrice);
	      }
	    } catch (ApiException e) {
	      System.err.println("Exception when calling SecurityApi#getSecurityStockPrices");
	      e.printStackTrace();
	    }
	    return stockPrices;
	    
}
  /**
   * 
   * @param identifier a unique tag given to each stock
   * @return stockPrice a realtime stock price
   */
  
  public String getRealTimePrice(String identifier) {
	  
	    ApiClient defaultClient = Configuration.getDefaultApiClient();
	    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
	    auth.setApiKey("OjNhNzM0YWI1NjE3ZGE3MWQxZmQ5YTE2NzNkZmQ3OWI0");

	    SecurityApi securityApi = new SecurityApi();
	    Float realTimePrice = null;
	    String stockPrice = null;

	    String source = null; // String | Return the realtime price from the specified data source. If no source is specified, the best source available is used.

	    try {
	      RealtimeStockPrice result = securityApi.getSecurityRealtimePrice(identifier, source);     
	      realTimePrice = result.getLastPrice().floatValue();
	      NumberFormat formatter = NumberFormat.getCurrencyInstance();
			double result2 = realTimePrice;
			stockPrice = String.valueOf(formatter.format(result2));
	      
	    } catch (ApiException e) {
	      System.err.println("Exception when calling SecurityApi#getSecurityRealtimePrice");
	      e.printStackTrace();
	    }
	    	return stockPrice;
	  }
  /**
   * @param identifier a unique tag given to each stock
   * @return pToERatio the price to earning ratio of a stock
   */
  
  public String getPtoERatio(String identifier) {
	  String pToERatio = null;
	  
	    ApiClient defaultClient = Configuration.getDefaultApiClient();
	    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
	    auth.setApiKey("OjNhNzM0YWI1NjE3ZGE3MWQxZmQ5YTE2NzNkZmQ3OWI0");

	    SecurityApi securityApi = new SecurityApi();
	    String tag = "pricetoearnings"; 

	    try {
	      NumberFormat formatter = NumberFormat.getCurrencyInstance();
	      BigDecimal result = securityApi.getSecurityDataPointNumber(identifier, tag);
	      float result2 = (float) (Math.round(result.floatValue() * 100.0) / 100.0);
	      double result3 = result2;
		  pToERatio = String.valueOf(formatter.format(result3));	 
	    } catch (ApiException e) {
	      System.err.println("Exception when calling SecurityApi#getSecurityDataPointNumber");
	      e.printStackTrace();
	    }
  
	  return pToERatio;
  }
  /**
   * 
   * @param identifier a unique tag given to each stock
   * @return currency the currency that is used to trade a certain stock
   */
  
  public String getCurrency(String identifier) {
	  
	    String currency = null;
	  
	    ApiClient defaultClient = Configuration.getDefaultApiClient();
	    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
	    auth.setApiKey("OjNhNzM0YWI1NjE3ZGE3MWQxZmQ5YTE2NzNkZmQ3OWI0");

	    SecurityApi securityApi = new SecurityApi();
	    String tag = "security_currency"; 
	    try {
	      String result = securityApi.getSecurityDataPointText(identifier, tag);
	      System.out.println(result);
	    } catch (ApiException e) {
	      System.err.println("Exception when calling SecurityApi#getSecurityDataPointText");
	      e.printStackTrace();
	    }
	  
	  return currency;
  }
	  
 }

/**
 * This class gets days that the stock market is open and performs a moving average algorithm
 * @author zainab abdulsalam
 *
 */
package project;

import org.threeten.bp.LocalDate;
import java.text.NumberFormat;
import java.util.*;

public class MovingAverage {
	
/**
 * 
 * @param numberOfDays defines the time period to check if any weekends fall in it
 * @return listOfDates dates that don't include weekends
 */
	public ArrayList<LocalDate> getDate(int numberOfDays) {
		ArrayList<LocalDate> listOfDates = new ArrayList<LocalDate>();
		LocalDate todaysDate = LocalDate.now();
		
		for (int i = 0; i <= numberOfDays + 1; i++) {
			
		if (todaysDate.getDayOfWeek().name() == "SUNDAY") {
			todaysDate = todaysDate.minusDays(2);
			
		}	
		else if (todaysDate.getDayOfWeek().name() == "SATURDAY") {
			
			todaysDate = todaysDate.minusDays(1);
		}
			listOfDates.add(todaysDate);
			todaysDate = todaysDate.minusDays(1);
		}
		return listOfDates;
	}

/**
 * 
 * @param stockName name of stock to get the prices of
 * @return stockPrices list of stock prices of a given stock
 */
	public ArrayList<Float> getStockPrices (String stockName) {
		ArrayList<Float> stockPrices = new ArrayList<Float>();
		ArrayList<LocalDate> listOfDates = getDate(5);
	    Importer importer = new Importer(); 		
		stockPrices = importer.getStockClosePrice(stockName, listOfDates.get(4), listOfDates.get(0));
		
		return stockPrices;
	}

/**
 * 
 * @param listOfStockPrices list of stock prices for the algorithm to be performed on
 * @return predictedStockPrice 
 */
	public String performAlgorithm (ArrayList<Float> listOfStockPrices) {
		float result = 0;
		float totalOfStockPrices = 0;
		
		for (int i = 0; i <= listOfStockPrices.size() - 1; i ++) {	
			totalOfStockPrices += listOfStockPrices.get(i);
		}	
		result = totalOfStockPrices / 5;
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		double result2 = result;
	    String predictedStockPrice = String.valueOf(formatter.format(result2));

		return predictedStockPrice;
	}
}

/**
 * This class gets stock prices over a period of time to reveal trends
 * @author zainab abdulsalam
 *
 */
package project;

import java.util.ArrayList;
import org.threeten.bp.LocalDate;

public class ViewTrends {
/**
 * 
 * @param userStockChoice name of stock to get the stock prices of
 * @param userTimePeriodChoice time period for stock price trends
 * @return
 */
	public ArrayList<Float> getStockPrices(String userStockChoice, String userTimePeriodChoice) {
		
		ArrayList<Float> listOfStockPrices = new ArrayList<Float>();
		ArrayList<LocalDate> listOfDates = new ArrayList<LocalDate>();
		Importer importer = new Importer();
		MovingAverage movingAverage = new MovingAverage();
		String stockName = userStockChoice;
		String timePeriod = userTimePeriodChoice;
		
		if (timePeriod == "5 days") {
			
			listOfDates = movingAverage.getDate(5);
			listOfStockPrices = importer.getStockClosePrice(stockName, listOfDates.get(4), listOfDates.get(0));				
		}	

		else if (timePeriod == "2 weeks") {
			
			listOfDates = movingAverage.getDate(14);
			listOfStockPrices = importer.getStockClosePrice(stockName, listOfDates.get(13), listOfDates.get(0));		
		}
		
		else if (timePeriod == "1 month") {
			listOfDates = movingAverage.getDate(30);
			listOfStockPrices = importer.getStockClosePrice(stockName, listOfDates.get(29), listOfDates.get(0));				
		}
		
		else if (timePeriod == "3 months") {
			listOfDates = movingAverage.getDate(90);
			listOfStockPrices = importer.getStockClosePrice(stockName, listOfDates.get(89), listOfDates.get(0));	
		}
		return listOfStockPrices;
	}
	

	
}

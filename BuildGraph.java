/**
 * This class builds a line chart that shows the stock price trends of a stock over a period of time
 * @author zainab abdulsalam
 *
 */
package project;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.threeten.bp.LocalDate;

import java.util.*;
import javax.swing.JFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings({ "serial", "unused" })
public class BuildGraph extends JFrame {

/**
 * 
 * @param stockName the prices represented in the line chart belong to this stock
 * @param timePeriod the period that the trends in the line chart will represent
 */
public BuildGraph(String stockName, String timePeriod) {
	  MovingAverage movingAverage = new MovingAverage();
	  ViewTrends viewTrends = new ViewTrends();
	  
      ArrayList<Float> listOfStockPrices = new ArrayList<Float>();  
	  ArrayList<LocalDate> listOfDates = new ArrayList<LocalDate>();
 
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
     
      if (timePeriod == "5 days") {
	      listOfDates = movingAverage.getDate(5);
		  listOfStockPrices = viewTrends.getStockPrices(stockName, timePeriod);	
		  System.out.println(listOfStockPrices);
	      for (int i = 0; i <= listOfStockPrices.size() - 1; i++) {
	      dataset.addValue(listOfStockPrices.get(i), stockName, String.valueOf(listOfDates.get(i).getDayOfMonth()) + "/" + String.valueOf(listOfDates.get(i).getMonthValue()));
	      }
      }
      
      else if (timePeriod == "2 weeks") {
	      listOfDates = movingAverage.getDate(14);
		  listOfStockPrices = viewTrends.getStockPrices(stockName, timePeriod);	
		  System.out.println(listOfDates.size());
		  System.out.println(listOfStockPrices.size());
	      for (int i = 0; i <= listOfStockPrices.size() - 1; i++) {
	      dataset.addValue(listOfStockPrices.get(i), stockName, String.valueOf(listOfDates.get(i).getDayOfMonth()) + "/" + String.valueOf(listOfDates.get(i).getMonthValue()));
	      }
      }
      
      else if (timePeriod == "1 month") {
	      listOfDates = movingAverage.getDate(30);
		  listOfStockPrices = viewTrends.getStockPrices(stockName, timePeriod);	
		  System.out.println(listOfDates.size());
		  System.out.println(listOfStockPrices.size());
	      for (int i = 0; i <= listOfStockPrices.size() - 1; i++) {
	    	  if (i % 6 == 0) {
	    		  dataset.addValue(listOfStockPrices.get(i), stockName, String.valueOf(listOfDates.get(i).getDayOfMonth()) + "/" + String.valueOf(listOfDates.get(i).getMonthValue()));
	    	  }
	    }
      }
      
      else if (timePeriod == "3 months") {
	      listOfDates = movingAverage.getDate(90);
		  listOfStockPrices = viewTrends.getStockPrices(stockName, timePeriod);	
	      for (int i = 0; i <= listOfStockPrices.size() - 1; i++) {
	    	  if(i % 10 == 0) {
	    		  dataset.addValue(listOfStockPrices.get(i), stockName, String.valueOf(listOfDates.get(i).getDayOfMonth()) + "/" + String.valueOf(listOfDates.get(i).getMonthValue()));
	    	  }
	     }
      }
      
      JFreeChart lineChart = ChartFactory.createLineChart(
         "Stock Trends",
         "Dates - " + timePeriod,"Stock Price, USD",
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
      
      ChartPanel chartPanel = new ChartPanel(lineChart);
      setContentPane(chartPanel);
   }

}

/**
 * This class builds a comparison bar chart that shows the realtime stock prices of three stocks in the chart
 * @author zainab abdulsalam
 *
 */
package project;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import javax.swing.JFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class BuildComparisonGraph extends JFrame {
	
/**
 * 
 * @param stock1 name of the 1st stock that is included in the bar chart
 * @param stock2 name of the 2nd stock that is included in the bar chart
 * @param stock3 name of the 3rd stock that is included in the bar chart
 */
   public BuildComparisonGraph(String stock1, String stock2, String stock3) {
 
      Importer importer = new Importer();
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      
      String stock1_new = importer.getRealTimePrice(stock1).substring(importer.getRealTimePrice(stock1).indexOf("£") + 1);
      String stock2_new = importer.getRealTimePrice(stock2).substring(importer.getRealTimePrice(stock2).indexOf("£") + 1);
      String stock3_new = importer.getRealTimePrice(stock3).substring(importer.getRealTimePrice(stock3).indexOf("£") + 1);
      
      dataset.addValue(Float.valueOf(stock1_new), stock1, stock1);
      dataset.addValue(Float.valueOf(stock2_new), stock2, stock2);
      dataset.addValue(Float.valueOf(stock3_new), stock3, stock3);
      
      JFreeChart barChart = ChartFactory.createStackedBarChart(
         "Stock Price Comparison",
         "Stock Prices","Stock Price, USD",
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel(barChart);
      setContentPane(chartPanel);
      chartPanel.setSize(getMaximumSize());
   }
}

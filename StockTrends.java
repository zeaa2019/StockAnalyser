package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.ui.RefineryUtilities;

import javafx.stage.Stage;
import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "serial", "unused" })
public class StockTrends extends JFrame {

	private JPanel contentPane;
	private String timePeriod;
	private String selectedStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockTrends frame = new StockTrends();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StockTrends() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String title = "View Stock Price Trends";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
		
		Choice choice = new Choice();
		
		Choice choice_1 = new Choice();
		
		choice_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				timePeriod = choice_1.getSelectedItem();	
				 }
			 });
		
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {					
				selectedStock = choice.getSelectedItem();
				selectedStock = selectedStock.substring(0, selectedStock.indexOf(":"));			
				}
			});
		
		choice_1.add("5 days");
		choice_1.add("2 weeks");
		choice_1.add("1 month");
		choice_1.add("3 months");

		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPage mainPage = new MainPage();
				mainPage.setVisible(true);
				mainPage.setTitle("Stock Analyser");
				dispose();
			}
		});
		button.putClientProperty("JComponent.sizeVariant", "mini");
		button.putClientProperty("JComponent.sizeVariant", "small");
		button.putClientProperty("JComponent.sizeVariant", "large");
		
		JButton button_1 = new JButton("Build Graph");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(selectedStock == null) {
					selectedStock = "AAPL";
				}
				
				if(timePeriod == null) {
					timePeriod = "5 days";
				}
				ArrayList<Float> listOfPrices = new ArrayList<Float>();
				BuildGraph buildGraph = new BuildGraph(selectedStock, timePeriod);
				buildGraph.setVisible(true);
				buildGraph.setTitle("Stock Price Trends");
				buildGraph.pack();
				RefineryUtilities.centerFrameOnScreen(buildGraph);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Select a stock and time range you would like to view the prices for");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(choice_1, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addGap(74)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addGap(16))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(272))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(choice_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(choice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(48)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(51)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
		
		choice.add("AAPL: Apple");
		choice.add("AXP: American Express");
		choice.add("BA: Boeing Co");
		choice.add("CAT: Caterpillar");
		choice.add("CSCO: Cisco Systems");
		choice.add("CVX: Chevron");
		choice.add("GE: General Electric Company");
		choice.add("GS: Goldman Sachs");
		choice.add("HD: Home Depot");
		choice.add("IBM: IBM Common");
		choice.add("INTC: Intel Corporation");
		choice.add("JNJ: Johnson & Johnson");
		choice.add("JPM: JPMorgan Chase & Co");
		choice.add("KO: Coca-Cola Co");
		choice.add("MCD: Mcdonalds Corp");
		choice.add("MMM: 3M Co");
		choice.add("MRK: Merk & Co");
		choice.add("MSFT: Microsoft");
		choice.add("NKE: Nike");
		choice.add("PFE: Pfizer Inc");
		choice.add("PG: Procter Gamble");
		choice.add("TRV: Travelers Companies");
		choice.add("UNH: UnitedHealth Group");
		choice.add("UTX: United Technologies Corp");
		choice.add("V: Visa Inc");
		choice.add("VZ: Verizon Communications");  
		choice.add("WMT: Walmart");
		choice.add("XOM: Exxon Mobil Corporation");
	}
}

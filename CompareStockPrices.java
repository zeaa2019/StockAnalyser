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

import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings({ "serial", "unused" })
public class CompareStockPrices extends JFrame {

	private JPanel contentPane;
	private String stock1;
	private String stock2;
	private String stock3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompareStockPrices frame = new CompareStockPrices();
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
	public CompareStockPrices() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		String title = "Compare Stock Prices";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
		
		ArrayList<String> listOfStocks = new ArrayList<String>();
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainPage mainPage = new MainPage();
				mainPage.setVisible(true);
				mainPage.setTitle("Stock Analyser");
				dispose();
			}
		});
		
		Choice choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				stock1 = choice.getSelectedItem();	
				stock1 = stock1.substring(0, stock1.indexOf(":"));
				
				 }
			 });
		 
		Choice choice_1 = new Choice();
		choice_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				stock2 = choice_1.getSelectedItem();
				stock2 = stock2.substring(0, stock2.indexOf(":"));
				
				 }
			 });
		
		Choice choice_2 = new Choice();
		choice_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				stock3 = choice_2.getSelectedItem();
				stock3 = stock3.substring(0, stock3.indexOf(":"));
				
				 }
			 });
		JLabel lblNewLabel = new JLabel("");
		
		JButton button_1 = new JButton("Build Graph");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("");
				
				if(stock1 == null) {
					stock1 = "AAPL";
				}
				if(stock2 == null) {
					stock2 = "AXP";
				}
				if(stock3 == null) {
					stock3 = "BA";
				}
				
				if (stock1.equals(stock2) || stock1.equals(stock3) || stock2.equals(stock3)) {
					lblNewLabel.setText("Select 3 different stocks");
				}
				else {
					BuildComparisonGraph buildComparisonGraph = new BuildComparisonGraph(stock1, stock2, stock3);
					buildComparisonGraph.setVisible(true);
					buildComparisonGraph.setTitle("Stock Price Comparison Graph");
					buildComparisonGraph.pack();
					RefineryUtilities.centerFrameOnScreen(buildComparisonGraph);
				}
			}
		});
		
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
		
		
		choice_1.add("AXP: American Express");
		choice_1.add("AAPL: Apple");
		choice_1.add("BA: Boeing Co");
		choice_1.add("CAT: Caterpillar");
		choice_1.add("CSCO: Cisco Systems");
		choice_1.add("CVX: Chevron");
		choice_1.add("GE: General Electric Company");
		choice_1.add("GS: Goldman Sachs");
		choice_1.add("HD: Home Depot");
		choice_1.add("IBM: IBM Common");
		choice_1.add("INTC: Intel Corporation");
		choice_1.add("JNJ: Johnson & Johnson");
		choice_1.add("JPM: JPMorgan Chase & Co");
		choice_1.add("KO: Coca-Cola Co");
		choice_1.add("MCD: Mcdonalds Corp");
		choice_1.add("MMM: 3M Co");
		choice_1.add("MRK: Merk & Co");
		choice_1.add("MSFT: Microsoft");
		choice_1.add("NKE: Nike");
		choice_1.add("PFE: Pfizer Inc");
		choice_1.add("PG: Procter Gamble");
		choice_1.add("TRV: Travelers Companies");
		choice_1.add("UNH: UnitedHealth Group");
		choice_1.add("UTX: United Technologies Corp");
		choice_1.add("V: Visa Inc");
		choice_1.add("VZ: Verizon Communications");  
		choice_1.add("WMT: Walmart");
		choice_1.add("XOM: Exxon Mobil Corporation");
		
		choice_2.add("BA: Boeing Co");
		choice_2.add("AAPL: Apple");
		choice_2.add("AXP: American Express");
		choice_2.add("CAT: Caterpillar");
		choice_2.add("CSCO: Cisco Systems");
		choice_2.add("CVX: Chevron");
		choice_2.add("DIS: Walt Disney");
		choice_2.add("GE: General Electric Company");
		choice_2.add("GS: Goldman Sachs");
		choice_2.add("HD: Home Depot");
		choice_2.add("IBM: IBM Common");
		choice_2.add("INTC: Intel Corporation");
		choice_2.add("JNJ: Johnson & Johnson");
		choice_2.add("JPM: JPMorgan Chase & Co");
		choice_2.add("KO: Coca-Cola Co");
		choice_2.add("MCD: Mcdonalds Corp");
		choice_2.add("MMM: 3M Co");
		choice_2.add("MRK: Merk & Co");
		choice_2.add("MSFT: Microsoft");
		choice_2.add("NKE: Nike");
		choice_2.add("PFE: Pfizer Inc");
		choice_2.add("PG: Procter Gamble");
		choice_2.add("TRV: Travelers Companies");
		choice_2.add("UNH: UnitedHealth Group");
		choice_2.add("UTX: United Technologies Corp");
		choice_2.add("V: Visa Inc");
		choice_2.add("VZ: Verizon Communications");  
		choice_2.add("WMT: Walmart");
		choice_2.add("XOM: Exxon Mobil Corporation");
		
		JLabel lblNewLabel_1 = new JLabel("Select 3 different stocks to view today's stock price comparison chart");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(choice_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(73))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(choice_2, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(225))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(265)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(56))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(choice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
						.addComponent(choice_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(49)
					.addComponent(choice_2, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

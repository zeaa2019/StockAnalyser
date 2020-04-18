package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javafx.scene.layout.Border;

import javax.swing.JList;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "unused", "serial" })
public class ViewStockPricePredictions extends JFrame{

	private JPanel contentPane;
	private String stockPricePrediction;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStockPricePredictions frame = new ViewStockPricePredictions();
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
	
	public ViewStockPricePredictions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		String title = "View Stock Price Predictions";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
		
		Choice choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectedStock = choice.getSelectedItem();
				selectedStock = selectedStock.substring(0, selectedStock.indexOf(":"));
				
				MovingAverage movingAverage = new MovingAverage();	
				ArrayList<Float> listOfStockPrices = new ArrayList<Float>();
				listOfStockPrices = movingAverage.getStockPrices(selectedStock);
				stockPricePrediction = movingAverage.performAlgorithm(listOfStockPrices);
				label.setText("USD: " + stockPricePrediction.substring(stockPricePrediction.indexOf("£") + 1));
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				MainPage backToHome = new MainPage();
				backToHome.setVisible(true);	
				backToHome.setTitle("Stock Analyser");
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("Select a stock to view its next stock market day price prediction");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addGap(209))
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(194)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(313))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(choice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
							.addGap(15)))
					.addGap(52)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(44))
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

package project;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "serial", "unused" })
public class ViewRealTimeStockPrices extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRealTimeStockPrices frame = new ViewRealTimeStockPrices();
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
	public ViewRealTimeStockPrices() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String title = "View Real-Time Stock Prices";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		Choice choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectedStock = choice.getSelectedItem();
				selectedStock = selectedStock.substring(0, selectedStock.indexOf(":"));
				
				Importer importer = new Importer();
				String realTimeStockPrice = importer.getRealTimePrice(selectedStock);
				
				lblNewLabel_1.setText("USD: " + realTimeStockPrice.substring(realTimeStockPrice.indexOf("£") + 1));					
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MainPage backToHome = new MainPage();
				backToHome.setVisible(true);
				backToHome.setTitle("Stock Analyser");

			}
		});
		
		JLabel lblNewLabel = new JLabel("Select a stock you want to view the real-time stock price for");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(212))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(215)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(304))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(32))
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

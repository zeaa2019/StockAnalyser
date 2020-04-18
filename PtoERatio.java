package project;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "serial", "unused" })
public class PtoERatio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtoERatio frame = new PtoERatio();
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
	public PtoERatio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String title = "View Price to Earnings Ratio";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				MainPage backToHome = new MainPage();
				backToHome.setVisible(true);
				backToHome.setTitle("Stock Analyser");	
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		Choice choice = new Choice();		
		choice.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
								
				String selectedStock = choice.getSelectedItem();
				selectedStock = selectedStock.substring(0, selectedStock.indexOf(":"));
				
				Importer importer = new Importer();
				String pToERatio = importer.getPtoERatio(selectedStock);
								
				lblNewLabel_1.setText("USD: " + pToERatio.substring(pToERatio.indexOf("£") + 1));
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Select a stock you want to view the price to earnings ratio for");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(249))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(217)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(307))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
		

		
		
		choice.add("AAPL: Apple");
		choice.add("AXP: American Express");
		choice.add("CAT: Caterpillar");
		choice.add("CSCO: Cisco Systems");
		choice.add("CVX: Chevron");
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

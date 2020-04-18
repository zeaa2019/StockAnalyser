package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "unused", "serial" })
public class MainPage extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					frame.setTitle("Stock Analyser");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */

	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnNewButton = new JButton("Stock Price Predictions");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStockPricePredictions viewPredictions = new ViewStockPricePredictions();
				viewPredictions.setVisible(true);
				viewPredictions.setTitle("View Stock Price Predictions");
				dispose();
			}
		});
		
		JButton btnRealTimeStock = new JButton("Real Time Stock Prices");
		btnRealTimeStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewRealTimeStockPrices realTimePrices = new ViewRealTimeStockPrices();
				realTimePrices.setVisible(true);
				realTimePrices.setTitle("View Real-Time Stock Prices");
				dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("P to E Ratio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PtoERatio pToERatio = new PtoERatio();
				pToERatio.setVisible(true);
				pToERatio.setTitle("Price to Earnings Ratio");
				dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Compare Stock Prices");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CompareStockPrices compareStockPrices = new CompareStockPrices();
				compareStockPrices.setVisible(true);
				compareStockPrices.setTitle("Compare Stock Prices");
				dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Invest");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.investopedia.com/best-brokers-for-beginners-4587873"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_4_1 = new JButton("Help");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://docs.google.com/document/d/1awoUvyoMYYKpMeVkYsLY2XaY9vpu8f9Yt4WhUKRx2yw/edit?usp=sharing"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}      
			}
		});
		
		JButton btnNewButton_5 = new JButton("Currency Convertor");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCurrencyConversions viewCurrencyConversions = new ViewCurrencyConversions();
				viewCurrencyConversions.setVisible(true);
				viewCurrencyConversions.setTitle("Currency Convertor");
				dispose();
			}
		});
		
		JButton btnNewButton_3_1 = new JButton("View Trends");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockTrends stockTrends = new StockTrends();
				stockTrends.setVisible(true);
				stockTrends.setTitle("Stock Price Trends");
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Report");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://docs.google.com/document/d/1CXX_r7hE2D55U1gg9SH9qYiu7SPgTarCB7waITcne2E/edit?usp=sharing"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
							.addGap(25)
							.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRealTimeStock, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
							.addGap(25)
							.addComponent(btnNewButton_3_1, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
							.addGap(40)
							.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(btnNewButton_4_1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
							.addGap(149)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRealTimeStock, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(btnNewButton_3_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addGap(42))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_4_1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

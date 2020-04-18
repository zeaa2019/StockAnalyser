package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextListener;
import java.awt.im.InputContext;
import java.util.InputMismatchException;
import java.awt.event.TextEvent;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings({ "serial", "unused" })
public class ViewCurrencyConversions extends JFrame {

	private JPanel contentPane;
	private String toCurrency;
	private Float value;
	private String value2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCurrencyConversions frame = new ViewCurrencyConversions();
					frame.setVisible(true);
					frame.setTitle("Currency Convertor");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCurrencyConversions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		String title = "Currency Convertor";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		contentPane.setBorder(border);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
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
				toCurrency = choice.getSelectedItem();	
				 }
			 });
		
		 choice.add("JPY: Japanese yen");		
		 choice.add("GBP: Pound sterling");		
		 choice.add("CHF: Swiss franc");		
		 choice.add("AUD: Australian dollar");		
		 choice.add("CAD: Canadian dollar");		
		 choice.add("CNY: Chinese yuan renminbi");		
		 choice.add("HKD: Hong Kong dollar");		
		 choice.add("INR: Indian rupee");			
		 choice.add("NZD: New Zealand dollar");				
		 choice.add("EUR: Euros");		
		 choice.add("AED: Dirhams");		
		 choice.add("ZAR: South African rand");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton button = new JButton("Convert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				try
					{
					value = Float.valueOf(value2);
				}
				catch(NumberFormatException exception)
					{
					lblNewLabel_1.setText("Enter a number");
					lblNewLabel.setText("");
					value = null;
					
				}
				if (toCurrency == null) {
					toCurrency = "JPY: Japanese yen";
				}
				CurrencyConvertor currencyConvertor = new CurrencyConvertor();
				String convertedAmount = toCurrency.substring(0, toCurrency.indexOf(":")) + ": " + String.valueOf(currencyConvertor.convert(toCurrency, value));
				lblNewLabel.setText(convertedAmount);
			}
		});
		
		TextField textField = new TextField();
		textField.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
				
			 value2 = textField.getText();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Select a currency and enter a USD value to convert to selected currency");
		
		JLabel lblNewLabel_3 = new JLabel("USD:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addGap(7))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(choice, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(33))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(139)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
							.addGap(38)))
					.addGap(40)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(21))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(74)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(choice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(35))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(22))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(24))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addGap(16))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

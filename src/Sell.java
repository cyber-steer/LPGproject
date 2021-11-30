import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Sell extends JPanel {
	int count;
	JButton btn,btnReset;
	JComboBox<String> comboCode,comboNumber;
	JTextField text3kg;
	JTextField text5kg;
	JTextField text10kg;
	JTextField text20kg;
	JTextField text50kg;
	JTextField propanePrice;
	JTextField bhutanPrice;
	JTextField textPropane;
	JTextField textBhutan;
	 JTextField textresult;
	 JTextField text13kg;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Sell() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel North = new JPanel();
		add(North, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LPG \uD310\uB9E4 \uC785\uB825");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		North.add(lblNewLabel);
		
		JPanel center = new JPanel();
		center.setLayout(null);
		add(center, BorderLayout.CENTER);
		
		JPanel prophan = new JPanel();
		prophan.setBorder(new TitledBorder(null, "\uD504\uB85C\uD310", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		prophan.setBounds(12, 10, 299, 56);
		center.add(prophan);
		prophan.setLayout(new GridLayout(0, 5, 5, 0));
		
		JPanel kg3 = new JPanel();
		prophan.add(kg3);
		kg3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("3 KG");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		kg3.add(lblNewLabel_1);
		
		text3kg = new JTextField();
		text3kg.setHorizontalAlignment(SwingConstants.CENTER);
		text3kg.setText("0");
		text3kg.setColumns(10);
		kg3.add(text3kg);
		
		JPanel kg5 = new JPanel();
		prophan.add(kg5);
		kg5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("5 KG");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		kg5.add(lblNewLabel_1_1);
		
		text5kg = new JTextField();
		text5kg.setHorizontalAlignment(SwingConstants.CENTER);
		text5kg.setText("0");
		text5kg.setColumns(10);
		kg5.add(text5kg);
		
		JPanel kg10 = new JPanel();
		prophan.add(kg10);
		kg10.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("10 KG");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		kg10.add(lblNewLabel_1_2);
		
		text10kg = new JTextField();
		text10kg.setHorizontalAlignment(SwingConstants.CENTER);
		text10kg.setText("0");
		text10kg.setColumns(10);
		kg10.add(text10kg);
		
		JPanel kg20 = new JPanel();
		prophan.add(kg20);
		kg20.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_3 = new JLabel("20 KG");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		kg20.add(lblNewLabel_1_3);
		
		text20kg = new JTextField();
		text20kg.setHorizontalAlignment(SwingConstants.CENTER);
		text20kg.setText("0");
		text20kg.setColumns(10);
		kg20.add(text20kg);
		
		JPanel kg50 = new JPanel();
		prophan.add(kg50);
		kg50.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_4 = new JLabel("50 KG");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		kg50.add(lblNewLabel_1_4);
		
		text50kg = new JTextField();
		text50kg.setHorizontalAlignment(SwingConstants.CENTER);
		text50kg.setText("0");
		text50kg.setColumns(10);
		kg50.add(text50kg);
		
		JPanel bhutan = new JPanel();
		bhutan.setBorder(new TitledBorder(null, "\uBD80\uD0C4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bhutan.setBounds(12, 76, 76, 56);
		center.add(bhutan);
		bhutan.setLayout(new BorderLayout(0, 0));
		
		JPanel kg3_1 = new JPanel();
		bhutan.add(kg3_1, BorderLayout.CENTER);
		kg3_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_6 = new JLabel("13 KG");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		kg3_1.add(lblNewLabel_1_6);
		
		text13kg = new JTextField();
		text13kg.setHorizontalAlignment(SwingConstants.CENTER);
		text13kg.setText("0");
		text13kg.setColumns(10);
		kg3_1.add(text13kg);
		
		JPanel price = new JPanel();
		price.setBounds(100, 76, 208, 53);
		center.add(price);
		price.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel panel_4_1_1_1 = new JPanel();
		price.add(panel_4_1_1_1);
		panel_4_1_1_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uD504\uB85C\uD310 \uB2E8\uAC00");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_1_1_1.add(lblNewLabel_1_1_1_1);
		
		propanePrice = new JTextField();
		propanePrice.setHorizontalAlignment(SwingConstants.CENTER);
		propanePrice.setEnabled(false);
		propanePrice.setColumns(10);
		panel_4_1_1_1.add(propanePrice);
		
		JPanel panel_4_1_1_2 = new JPanel();
		price.add(panel_4_1_1_2);
		panel_4_1_1_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("\uBD80\uD0C4 \uB2E8\uAC00");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_1_1_2.add(lblNewLabel_1_1_1_2);
		
		bhutanPrice = new JTextField();
		bhutanPrice.setText("'");
		bhutanPrice.setHorizontalAlignment(SwingConstants.CENTER);
		bhutanPrice.setEnabled(false);
		bhutanPrice.setColumns(10);
		panel_4_1_1_2.add(bhutanPrice);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 142, 231, 46);
		center.add(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\uAC70\uB798\uCC98 \uCF54\uB4DC");
		panel_1.add(lblNewLabel_2);
		comboCode = new JComboBox<String>();
		panel_1.add(comboCode);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		panel_2.add(lblNewLabel_3);
		
		comboNumber = new JComboBox<String>();
		panel_2.add(comboNumber);

		btn = new JButton("\uB2E4\uC74C");
		btn.setBounds(323, 165, 67, 23);
		center.add(btn);
		
		JPanel result = new JPanel();
		result.setBounds(323, 10, 67, 145);
		center.add(result);
		result.setLayout(new GridLayout(3, 1, 0, 15));
		
		JPanel panel_3 = new JPanel();
		result.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("\uD504\uB85C\uD310");
		panel_3.add(lblNewLabel_4);
		
		textPropane = new JTextField();
		textPropane.setText("KG");
		textPropane.setEnabled(false);
		textPropane.setColumns(10);
		panel_3.add(textPropane);
		
		JPanel panel_3_1 = new JPanel();
		result.add(panel_3_1);
		panel_3_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4_1 = new JLabel("\uBD80\uD0C4");
		panel_3_1.add(lblNewLabel_4_1);
		
		textBhutan = new JTextField();
		textBhutan.setText("KG");
		textBhutan.setEnabled(false);
		textBhutan.setColumns(10);
		panel_3_1.add(textBhutan);
		
		JPanel panel_3_2 = new JPanel();
		result.add(panel_3_2);
		panel_3_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4_2 = new JLabel("\uCD1D \uAE08\uC561");
		panel_3_2.add(lblNewLabel_4_2);
		
		textresult = new JTextField();
		textresult.setText("\uC6D0");
		textresult.setEnabled(false);
		textresult.setColumns(10);
		panel_3_2.add(textresult);
		
		btnReset = new JButton("\uB9AC\uC14B");
		btnReset.setBounds(249, 165, 67, 23);
		center.add(btnReset);
		comboBoxItemAdd();
		priceView();
		//===========================================이벤트
		comboCode.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   String cname = comboCode.getSelectedItem()+"";
				   try {
						   comboBoxView(cname);
				   } catch (SQLException e1) {
					   // TODO Auto-generated catch block
					   e1.printStackTrace();
				   }
				   
			   }
		});
			 
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count ==0) {
					try {
						int totalPropane = Integer.parseInt(text3kg.getText())*3+
								Integer.parseInt(text5kg.getText())*5+
								Integer.parseInt(text10kg.getText())*10+
								Integer.parseInt(text20kg.getText())*20+
								Integer.parseInt(text50kg.getText())*50;
						int totalBhutan = Integer.parseInt(text13kg.getText())*13;
						int totalPrice = totalPropane*(Integer.parseInt(propanePrice.getText()))+totalBhutan*(Integer.parseInt(bhutanPrice.getText()));
						textPropane.setText(totalPropane +"kg");
						textBhutan.setText(totalBhutan+"kg");
						textresult.setText(totalPrice +"원");
					}catch(NumberFormatException error) {
						textPropane.setText("오류");
						textBhutan.setText("정수");
						textresult.setText("입력");
						btn.setEnabled(false);
						System.err.print(error);
					}
					text3kg.setEnabled(false);
					text3kg.setBackground(Color.GRAY);
					text5kg.setEnabled(false);
					text5kg.setBackground(Color.GRAY);
					text10kg.setEnabled(false);
					text10kg.setBackground(Color.GRAY);
					text20kg.setEnabled(false);
					text20kg.setBackground(Color.GRAY);
					text50kg.setEnabled(false);
					text50kg.setBackground(Color.GRAY);
					text13kg.setEnabled(false);
					text13kg.setBackground(Color.GRAY);
					comboCode.setEnabled(false);
					comboCode.setBackground(Color.GRAY);
					comboNumber.setEnabled(false);
					comboNumber.setBackground(Color.GRAY);
					
					btn.setText("저장");
					count =+1;
				}else {
					try {
						DataBase.save(text3kg.getText(), text5kg.getText(),text10kg.getText(), text20kg.getText(), text50kg.getText(), text13kg.getText()
								,comboCode.getSelectedItem().toString(),comboNumber.getSelectedItem().toString());
					} catch (SQLException e1) {
					}
					text3kg.setEnabled(true);
					text5kg.setEnabled(true);
					text10kg.setEnabled(true);
					text20kg.setEnabled(true);
					text50kg.setEnabled(true);
					text13kg.setEnabled(true);
					text3kg.setText("0");
					text5kg.setText("0");
					text10kg.setText("0");
					text20kg.setText("0");
					text50kg.setText("0");
					text13kg.setText("0");
					textPropane.setText("kg");
					textBhutan.setText("kg");
					textresult.setText("원");
					count=0;
					btn.setEnabled(true);
					btn.setText("다음");
					
				}
				
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text3kg.setEnabled(true);
				text5kg.setEnabled(true);
				text10kg.setEnabled(true);
				text20kg.setEnabled(true);
				text50kg.setEnabled(true);
				text13kg.setEnabled(true);
				text3kg.setText("0");
				text5kg.setText("0");
				text10kg.setText("0");
				text20kg.setText("0");
				text50kg.setText("0");
				text13kg.setText("0");
				textPropane.setText("KG");
				textBhutan.setText("KG");
				textresult.setText("원");
				count=0;
				btn.setText("다음");
				btn.setEnabled(true);
				comboCode.setEnabled(true);
				comboNumber.setEnabled(true);
			}
		});

	}
	public void comboBoxItemAdd() throws SQLException {
		comboCode.removeAllItems();
		String queryString = "SELECT DISTINCT cname FROM customer";
		ResultSet resultSet = DataBase.query("select", queryString);
		comboCode.addItem("--선택--");
		while(resultSet.next()) {
			comboCode.addItem(resultSet.getString("cname"));
		}
	}
	public void comboBoxView(String cname) throws SQLException {
		comboNumber.removeAllItems();
		String queryString = "SELECT cnumber FROM customer where cname=\""+cname+"\";";
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			comboNumber.addItem(resultSet.getString("cnumber"));
		}
	}
	public void priceView() throws SQLException {
		String queryString = "select propane, bhutan from price";
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			propanePrice.setText(resultSet.getInt("propane")+"");
			bhutanPrice.setText(resultSet.getInt("bhutan")+"");
		}
	}
}

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JPanel {
	TableOrder tableOrder;
	JComboBox<String> comboBase, comboNumber;
	private JTextField textPropane;
	private JTextField textBhutan;
	private JTextField txtPropanePer;
	private JTextField txtPropaneTank;
	private JTextField txtBhutanPer;
	private JTextField txtBhutanTank;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Order() throws SQLException {
		tableOrder = new TableOrder();
		setLayout(new BorderLayout(0, 0));
		
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uBC1C\uC8FC \uC785\uB825");
		lblNewLabel.setFont(new Font("±º∏≤", Font.BOLD, 30));
		north.add(lblNewLabel);
		
		JPanel center = new JPanel();
		add(center);
		center.setLayout(null);
		
		JPanel base = new JPanel();
		base.setBounds(12, 10, 220, 37);
		center.add(base);
		base.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel panel = new JPanel();
		base.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uC9C0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		comboBase =new JComboBox<String>();
		panel.add(comboBase);
		
		JPanel panel_1 = new JPanel();
		base.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\uCC28\uB7C9\uBC88\uD638");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		comboNumber =new JComboBox<String>();
		panel_1.add(comboNumber);
		comboNumber.addItem("0123");
		comboNumber.addItem("4567");
		comboNumber.addItem("8901");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 57, 219, 37);
		center.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel propaneOrder = new JPanel();
		panel_2.add(propaneOrder);
		propaneOrder.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("\uD504\uB85C\uD310 \uBC1C\uC8FC");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		propaneOrder.add(lblNewLabel_1_1);
		
		textPropane = new JTextField();
		textPropane.setColumns(10);
		propaneOrder.add(textPropane);
		
		JPanel bhutanOrder = new JPanel();
		panel_2.add(bhutanOrder);
		bhutanOrder.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBD80\uD0C4 \uBC1C\uC8FC");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		bhutanOrder.add(lblNewLabel_1_2);
		
		textBhutan = new JTextField();
		textBhutan.setColumns(10);
		bhutanOrder.add(textBhutan);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uD604\uC7AC \uD0F1\uD06C \uC6A9\uB7C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(244, 10, 134, 146);
		center.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 20));
		
		JPanel panel_4_1 = new JPanel();
		panel_3.add(panel_4_1);
		panel_4_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3_1 = new JLabel("\uD504\uB85C\uD310 \uC6A9\uB7C9");
		panel_4_1.add(lblNewLabel_3_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_4_1.add(panel_5_1);
		panel_5_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		txtPropaneTank = new JTextField();
		txtPropaneTank.setEnabled(false);
		panel_5_1.add(txtPropaneTank);
		txtPropaneTank.setColumns(10);
		
		txtPropanePer = new JTextField();
		txtPropanePer.setEnabled(false);
		panel_5_1.add(txtPropanePer);
		txtPropanePer.setColumns(10);
		
		JPanel panel_4_2 = new JPanel();
		panel_3.add(panel_4_2);
		panel_4_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3_2 = new JLabel("\uBD80\uD0C4 \uC6A9\uB7C9");
		panel_4_2.add(lblNewLabel_3_2);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_4_2.add(panel_5_1_1);
		panel_5_1_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		txtBhutanTank = new JTextField();
		txtBhutanTank.setEnabled(false);
		txtBhutanTank.setColumns(10);
		panel_5_1_1.add(txtBhutanTank);
		
		txtBhutanPer = new JTextField();
		txtBhutanPer.setEnabled(false);
		txtBhutanPer.setColumns(10);
		panel_5_1_1.add(txtBhutanPer);
		
		JButton btn = new JButton("\uD655\uC778");
		btn.setBounds(76, 133, 91, 23);
		center.add(btn);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(390, 10, 210, 179);
		center.add(tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
		tablePanel.add(tableOrder,BorderLayout.CENTER);
		
		JButton btn_1 = new JButton("\uC0AD\uC81C");
		btn_1.setBounds(287, 166, 91, 23);
		center.add(btn_1);

		tankView();
		comboBoxItemAdd();

		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tableOrder.delete();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					tableOrder.view();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				String sqlString="INSERT INTO `lpgstationdb`.`orderdata` "
						+ "(`ono` ,`oday` ,`pvalue` ,`bvalue` ,`obase` ,`onumber`) "
						+ "VALUES (NULL , '"
						+format.format(date)+"', '"
						+textPropane.getText()+"', '"
						+textBhutan.getText()+"', '"
						+comboBase.getSelectedItem().toString()+"', '"
						+comboNumber.getSelectedItem().toString()+"');";
				try {
					DataBase.query("insert", sqlString);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					tableOrder.view();
					tankView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sqlString="UPDATE `lpgstationdb`.`tank` SET `ptank` = '"
				+(Integer.parseInt(textPropane.getText())+Integer.parseInt(txtPropaneTank.getText()))+"',`btank` = '"
				+(Integer.parseInt(textBhutan.getText())+Integer.parseInt(txtBhutanTank.getText()))+"' WHERE `tank`.`bno` =1 LIMIT 1 ;";
				System.out.println(sqlString);
				try {
					DataBase.query("update", sqlString);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					tankView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textPropane.setText("");
				textBhutan.setText("");
			}
		});
	}
	public void tankView() throws SQLException {
		double ptank=0, btank=0;
		int iptank=0, ibtank=0;
		String queryString = "select ptank,btank from tank";
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			ptank = resultSet.getInt("ptank");
			btank = resultSet.getInt("btank");
			iptank = resultSet.getInt("ptank");
			ibtank = resultSet.getInt("btank");
		}
		txtPropaneTank.setText(iptank+"");
		txtBhutanTank.setText(ibtank+"");
		ptank = ptank/50000*100;
		btank = btank/50000*100;
		ptank = Math.round(ptank*100)/100.0;
		btank = Math.round(ptank*100)/100.0;
		txtPropanePer.setText(ptank+"%");
		txtBhutanPer.setText(btank+"%");
	}

	public void comboBoxItemAdd() throws SQLException {
		comboBase.removeAllItems();
		comboBase.addItem("==º±≈√==");
		String queryString = "SELECT DISTINCT bname FROM base";
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			comboBase.addItem(resultSet.getString("bname"));
		}
	}
}

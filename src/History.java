import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JPanel {
	int selet;
	TableHistory tableHistory;
	JButton btnDelete,btnRevise;
	private JTextField text3kg;
	private JTextField text5kg;
	private JTextField text10kg;
	private JTextField text20kg;
	private JTextField text50kg;
	private JTextField text13kg;
	private JTextField textPropane;
	private JTextField textBhutan;
	private JTextField textResult;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public History() throws SQLException {
		tableHistory = new TableHistory();
		tableHistory.table.addMouseListener(new JTableMouseListener());
		setLayout(new BorderLayout(0, 0));
		
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		north.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uAE30\uB85D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 30));
		north.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		center.add(panel);
		panel.setLayout(null);
		
		DateSearch dateSearch = new DateSearch();
		dateSearch.setBounds(12, 0, 130, 42);
		panel.add(dateSearch);
		
		DateSearch dateSearch_1 = new DateSearch();
		dateSearch_1.setBounds(154, 0, 130, 42);
		panel.add(dateSearch_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("~");
		lblNewLabel_1_1.setBounds(143, 18, 22, 15);
		panel.add(lblNewLabel_1_1);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(12, 52, 272, 229);
		panel.add(tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
		tablePanel.add(tableHistory);
		
		JPanel panel_1 = new JPanel();
		center.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(12, 43, 201, 201);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4_3_1 = new JPanel();
		panel_4_3_1.setBounds(12, 107, 79, 36);
		panel_3.add(panel_4_3_1);
		panel_4_3_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_3_1 = new JLabel("\uD504\uB85C\uD310");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_3_1.add(lblNewLabel_2_3_1);
		
		textPropane = new JTextField();
		textPropane.setEditable(false);
		textPropane.setColumns(10);
		panel_4_3_1.add(textPropane);
		
		JPanel panel_4_3_2 = new JPanel();
		panel_4_3_2.setBounds(110, 107, 79, 36);
		panel_3.add(panel_4_3_2);
		panel_4_3_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_3_2 = new JLabel("\uBD80\uD0C4");
		lblNewLabel_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_3_2.add(lblNewLabel_2_3_2);
		
		textBhutan = new JTextField();
		textBhutan.setEditable(false);
		textBhutan.setColumns(10);
		panel_4_3_2.add(textBhutan);
		
		JPanel kg = new JPanel();
		kg.setBounds(12, 10, 177, 87);
		panel_3.add(kg);
		kg.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_4 = new JPanel();
		kg.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("3 KG");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		text3kg = new JTextField();
		panel_4.add(text3kg);
		text3kg.setColumns(10);
		
		JPanel panel_4_1 = new JPanel();
		kg.add(panel_4_1);
		panel_4_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("5 KG");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_1.add(lblNewLabel_2_1);
		
		text5kg = new JTextField();
		text5kg.setColumns(10);
		panel_4_1.add(text5kg);
		
		JPanel panel_4_2 = new JPanel();
		kg.add(panel_4_2);
		panel_4_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_2 = new JLabel("10 KG");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_2.add(lblNewLabel_2_2);
		
		text10kg = new JTextField();
		text10kg.setColumns(10);
		panel_4_2.add(text10kg);
		
		JPanel panel_4_3 = new JPanel();
		kg.add(panel_4_3);
		panel_4_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_3 = new JLabel("20 KG");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_3.add(lblNewLabel_2_3);
		
		text20kg = new JTextField();
		text20kg.setColumns(10);
		panel_4_3.add(text20kg);
		
		JPanel panel_4_4 = new JPanel();
		kg.add(panel_4_4);
		panel_4_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_4 = new JLabel("50 KG");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_4.add(lblNewLabel_2_4);
		
		text50kg = new JTextField();
		text50kg.setColumns(10);
		panel_4_4.add(text50kg);
		
		JPanel panel_4_5 = new JPanel();
		kg.add(panel_4_5);
		panel_4_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_5 = new JLabel("13 KG");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_5.add(lblNewLabel_2_5);
		
		text13kg = new JTextField();
		text13kg.setColumns(10);
		panel_4_5.add(text13kg);
		
		JPanel panel_4_3_2_1 = new JPanel();
		panel_4_3_2_1.setBounds(12, 155, 177, 36);
		panel_3.add(panel_4_3_2_1);
		panel_4_3_2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("\uCD1D \uAE08\uC561");
		lblNewLabel_2_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_3_2_1.add(lblNewLabel_2_3_2_1);
		
		textResult = new JTextField();
		textResult.setEditable(false);
		textResult.setColumns(10);
		panel_4_3_2_1.add(textResult);
		
		btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.setBounds(122, 254, 91, 23);
		panel_1.add(btnDelete);
		
		btnRevise = new JButton("\uC218\uC815");
		btnRevise.setBounds(12, 254, 91, 23);
		panel_1.add(btnRevise);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(152, 10, 71, 23);
		panel_1.add(btnSearch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(38, 10, 108, 23);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC70\uB798\uCC98");
		lblNewLabel_1.setBounds(0, 14, 49, 15);
		panel_1.add(lblNewLabel_1);
		//======================================================
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					delet();
					tableHistory.view();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				text3kg.setText("");
				text5kg.setText("");
				text10kg.setText("");
				text20kg.setText("");
				text50kg.setText("");
				text13kg.setText("");
				textPropane.setText("");
				textBhutan.setText("");
				textResult.setText("");
			}
		});
		btnRevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalPropane = Integer.parseInt(text3kg.getText())*3+
						Integer.parseInt(text5kg.getText())*5+
						Integer.parseInt(text10kg.getText())*10+
						Integer.parseInt(text20kg.getText())*20+
						Integer.parseInt(text50kg.getText())*50;
				int totalBhutan = Integer.parseInt(text13kg.getText())*13;
				
				int price=0;
				String sqlString ="SELECT propane, bhutan FROM `price`";
				try {
					ResultSet resultSet = DataBase.query("select", sqlString);
					while(resultSet.next()) {
						System.out.println("propane: "+resultSet.getInt("propane"));
						System.out.println("bhutan: "+resultSet.getInt("bhutan"));
						price = totalPropane*resultSet.getInt("propane")+(totalBhutan*resultSet.getInt("bhutan"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sqlString = "UPDATE `lpgstationdb`.`sell` SET `kg3` = '"
				+text3kg.getText()+"', `kg5` = '"
				+text5kg.getText()+"', `kg10` = '"
				+text10kg.getText()+"', `kg20` = '"
				+text20kg.getText()+"', `kg50` = '"
				+text50kg.getText()+"', `kg13` = '"
				+text13kg.getText()+"', `sprice` = '"
				+price+"' WHERE `sell`.`sno` ="
				+selet+" LIMIT 1 ;";
				
				try {
					DataBase.query("update", sqlString);
					tableHistory.view();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(totalPropane);
				System.out.println(totalBhutan);
				System.out.println(price);
				textPropane.setText(totalPropane+"KG");
				textBhutan.setText(totalBhutan+"KG");
				textResult.setText(price+"¿ø");
				
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = (Date) dateSearch.spinner.getValue();
				Date date1 = (Date) dateSearch_1.spinner.getValue();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				System.out.print(format.format(date));
				
				String sqlString = "SELECT * FROM sell "
						+ "WHERE sday BETWEEN \""+format.format(date)+"\" AND \""+format.format(date1)+"\"";
				try {
					tableHistory.view(sqlString);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	public void delet() throws SQLException {
		System.out.println("delet");
		String sqlString = "DELETE FROM `lpgstationdb`.`sell` WHERE `sell`.`sno` ="+selet+" LIMIT 1;";
		DataBase.dbConnect();
		DataBase.query("delet", sqlString);
	}
	private class JTableMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			JTable jTable = (JTable)e.getSource();
			int row = jTable.getSelectedRow();
			int col = jTable.getSelectedColumn();

            System.out.println(tableHistory.model.getValueAt(row, 0));
            selet = (Integer) (tableHistory.model.getValueAt(row, 0));
            
            String sqlString="SELECT * FROM sell WHERE sno ="+selet;
            try {
				ResultSet resultSet = DataBase.query("select", sqlString);
				while(resultSet.next()) {
					int ptank,btank;
					ptank = resultSet.getInt("kg3")*3
							+resultSet.getInt("kg5")*5
							+resultSet.getInt("kg10")*10
							+resultSet.getInt("kg20")*20
							+resultSet.getInt("kg50")*50;
					btank = resultSet.getInt("kg13")*13;
					text3kg.setText(resultSet.getInt("kg3")+"");
					text5kg.setText(resultSet.getInt("kg5")+"");
					text10kg.setText(resultSet.getInt("kg10")+"");
					text20kg.setText(resultSet.getInt("kg20")+"");
					text50kg.setText(resultSet.getInt("kg50")+"");
					text13kg.setText(resultSet.getInt("kg13")+"");
					textPropane.setText(ptank+"KG");
					textBhutan.setText(btank+"KG");
					textResult.setText(resultSet.getInt("sprice")+"¿ø");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
}

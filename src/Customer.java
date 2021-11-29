import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Customer extends JPanel {
	TablevView tablevView;
	int count, propane, bhutan;
	private JTextField textCname;
	private JTextField textCnumber;
	JTextField txtPropanePrice;
	JTextField txtBhutanPrice;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Customer() throws SQLException {
		tablevView = new TablevView();
		count = 0;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uAC70\uB798\uCC98");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC70\uB798\uCC98");
		lblNewLabel_1.setBounds(25, 13, 50, 15);
		panel_1.add(lblNewLabel_1);
		
		textCname = new JTextField();
		textCname.setBounds(74, 10, 96, 21);
		panel_1.add(textCname);
		textCname.setColumns(10);
		
		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.setBounds(105, 66, 65, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\uCC28\uB7C9\uBC88\uD638");
		lblNewLabel_2.setBounds(12, 38, 50, 15);
		panel_1.add(lblNewLabel_2);
		
		textCnumber = new JTextField();
		textCnumber.setBounds(74, 35, 96, 21);
		panel_1.add(textCnumber);
		textCnumber.setColumns(10);
		
		
		JButton btnNewButton_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1.setBounds(171, 222, 65, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uD504\uB85C\uD310");
		lblNewLabel_3.setBounds(25, 121, 50, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBD80\uD0C4");
		lblNewLabel_4.setBounds(25, 152, 50, 15);
		panel_1.add(lblNewLabel_4);
		
		txtPropanePrice = new JTextField();
		txtPropanePrice.setText("0");
		txtPropanePrice.setEnabled(false);
		txtPropanePrice.setBounds(74, 118, 96, 21);
		panel_1.add(txtPropanePrice);
		txtPropanePrice.setColumns(10);
		
		txtBhutanPrice = new JTextField();
		txtBhutanPrice.setText("0");
		txtBhutanPrice.setEnabled(false);
		txtBhutanPrice.setBounds(74, 149, 96, 21);
		panel_1.add(txtBhutanPrice);
		txtBhutanPrice.setColumns(10);
		
		JButton btnRevise = new JButton("\uC218\uC815");
		btnRevise.setBounds(25, 177, 65, 23);
		JButton btnSave = new JButton("\uC800\uC7A5");
		btnSave.setBounds(105, 177, 65, 23);
		panel_1.add(btnRevise);
		panel_1.add(btnSave);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(248, 13, 190, 232);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(tablevView, BorderLayout.CENTER);

		String[] headStrings = {"번호","거래처 명","차량번호"};
		String[][] dataStrings = {{"1","2","3"},{"4","5","6"}};
		btnSave.setVisible(false);
		
		propane = Integer.parseInt(txtPropanePrice.getText());
		bhutan = Integer.parseInt(txtBhutanPrice.getText());
		
		priceView();
		//=======================================================이벤트
		btnRevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
					btnSave.setVisible(true);
					btnRevise.setText("취소");
					txtPropanePrice.enable(true);
					txtBhutanPrice.enable(true);
					count++;
				}else {
					btnSave.setVisible(false);
					btnRevise.setText("수정");
					txtPropanePrice.setText(propane+"");
					txtBhutanPrice.setText(bhutan+"");
					txtPropanePrice.enable(false);
					txtBhutanPrice.enable(false);
					count =0;
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.setVisible(false);
				btnRevise.setText("수정");
				try {
					propane = Integer.parseInt(txtPropanePrice.getText());
					bhutan = Integer.parseInt(txtBhutanPrice.getText());
				}catch (NumberFormatException error){
					txtPropanePrice.setText("정수");
					txtBhutanPrice.setText("입력");
				}
				txtPropanePrice.setText(propane+"");
				txtBhutanPrice.setText(bhutan+"");
				txtPropanePrice.enable(false);
				txtBhutanPrice.enable(false);
				count = 0;
			}
		});
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.save(textCname.getText(), textCnumber.getText());
				textCname.setText("");
				textCnumber.setText("");
				try {
					tablevView.view();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tablevView.delete();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					tablevView.view();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public void priceView() throws SQLException {
		String queryString = "select propane, bhutan from price";
		DataBase.dbConnect();
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			txtPropanePrice.setText(resultSet.getInt("propane")+"");
			txtBhutanPrice.setText(resultSet.getInt("bhutan")+"");
		}
	}
}

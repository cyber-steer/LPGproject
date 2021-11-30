import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import javax.swing.JScrollPane;

public class TablevView extends JPanel {
	int selet;
	JTable table;
	JScrollPane scrollPane;
	String[] headStrings = {"번호","거래처 명","차량번호"};
	DefaultTableModel model;
	public TablevView() throws SQLException {
		model = new DefaultTableModel(headStrings,0);
		table = new JTable(model);
		table.addMouseListener(new JTableMouseListener());
		setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane(table);
		view();
		add(scrollPane);
	}
	private class JTableMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			JTable jTable = (JTable)e.getSource();
			int row = jTable.getSelectedRow();
			int col = jTable.getSelectedColumn();

            System.out.println(model.getValueAt(row, 0));
            selet = (Integer) (model.getValueAt(row, 0));
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
	void view() throws SQLException {
		model.setNumRows(0);
		String queryString = "select * from customer order by cusno";
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			model.addRow(new Object[] {
					resultSet.getInt("cusno"),
					resultSet.getString("cname"),
					resultSet.getString("cnumber"),
			});
		}
	}
	void delete() throws SQLException {
		String sqlString = "DELETE FROM `lpgstationdb`.`customer` WHERE `customer`.`cusno` ="+selet+" LIMIT 1;";
		DataBase.query("delet", sqlString);
	}
}

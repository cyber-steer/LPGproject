import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TableOrder extends JPanel{
	int selet;
	JTable table;
	JScrollPane scrollPane;
	String[] headStrings = {"번호","날짜","기지명 ","프로판","부탄"};
	DefaultTableModel model;
	public TableOrder() throws SQLException {
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
		String queryString = "select * from orderdata order by ono";
		DataBase.dbConnect();
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			model.addRow(new Object[] {
					resultSet.getInt("ono"),
					resultSet.getString("oday"),
					resultSet.getString("obase"),
					resultSet.getString("pvalue"),
					resultSet.getString("bvalue"),
			});
		}
	}
	void delete() throws SQLException {
		String sqlString = "DELETE FROM `lpgstationdb`.`orderdata` WHERE `orderdata`.`ono` ="+selet+" LIMIT 1;";
		DataBase.dbConnect();
		DataBase.query("delet", sqlString);
	}


}

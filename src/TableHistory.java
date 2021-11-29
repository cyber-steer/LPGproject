import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TableHistory extends JPanel{
	int selet;
	JTable table;
	JScrollPane scrollPane;
	String[] headStrings = {"번호","거래처 명","날짜","금액"};
	DefaultTableModel model;
	public TableHistory() throws SQLException {
		model = new DefaultTableModel(headStrings,0);
		table = new JTable(model);
//		table.addMouseListener(new JTableMouseListener());
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
		String queryString = "select * from sell order by sno";
		DataBase.dbConnect();
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			model.addRow(new Object[] {
					resultSet.getInt("sno"),
					resultSet.getString("cname"),
					resultSet.getDate("sday"),
					resultSet.getInt("sprice"),
			});
		}
	}
	void view(String queryString) throws SQLException {
		model.setNumRows(0);
		DataBase.dbConnect();
		ResultSet resultSet = DataBase.query("select", queryString);
		while(resultSet.next()) {
			model.addRow(new Object[] {
					resultSet.getInt("sno"),
					resultSet.getString("cname"),
					resultSet.getDate("sday"),
					resultSet.getInt("sprice"),
			});
		}
	}
	void delete() throws SQLException {
		String sqlString = "DELETE FROM `lpgstationdb`.`sell` WHERE `sell`.`cusno` ="+selet+" LIMIT 1;";
		DataBase.dbConnect();
		DataBase.query("delet", sqlString);
	}


}

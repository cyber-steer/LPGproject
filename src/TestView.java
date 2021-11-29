import java.sql.SQLException;

import javax.swing.JFrame;

public class TestView extends JFrame{
	
	public TestView() throws SQLException {
		TableOrder tableOrder = new TableOrder();
		add(tableOrder);
		
		
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws SQLException {
		new TestView();
	}

}

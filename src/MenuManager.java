import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JTabbedPane;

public class MenuManager extends JPanel {
	History history;
	Customer customer;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public MenuManager() throws SQLException {
		customer = new Customer();
		history = new History();
		setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("기록",history);
		tabbedPane.addTab("거래처",customer);
	}

}

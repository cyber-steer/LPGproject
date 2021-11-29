import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.sql.SQLException;

public class MenuSell extends JPanel {
	Sell sell;
	Order order;
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public MenuSell() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		sell = new Sell();
		order = new Order();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		

		tabbedPane.addTab("판매",sell);
		tabbedPane.addTab("발주",order);
	}

}

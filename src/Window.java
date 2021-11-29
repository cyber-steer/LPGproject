import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Window extends JFrame {
	public static final int ADMIN = 0;
	public static final int GUEST = 1;
	public int propane;
	public int bhutan;
	public static int condition=1;

	int count;
	String client;
	MenuSell sell;
	MenuManager manager;
	Login login;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu nemuSell;
	private JMenu menuManager;
	private JMenuItem menuItemSell;
	private JMenuItem menuItemManager;
	private JMenu menuHelp;
	private JMenuItem menuItemLogout;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Window() throws SQLException {
		//기본 틀 생성
		manager = new MenuManager();
		sell = new MenuSell();
		propane = manager.customer.propane;
		bhutan = manager.customer.bhutan;
		count=0;
		setTitle("LPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		menuBar = new JMenuBar();
		panel_1.add(menuBar);
		
		nemuSell = new JMenu("\uD310\uB9E4");
		
		menuManager = new JMenu("\uAD00\uB9AC");
		
		menuHelp = new JMenu("help");
		
		menuItemLogout = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		menuHelp.add(menuItemLogout);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		menuItemSell = new JMenuItem("\uD310\uB9E4\uD0ED");
		nemuSell.add(menuItemSell);
		
		menuItemManager = new JMenuItem("\uAD00\uB9AC\uD0ED");
		menuManager.add(menuItemManager);
			
		//로그인 형태에따라 패널 추가
		if(condition == ADMIN) {
			menuBar.add(nemuSell);
			menuBar.add(menuManager);
			menuBar.add(menuHelp);
			menuItemSell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.remove(manager);
					panel.add(sell);
					try {
						sell.sell.comboBoxItemAdd();
						sell.order.tankView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			menuItemManager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.remove(sell);
					panel.add(manager);
					try {
						manager.history.tableHistory.view();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
		}
		else {
			menuBar.add(menuHelp);
			sell = new MenuSell();
			panel.add(sell.sell);
			
		}
		//====================================================================
		menuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();
			}
		});
	}

}

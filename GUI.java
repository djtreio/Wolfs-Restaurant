import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private final JButton btnOrders = new JButton("Orders");
	private final JButton btnTables = new JButton("Tables");
	private final JButton btnReservations = new JButton("Reservations");
	private final JButton btnMenu = new JButton("Menu");
	private final JButton btnEmployees = new JButton("Employees");
	private final JLabel lblNewLabel = new JLabel("The Hub");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GUI("");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public GUI(String type) {
		switch(type) {
		case "":
			initialize();
			break;
		case "Employee":
			initializeEL();
			break;
		case "EmployeeEdit":
			initializeE();
			break;
		
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{126, 95, 95, 95, 95, 95, 0};
		gbl_panel.rowHeights = new int[]{39, 61, 23, 35, 23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnOrders, gbc_btnNewButton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnTables, gbc_btnNewButton_1);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnReservations, gbc_btnNewButton_2);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 4;
		panel.add(btnMenu, gbc_btnNewButton_3);
		GridBagConstraints gbc_btnOrders = new GridBagConstraints();
		gbc_btnOrders.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrders.insets = new Insets(0, 0, 0, 5);
		gbc_btnOrders.gridx = 4;
		gbc_btnOrders.gridy = 4;
		panel.add(btnEmployees, gbc_btnOrders);
		
		frame.setVisible(true);
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.setVisible(false);
							frame.dispose();
							new GUI("Employee");
					
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	
	
	private JFrame ELframe;
	private final JList ELlist = new JList();
	private final JButton ELbtnAdd = new JButton("Add");
	private final JButton ELbtnRemove = new JButton("Remove");
	private final JButton ELbtnEdit = new JButton("Edit");
	private final JLabel ELlblEmployee = new JLabel("Employee");
	private final JButton ELbtnOK = new JButton("OK");
	private final JButton ELbtnCancel = new JButton("Cancel");
	
	private void initializeEL() {
		
		ELframe = new JFrame();
		ELframe.setBounds(100, 100, 786, 474);
		ELframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ELframe.getContentPane().setLayout(null);
		ELlist.setBounds(417, 51, 325, 333);

		ELframe.getContentPane().add(ELlist);
		ELbtnAdd.setBounds(166, 132, 89, 23);

		ELframe.getContentPane().add(ELbtnAdd);
		ELbtnRemove.setBounds(166, 194, 89, 23);

		ELframe.getContentPane().add(ELbtnRemove);
		ELbtnEdit.setBounds(166, 257, 89, 23);

		ELframe.getContentPane().add(ELbtnEdit);
		ELlblEmployee.setBounds(360, 11, 48, 14);

		ELframe.getContentPane().add(ELlblEmployee);
		ELbtnOK.setBounds(22, 369, 89, 23);

		ELframe.getContentPane().add(ELbtnOK);
		ELbtnCancel.setBounds(124, 369, 89, 23);
		
		ELbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ELframe.setVisible(false);
				initialize();
			}
		});
		
		ELbtnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ELframe.setVisible(false);
							ELframe.dispose();
							new GUI("EmployeeEdit");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		ELframe.getContentPane().add(ELbtnCancel);
		
		ELframe.setVisible(true);
	}
	
	

	
	
	private JFrame Eframe;
	private final JPanel Epanel = new JPanel();
	private final JPanel Epanel1 = new JPanel();
	private final JLabel ElblName = new JLabel("Name");
	private final JTextField EfldName = new JTextField();
	private final JPanel Epanel4 = new JPanel();
	private final JLabel ElblEmployee = new JLabel("Employee");
	private final JPanel Epanel2 = new JPanel();
	private final JLabel ElblPhone = new JLabel("Phone");
	private final JTextField EfldPhone = new JTextField();
	private final JLabel ElblUser = new JLabel("Username");
	private final JTextField EfldUser = new JTextField();
	private final JLabel ElblPos = new JLabel("Position");
	private final JTextField EfldPos = new JTextField();
	private final JLabel ElblStatus = new JLabel("Status");
	private final JTextField EfldStatus = new JTextField();
	private final JLabel ElblEmail = new JLabel("Email");
	private final JTextField EfldEmail = new JTextField();
	private final JLabel ElblType = new JLabel("Account Type");
	private final JTextField EfldType = new JTextField();
	private final JPanel panel_3 = new JPanel();
	private final JPanel Epanel3 = new JPanel();
	private final JButton EbtnCancel = new JButton("Cancel");
	private final JButton EbtnOK = new JButton("OK");
	
	
	private void initializeE() {
		EfldType.setColumns(10);
		EfldEmail.setColumns(10);
		EfldUser.setColumns(10);
		Eframe = new JFrame();
		Eframe.setBounds(100, 100, 684, 426);
		Eframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Eframe.getContentPane().add(Epanel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{169, 169, 0};
		gbl_panel.rowHeights = new int[]{237, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		Epanel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_Epanel1 = new GridBagConstraints();
		gbc_Epanel1.anchor = GridBagConstraints.WEST;
		gbc_Epanel1.fill = GridBagConstraints.VERTICAL;
		gbc_Epanel1.insets = new Insets(0, 0, 0, 5);
		gbc_Epanel1.gridx = 0;
		gbc_Epanel1.gridy = 0;
		Epanel.add(Epanel1, gbc_Epanel1);
		GridBagLayout gbl_Epanel1 = new GridBagLayout();
		gbl_Epanel1.columnWidths = new int[]{17, 169, 0};
		gbl_Epanel1.rowHeights = new int[]{10, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Epanel1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Epanel1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Epanel1.setLayout(gbl_Epanel1);
		
		GridBagConstraints gbc_ElblName = new GridBagConstraints();
		gbc_ElblName.anchor = GridBagConstraints.WEST;
		gbc_ElblName.insets = new Insets(0, 0, 5, 0);
		gbc_ElblName.gridx = 1;
		gbc_ElblName.gridy = 1;
		Epanel1.add(ElblName, gbc_ElblName);
		GridBagConstraints gbc_EfldName = new GridBagConstraints();
		gbc_EfldName.insets = new Insets(0, 0, 5, 0);
		gbc_EfldName.fill = GridBagConstraints.BOTH;
		gbc_EfldName.gridx = 1;
		gbc_EfldName.gridy = 2;
		Epanel1.add(EfldName, gbc_EfldName);
		EfldName.setColumns(10);
		
		GridBagConstraints gbc_ElblUser = new GridBagConstraints();
		gbc_ElblUser.anchor = GridBagConstraints.WEST;
		gbc_ElblUser.insets = new Insets(0, 0, 5, 0);
		gbc_ElblUser.gridx = 1;
		gbc_ElblUser.gridy = 4;
		Epanel1.add(ElblUser, gbc_ElblUser);
		
		GridBagConstraints gbc_EfldUser = new GridBagConstraints();
		gbc_EfldUser.insets = new Insets(0, 0, 5, 0);
		gbc_EfldUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_EfldUser.gridx = 1;
		gbc_EfldUser.gridy = 5;
		Epanel1.add(EfldUser, gbc_EfldUser);
		
		GridBagConstraints gbc_ElblPos = new GridBagConstraints();
		gbc_ElblPos.anchor = GridBagConstraints.WEST;
		gbc_ElblPos.insets = new Insets(0, 0, 5, 0);
		gbc_ElblPos.gridx = 1;
		gbc_ElblPos.gridy = 7;
		Epanel1.add(ElblPos, gbc_ElblPos);
		EfldPos.setColumns(10);
		
		GridBagConstraints gbc_EfldPos = new GridBagConstraints();
		gbc_EfldPos.insets = new Insets(0, 0, 5, 0);
		gbc_EfldPos.fill = GridBagConstraints.HORIZONTAL;
		gbc_EfldPos.gridx = 1;
		gbc_EfldPos.gridy = 8;
		Epanel1.add(EfldPos, gbc_EfldPos);
		
		GridBagConstraints gbc_ElblStatus = new GridBagConstraints();
		gbc_ElblStatus.anchor = GridBagConstraints.WEST;
		gbc_ElblStatus.insets = new Insets(0, 0, 5, 0);
		gbc_ElblStatus.gridx = 1;
		gbc_ElblStatus.gridy = 10;
		Epanel1.add(ElblStatus, gbc_ElblStatus);
		EfldStatus.setColumns(10);
		
		GridBagConstraints gbc_EfldStatus = new GridBagConstraints();
		gbc_EfldStatus.insets = new Insets(0, 0, 5, 0);
		gbc_EfldStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_EfldStatus.gridx = 1;
		gbc_EfldStatus.gridy = 11;
		Epanel1.add(EfldStatus, gbc_EfldStatus);
		
		GridBagConstraints gbc_Epanel2 = new GridBagConstraints();
		gbc_Epanel2.fill = GridBagConstraints.BOTH;
		gbc_Epanel2.gridx = 1;
		gbc_Epanel2.gridy = 0;
		Epanel.add(Epanel2, gbc_Epanel2);
		GridBagLayout gbl_Epanel2 = new GridBagLayout();
		gbl_Epanel2.columnWidths = new int[]{0, 169, 0};
		gbl_Epanel2.rowHeights = new int[]{14, 0, 20, 0, 0, 0, 0, 0, 0, 0};
		gbl_Epanel2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Epanel2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Epanel2.setLayout(gbl_Epanel2);
		
		GridBagConstraints gbc_ElblPhone = new GridBagConstraints();
		gbc_ElblPhone.anchor = GridBagConstraints.WEST;
		gbc_ElblPhone.insets = new Insets(0, 0, 5, 0);
		gbc_ElblPhone.gridx = 1;
		gbc_ElblPhone.gridy = 1;
		Epanel2.add(ElblPhone, gbc_ElblPhone);
		
		GridBagConstraints gbc_EfldPhone = new GridBagConstraints();
		gbc_EfldPhone.insets = new Insets(0, 0, 5, 0);
		gbc_EfldPhone.fill = GridBagConstraints.BOTH;
		gbc_EfldPhone.gridx = 1;
		gbc_EfldPhone.gridy = 2;
		EfldPhone.setColumns(10);
		Epanel2.add(EfldPhone, gbc_EfldPhone);
		
		GridBagConstraints gbc_ElblEmail = new GridBagConstraints();
		gbc_ElblEmail.anchor = GridBagConstraints.WEST;
		gbc_ElblEmail.insets = new Insets(0, 0, 5, 0);
		gbc_ElblEmail.gridx = 1;
		gbc_ElblEmail.gridy = 4;
		Epanel2.add(ElblEmail, gbc_ElblEmail);
		
		GridBagConstraints gbc_EfldEmail = new GridBagConstraints();
		gbc_EfldEmail.insets = new Insets(0, 0, 5, 0);
		gbc_EfldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_EfldEmail.gridx = 1;
		gbc_EfldEmail.gridy = 5;
		Epanel2.add(EfldEmail, gbc_EfldEmail);
		
		GridBagConstraints gbc_ElblType = new GridBagConstraints();
		gbc_ElblType.anchor = GridBagConstraints.WEST;
		gbc_ElblType.insets = new Insets(0, 0, 5, 0);
		gbc_ElblType.gridx = 1;
		gbc_ElblType.gridy = 7;
		Epanel2.add(ElblType, gbc_ElblType);
		
		GridBagConstraints gbc_EfldType = new GridBagConstraints();
		gbc_EfldType.fill = GridBagConstraints.HORIZONTAL;
		gbc_EfldType.gridx = 1;
		gbc_EfldType.gridy = 8;
		Epanel2.add(EfldType, gbc_EfldType);
		
		Eframe.getContentPane().add(Epanel4, BorderLayout.NORTH);
		
		Epanel4.add(ElblEmployee);
		
		Eframe.getContentPane().add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3.add(Epanel3);
		GridBagLayout gbl_Epanel3 = new GridBagLayout();
		gbl_Epanel3.columnWidths = new int[]{64, 65, 0, 0};
		gbl_Epanel3.rowHeights = new int[]{346, 0};
		gbl_Epanel3.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Epanel3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		Epanel3.setLayout(gbl_Epanel3);
		
		
		EbtnOK.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_EbtnOK = new GridBagConstraints();
		gbc_EbtnOK.fill = GridBagConstraints.HORIZONTAL;
		gbc_EbtnOK.anchor = GridBagConstraints.SOUTHWEST;
		gbc_EbtnOK.insets = new Insets(0, 0, 0, 5);
		gbc_EbtnOK.gridx = 0;
		gbc_EbtnOK.gridy = 0;
		Epanel3.add(EbtnOK, gbc_EbtnOK);
		EbtnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_EbtnCancel = new GridBagConstraints();
		gbc_EbtnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_EbtnCancel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_EbtnCancel.gridx = 1;
		gbc_EbtnCancel.gridy = 0;
		Epanel3.add(EbtnCancel, gbc_EbtnCancel);
		
		Eframe.setVisible(true);
		
		EbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eframe.setVisible(false);
				Eframe.dispose();
				initializeEL();
			}
		});
		
		
	}
	
	
}

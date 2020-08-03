package CP317;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
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
		case "Orders":
			initializeO();
			break;
		case "OrderList":
			initializeOL();
			break;
		case "OrderItem":
			initializeOI();
			break;
		case "MenuList":
			initializeML();
			break;
		case "MenuItem":
			initializeMI();
			break;
		case "ReservationList":
			initializeRL();
			break;
		case "ReservationEdit":
			initializeRE();
			break;
		case "Tables":
			initializeT();
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
		
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.setVisible(false);
							frame.dispose();
							new GUI("Orders");
					
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.setVisible(false);
							frame.dispose();
							new GUI("MenuList");
					
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.setVisible(false);
							frame.dispose();
							new GUI("ReservationList");
					
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.setVisible(false);
							frame.dispose();
							new GUI("Tables");
					
							
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
	
	private JFrame Oframe;
	private final JList Olist = new JList();
	private final JLabel OlblOrders = new JLabel("Orders");
	private final JButton ObtnOK = new JButton("OK");
	private final JButton ObtnCancel = new JButton("Cancel");
	private final JButton ObtnNewOrder = new JButton("New Order");
	
	
	private void initializeO() {
		Oframe = new JFrame();
		Oframe.setBounds(100, 100, 786, 474);
		Oframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Oframe.getContentPane().setLayout(null);
		Olist.setBounds(322, 51, 420, 333);
		
		Oframe.getContentPane().add(Olist);
		OlblOrders.setBounds(360, 11, 48, 14);
		
		Oframe.getContentPane().add(OlblOrders);
		ObtnOK.setBounds(22, 369, 89, 23);
		
		Oframe.getContentPane().add(ObtnOK);
		ObtnCancel.setBounds(124, 369, 89, 23);
		
		Oframe.getContentPane().add(ObtnCancel);
		ObtnNewOrder.setBounds(80, 158, 148, 23);
		
		Oframe.getContentPane().add(ObtnNewOrder);
		
		
		ObtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oframe.setVisible(false);
				Oframe.dispose();
				initialize();
			}
		});
		
		ObtnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Oframe.setVisible(false);
							Oframe.dispose();
							new GUI("OrderList");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		Oframe.setVisible(true);
	}
	
	
	private JFrame OLframe;
	private final JList OLlist = new JList();
	private final JButton OLbtnAdd = new JButton("Add");
	private final JButton OLbtnRemove = new JButton("Remove");
	private final JButton OLbtnEdit = new JButton("Edit");
	private final JLabel OLlblOrders = new JLabel("Order");
	private final JButton OLbtnOK = new JButton("OK");
	private final JButton OLbtnCancel = new JButton("Cancel");
	private final JTextField OLtxtDiscount = new JTextField();
	private final JLabel OLlblDiscount = new JLabel("Discount");
	
	
	private void initializeOL() {
		OLtxtDiscount.setBounds(211, 287, 96, 20);
		OLtxtDiscount.setColumns(10);
		OLframe = new JFrame();
		OLframe.setBounds(100, 100, 786, 474);
		OLframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OLframe.getContentPane().setLayout(null);
		OLlist.setBounds(417, 51, 325, 333);
		
		OLframe.getContentPane().add(OLlist);
		OLbtnAdd.setBounds(167, 96, 89, 23);
		
		OLframe.getContentPane().add(OLbtnAdd);
		OLbtnRemove.setBounds(167, 158, 89, 23);
		
		OLframe.getContentPane().add(OLbtnRemove);
		OLbtnEdit.setBounds(167, 221, 89, 23);
		
		OLframe.getContentPane().add(OLbtnEdit);
		OLlblOrders.setBounds(360, 11, 48, 14);
		
		OLframe.getContentPane().add(OLlblOrders);
		OLbtnOK.setBounds(22, 369, 89, 23);
		
		OLframe.getContentPane().add(OLbtnOK);
		OLbtnCancel.setBounds(124, 369, 89, 23);
		
		OLframe.getContentPane().add(OLbtnCancel);
		
		OLframe.getContentPane().add(OLtxtDiscount);
		OLlblDiscount.setHorizontalAlignment(SwingConstants.TRAILING);
		OLlblDiscount.setBounds(87, 290, 89, 14);
		
		OLframe.getContentPane().add(OLlblDiscount);
		
		
		OLbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OLframe.setVisible(false);
				OLframe.dispose();
				initializeO();
			}
		});
		
		OLbtnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							OLframe.setVisible(false);
							OLframe.dispose();
							new GUI("OrderItem");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		OLframe.setVisible(true);
	}
	
	private JFrame OIframe;
	private final JPanel OIpanel = new JPanel();
	private final JPanel OIpanel1 = new JPanel();
	private final JLabel OIlblItem = new JLabel("Item");
	private final JTextField OItxtItem = new JTextField();
	private final JPanel OIpanel2 = new JPanel();
	private final JLabel OIlblOrder = new JLabel("Order Item");
	private final JPanel OIpanel3 = new JPanel();
	private final JLabel OIlblDiscount = new JLabel("Discount Offset");
	private final JTextField OItxtDiscount = new JTextField();
	private final JLabel OIlblSide = new JLabel("Side");
	private final JTextField OItxtSide = new JTextField();
	private final JLabel OIlblAllergy = new JLabel("Allergies");
	private final JTextField OItxtAllergy = new JTextField();
	private final JLabel OIlblNotes = new JLabel("Notes");
	private final JTextField OItxtNotes = new JTextField();
	private final JPanel OIpanel4 = new JPanel();
	private final JPanel OIpanel5 = new JPanel();
	private final JButton OIbtnCancel = new JButton("Cancel");
	private final JButton OIbtnOK = new JButton("OK");
	
	
	private void initializeOI() {
		OItxtNotes.setColumns(10);
		OItxtAllergy.setColumns(10);
		OItxtSide.setColumns(10);
		OIframe = new JFrame();
		OIframe.setBounds(100, 100, 684, 426);
		OIframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		OIframe.getContentPane().add(OIpanel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{169, 169, 0};
		gbl_panel.rowHeights = new int[]{237, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		OIpanel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		OIpanel.add(OIpanel1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{17, 169, 0};
		gbl_panel_1.rowHeights = new int[]{10, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		OIpanel1.setLayout(gbl_panel_1);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		OIpanel1.add(OIlblItem, gbc_lblNewLabel);
		GridBagConstraints gbc_OItxtItem = new GridBagConstraints();
		gbc_OItxtItem.insets = new Insets(0, 0, 5, 0);
		gbc_OItxtItem.fill = GridBagConstraints.BOTH;
		gbc_OItxtItem.gridx = 1;
		gbc_OItxtItem.gridy = 2;
		OIpanel1.add(OItxtItem, gbc_OItxtItem);
		OItxtItem.setColumns(10);
		
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		OIpanel1.add(OIlblSide, gbc_lblNewLabel_3);
		
		GridBagConstraints gbc_OItxtSide = new GridBagConstraints();
		gbc_OItxtSide.insets = new Insets(0, 0, 5, 0);
		gbc_OItxtSide.fill = GridBagConstraints.HORIZONTAL;
		gbc_OItxtSide.gridx = 1;
		gbc_OItxtSide.gridy = 5;
		OIpanel1.add(OItxtSide, gbc_OItxtSide);
		
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		OIpanel1.add(OIlblAllergy, gbc_lblNewLabel_4);
		
		GridBagConstraints gbc_OItxtAllergy = new GridBagConstraints();
		gbc_OItxtAllergy.insets = new Insets(0, 0, 5, 0);
		gbc_OItxtAllergy.fill = GridBagConstraints.HORIZONTAL;
		gbc_OItxtAllergy.gridx = 1;
		gbc_OItxtAllergy.gridy = 8;
		OIpanel1.add(OItxtAllergy, gbc_OItxtAllergy);
		
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 1;
		gbc_panel_1_1.gridy = 0;
		OIpanel.add(OIpanel3, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{0, 169, 0};
		gbl_panel_1_1.rowHeights = new int[]{14, 0, 20, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		OIpanel3.setLayout(gbl_panel_1_1);
		
		GridBagConstraints gbc_OIlblDiscount = new GridBagConstraints();
		gbc_OIlblDiscount.anchor = GridBagConstraints.WEST;
		gbc_OIlblDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_OIlblDiscount.gridx = 1;
		gbc_OIlblDiscount.gridy = 1;
		OIpanel3.add(OIlblDiscount, gbc_OIlblDiscount);
		
		GridBagConstraints gbc_OItxtDiscount = new GridBagConstraints();
		gbc_OItxtDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_OItxtDiscount.fill = GridBagConstraints.BOTH;
		gbc_OItxtDiscount.gridx = 1;
		gbc_OItxtDiscount.gridy = 2;
		OItxtDiscount.setColumns(10);
		OIpanel3.add(OItxtDiscount, gbc_OItxtDiscount);
		
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 4;
		OIpanel3.add(OIlblNotes, gbc_lblNewLabel_7);
		
		GridBagConstraints gbc_OItxtNotes = new GridBagConstraints();
		gbc_OItxtNotes.gridheight = 3;
		gbc_OItxtNotes.insets = new Insets(0, 0, 5, 0);
		gbc_OItxtNotes.fill = GridBagConstraints.BOTH;
		gbc_OItxtNotes.gridx = 1;
		gbc_OItxtNotes.gridy = 5;
		OIpanel3.add(OItxtNotes, gbc_OItxtNotes);
		
		OIframe.getContentPane().add(OIpanel2, BorderLayout.NORTH);
		
		OIpanel2.add(OIlblOrder);
		
		OIframe.getContentPane().add(OIpanel4, BorderLayout.EAST);
		OIpanel4.setLayout(new GridLayout(0, 1, 0, 0));
		
		OIpanel4.add(OIpanel5);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{64, 65, 0, 0};
		gbl_panel_4.rowHeights = new int[]{346, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		OIpanel5.setLayout(gbl_panel_4);
		OIbtnOK.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_OIbtnOK = new GridBagConstraints();
		gbc_OIbtnOK.fill = GridBagConstraints.HORIZONTAL;
		gbc_OIbtnOK.anchor = GridBagConstraints.SOUTHWEST;
		gbc_OIbtnOK.insets = new Insets(0, 0, 0, 5);
		gbc_OIbtnOK.gridx = 0;
		gbc_OIbtnOK.gridy = 0;
		OIpanel5.add(OIbtnOK, gbc_OIbtnOK);
		OIbtnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_OIbtnCancel = new GridBagConstraints();
		gbc_OIbtnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_OIbtnCancel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_OIbtnCancel.gridx = 1;
		gbc_OIbtnCancel.gridy = 0;
		OIpanel5.add(OIbtnCancel, gbc_OIbtnCancel);
		
		
		OIbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OIframe.setVisible(false);
				OIframe.dispose();
				initializeOL();
			}
		});
		
		
		
		
		OIframe.setVisible(true);
	}
	
	
	private JFrame MLframe;
	private final JList MLlist = new JList();
	private final JButton MLbtnAdd = new JButton("Add");
	private final JButton MLbtnRemove = new JButton("Remove");
	private final JButton MLbtnEdit = new JButton("Edit");
	private final JLabel MLlblMenu = new JLabel("Menu");
	private final JButton MLbtnOK = new JButton("OK");
	private final JButton MLbtnCancel = new JButton("Cancel");
	
	
	private void initializeML() {
		MLframe = new JFrame();
		MLframe.setBounds(100, 100, 786, 474);
		MLframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MLframe.getContentPane().setLayout(null);
		MLlist.setBounds(417, 51, 325, 333);
		
		MLframe.getContentPane().add(MLlist);
		MLbtnAdd.setBounds(166, 132, 89, 23);
		
		MLframe.getContentPane().add(MLbtnAdd);
		MLbtnRemove.setBounds(166, 194, 89, 23);
		
		MLframe.getContentPane().add(MLbtnRemove);
		MLbtnEdit.setBounds(166, 257, 89, 23);
		
		MLframe.getContentPane().add(MLbtnEdit);
		MLlblMenu.setBounds(360, 11, 48, 14);
		
		MLframe.getContentPane().add(MLlblMenu);
		MLbtnOK.setBounds(22, 369, 89, 23);
		
		MLframe.getContentPane().add(MLbtnOK);
		MLbtnCancel.setBounds(124, 369, 89, 23);
		
		MLframe.getContentPane().add(MLbtnCancel);
		
		
		MLbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MLframe.setVisible(false);
				MLframe.dispose();
				initialize();
			}
		});
		
		MLbtnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MLframe.setVisible(false);
							MLframe.dispose();
							new GUI("MenuItem");
					
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		MLframe.setVisible(true);
	}
	
	
	private JFrame MIframe;
	private final JLabel MIlblMenuItem = new JLabel("Menu Item");
	private final JLabel MIlblName = new JLabel("Name");
	private final JTextField MItxtName = new JTextField();
	private final JLabel MIlblPrice = new JLabel("Price");
	private final JTextField MItxtPrice = new JTextField();
	private final JButton MIbtnOK = new JButton("OK");
	private final JButton MIbtnCancel = new JButton("Cancel");
	
	
	private void initializeMI() {
		MItxtPrice.setBounds(23, 145, 96, 20);
		MItxtPrice.setColumns(10);
		MItxtName.setBounds(23, 89, 96, 20);
		MItxtName.setColumns(10);
		MIframe = new JFrame();
		MIframe.setBounds(100, 100, 450, 300);
		MIframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MIframe.getContentPane().setLayout(null);
		MIlblMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MIlblMenuItem.setBounds(23, 25, 101, 30);
		
		MIframe.getContentPane().add(MIlblMenuItem);
		MIlblName.setBounds(23, 73, 48, 14);
		
		MIframe.getContentPane().add(MIlblName);
		
		MIframe.getContentPane().add(MItxtName);
		MIlblPrice.setBounds(23, 130, 48, 14);
		
		MIframe.getContentPane().add(MIlblPrice);
		
		MIframe.getContentPane().add(MItxtPrice);
		MIbtnOK.setBounds(236, 216, 89, 23);
		
		MIframe.getContentPane().add(MIbtnOK);
		MIbtnCancel.setBounds(335, 216, 89, 23);
		
		MIframe.getContentPane().add(MIbtnCancel);
		
		
		MIbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MIframe.setVisible(false);
				MIframe.dispose();
				initializeML();
			}
		});
		
		MIframe.setVisible(true);
	}
	
	
	private JFrame RLframe;
	private final JList RLlist = new JList();
	private final JButton RLbtnAdd = new JButton("Add");
	private final JButton RLbtnRemove = new JButton("Remove");
	private final JButton RLbtnEdit = new JButton("Edit");
	private final JLabel RLlblReservation = new JLabel("Reservation");
	private final JButton RLbtnOK = new JButton("OK");
	private final JButton RLbtnCancel = new JButton("Cancel");
	
	
	private void initializeRL() {
		RLframe = new JFrame();
		RLframe.setBounds(100, 100, 786, 474);
		RLframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RLframe.getContentPane().setLayout(null);
		RLlist.setBounds(417, 51, 325, 333);
		
		RLframe.getContentPane().add(RLlist);
		RLbtnAdd.setBounds(166, 132, 89, 23);
		
		RLframe.getContentPane().add(RLbtnAdd);
		RLbtnRemove.setBounds(166, 194, 89, 23);
		
		RLframe.getContentPane().add(RLbtnRemove);
		RLbtnEdit.setBounds(166, 257, 89, 23);
		
		RLframe.getContentPane().add(RLbtnEdit);
		RLlblReservation.setBounds(351, 11, 67, 14);
		
		RLframe.getContentPane().add(RLlblReservation);
		RLbtnOK.setBounds(22, 369, 89, 23);
		
		RLframe.getContentPane().add(RLbtnOK);
		RLbtnCancel.setBounds(124, 369, 89, 23);
		
		RLframe.getContentPane().add(RLbtnCancel);
		
		
		RLbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RLframe.setVisible(false);
				RLframe.dispose();
				initialize();
			}
		});
		
		
		RLbtnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RLframe.setVisible(false);
							RLframe.dispose();
							new GUI("ReservationEdit");
					
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		RLframe.setVisible(true);
	}
	
	
	private JFrame REframe;
	private final JPanel REpanel = new JPanel();
	private final JPanel REpanel1 = new JPanel();
	private final JLabel RElblName = new JLabel("Name");
	private final JTextField REtxtName = new JTextField();
	private final JPanel REpanel2 = new JPanel();
	private final JLabel RElblReservation = new JLabel("Reservation");
	private final JPanel REpanel3 = new JPanel();
	private final JLabel RElblDate = new JLabel("Date");
	private final JTextField REtxtDate = new JTextField();
	private final JLabel RElblEmail = new JLabel("Email");
	private final JTextField REtxtEmail = new JTextField();
	private final JLabel RElblPhone = new JLabel("Phone Number");
	private final JTextField REtxtPhone = new JTextField();
	private final JLabel RElblPeople = new JLabel("# of People");
	private final JTextField REtxtPeople = new JTextField();
	private final JLabel RElblTime = new JLabel("Time");
	private final JTextField REtxtTime = new JTextField();
	private final JLabel RElblNotes = new JLabel("Notes");
	private final JTextField REtxtNotes = new JTextField();
	private final JPanel REpanel4 = new JPanel();
	private final JPanel REpanel5 = new JPanel();
	private final JButton REbtnCancel = new JButton("Cancel");
	private final JButton REbtnOK = new JButton("OK");
	
	
	private void initializeRE() {
		REtxtNotes.setColumns(10);
		REtxtTime.setColumns(10);
		REtxtPeople.setColumns(10);
		REtxtPhone.setColumns(10);
		REtxtEmail.setColumns(10);
		REframe = new JFrame();
		REframe.setBounds(100, 100, 684, 426);
		REframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		REframe.getContentPane().add(REpanel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{169, 169, 0};
		gbl_panel.rowHeights = new int[]{237, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		REpanel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		REpanel.add(REpanel1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{17, 169, 0};
		gbl_panel_1.rowHeights = new int[]{10, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		REpanel1.setLayout(gbl_panel_1);
		
		GridBagConstraints gbc_RElblName = new GridBagConstraints();
		gbc_RElblName.anchor = GridBagConstraints.WEST;
		gbc_RElblName.insets = new Insets(0, 0, 5, 0);
		gbc_RElblName.gridx = 1;
		gbc_RElblName.gridy = 1;
		REpanel1.add(RElblName, gbc_RElblName);
		GridBagConstraints gbc_REtxtName = new GridBagConstraints();
		gbc_REtxtName.insets = new Insets(0, 0, 5, 0);
		gbc_REtxtName.fill = GridBagConstraints.BOTH;
		gbc_REtxtName.gridx = 1;
		gbc_REtxtName.gridy = 2;
		REpanel1.add(REtxtName, gbc_REtxtName);
		REtxtName.setColumns(10);
		
		GridBagConstraints gbc_RElblEmail = new GridBagConstraints();
		gbc_RElblEmail.anchor = GridBagConstraints.WEST;
		gbc_RElblEmail.insets = new Insets(0, 0, 5, 0);
		gbc_RElblEmail.gridx = 1;
		gbc_RElblEmail.gridy = 4;
		REpanel1.add(RElblEmail, gbc_RElblEmail);
		
		GridBagConstraints gbc_REtxtEmail = new GridBagConstraints();
		gbc_REtxtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_REtxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_REtxtEmail.gridx = 1;
		gbc_REtxtEmail.gridy = 5;
		REpanel1.add(REtxtEmail, gbc_REtxtEmail);
		
		GridBagConstraints gbc_RElblPhone = new GridBagConstraints();
		gbc_RElblPhone.anchor = GridBagConstraints.WEST;
		gbc_RElblPhone.insets = new Insets(0, 0, 5, 0);
		gbc_RElblPhone.gridx = 1;
		gbc_RElblPhone.gridy = 7;
		REpanel1.add(RElblPhone, gbc_RElblPhone);
		
		GridBagConstraints gbc_REtxtPhone = new GridBagConstraints();
		gbc_REtxtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_REtxtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_REtxtPhone.gridx = 1;
		gbc_REtxtPhone.gridy = 8;
		REpanel1.add(REtxtPhone, gbc_REtxtPhone);
		
		GridBagConstraints gbc_RElblPeople = new GridBagConstraints();
		gbc_RElblPeople.anchor = GridBagConstraints.WEST;
		gbc_RElblPeople.insets = new Insets(0, 0, 5, 0);
		gbc_RElblPeople.gridx = 1;
		gbc_RElblPeople.gridy = 10;
		REpanel1.add(RElblPeople, gbc_RElblPeople);
		
		GridBagConstraints gbc_REtxtPeople = new GridBagConstraints();
		gbc_REtxtPeople.insets = new Insets(0, 0, 5, 0);
		gbc_REtxtPeople.fill = GridBagConstraints.HORIZONTAL;
		gbc_REtxtPeople.gridx = 1;
		gbc_REtxtPeople.gridy = 11;
		REpanel1.add(REtxtPeople, gbc_REtxtPeople);
		
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 1;
		gbc_panel_1_1.gridy = 0;
		REpanel.add(REpanel3, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{0, 169, 0};
		gbl_panel_1_1.rowHeights = new int[]{14, 0, 20, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		REpanel3.setLayout(gbl_panel_1_1);
		
		GridBagConstraints gbc_RElblDate = new GridBagConstraints();
		gbc_RElblDate.anchor = GridBagConstraints.WEST;
		gbc_RElblDate.insets = new Insets(0, 0, 5, 0);
		gbc_RElblDate.gridx = 1;
		gbc_RElblDate.gridy = 1;
		REpanel3.add(RElblDate, gbc_RElblDate);
		
		GridBagConstraints gbc_REtxtDate = new GridBagConstraints();
		gbc_REtxtDate.insets = new Insets(0, 0, 5, 0);
		gbc_REtxtDate.fill = GridBagConstraints.BOTH;
		gbc_REtxtDate.gridx = 1;
		gbc_REtxtDate.gridy = 2;
		REtxtDate.setColumns(10);
		REpanel3.add(REtxtDate, gbc_REtxtDate);
		
		GridBagConstraints gbc_RElblTime = new GridBagConstraints();
		gbc_RElblTime.anchor = GridBagConstraints.WEST;
		gbc_RElblTime.insets = new Insets(0, 0, 5, 0);
		gbc_RElblTime.gridx = 1;
		gbc_RElblTime.gridy = 4;
		REpanel3.add(RElblTime, gbc_RElblTime);
		
		GridBagConstraints gbc_REtxtTime = new GridBagConstraints();
		gbc_REtxtTime.insets = new Insets(0, 0, 5, 0);
		gbc_REtxtTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_REtxtTime.gridx = 1;
		gbc_REtxtTime.gridy = 5;
		REpanel3.add(REtxtTime, gbc_REtxtTime);
		
		GridBagConstraints gbc_RElblNotes = new GridBagConstraints();
		gbc_RElblNotes.anchor = GridBagConstraints.WEST;
		gbc_RElblNotes.insets = new Insets(0, 0, 5, 0);
		gbc_RElblNotes.gridx = 1;
		gbc_RElblNotes.gridy = 7;
		REpanel3.add(RElblNotes, gbc_RElblNotes);
		
		GridBagConstraints gbc_REtxtNotes = new GridBagConstraints();
		gbc_REtxtNotes.anchor = GridBagConstraints.NORTH;
		gbc_REtxtNotes.fill = GridBagConstraints.HORIZONTAL;
		gbc_REtxtNotes.gridx = 1;
		gbc_REtxtNotes.gridy = 8;
		REpanel3.add(REtxtNotes, gbc_REtxtNotes);
		
		REframe.getContentPane().add(REpanel2, BorderLayout.NORTH);
		
		REpanel2.add(RElblReservation);
		
		REframe.getContentPane().add(REpanel4, BorderLayout.EAST);
		REpanel4.setLayout(new GridLayout(0, 1, 0, 0));
		
		REpanel4.add(REpanel5);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{64, 65, 0, 0};
		gbl_panel_4.rowHeights = new int[]{346, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		REpanel5.setLayout(gbl_panel_4);
		REbtnOK.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_REbtnOK = new GridBagConstraints();
		gbc_REbtnOK.fill = GridBagConstraints.HORIZONTAL;
		gbc_REbtnOK.anchor = GridBagConstraints.SOUTHWEST;
		gbc_REbtnOK.insets = new Insets(0, 0, 0, 5);
		gbc_REbtnOK.gridx = 0;
		gbc_REbtnOK.gridy = 0;
		REpanel5.add(REbtnOK, gbc_REbtnOK);
		REbtnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_REbtnCancel = new GridBagConstraints();
		gbc_REbtnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_REbtnCancel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_REbtnCancel.gridx = 1;
		gbc_REbtnCancel.gridy = 0;
		REpanel5.add(REbtnCancel, gbc_REbtnCancel);
		
		
		REbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				REframe.setVisible(false);
				REframe.dispose();
				initializeRL();
			}
		});
		
		
		
		REframe.setVisible(true);
	}
	
	
	private JFrame Tframe;
	private final JToggleButton Ttgl1 = new JToggleButton("1");
	private final JToggleButton Ttgl2 = new JToggleButton("2");
	private final JToggleButton Ttgl3 = new JToggleButton("3");
	private final JToggleButton Ttgl4 = new JToggleButton("4");
	private final JToggleButton Ttgl5 = new JToggleButton("5");
	private final JToggleButton Ttgl6 = new JToggleButton("6");
	private final JToggleButton Ttgl7 = new JToggleButton("7");
	private final JToggleButton Ttgl8 = new JToggleButton("8");
	private final JToggleButton Ttgl9 = new JToggleButton("9");
	private final JToggleButton Ttgl10 = new JToggleButton("10");
	private final JToggleButton Ttgl11 = new JToggleButton("11");
	private final JToggleButton Ttgl12 = new JToggleButton("12");
	private final JLabel TlblTables = new JLabel("Tables");
	private final JButton TbtnReady = new JButton("Ready");
	private final JButton TbtnDirty = new JButton("Dirty");
	private final JButton TbtnBusy = new JButton("Busy");
	private final JButton TbtnOk = new JButton("OK");
	private final JButton TbtnCancel = new JButton("Cancel");
	
	
	private void initializeT() {
		Tframe = new JFrame();
		Tframe.setBounds(100, 100, 764, 433);
		Tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tframe.getContentPane().setLayout(null);
		Ttgl1.setOpaque(true);
		Ttgl1.setBackground(Color.RED);
		Ttgl1.setBounds(47, 88, 123, 40);
		
		Tframe.getContentPane().add(Ttgl1);
		Ttgl2.setOpaque(true);
		Ttgl2.setBackground(Color.RED);
		Ttgl2.setBounds(193, 88, 123, 40);
		
		Tframe.getContentPane().add(Ttgl2);
		Ttgl3.setBackground(Color.GREEN);
		Ttgl3.setOpaque(true);
		Ttgl3.setBounds(341, 88, 123, 40);
		
		Tframe.getContentPane().add(Ttgl3);
		Ttgl4.setBackground(Color.GREEN);
		Ttgl4.setOpaque(true);
		Ttgl4.setBounds(47, 149, 123, 40);
		
		Tframe.getContentPane().add(Ttgl4);
		Ttgl5.setBackground(Color.YELLOW);
		Ttgl5.setOpaque(true);
		Ttgl5.setBounds(193, 149, 123, 40);
		
		Tframe.getContentPane().add(Ttgl5);
		Ttgl6.setBackground(Color.RED);
		Ttgl6.setOpaque(true);
		Ttgl6.setBounds(341, 149, 123, 40);
		
		Tframe.getContentPane().add(Ttgl6);
		Ttgl7.setBackground(Color.GREEN);
		Ttgl7.setOpaque(true);
		Ttgl7.setBounds(47, 209, 123, 40);
		
		Tframe.getContentPane().add(Ttgl7);
		Ttgl8.setBackground(Color.GREEN);
		Ttgl8.setOpaque(true);
		Ttgl8.setBounds(193, 209, 123, 40);
		
		Tframe.getContentPane().add(Ttgl8);
		Ttgl9.setBackground(Color.GREEN);
		Ttgl9.setOpaque(true);
		Ttgl9.setBounds(341, 209, 123, 40);
		
		Tframe.getContentPane().add(Ttgl9);
		Ttgl10.setBackground(Color.RED);
		Ttgl10.setOpaque(true);
		Ttgl10.setBounds(47, 271, 123, 40);
		
		Tframe.getContentPane().add(Ttgl10);
		Ttgl11.setBackground(Color.YELLOW);
		Ttgl11.setOpaque(true);
		Ttgl11.setBounds(193, 271, 123, 40);
		
		Tframe.getContentPane().add(Ttgl11);
		Ttgl12.setBackground(Color.YELLOW);
		Ttgl12.setOpaque(true);
		Ttgl12.setBounds(341, 271, 123, 40);
		
		Tframe.getContentPane().add(Ttgl12);
		TlblTables.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TlblTables.setBounds(47, 31, 123, 25);
		
		Tframe.getContentPane().add(TlblTables);
		TbtnReady.setBackground(Color.GREEN);
		TbtnReady.setBounds(601, 88, 89, 23);
		
		Tframe.getContentPane().add(TbtnReady);
		TbtnDirty.setBackground(Color.YELLOW);
		TbtnDirty.setBounds(601, 127, 89, 23);
		
		Tframe.getContentPane().add(TbtnDirty);
		TbtnBusy.setBackground(Color.RED);
		TbtnBusy.setBounds(601, 166, 89, 23);
		
		Tframe.getContentPane().add(TbtnBusy);
		TbtnOk.setBounds(47, 346, 89, 23);
		
		Tframe.getContentPane().add(TbtnOk);
		TbtnCancel.setBounds(161, 346, 89, 23);
		
		Tframe.getContentPane().add(TbtnCancel);
		
		
		TbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tframe.setVisible(false);
				Tframe.dispose();
				initialize();
			}
		});
		
		
		Tframe.setVisible(true);
	}
	
}

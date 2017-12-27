
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MyProjectInfo {

	public JFrame frame;
	private JPanel pnl_task;
	private JLabel lbl_list;
	private JLabel lbl_calendar;
	private JPanel pnl_task_info;
	private JLabel lblName;
	private JLabel lblManager;
	private JLabel lblPriority;
	private JLabel lblState;
	private JLabel lblStart;
	private JLabel lblEnd;
	private JTextField textFieldName;
	private JTextField textFieldManager;
	private JButton btnEditar;
	private JButton btnDelete;
	private JTextField textFieldStart;
	private JTextField textFieldEnd;
	private JComboBox comboBoxPriority;
	private JComboBox comboBoxState;
	private JList list;
	private JPanel pnlAddTask;
	private JTextField txtName;
	private JTextField txtManager;
	private JLabel lblAdd_Name;
	private JLabel lblAdd_Manager;
	private JComboBox comboBox;
	private JLabel lblAdd_Priority;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label;
	private JLabel label_1;
	private JComboBox comboBox_1;
	private JLabel lblAnotation;
	private JTextPane textPane;
	private JScrollBar scrollBar;
	private JButton button;
	private JScrollPane scrollPane;
	private JLabel btnAdd1;
	private JLabel btnChat;
	private JLabel btnAdd2;
	private JLabel lblNewLabel;

	/**
	 * Create the application.
	 */
	public MyProjectInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{216, 277, 384, 0};
		gridBagLayout.rowHeights = new int[]{38, 41, 627, 13, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(getLblNewLabel(), gbc_lblNewLabel);
		GridBagConstraints gbc_btnChat = new GridBagConstraints();
		gbc_btnChat.anchor = GridBagConstraints.EAST;
		gbc_btnChat.insets = new Insets(0, 0, 5, 0);
		gbc_btnChat.gridx = 2;
		gbc_btnChat.gridy = 1;
		frame.getContentPane().add(getBtnChat(), gbc_btnChat);
		GridBagConstraints gbc_pnl_task = new GridBagConstraints();
		gbc_pnl_task.insets = new Insets(0, 0, 5, 5);
		gbc_pnl_task.fill = GridBagConstraints.BOTH;
		gbc_pnl_task.gridx = 0;
		gbc_pnl_task.gridy = 2;
		frame.getContentPane().add(getPanel_1(), gbc_pnl_task);
		GridBagConstraints gbc_pnl_task_info = new GridBagConstraints();
		gbc_pnl_task_info.fill = GridBagConstraints.BOTH;
		gbc_pnl_task_info.insets = new Insets(0, 0, 5, 5);
		gbc_pnl_task_info.gridx = 1;
		gbc_pnl_task_info.gridy = 2;
		frame.getContentPane().add(getPnl_task_info(), gbc_pnl_task_info);
		getPnl_task_info().setVisible(true);
		GridBagConstraints gbc_pnlAddTask = new GridBagConstraints();
		gbc_pnlAddTask.insets = new Insets(0, 0, 5, 0);
		gbc_pnlAddTask.fill = GridBagConstraints.BOTH;
		gbc_pnlAddTask.gridx = 2;
		gbc_pnlAddTask.gridy = 2;
		frame.getContentPane().add(getPnlAddTask(), gbc_pnlAddTask);
		GridBagConstraints gbc_btnAdd1 = new GridBagConstraints();
		gbc_btnAdd1.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd1.gridx = 0;
		gbc_btnAdd1.gridy = 3;
		frame.getContentPane().add(getBtnAdd1(), gbc_btnAdd1);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 2;
		gbc_button.gridy = 3;
		frame.getContentPane().add(getButton(), gbc_button);
		
	
	}
	private JPanel getPanel_1() {
		if (pnl_task == null) {
			pnl_task = new JPanel();
			GridBagLayout gbl_pnl_task = new GridBagLayout();
			gbl_pnl_task.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnl_task.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnl_task.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnl_task.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			pnl_task.setLayout(gbl_pnl_task);
			GridBagConstraints gbc_lbl_list = new GridBagConstraints();
			gbc_lbl_list.anchor = GridBagConstraints.WEST;
			gbc_lbl_list.insets = new Insets(0, 0, 5, 5);
			gbc_lbl_list.gridx = 0;
			gbc_lbl_list.gridy = 0;
			pnl_task.add(getLbl_list(), gbc_lbl_list);
			GridBagConstraints gbc_lbl_calendar = new GridBagConstraints();
			gbc_lbl_calendar.insets = new Insets(0, 0, 5, 0);
			gbc_lbl_calendar.gridx = 8;
			gbc_lbl_calendar.gridy = 0;
			pnl_task.add(getLbl_calendar(), gbc_lbl_calendar);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.gridwidth = 9;
			gbc_list.gridheight = 7;
			gbc_list.insets = new Insets(0, 0, 5, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 0;
			gbc_list.gridy = 1;
			pnl_task.add(getList(), gbc_list);
		}
		return pnl_task;
	}
	private JLabel getLbl_list() {
		if (lbl_list == null) {
			lbl_list = new JLabel("");
			lbl_list.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/list.png")));
		}
		return lbl_list;
	}
	private JLabel getLbl_calendar() {
		if (lbl_calendar == null) {
			lbl_calendar = new JLabel("");
			lbl_calendar.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/calendar.png")));
		}
		return lbl_calendar;
	}
	private JPanel getPnl_task_info() {
		if (pnl_task_info == null) {
			pnl_task_info = new JPanel();
			pnl_task_info.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			GridBagLayout gbl_pnl_task_info = new GridBagLayout();
			gbl_pnl_task_info.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnl_task_info.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnl_task_info.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnl_task_info.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			pnl_task_info.setLayout(gbl_pnl_task_info);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			pnl_task_info.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.gridwidth = 2;
			gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.gridx = 2;
			gbc_textFieldName.gridy = 1;
			pnl_task_info.add(getTextFieldName(), gbc_textFieldName);
			GridBagConstraints gbc_lblManager = new GridBagConstraints();
			gbc_lblManager.insets = new Insets(0, 0, 5, 5);
			gbc_lblManager.gridx = 1;
			gbc_lblManager.gridy = 4;
			pnl_task_info.add(getLblManager(), gbc_lblManager);
			GridBagConstraints gbc_textFieldManager = new GridBagConstraints();
			gbc_textFieldManager.gridwidth = 2;
			gbc_textFieldManager.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldManager.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldManager.gridx = 2;
			gbc_textFieldManager.gridy = 4;
			pnl_task_info.add(getTextFieldManager(), gbc_textFieldManager);
			GridBagConstraints gbc_lblPriority = new GridBagConstraints();
			gbc_lblPriority.fill = GridBagConstraints.VERTICAL;
			gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
			gbc_lblPriority.gridx = 1;
			gbc_lblPriority.gridy = 7;
			pnl_task_info.add(getLblPriority(), gbc_lblPriority);
			GridBagConstraints gbc_comboBoxPriority = new GridBagConstraints();
			gbc_comboBoxPriority.gridwidth = 2;
			gbc_comboBoxPriority.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxPriority.fill = GridBagConstraints.BOTH;
			gbc_comboBoxPriority.gridx = 2;
			gbc_comboBoxPriority.gridy = 7;
			pnl_task_info.add(getComboBoxPriority(), gbc_comboBoxPriority);
			GridBagConstraints gbc_lblState = new GridBagConstraints();
			gbc_lblState.insets = new Insets(0, 0, 5, 5);
			gbc_lblState.gridx = 1;
			gbc_lblState.gridy = 10;
			pnl_task_info.add(getLblState(), gbc_lblState);
			GridBagConstraints gbc_comboBoxState = new GridBagConstraints();
			gbc_comboBoxState.gridwidth = 2;
			gbc_comboBoxState.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxState.fill = GridBagConstraints.BOTH;
			gbc_comboBoxState.gridx = 2;
			gbc_comboBoxState.gridy = 10;
			pnl_task_info.add(getComboBoxState(), gbc_comboBoxState);
			GridBagConstraints gbc_lblStart = new GridBagConstraints();
			gbc_lblStart.fill = GridBagConstraints.VERTICAL;
			gbc_lblStart.insets = new Insets(0, 0, 5, 5);
			gbc_lblStart.gridx = 1;
			gbc_lblStart.gridy = 13;
			pnl_task_info.add(getLblStart(), gbc_lblStart);
			GridBagConstraints gbc_textFieldStart = new GridBagConstraints();
			gbc_textFieldStart.gridwidth = 2;
			gbc_textFieldStart.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldStart.fill = GridBagConstraints.BOTH;
			gbc_textFieldStart.gridx = 2;
			gbc_textFieldStart.gridy = 13;
			pnl_task_info.add(getTextFieldStart(), gbc_textFieldStart);
			GridBagConstraints gbc_lblEnd = new GridBagConstraints();
			gbc_lblEnd.fill = GridBagConstraints.VERTICAL;
			gbc_lblEnd.insets = new Insets(0, 0, 5, 5);
			gbc_lblEnd.gridx = 1;
			gbc_lblEnd.gridy = 16;
			pnl_task_info.add(getLblEnd(), gbc_lblEnd);
			GridBagConstraints gbc_textFieldEnd = new GridBagConstraints();
			gbc_textFieldEnd.gridwidth = 2;
			gbc_textFieldEnd.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldEnd.fill = GridBagConstraints.BOTH;
			gbc_textFieldEnd.gridx = 2;
			gbc_textFieldEnd.gridy = 16;
			pnl_task_info.add(getTextFieldEnd(), gbc_textFieldEnd);
			GridBagConstraints gbc_btnEditar = new GridBagConstraints();
			gbc_btnEditar.gridwidth = 2;
			gbc_btnEditar.gridheight = 2;
			gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
			gbc_btnEditar.gridx = 1;
			gbc_btnEditar.gridy = 18;
			pnl_task_info.add(getBtnEditar(), gbc_btnEditar);
			GridBagConstraints gbc_btnDelete = new GridBagConstraints();
			gbc_btnDelete.gridwidth = 2;
			gbc_btnDelete.gridheight = 2;
			gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
			gbc_btnDelete.gridx = 3;
			gbc_btnDelete.gridy = 18;
			pnl_task_info.add(getBtnDelete(), gbc_btnDelete);
			
		
		}
		return pnl_task_info;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
		}
		return lblName;
	}
	private JLabel getLblManager() {
		if (lblManager == null) {
			lblManager = new JLabel("Manager:");
		}
		return lblManager;
	}
	private JLabel getLblPriority() {
		if (lblPriority == null) {
			lblPriority = new JLabel("Priority:");
		}
		return lblPriority;
	}
	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel("State:");
		}
		return lblState;
	}
	private JLabel getLblStart() {
		if (lblStart == null) {
			lblStart = new JLabel("Start:");
		}
		return lblStart;
	}
	private JLabel getLblEnd() {
		if (lblEnd == null) {
			lblEnd = new JLabel("End:");
		}
		return lblEnd;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private JTextField getTextFieldManager() {
		if (textFieldManager == null) {
			textFieldManager = new JTextField();
			textFieldManager.setColumns(10);
		}
		return textFieldManager;
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Edit");
		}
		return btnEditar;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
		}
		return btnDelete;
	}
	
	private JTextField getTextFieldStart() {
		
		if (textFieldStart == null) {
			textFieldStart = new JTextField();
			textFieldStart.setColumns(10);
		}
		return textFieldStart;
	}
	private JTextField getTextFieldEnd() {
		if (textFieldEnd == null) {
			textFieldEnd = new JTextField();
			textFieldEnd.setColumns(10);
		}
		return textFieldEnd;
	}
	private JComboBox getComboBoxPriority() {
		if (comboBoxPriority == null) {
			comboBoxPriority = new JComboBox();
			comboBoxPriority.setModel(new DefaultComboBoxModel(new String[] {"Low", "Medium", "High"}));
		}
		return comboBoxPriority;
	}
	private JComboBox getComboBoxState() {
		if (comboBoxState == null) {
			comboBoxState = new JComboBox();
		}
		return comboBoxState;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Task One", "Task Two", "Task Three"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return list;
	}
	private void jList1MouseClicked(java.awt.event.MouseEvent evt) {

	    Object sel =null;

	    int[] selectedIx = this.list.getSelectedIndices();      

	    for (int i = 0; i < selectedIx.length; i++) {
	        sel = list.getModel().getElementAt(selectedIx[i]);
	    }

	    System.out.println("Selectionado "+sel);
	}
	
	private JPanel getPnlAddTask() {
		if (pnlAddTask == null) {
			pnlAddTask = new JPanel();
			pnlAddTask.setBorder(new TitledBorder(null, "Add Task", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagLayout gbl_pnlAddTask = new GridBagLayout();
			gbl_pnlAddTask.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlAddTask.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlAddTask.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_pnlAddTask.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			pnlAddTask.setLayout(gbl_pnlAddTask);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 5;
			gbc_scrollPane.gridwidth = 5;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 1;
			pnlAddTask.add(getScrollPane(), gbc_scrollPane);
			GridBagConstraints gbc_btnAdd2 = new GridBagConstraints();
			gbc_btnAdd2.anchor = GridBagConstraints.EAST;
			gbc_btnAdd2.insets = new Insets(0, 0, 5, 0);
			gbc_btnAdd2.gridx = 6;
			gbc_btnAdd2.gridy = 3;
			pnlAddTask.add(getBtnAdd2(), gbc_btnAdd2);
			GridBagConstraints gbc_scrollBar = new GridBagConstraints();
			gbc_scrollBar.fill = GridBagConstraints.HORIZONTAL;
			gbc_scrollBar.gridwidth = 5;
			gbc_scrollBar.insets = new Insets(0, 0, 5, 5);
			gbc_scrollBar.gridx = 1;
			gbc_scrollBar.gridy = 6;
			pnlAddTask.add(getScrollBar_1(), gbc_scrollBar);
			GridBagConstraints gbc_lblAdd_Name = new GridBagConstraints();
			gbc_lblAdd_Name.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdd_Name.gridx = 1;
			gbc_lblAdd_Name.gridy = 9;
			pnlAddTask.add(getLblAdd_Name(), gbc_lblAdd_Name);
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 5;
			gbc_txtName.gridy = 9;
			pnlAddTask.add(getTxtName(), gbc_txtName);
			GridBagConstraints gbc_lblAdd_Manager = new GridBagConstraints();
			gbc_lblAdd_Manager.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdd_Manager.gridx = 1;
			gbc_lblAdd_Manager.gridy = 12;
			pnlAddTask.add(getLblAdd_Manager(), gbc_lblAdd_Manager);
			GridBagConstraints gbc_txtManager = new GridBagConstraints();
			gbc_txtManager.insets = new Insets(0, 0, 5, 5);
			gbc_txtManager.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtManager.gridx = 5;
			gbc_txtManager.gridy = 12;
			pnlAddTask.add(getTxtManager(), gbc_txtManager);
			GridBagConstraints gbc_lblAdd_Priority = new GridBagConstraints();
			gbc_lblAdd_Priority.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdd_Priority.gridx = 1;
			gbc_lblAdd_Priority.gridy = 14;
			pnlAddTask.add(getLblAdd_Priority(), gbc_lblAdd_Priority);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 5;
			gbc_comboBox.gridy = 14;
			pnlAddTask.add(getComboBox(), gbc_comboBox);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 16;
			pnlAddTask.add(getLabel(), gbc_label);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 5;
			gbc_textField.gridy = 16;
			pnlAddTask.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 18;
			pnlAddTask.add(getLabel_1(), gbc_label_1);
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 5;
			gbc_textField_1.gridy = 18;
			pnlAddTask.add(getTextField_1(), gbc_textField_1);
			GridBagConstraints gbc_lblAnotation = new GridBagConstraints();
			gbc_lblAnotation.insets = new Insets(0, 0, 5, 5);
			gbc_lblAnotation.gridx = 1;
			gbc_lblAnotation.gridy = 20;
			pnlAddTask.add(getLblAnotation(), gbc_lblAnotation);
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 5;
			gbc_comboBox_1.gridy = 20;
			pnlAddTask.add(getComboBox_1(), gbc_comboBox_1);
			GridBagConstraints gbc_textPane = new GridBagConstraints();
			gbc_textPane.gridwidth = 6;
			gbc_textPane.fill = GridBagConstraints.BOTH;
			gbc_textPane.gridx = 1;
			gbc_textPane.gridy = 21;
			pnlAddTask.add(getTextPane(), gbc_textPane);
		}
		return pnlAddTask;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setColumns(10);
		}
		return txtName;
	}
	private JTextField getTxtManager() {
		if (txtManager == null) {
			txtManager = new JTextField();
			txtManager.setColumns(10);
		}
		return txtManager;
	}
	private JLabel getLblAdd_Name() {
		if (lblAdd_Name == null) {
			lblAdd_Name = new JLabel("Name:");
		}
		return lblAdd_Name;
	}
	private JLabel getLblAdd_Manager() {
		if (lblAdd_Manager == null) {
			lblAdd_Manager = new JLabel("Manager:");
		}
		return lblAdd_Manager;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Low", "Medium", "High"}));
		}
		return comboBox;
	}
	private JLabel getLblAdd_Priority() {
		if (lblAdd_Priority == null) {
			lblAdd_Priority = new JLabel("Priority:");
		}
		return lblAdd_Priority;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Start:");
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("End:");
		}
		return label_1;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
		}
		return comboBox_1;
	}
	private JLabel getLblAnotation() {
		if (lblAnotation == null) {
			lblAnotation = new JLabel("Anotation: ");
		}
		return lblAnotation;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
		}
		return textPane;
	}
	private JScrollBar getScrollBar_1() {
		if (scrollBar == null) {
			scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		}
		return scrollBar;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Añadir");
		}
		return button;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
		}
		return scrollPane;
	}
	private JLabel getBtnAdd1() {
		if (btnAdd1 == null) {
			btnAdd1 = new JLabel("");
			btnAdd1.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/addButton.png")));
		}
		return btnAdd1;
	}
	private JLabel getBtnChat() {
		if (btnChat == null) {
			btnChat = new JLabel("");
			btnChat.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/icon_chat.png")));
			btnChat.addMouseListener(new BtnChatListener());
		}
		return btnChat;
	}
	private JLabel getBtnAdd2() {
		if (btnAdd2 == null) {
			btnAdd2 = new JLabel("");
			btnAdd2.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/addButton.png")));
		}
		return btnAdd2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/task.png")));
		}
		return lblNewLabel;
	}

	private class BtnChatListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent event) {
			Chat window = new Chat();
			window.frame.setVisible(true);
		}
	}

}
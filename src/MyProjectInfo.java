import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.text.SimpleDateFormat;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.MutableComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;


public class MyProjectInfo {

	public JFrame frame;
	private JPanel pnl_task;
	private JLabel lbl_list;
	private JLabel lbl_calendar;
	private JList list;
	private JPanel pnlAddTask;
	private JTextField txtName;
	private JTextField txtManager;
	private JLabel lblAdd_Name;
	private JLabel lblAdd_Manager;
	private JComboBox comboBoxPriorityAdd;
	private JLabel lblAdd_Priority;
	private JLabel label;
	private JLabel label_1;
	private JComboBox comboBoxStateAdd;
	private JLabel lblStateAdd;
	private JTextPane textPaneAnotation;
	private JScrollBar scrollBar;
	private JButton button;
	private JScrollPane scrollPane;
	private JLabel btnAddTask;
	private JLabel btnChat;
	private JLabel btnAddImage;
	private JLabel lbimagetask;
	private JSONArray tasks;
	private JSONObject obj;
	private JLabel lblAnotation;
	private JLayeredPane layeredPane;
	private JPanel pnl_botonera;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnModify;
	private int index;
	private JLabel imgScroll1;
	private JLabel imgScroll2;
	private JLabel imgScroll3;
	private JLabel labelImageTask1;
	private JLabel labelScroll1;
	private String path, strDateStart,strDateEnd;
	private Date dateStart, dateEnd;
	private JDateChooser dateChooserStart;
	private JDateChooser dateChooserEnd;

	/**
	 * Create the application.
	 */
	public MyProjectInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void updateList(){
		try {
			StringBuilder sb = new StringBuilder();

		    String line;
		    BufferedReader br = new BufferedReader(new FileReader("/Users/bersus96/Dropbox/Mi trabajo de eclipse/IPOProject/src/data.json"));
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
			obj = new JSONObject(sb.toString());
			tasks = obj.getJSONArray("tasks");
		
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initialize() {
		updateList();
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{216, 277, 384, 0};
		gridBagLayout.rowHeights = new int[]{38, 41, 627, 13, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lbimagetask = new GridBagConstraints();
		gbc_lbimagetask.gridheight = 2;
		gbc_lbimagetask.insets = new Insets(0, 0, 5, 5);
		gbc_lbimagetask.gridx = 0;
		gbc_lbimagetask.gridy = 0;
		frame.getContentPane().add(getLbimagetask(), gbc_lbimagetask);
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
		GridBagConstraints gbc_pnlAddTask = new GridBagConstraints();
		gbc_pnlAddTask.gridwidth = 2;
		gbc_pnlAddTask.insets = new Insets(0, 0, 5, 0);
		gbc_pnlAddTask.fill = GridBagConstraints.BOTH;
		gbc_pnlAddTask.gridx = 1;
		gbc_pnlAddTask.gridy = 2;
		frame.getContentPane().add(getPnlAddTask(), gbc_pnlAddTask);
		GridBagConstraints gbc_btnAddTask = new GridBagConstraints();
		gbc_btnAddTask.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddTask.gridx = 0;
		gbc_btnAddTask.gridy = 3;
		frame.getContentPane().add(getBtnAddTask(), gbc_btnAddTask);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		GridBagConstraints gbc_pnl_botonera = new GridBagConstraints();
		gbc_pnl_botonera.gridwidth = 2;
		gbc_pnl_botonera.fill = GridBagConstraints.BOTH;
		gbc_pnl_botonera.gridx = 1;
		gbc_pnl_botonera.gridy = 3;
		frame.getContentPane().add(getPnl_botonera(), gbc_pnl_botonera);
		pnlAddTask.setVisible(false);
		btnModify.setVisible(false);
		btnDelete.setVisible(false);
		btnAdd.setVisible(false);
		
		
	
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
	private JList getList() {
		updateList();
		if (list == null) {
			ArrayList<String> values = new ArrayList<String>(); 
		
			list = new JList();
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						btnModify.setVisible(true);
						btnDelete.setVisible(true);
						btnAdd.setVisible(false);
						pnlAddTask.setBorder(new TitledBorder(null, "Task Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						pnlAddTask.setVisible(true);
						index = list.locationToIndex(e.getPoint());
				        try {
							txtName.setText(tasks.getJSONObject(index).getString("name"));
							txtManager.setText(tasks.getJSONObject(index).getString("manager"));
							Date dateStart = new SimpleDateFormat("MMM dd, yyyy").parse(tasks.getJSONObject(index).getString("start"));
							dateChooserStart.setDate(dateStart);
							Date dateEnd = new SimpleDateFormat("MMM dd, yyyy").parse(tasks.getJSONObject(index).getString("end"));
							dateChooserEnd.setDate(dateEnd);
							textPaneAnotation.setText(tasks.getJSONObject(index).getString("anotation"));
							comboBoxPriorityAdd.setSelectedIndex(tasks.getJSONObject(index).getInt("priority"));
							comboBoxStateAdd.setSelectedIndex(tasks.getJSONObject(index).getInt("state"));
						} catch (JSONException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
				}
			});			
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			try {
				for (int i = 0; i < tasks.length(); i++) {
					String task_x = tasks.getJSONObject(i).getString("name");
					values.add(task_x);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			list.setModel(new AbstractListModel() {	
				public int getSize() {					
					return values.size();
				}
				public Object getElementAt(int index) {
					return values.get(index);
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
	}
	private JPanel getPnlAddTask() {
		if (pnlAddTask == null) {
			pnlAddTask = new JPanel();
			pnlAddTask.setBorder(new TitledBorder(null, "Add Task", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagLayout gbl_pnlAddTask = new GridBagLayout();
			gbl_pnlAddTask.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlAddTask.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlAddTask.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_pnlAddTask.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			pnlAddTask.setLayout(gbl_pnlAddTask);
			GridBagConstraints gbc_layeredPane = new GridBagConstraints();
			gbc_layeredPane.gridwidth = 7;
			gbc_layeredPane.insets = new Insets(0, 0, 5, 5);
			gbc_layeredPane.fill = GridBagConstraints.BOTH;
			gbc_layeredPane.gridx = 0;
			gbc_layeredPane.gridy = 0;
			
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 5;
			gbc_scrollPane.gridwidth = 5;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 2;
			pnlAddTask.add(getScrollPane(), gbc_scrollPane);
			GridBagConstraints gbc_btnAddImage = new GridBagConstraints();
			gbc_btnAddImage.insets = new Insets(0, 0, 5, 0);
			gbc_btnAddImage.gridx = 6;
			gbc_btnAddImage.gridy = 4;
			pnlAddTask.add(getBtnAddImage(), gbc_btnAddImage);
			GridBagConstraints gbc_scrollBar = new GridBagConstraints();
			gbc_scrollBar.fill = GridBagConstraints.HORIZONTAL;
			gbc_scrollBar.gridwidth = 5;
			gbc_scrollBar.insets = new Insets(0, 0, 5, 5);
			gbc_scrollBar.gridx = 1;
			gbc_scrollBar.gridy = 7;
			pnlAddTask.add(getScrollBar_1(), gbc_scrollBar);
			GridBagConstraints gbc_lblAdd_Name = new GridBagConstraints();
			gbc_lblAdd_Name.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdd_Name.gridx = 1;
			gbc_lblAdd_Name.gridy = 10;
			pnlAddTask.add(getLblAdd_Name(), gbc_lblAdd_Name);
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 5;
			gbc_txtName.gridy = 10;
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
			GridBagConstraints gbc_comboBoxPriorityAdd = new GridBagConstraints();
			gbc_comboBoxPriorityAdd.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxPriorityAdd.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxPriorityAdd.gridx = 5;
			gbc_comboBoxPriorityAdd.gridy = 14;
			pnlAddTask.add(getComboBoxPriorityAdd(), gbc_comboBoxPriorityAdd);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 16;
			pnlAddTask.add(getLabel(), gbc_label);
			GridBagConstraints gbc_dateChooserStart = new GridBagConstraints();
			gbc_dateChooserStart.insets = new Insets(0, 0, 5, 5);
			gbc_dateChooserStart.fill = GridBagConstraints.HORIZONTAL;
			gbc_dateChooserStart.gridx = 5;
			gbc_dateChooserStart.gridy = 16;
			pnlAddTask.add(getDateChooserStart(), gbc_dateChooserStart);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 18;
			pnlAddTask.add(getLabel_1(), gbc_label_1);
			GridBagConstraints gbc_dateChooserEnd = new GridBagConstraints();
			gbc_dateChooserEnd.insets = new Insets(0, 0, 5, 5);
			gbc_dateChooserEnd.fill = GridBagConstraints.HORIZONTAL;
			gbc_dateChooserEnd.gridx = 5;
			gbc_dateChooserEnd.gridy = 18;
			pnlAddTask.add(getDateChooser_1(), gbc_dateChooserEnd);
			GridBagConstraints gbc_lblStateAdd = new GridBagConstraints();
			gbc_lblStateAdd.insets = new Insets(0, 0, 5, 5);
			gbc_lblStateAdd.gridx = 1;
			gbc_lblStateAdd.gridy = 20;
			pnlAddTask.add(getLblStateAdd(), gbc_lblStateAdd);
			GridBagConstraints gbc_comboBoxStateAdd = new GridBagConstraints();
			gbc_comboBoxStateAdd.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxStateAdd.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxStateAdd.gridx = 5;
			gbc_comboBoxStateAdd.gridy = 20;
			pnlAddTask.add(getComboBoxStateAdd(), gbc_comboBoxStateAdd);
			GridBagConstraints gbc_lblAnotation = new GridBagConstraints();
			gbc_lblAnotation.insets = new Insets(0, 0, 5, 5);
			gbc_lblAnotation.gridx = 1;
			gbc_lblAnotation.gridy = 22;
			pnlAddTask.add(getLblAnotation(), gbc_lblAnotation);
			GridBagConstraints gbc_textPaneAnotation = new GridBagConstraints();
			gbc_textPaneAnotation.gridwidth = 6;
			gbc_textPaneAnotation.fill = GridBagConstraints.BOTH;
			gbc_textPaneAnotation.gridx = 1;
			gbc_textPaneAnotation.gridy = 23;
			pnlAddTask.add(getTextPaneAnotation(), gbc_textPaneAnotation);
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
	private JComboBox getComboBoxPriorityAdd() {
		if (comboBoxPriorityAdd == null) {
			comboBoxPriorityAdd = new JComboBox();
			comboBoxPriorityAdd.setModel(new DefaultComboBoxModel(new String[] {"Low", "Medium", "High"}));
		}
		return comboBoxPriorityAdd;
	}
	private JLabel getLblAdd_Priority() {
		if (lblAdd_Priority == null) {
			lblAdd_Priority = new JLabel("Priority:");
		}
		return lblAdd_Priority;
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
	private JComboBox getComboBoxStateAdd() {
		if (comboBoxStateAdd == null) {
			comboBoxStateAdd = new JComboBox();
			comboBoxStateAdd.setModel(new DefaultComboBoxModel(new String[] {"Normal", "In focus", "Disabled", "Closed", "In focus and closed", "Disabled and closed"}));
		}
		return comboBoxStateAdd;
	}
	private JLabel getLblStateAdd() {
		if (lblStateAdd == null) {
			lblStateAdd = new JLabel("State:");
		}
		return lblStateAdd;
	}
	private JTextPane getTextPaneAnotation() {
		if (textPaneAnotation == null) {
			textPaneAnotation = new JTextPane();
		}
		return textPaneAnotation;
	}
	private JScrollBar getScrollBar_1() {
		if (scrollBar == null) {
			scrollBar = new JScrollBar(Adjustable.HORIZONTAL);
		}
		return scrollBar;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getLabelImageTask1());
			scrollPane.setRowHeaderView(getLabelScroll1());
			imgScroll1 = new JLabel("");
			imgScroll2 = new JLabel("");
			imgScroll3 = new JLabel("");
			
		}
		return scrollPane;
	}
	private JLabel getBtnAddTask() {
		if (btnAddTask == null) {
			btnAddTask = new JLabel("");
			btnAddTask.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						btnAdd.setVisible(true);
						btnModify.setVisible(false);
						btnDelete.setVisible(false);
						pnlAddTask.setBorder(new TitledBorder(null, "Add Task", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						pnlAddTask.setVisible(true);
						txtName.setText("");
						txtManager.setText("");
						dateChooserStart.setDate(null);
						dateChooserEnd.setDate(null);
						textPaneAnotation.setText("");
						comboBoxPriorityAdd.setSelectedIndex(0);
						comboBoxStateAdd.setSelectedIndex(0);
					}				
				}
			});
			btnAddTask.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/addButton.png")));
		}
		return btnAddTask;
	}
	private JLabel getBtnChat() {
		if (btnChat == null) {
			btnChat = new JLabel("");
			btnChat.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/icon_chat.png")));
			btnChat.addMouseListener(new BtnChatListener());
		}
		return btnChat;
	}
	private JLabel getBtnAddImage() {
		if (btnAddImage == null) {
			btnAddImage = new JLabel("");
			btnAddImage.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/addButton.png")));
			btnAddImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
						jfc.setCurrentDirectory(new File("/Users/bersus96/Dropbox/Mi trabajo de eclipse/IPOProject/src/resources"));
						int returnValue = jfc.showOpenDialog(null);
						// int returnValue = jfc.showSaveDialog(null); labelImageTask1
						if (returnValue == JFileChooser.APPROVE_OPTION) {
							File selectedFile = jfc.getSelectedFile();
							path = selectedFile.getAbsolutePath();
							System.out.println(selectedFile.getAbsolutePath());
							lbimagetask.setIcon(new ImageIcon(MyProjectInfo.class.getResource(path)));
						}
					}
				}
			});
		}
		return btnAddImage;
	}
	private JLabel getLbimagetask() {
		if (lbimagetask == null) {
			lbimagetask = new JLabel("");
			lbimagetask.setIcon(new ImageIcon(MyProjectInfo.class.getResource("/resources/task.png")));
		}
		return lbimagetask;
	}

	private class BtnChatListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent event) {
			Chat window = new Chat();
			window.frame.setVisible(true);
		}
	}

	private JLabel getLblAnotation() {
		if (lblAnotation == null) {
			lblAnotation = new JLabel("Anotation:");
		}
		return lblAnotation;
	}
	
	private JPanel getPnl_botonera() {
		if (pnl_botonera == null) {
			pnl_botonera = new JPanel();
			GridBagLayout gbl_pnl_botonera = new GridBagLayout();
			gbl_pnl_botonera.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnl_botonera.rowHeights = new int[]{0, 0, 0, 0};
			gbl_pnl_botonera.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnl_botonera.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			pnl_botonera.setLayout(gbl_pnl_botonera);
			GridBagConstraints gbc_btnModify = new GridBagConstraints();
			gbc_btnModify.insets = new Insets(0, 0, 0, 5);
			gbc_btnModify.gridx = 5;
			gbc_btnModify.gridy = 2;
			pnl_botonera.add(getBtnModify(), gbc_btnModify);
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
			gbc_btnAdd.gridx = 10;
			gbc_btnAdd.gridy = 2;
			pnl_botonera.add(getBtnAdd(), gbc_btnAdd);
			GridBagConstraints gbc_btnDelete = new GridBagConstraints();
			gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
			gbc_btnDelete.gridx = 15;
			gbc_btnDelete.gridy = 2;
			pnl_botonera.add(getBtnDelete(), gbc_btnDelete);
		}
		return pnl_botonera;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DefaultListModel model = new DefaultListModel();
					if(e.getClickCount() == 1){
						 dateStart = dateChooserStart.getDate();
						 strDateStart = DateFormat.getDateInstance().format(dateStart);
						 dateEnd = dateChooserEnd.getDate();
						 strDateEnd = DateFormat.getDateInstance().format(dateEnd);
						if (!txtName.getText().isEmpty() && !txtManager.getText().isEmpty() 
								&& !strDateStart.isEmpty() && !strDateEnd.isEmpty()) {
							JSONObject task = new JSONObject();
							try {
								task.put("name", txtName.getText());
								task.put("manager", txtManager.getText());
								task.put("priority", comboBoxPriorityAdd.getSelectedIndex());
								task.put("state", comboBoxStateAdd.getSelectedIndex());
								task.put("start", strDateStart);
								task.put("end",strDateEnd);
								task.put("resources", path);
								task.put("anotation", textPaneAnotation.getText());
								tasks.put(task);
								obj.put("tasks", tasks);
								FileWriter file = new FileWriter("/Users/bersus96/Dropbox/Mi trabajo de eclipse/IPOProject/src/data.json");
								BufferedWriter outstream = new BufferedWriter(file);
								outstream.write(obj.toString());
								outstream.close();
								list.setModel(model);
								getList();
							} catch (JSONException | IOException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
							
							try {
								MyProjectInfo window = new MyProjectInfo();
								window.frame.setVisible(true);
								
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnAdd;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1){
						try {
							JSONObject tarea = tasks.getJSONObject(index);
							obj.put("tasks", tasks);
							tasks.remove(index);
							FileWriter file = new FileWriter("/Users/bersus96/Dropbox/Mi trabajo de eclipse/IPOProject/src/data.json");
							BufferedWriter outstream = new BufferedWriter(file);
							outstream.write(obj.toString());
							outstream.close();
							getList();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							MyProjectInfo window = new MyProjectInfo();
							window.frame.setVisible(true);
							
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					
					
				}
			});
		
		}
		return btnDelete;
	}
	private JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("Modify");
			btnModify.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 if(e.getClickCount() == 1){
						 dateStart = dateChooserStart.getDate();
						 strDateStart = DateFormat.getDateInstance().format(dateStart);
						 dateEnd = dateChooserEnd.getDate();
						 strDateEnd = DateFormat.getDateInstance().format(dateEnd);
		
						if (!txtName.getText().isEmpty() && !txtManager.getText().isEmpty() && !strDateStart.isEmpty() && !strDateEnd.isEmpty()) {
					        try {
					        	
					        	JSONObject tarea = tasks.getJSONObject(index);
					        	tarea.put("name", txtName.getText());
								tarea.put("manager", txtManager.getText());
								tarea.put("priority", comboBoxPriorityAdd.getSelectedItem());
								tarea.put("state", comboBoxStateAdd.getSelectedItem());
								tarea.put("start", strDateStart);
								tarea.put("end",strDateEnd);
								tarea.put("resources", "../resources/user.png");
								tarea.put("anotation", textPaneAnotation.getText());
								tasks.put(tarea);
								obj.put("tasks", tasks);
								tasks.remove(index);
								FileWriter file = new FileWriter("/Users/bersus96/Dropbox/Mi trabajo de eclipse/IPOProject/src/data.json");
								BufferedWriter outstream = new BufferedWriter(file);
								outstream.write(obj.toString());
								outstream.close();
							} catch (JSONException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							try {
								MyProjectInfo window = new MyProjectInfo();
								window.frame.setVisible(true);
								
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnModify;
	}
	private JLabel getLabelImageTask1() {
		if (labelImageTask1 == null) {
			labelImageTask1 = new JLabel("");
		}
		return labelImageTask1;
	}
	private JLabel getLabelScroll1() {
		if (labelScroll1 == null) {
			labelScroll1 = new JLabel("");
		}
		return labelScroll1;
	}
	private JDateChooser getDateChooserStart() {
		if (dateChooserStart == null) {
			dateChooserStart = new JDateChooser();
		}
		return dateChooserStart;
	}
	private JDateChooser getDateChooser_1() {
		if (dateChooserEnd == null) {
			dateChooserEnd = new JDateChooser();
		}
		return dateChooserEnd;
	}
}
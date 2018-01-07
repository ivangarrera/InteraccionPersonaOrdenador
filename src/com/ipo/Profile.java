package com.ipo;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile {

	private class Btn_editMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// Modify name
			if (!textField_name.getText().isEmpty()) {
				try {
					current_user_json.put("name", textField_name.getText());
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
			// Modify user
			if (!textField_user.getText().isEmpty()) {
				try {
					current_user_json.put("user", textField_user.getText());
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
			// Modify password
			if (!passwordField_password.getText().isEmpty()) {
				try {
					current_user_json.put("password", passwordField_password.getText());
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
			// Write in external JSON file.
			if (!textField_name.getText().isEmpty() || !textField_user.getText().isEmpty() 
					|| !passwordField_password.getText().isEmpty()) {
				try {
					obj.put("users", users);
					FileWriter file = new FileWriter(this.getClass().getClassLoader().getResource("data.json").getPath());
					BufferedWriter outstream = new BufferedWriter(file);
					outstream.write(obj.toString());
					outstream.close();
					lbl_status_info.setForeground(Color.GREEN);
					lbl_status_info.setText("User has been modified.");
					ActionListener taskPerformer = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lbl_status_info.setText("");
						}
					};
					javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
					timer.setRepeats(false);
					timer.start();
					textField_name.setText("");
					textField_user.setText("");
					passwordField_password.setText("");
				} catch (JSONException | IOException ex) {
					lbl_status_info.setForeground(Color.RED);
					lbl_status_info.setText("User hasn't been modified.");
					ActionListener taskPerformer = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lbl_status_info.setText("");
						}
					};
					javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
					timer.setRepeats(false);
					timer.start();
					ex.printStackTrace();
				}
			} else {
				lbl_status_info.setForeground(Color.RED);
				lbl_status_info.setText("At least one field must be filled.");
				ActionListener taskPerformer = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lbl_status_info.setText("");
					}
				};
				javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
				timer.setRepeats(false);
				timer.start();
			}
		}
	}
	private class Btn_modifyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {			
			try {
				current_user_json.put("rol", comboBox_rol.getSelectedItem().toString());
				obj.put("users", users);
				FileWriter file = new FileWriter(this.getClass().getClassLoader().getResource("data.json").getPath());
				BufferedWriter outstream = new BufferedWriter(file);
				outstream.write(obj.toString());
				outstream.close();
				lbl_status_info.setForeground(Color.GREEN);
				lbl_status_info.setText("User has been modified.");
				ActionListener taskPerformer = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lbl_status_info.setText("");
					}
				};
				javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
				timer.setRepeats(false);
				timer.start();
			} catch (JSONException | IOException ex) {
				lbl_status_info.setForeground(Color.RED);
				lbl_status_info.setText("User hasn't been modified.");
				ActionListener taskPerformer = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lbl_status_info.setText("");
					}
				};
				javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
				timer.setRepeats(false);
				timer.start();
				ex.printStackTrace();
				ex.printStackTrace();
			}
		}
	}
	private class List_projectsMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent mouse_event) {
			if (mouse_event.getClickCount() == 2 && mouse_event.getButton() == MouseEvent.BUTTON1) {
				try {
					Projects window = new Projects(language);
					window.frame.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public JFrame frame;
	private JPanel pnl_image;
	private JPanel pnl_user_data;
	private JPanel pnl_user_other;
	private JLabel lbl_image;
	private JLabel lbl_name;
	private JLabel lbl_user;
	private JLabel lbl_password;
	private JTextField textField_name;
	private JTextField textField_user;
	private JPasswordField passwordField_password;
	private JLabel lbl_rol;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_rol;
	private JLabel lbl_projects;
	@SuppressWarnings("rawtypes")
	private JList list_projects;
	private JLabel lbl_skills;
	@SuppressWarnings("rawtypes")
	private JList list_skills;
	private JButton btn_edit;
	private JLabel lblNewLabel;
	private JButton btn_delete;
	private JSeparator separator;
	private JLabel lbl_last_access;
	
	private JSONArray projects;
	private JSONObject obj;
	private JSONArray users;
	private User user_registered;
	private JSONObject current_user_json;
	
	private JButton btn_modify;

	private JLabel lbl_status_info;

	private String language;
	
	/**
	 * Create the application.
	 */
	public Profile(String user, String language) {
		this.language = language;
		if (language.equals("spanish"))
			MessagesProfile.setIdioma("spanish");
		try {
			StringBuilder sb = new StringBuilder();

		    String line;
		    BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("data.json").getPath()));
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
			obj = new JSONObject(sb.toString());
			users = obj.getJSONArray("users");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < users.length(); i++) {
			try {
				if (users.getJSONObject(i).getString("user").equals(user)) {
					String name = users.getJSONObject(i).getString("name");
					String image_path = users.getJSONObject(i).getString("image_path");
					String last_access = users.getJSONObject(i).getString("last_access");
					String rol = users.getJSONObject(i).getString("rol");
					user_registered = new User(last_access, user, name, image_path, rol);
					
					// Save last access on disk
					users.getJSONObject(i).put("last_access", new Date().toString());
					obj.put("users", users);
					FileWriter file = new FileWriter(this.getClass().getClassLoader().getResource("data.json").getPath());
					BufferedWriter outstream = new BufferedWriter(file);
					outstream.write(obj.toString());
					outstream.close();
					current_user_json = users.getJSONObject(i);
					break;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		initialize();	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		
		try {
			StringBuilder sb = new StringBuilder();

		    String line;
		    BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("data.json").getPath()));
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
			JSONObject obj = new JSONObject(sb.toString());
			projects = obj.getJSONArray("projects");
			
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
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{261, 176, 0};
		gridBagLayout.rowHeights = new int[]{163, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		pnl_image = new JPanel();
		GridBagConstraints gbc_pnl_image = new GridBagConstraints();
		gbc_pnl_image.insets = new Insets(0, 0, 5, 5);
		gbc_pnl_image.fill = GridBagConstraints.BOTH;
		gbc_pnl_image.gridx = 0;
		gbc_pnl_image.gridy = 0;
		frame.getContentPane().add(pnl_image, gbc_pnl_image);
		
		lbl_image = new JLabel(); 
		if (user_registered.getImage_path().contains("resources/")) {
			ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource(user_registered.getImage_path()));
			Image img = icon.getImage();
			Image scaled = img.getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
			ImageIcon scaled_icon = new ImageIcon(scaled);
			lbl_image.setIcon(scaled_icon);
		} else {
			ImageIcon init_icon = new ImageIcon(user_registered.getImage_path());
			Image img = init_icon.getImage();
			Image scaled = img.getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
			ImageIcon scaled_icon = new ImageIcon(scaled);
			lbl_image.setIcon(scaled_icon);
		}
		
		pnl_image.add(lbl_image);
		
		pnl_user_data = new JPanel();
		pnl_user_data.setBorder(new TitledBorder(null, MessagesProfile.getString("Profile.pnl_user_data.borderTitle"), TitledBorder.TRAILING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_pnl_user_data = new GridBagConstraints();
		gbc_pnl_user_data.insets = new Insets(0, 0, 5, 5);
		gbc_pnl_user_data.fill = GridBagConstraints.BOTH;
		gbc_pnl_user_data.gridx = 0;
		gbc_pnl_user_data.gridy = 1;
		frame.getContentPane().add(pnl_user_data, gbc_pnl_user_data);
		GridBagLayout gbl_pnl_user_data = new GridBagLayout();
		gbl_pnl_user_data.columnWidths = new int[]{98, 70, 0};
		gbl_pnl_user_data.rowHeights = new int[]{15, 0, 0, 0, 0};
		gbl_pnl_user_data.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnl_user_data.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnl_user_data.setLayout(gbl_pnl_user_data);
		
		lbl_name = new JLabel(MessagesProfile.getString("Profile.lbl_name.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lbl_name = new GridBagConstraints();
		gbc_lbl_name.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_name.anchor = GridBagConstraints.EAST;
		gbc_lbl_name.gridx = 0;
		gbc_lbl_name.gridy = 0;
		pnl_user_data.add(lbl_name, gbc_lbl_name);
		
		textField_name = new JTextField();
		GridBagConstraints gbc_textField_name = new GridBagConstraints();
		gbc_textField_name.insets = new Insets(0, 0, 5, 0);
		gbc_textField_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_name.gridx = 1;
		gbc_textField_name.gridy = 0;
		pnl_user_data.add(textField_name, gbc_textField_name);
		textField_name.setColumns(10);
		
		lbl_user = new JLabel(MessagesProfile.getString("Profile.lbl_user.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lbl_user = new GridBagConstraints();
		gbc_lbl_user.anchor = GridBagConstraints.EAST;
		gbc_lbl_user.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_user.gridx = 0;
		gbc_lbl_user.gridy = 1;
		pnl_user_data.add(lbl_user, gbc_lbl_user);
		
		textField_user = new JTextField();
		GridBagConstraints gbc_textField_user = new GridBagConstraints();
		gbc_textField_user.insets = new Insets(0, 0, 5, 0);
		gbc_textField_user.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_user.gridx = 1;
		gbc_textField_user.gridy = 1;
		pnl_user_data.add(textField_user, gbc_textField_user);
		textField_user.setColumns(10);
		
		lbl_password = new JLabel(MessagesProfile.getString("Profile.lbl_password.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lbl_password = new GridBagConstraints();
		gbc_lbl_password.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_password.anchor = GridBagConstraints.EAST;
		gbc_lbl_password.gridx = 0;
		gbc_lbl_password.gridy = 2;
		pnl_user_data.add(lbl_password, gbc_lbl_password);
		
		passwordField_password = new JPasswordField();
		GridBagConstraints gbc_passwordField_password = new GridBagConstraints();
		gbc_passwordField_password.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_password.gridx = 1;
		gbc_passwordField_password.gridy = 2;
		pnl_user_data.add(passwordField_password, gbc_passwordField_password);
		
		btn_edit = new JButton(MessagesProfile.getString("Profile.btn_edit.text")); //$NON-NLS-1$
		btn_edit.addMouseListener(new Btn_editMouseListener());
		GridBagConstraints gbc_btn_edit = new GridBagConstraints();
		gbc_btn_edit.insets = new Insets(0, 0, 0, 5);
		gbc_btn_edit.gridx = 1;
		gbc_btn_edit.gridy = 3;
		pnl_user_data.add(btn_edit, gbc_btn_edit);
		
		pnl_user_other = new JPanel();
		pnl_user_other.setBackground(UIManager.getColor("windowBorder"));
		pnl_user_other.setBorder(new TitledBorder(null, MessagesProfile.getString("Profile.pnl_user_other.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_pnl_user_other = new GridBagConstraints();
		gbc_pnl_user_other.insets = new Insets(0, 0, 5, 0);
		gbc_pnl_user_other.gridheight = 2;
		gbc_pnl_user_other.fill = GridBagConstraints.BOTH;
		gbc_pnl_user_other.gridx = 1;
		gbc_pnl_user_other.gridy = 0;
		frame.getContentPane().add(pnl_user_other, gbc_pnl_user_other);
		GridBagLayout gbl_pnl_user_other = new GridBagLayout();
		gbl_pnl_user_other.columnWidths = new int[]{109, 133, 0};
		gbl_pnl_user_other.rowHeights = new int[]{0, 142, 129, 0, 0, 0, 0};
		gbl_pnl_user_other.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnl_user_other.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnl_user_other.setLayout(gbl_pnl_user_other);
		
		lbl_rol = new JLabel(MessagesProfile.getString("Profile.lbl_rol.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lbl_rol = new GridBagConstraints();
		gbc_lbl_rol.anchor = GridBagConstraints.EAST;
		gbc_lbl_rol.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_rol.gridx = 0;
		gbc_lbl_rol.gridy = 0;
		pnl_user_other.add(lbl_rol, gbc_lbl_rol);
		
		comboBox_rol = new JComboBox();
		comboBox_rol.setModel(new DefaultComboBoxModel(new String[] {"manager", "employee", "other"}));
		GridBagConstraints gbc_comboBox_rol = new GridBagConstraints();
		gbc_comboBox_rol.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_rol.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_rol.gridx = 1;
		gbc_comboBox_rol.gridy = 0;
		for (int i = 0; i <= comboBox_rol.getComponentCount(); i++) {
			if (comboBox_rol.getItemAt(i).equals(user_registered.getRol())) {
				comboBox_rol.setSelectedIndex(i);
			}
		}
		
		pnl_user_other.add(comboBox_rol, gbc_comboBox_rol);
		
		
		lbl_projects = new JLabel(MessagesProfile.getString("Profile.lbl_projects.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lbl_projects = new GridBagConstraints();
		gbc_lbl_projects.anchor = GridBagConstraints.EAST;
		gbc_lbl_projects.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_projects.gridx = 0;
		gbc_lbl_projects.gridy = 1;
		pnl_user_other.add(lbl_projects, gbc_lbl_projects);
		
		list_projects = new JList();
		list_projects.addMouseListener(new List_projectsMouseListener());
		ArrayList<String> values = new ArrayList<>();

		for (int i = 0; i < projects.length(); i++) {
			try {
				values.add(projects.getJSONObject(i).getString("name"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		list_projects.setModel(new AbstractListModel() {
			
			@Override
			public Object getElementAt(int index) {
				return values.get(index);
			}
			@Override
			public int getSize() {
				return values.size();
			}
		});
		list_projects.setBackground(SystemColor.window);
		GridBagConstraints gbc_list_projects = new GridBagConstraints();
		gbc_list_projects.insets = new Insets(0, 0, 5, 0);
		gbc_list_projects.fill = GridBagConstraints.BOTH;
		gbc_list_projects.gridx = 1;
		gbc_list_projects.gridy = 1;
		pnl_user_other.add(list_projects, gbc_list_projects);
		
		lbl_skills = new JLabel(MessagesProfile.getString("Profile.lbl_skills.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lbl_skills = new GridBagConstraints();
		gbc_lbl_skills.anchor = GridBagConstraints.EAST;
		gbc_lbl_skills.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_skills.gridx = 0;
		gbc_lbl_skills.gridy = 2;
		pnl_user_other.add(lbl_skills, gbc_lbl_skills);
		
		list_skills = new JList();
		list_skills.setModel(new AbstractListModel() {
			String[] values = new String[] {"Skill1", "Skill2", "Skill3", "Skill4"};
			@Override
			public Object getElementAt(int index) {
				return values[index];
			}
			@Override
			public int getSize() {
				return values.length;
			}
		});
		list_skills.setBackground(SystemColor.window);
		GridBagConstraints gbc_list_skills = new GridBagConstraints();
		gbc_list_skills.insets = new Insets(0, 0, 5, 0);
		gbc_list_skills.fill = GridBagConstraints.BOTH;
		gbc_list_skills.gridx = 1;
		gbc_list_skills.gridy = 2;
		pnl_user_other.add(list_skills, gbc_list_skills);
		
		btn_modify = new JButton(MessagesProfile.getString("Profile.btn_modify.text")); //$NON-NLS-1$
		btn_modify.addMouseListener(new Btn_modifyMouseListener());
		GridBagConstraints gbc_btn_modify = new GridBagConstraints();
		gbc_btn_modify.gridx = 1;
		gbc_btn_modify.gridy = 5;
		pnl_user_other.add(btn_modify, gbc_btn_modify);
		
		lblNewLabel = new JLabel(MessagesProfile.getString("Profile.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		btn_delete = new JButton(MessagesProfile.getString("Profile.btn_delete.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btn_delete = new GridBagConstraints();
		gbc_btn_delete.insets = new Insets(0, 0, 5, 0);
		gbc_btn_delete.anchor = GridBagConstraints.EAST;
		gbc_btn_delete.gridx = 1;
		gbc_btn_delete.gridy = 2;
		frame.getContentPane().add(btn_delete, gbc_btn_delete);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 2;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		frame.getContentPane().add(separator, gbc_separator);
		
		lbl_last_access = new JLabel("Last access: " + user_registered.getLast_access());
		GridBagConstraints gbc_lbl_last_access = new GridBagConstraints();
		gbc_lbl_last_access.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_last_access.anchor = GridBagConstraints.EAST;
		gbc_lbl_last_access.gridx = 1;
		gbc_lbl_last_access.gridy = 4;
		frame.getContentPane().add(lbl_last_access, gbc_lbl_last_access);
		
		lbl_status_info = new JLabel("");
		GridBagConstraints gbc_lbl_status_info = new GridBagConstraints();
		gbc_lbl_status_info.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_status_info.gridx = 0;
		gbc_lbl_status_info.gridy = 4;
		frame.getContentPane().add(lbl_status_info, gbc_lbl_status_info);
	}
	
}

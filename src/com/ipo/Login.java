package com.ipo;
import java.awt.Color;
import java.awt.EventQueue;
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
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login {

	private class BtnloginMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent mouse_event) {
			try {
				for (int i = 0; i < users.length(); i++) {
					if (users.getJSONObject(i).getString("user").equals(textFieldusrlogin.getText())
							&& users.getJSONObject(i).getString("password").equals(passwordFieldlogin.getText())) {
						Profile window = new Profile(users.getJSONObject(i).getString("user"), language);
						window.frame.setVisible(true);
						frmLogin.setVisible(false);
						frmLogin.dispose();
						break;
					}
				}
				lbl_status_info.setForeground(Color.RED);
				lbl_status_info.setText("User or password not correct.");
				ActionListener taskPerformer = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lbl_status_info.setText("");
					}
				};
				javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
				timer.setRepeats(false);
				timer.start();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	private class ButtonregisterMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (!textFieldnewname.getText().isEmpty() && !textFieldnewuser.getText().isEmpty() 
					&& !passwordFieldnew.getText().isEmpty()) {
				JSONObject user = new JSONObject();
				try {
					user.put("name", textFieldnewname.getText());
					user.put("user", textFieldnewuser.getText());
					user.put("password", passwordFieldnew.getText());
					user.put("image_path", "../resources/user.png");
					user.put("last_access", new Date());
					user.put("rol", "employee");
					users.put(user);
					obj.put("users", users);
					FileWriter file = new FileWriter(this.getClass().getClassLoader().getResource("data.json").getPath());
					BufferedWriter outstream = new BufferedWriter(file);
					outstream.write(obj.toString());
					outstream.close();
					lbl_status_info.setForeground(Color.GREEN);
					lbl_status_info.setText("User registered correctly.");
					ActionListener taskPerformer = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lbl_status_info.setText("");
						}
					};
					javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
					timer.setRepeats(false);
					timer.start();
				} catch (JSONException | IOException e) {
					lbl_status_info.setForeground(Color.RED);
					lbl_status_info.setText("User hasn't registered correctly.");
					ActionListener taskPerformer = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lbl_status_info.setText("");
						}
					};
					javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
					timer.setRepeats(false);
					timer.start();
					e.printStackTrace();
				}
			} else {
				lbl_status_info.setForeground(Color.RED);
				lbl_status_info.setText("Fields can't be empty.");
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
	private class Lbl_spainMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			MessagesIpoProject.setIdioma("spanish");
			Login ventana = new Login("spanish");
			ventana.frmLogin.setVisible(true);
			language = "spanish";
			frmLogin.dispose();
		}
	}
	private class Lbl_ukMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MessagesIpoProject.setIdioma("");
			Login ventana = new Login("english");
			ventana.frmLogin.setVisible(true);
			language = "english";
			frmLogin.dispose();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login window = new Login("english");
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame frmLogin;
	private JPanel panel_new_user;
	private JPanel panel_existing_user;
	private JPanel panel_image;
	private JLabel lbluserlogin;
	private JLabel lblpsswdlogin;
	private JTextField textFieldusrlogin;
	private JButton btnlogin;
	private JLabel lblnewuser;
	private JTextField textFieldnewuser;
	private JButton buttonregister;
	private JLabel lblnewname;
	private JTextField textFieldnewname;
	private JLabel lblnewpasswd;
	private JPasswordField passwordFieldlogin;
	private JPasswordField passwordFieldnew;
	private JLabel lblimage;
	private JSONArray users;
	private JSONObject obj;

	private JLabel lbl_status_info;

	private JPanel panel_flags;

	private JLabel lbl_spain;

	private JLabel lbl_uk;
	private String language;
	/**
	 * Create the application.
	 */
	public Login(String language) {
		this.language = language;
		initialize();
		// Set spanish flag
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("resources/spain.png"));
		Image img = icon.getImage();
		Image scaled = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaled_icon = new ImageIcon(scaled);
		lbl_spain.setIcon(scaled_icon);

		// Set UK flag
		icon = new ImageIcon(this.getClass().getClassLoader().getResource("resources/uk.png"));
		img = icon.getImage();
		scaled = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		scaled_icon = new ImageIcon(scaled);
		lbl_uk.setIcon(scaled_icon);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		try {
			StringBuilder sb = new StringBuilder();

		    String line;
		    BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("data.json").getPath()));
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
			obj = new JSONObject(sb.toString());
			users = obj.getJSONArray("users");
			
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
		
		frmLogin = new JFrame();
		frmLogin.setTitle(MessagesIpoProject.getString("Login.frmLogin.title")); //$NON-NLS-1$
		frmLogin.setBounds(100, 100, 600, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		frmLogin.getContentPane().setLayout(gridBagLayout);
		
		panel_image = new JPanel();
		GridBagConstraints gbc_panel_image = new GridBagConstraints();
		gbc_panel_image.gridheight = 2;
		gbc_panel_image.insets = new Insets(0, 0, 5, 5);
		gbc_panel_image.fill = GridBagConstraints.BOTH;
		gbc_panel_image.gridx = 0;
		gbc_panel_image.gridy = 0;
		frmLogin.getContentPane().add(panel_image, gbc_panel_image);
		GridBagLayout gbl_panel_image = new GridBagLayout();
		gbl_panel_image.columnWidths = new int[]{310, 0, 0};
		gbl_panel_image.rowHeights = new int[]{206, 0, 0, 0};
		gbl_panel_image.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_image.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_image.setLayout(gbl_panel_image);
		
		panel_flags = new JPanel();
		GridBagConstraints gbc_panel_flags = new GridBagConstraints();
		gbc_panel_flags.insets = new Insets(0, 0, 5, 5);
		gbc_panel_flags.fill = GridBagConstraints.BOTH;
		gbc_panel_flags.gridx = 0;
		gbc_panel_flags.gridy = 0;
		panel_image.add(panel_flags, gbc_panel_flags);
		
		lbl_spain = new JLabel(MessagesIpoProject.getString("Login.lbl_spain.text")); //$NON-NLS-1$
		lbl_spain.addMouseListener(new Lbl_spainMouseListener());
		lbl_spain.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_flags.add(lbl_spain);
		
		lbl_uk = new JLabel(MessagesIpoProject.getString("Login.lbl_uk.text")); //$NON-NLS-1$
		lbl_uk.addMouseListener(new Lbl_ukMouseListener());
		panel_flags.add(lbl_uk);
		
		lblimage = new JLabel();
		lblimage.setBackground(SystemColor.control);
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblimage.setIcon(null);
		GridBagConstraints gbc_lblimage = new GridBagConstraints();
		gbc_lblimage.insets = new Insets(0, 0, 5, 0);
		gbc_lblimage.fill = GridBagConstraints.BOTH;
		gbc_lblimage.gridx = 1;
		gbc_lblimage.gridy = 1;
		panel_image.add(lblimage, gbc_lblimage);
		
		panel_existing_user = new JPanel();
		panel_existing_user.setBackground(SystemColor.control);
		panel_existing_user.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), MessagesIpoProject.getString("Login.panel_existing_user.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))); //$NON-NLS-1$
		GridBagConstraints gbc_panel_existing_user = new GridBagConstraints();
		gbc_panel_existing_user.insets = new Insets(0, 0, 5, 0);
		gbc_panel_existing_user.fill = GridBagConstraints.BOTH;
		gbc_panel_existing_user.gridx = 1;
		gbc_panel_existing_user.gridy = 0;
		frmLogin.getContentPane().add(panel_existing_user, gbc_panel_existing_user);
		GridBagLayout gbl_panel_existing_user = new GridBagLayout();
		gbl_panel_existing_user.columnWidths = new int[]{77, 70, 70, 0};
		gbl_panel_existing_user.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0};
		gbl_panel_existing_user.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_existing_user.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_existing_user.setLayout(gbl_panel_existing_user);
		
		lbluserlogin = new JLabel(MessagesIpoProject.getString("Login.lbluserlogin.text")); //$NON-NLS-1$
		lbluserlogin.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lbluserlogin = new GridBagConstraints();
		gbc_lbluserlogin.anchor = GridBagConstraints.EAST;
		gbc_lbluserlogin.insets = new Insets(0, 0, 5, 5);
		gbc_lbluserlogin.gridx = 0;
		gbc_lbluserlogin.gridy = 0;
		panel_existing_user.add(lbluserlogin, gbc_lbluserlogin);
		
		passwordFieldlogin = new JPasswordField();
		GridBagConstraints gbc_passwordFieldlogin = new GridBagConstraints();
		gbc_passwordFieldlogin.gridwidth = 2;
		gbc_passwordFieldlogin.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldlogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldlogin.gridx = 1;
		gbc_passwordFieldlogin.gridy = 3;
		panel_existing_user.add(passwordFieldlogin, gbc_passwordFieldlogin);
		
		lblpsswdlogin = new JLabel(MessagesIpoProject.getString("Login.lblpsswdlogin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblpsswdlogin = new GridBagConstraints();
		gbc_lblpsswdlogin.anchor = GridBagConstraints.EAST;
		gbc_lblpsswdlogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblpsswdlogin.gridx = 0;
		gbc_lblpsswdlogin.gridy = 3;
		panel_existing_user.add(lblpsswdlogin, gbc_lblpsswdlogin);
		
		textFieldusrlogin = new JTextField();
		GridBagConstraints gbc_textFieldusrlogin = new GridBagConstraints();
		gbc_textFieldusrlogin.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldusrlogin.gridwidth = 2;
		gbc_textFieldusrlogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldusrlogin.gridx = 1;
		gbc_textFieldusrlogin.gridy = 0;
		panel_existing_user.add(textFieldusrlogin, gbc_textFieldusrlogin);
		textFieldusrlogin.setColumns(10);
		
		btnlogin = new JButton(MessagesIpoProject.getString("Login.btnlogin.text")); //$NON-NLS-1$
		btnlogin.addMouseListener(new BtnloginMouseListener());
		GridBagConstraints gbc_btnlogin = new GridBagConstraints();
		gbc_btnlogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnlogin.gridx = 1;
		gbc_btnlogin.gridy = 5;
		panel_existing_user.add(btnlogin, gbc_btnlogin);
		
		panel_new_user = new JPanel();
		panel_new_user.setBackground(SystemColor.control);
		panel_new_user.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), MessagesIpoProject.getString("Login.panel_new_user.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51))); //$NON-NLS-1$
		GridBagConstraints gbc_panel_new_user = new GridBagConstraints();
		gbc_panel_new_user.insets = new Insets(0, 0, 5, 0);
		gbc_panel_new_user.fill = GridBagConstraints.BOTH;
		gbc_panel_new_user.gridx = 1;
		gbc_panel_new_user.gridy = 1;
		frmLogin.getContentPane().add(panel_new_user, gbc_panel_new_user);
		GridBagLayout gbl_panel_new_user = new GridBagLayout();
		gbl_panel_new_user.columnWidths = new int[]{0, 69, 60, 0};
		gbl_panel_new_user.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_new_user.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_new_user.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_new_user.setLayout(gbl_panel_new_user);
		
		lblnewuser = new JLabel(MessagesIpoProject.getString("Login.lblnewuser.text")); //$NON-NLS-1$
		lblnewuser.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblnewuser = new GridBagConstraints();
		gbc_lblnewuser.anchor = GridBagConstraints.EAST;
		gbc_lblnewuser.insets = new Insets(0, 0, 5, 5);
		gbc_lblnewuser.gridx = 0;
		gbc_lblnewuser.gridy = 1;
		panel_new_user.add(lblnewuser, gbc_lblnewuser);
		
		textFieldnewuser = new JTextField();
		textFieldnewuser.setColumns(10);
		GridBagConstraints gbc_textFieldnewuser = new GridBagConstraints();
		gbc_textFieldnewuser.gridwidth = 2;
		gbc_textFieldnewuser.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldnewuser.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldnewuser.gridx = 1;
		gbc_textFieldnewuser.gridy = 1;
		panel_new_user.add(textFieldnewuser, gbc_textFieldnewuser);
		
		buttonregister = new JButton(MessagesIpoProject.getString("Login.buttonregister.text")); //$NON-NLS-1$
		buttonregister.addMouseListener(new ButtonregisterMouseListener());
		GridBagConstraints gbc_buttonregister = new GridBagConstraints();
		gbc_buttonregister.insets = new Insets(0, 0, 5, 5);
		gbc_buttonregister.gridx = 1;
		gbc_buttonregister.gridy = 3;
		panel_new_user.add(buttonregister, gbc_buttonregister);
		
		lblnewname = new JLabel(MessagesIpoProject.getString("Login.lblnewname.text")); //$NON-NLS-1$
		lblnewname.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblnewname = new GridBagConstraints();
		gbc_lblnewname.anchor = GridBagConstraints.EAST;
		gbc_lblnewname.insets = new Insets(0, 0, 5, 5);
		gbc_lblnewname.gridx = 0;
		gbc_lblnewname.gridy = 0;
		panel_new_user.add(lblnewname, gbc_lblnewname);
		
		textFieldnewname = new JTextField();
		textFieldnewname.setColumns(10);
		GridBagConstraints gbc_textFieldnewname = new GridBagConstraints();
		gbc_textFieldnewname.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldnewname.gridwidth = 2;
		gbc_textFieldnewname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldnewname.gridx = 1;
		gbc_textFieldnewname.gridy = 0;
		panel_new_user.add(textFieldnewname, gbc_textFieldnewname);
		
		lblnewpasswd = new JLabel(MessagesIpoProject.getString("Login.lblnewpasswd.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblnewpasswd = new GridBagConstraints();
		gbc_lblnewpasswd.anchor = GridBagConstraints.EAST;
		gbc_lblnewpasswd.insets = new Insets(0, 0, 5, 5);
		gbc_lblnewpasswd.gridx = 0;
		gbc_lblnewpasswd.gridy = 2;
		panel_new_user.add(lblnewpasswd, gbc_lblnewpasswd);
		
		passwordFieldnew = new JPasswordField();
		GridBagConstraints gbc_passwordFieldnew = new GridBagConstraints();
		gbc_passwordFieldnew.gridwidth = 2;
		gbc_passwordFieldnew.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldnew.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldnew.gridx = 1;
		gbc_passwordFieldnew.gridy = 2;
		panel_new_user.add(passwordFieldnew, gbc_passwordFieldnew);
		
		lbl_status_info = new JLabel("");
		GridBagConstraints gbc_lbl_status_info = new GridBagConstraints();
		gbc_lbl_status_info.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_status_info.gridx = 0;
		gbc_lbl_status_info.gridy = 2;
		frmLogin.getContentPane().add(lbl_status_info, gbc_lbl_status_info);
	}
	
}

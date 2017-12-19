import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

public class Profile {

	private JFrame frame;
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
	private JComboBox comboBox_rol;
	private JLabel lbl_projects;
	private JList list_projects;
	private JLabel lbl_skills;
	private JList list_skills;
	private JButton btn_modify;
	private JButton btn_edit;
	private JLabel lblNewLabel;
	private JButton btn_delete;
	private JSeparator separator;
	private JLabel lbl_last_access;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{261, 176, 0};
		gridBagLayout.rowHeights = new int[]{163, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		pnl_image = new JPanel();
		GridBagConstraints gbc_pnl_image = new GridBagConstraints();
		gbc_pnl_image.insets = new Insets(0, 0, 5, 5);
		gbc_pnl_image.fill = GridBagConstraints.BOTH;
		gbc_pnl_image.gridx = 0;
		gbc_pnl_image.gridy = 0;
		frame.getContentPane().add(pnl_image, gbc_pnl_image);
		
		lbl_image = new JLabel("");
		lbl_image.setIcon(new ImageIcon(Profile.class.getResource("/resources/user.png")));
		pnl_image.add(lbl_image);
		
		pnl_user_data = new JPanel();
		pnl_user_data.setBorder(new TitledBorder(null, "Personal Data", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
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
		
		lbl_name = new JLabel("Name:");
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
		
		lbl_user = new JLabel("User:");
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
		
		lbl_password = new JLabel("Password:");
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
		
		btn_edit = new JButton("Edit");
		GridBagConstraints gbc_btn_edit = new GridBagConstraints();
		gbc_btn_edit.insets = new Insets(0, 0, 0, 5);
		gbc_btn_edit.gridx = 1;
		gbc_btn_edit.gridy = 3;
		pnl_user_data.add(btn_edit, gbc_btn_edit);
		
		pnl_user_other = new JPanel();
		pnl_user_other.setBackground(UIManager.getColor("windowBorder"));
		pnl_user_other.setBorder(new TitledBorder(null, "Other Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnl_user_other = new GridBagConstraints();
		gbc_pnl_user_other.insets = new Insets(0, 0, 5, 0);
		gbc_pnl_user_other.gridheight = 2;
		gbc_pnl_user_other.fill = GridBagConstraints.BOTH;
		gbc_pnl_user_other.gridx = 1;
		gbc_pnl_user_other.gridy = 0;
		frame.getContentPane().add(pnl_user_other, gbc_pnl_user_other);
		GridBagLayout gbl_pnl_user_other = new GridBagLayout();
		gbl_pnl_user_other.columnWidths = new int[]{109, 133, 0};
		gbl_pnl_user_other.rowHeights = new int[]{0, 142, 129, 0, 0};
		gbl_pnl_user_other.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnl_user_other.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnl_user_other.setLayout(gbl_pnl_user_other);
		
		lbl_rol = new JLabel("Rol:");
		GridBagConstraints gbc_lbl_rol = new GridBagConstraints();
		gbc_lbl_rol.anchor = GridBagConstraints.EAST;
		gbc_lbl_rol.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_rol.gridx = 0;
		gbc_lbl_rol.gridy = 0;
		pnl_user_other.add(lbl_rol, gbc_lbl_rol);
		
		comboBox_rol = new JComboBox();
		comboBox_rol.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Employee", "Other"}));
		GridBagConstraints gbc_comboBox_rol = new GridBagConstraints();
		gbc_comboBox_rol.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_rol.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_rol.gridx = 1;
		gbc_comboBox_rol.gridy = 0;
		pnl_user_other.add(comboBox_rol, gbc_comboBox_rol);
		
		lbl_projects = new JLabel("Projects:");
		GridBagConstraints gbc_lbl_projects = new GridBagConstraints();
		gbc_lbl_projects.anchor = GridBagConstraints.EAST;
		gbc_lbl_projects.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_projects.gridx = 0;
		gbc_lbl_projects.gridy = 1;
		pnl_user_other.add(lbl_projects, gbc_lbl_projects);
		
		list_projects = new JList();
		list_projects.setBackground(SystemColor.window);
		GridBagConstraints gbc_list_projects = new GridBagConstraints();
		gbc_list_projects.insets = new Insets(0, 0, 5, 0);
		gbc_list_projects.fill = GridBagConstraints.BOTH;
		gbc_list_projects.gridx = 1;
		gbc_list_projects.gridy = 1;
		pnl_user_other.add(list_projects, gbc_list_projects);
		
		lbl_skills = new JLabel("Skills:");
		GridBagConstraints gbc_lbl_skills = new GridBagConstraints();
		gbc_lbl_skills.anchor = GridBagConstraints.EAST;
		gbc_lbl_skills.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_skills.gridx = 0;
		gbc_lbl_skills.gridy = 2;
		pnl_user_other.add(lbl_skills, gbc_lbl_skills);
		
		list_skills = new JList();
		list_skills.setBackground(SystemColor.window);
		GridBagConstraints gbc_list_skills = new GridBagConstraints();
		gbc_list_skills.insets = new Insets(0, 0, 5, 0);
		gbc_list_skills.fill = GridBagConstraints.BOTH;
		gbc_list_skills.gridx = 1;
		gbc_list_skills.gridy = 2;
		pnl_user_other.add(list_skills, gbc_list_skills);
		
		btn_modify = new JButton("Modify");
		GridBagConstraints gbc_btn_modify = new GridBagConstraints();
		gbc_btn_modify.gridx = 1;
		gbc_btn_modify.gridy = 3;
		pnl_user_other.add(btn_modify, gbc_btn_modify);
		
		lblNewLabel = new JLabel("Don't want to use the app anymore? ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		btn_delete = new JButton("Delete account");
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
		
		lbl_last_access = new JLabel("Last access: YYYY-MM-DD hh:mm:ss");
		GridBagConstraints gbc_lbl_last_access = new GridBagConstraints();
		gbc_lbl_last_access.anchor = GridBagConstraints.EAST;
		gbc_lbl_last_access.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_last_access.gridx = 1;
		gbc_lbl_last_access.gridy = 4;
		frame.getContentPane().add(lbl_last_access, gbc_lbl_last_access);
	}

}

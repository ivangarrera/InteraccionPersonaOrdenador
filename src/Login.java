import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frmLogin;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
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
		gbl_panel_image.columnWidths = new int[]{310, 0};
		gbl_panel_image.rowHeights = new int[]{206, 0};
		gbl_panel_image.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_image.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_image.setLayout(gbl_panel_image);
		
		lblimage = new JLabel("");
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblimage.setIcon(new ImageIcon("/home/ivangarrera/Desktop/gestion.png"));
		GridBagConstraints gbc_lblimage = new GridBagConstraints();
		gbc_lblimage.fill = GridBagConstraints.BOTH;
		gbc_lblimage.gridx = 0;
		gbc_lblimage.gridy = 0;
		panel_image.add(lblimage, gbc_lblimage);
		
		panel_existing_user = new JPanel();
		panel_existing_user.setBackground(new Color(204, 255, 153));
		panel_existing_user.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Existing User", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panel_existing_user = new GridBagConstraints();
		gbc_panel_existing_user.insets = new Insets(0, 0, 5, 0);
		gbc_panel_existing_user.fill = GridBagConstraints.BOTH;
		gbc_panel_existing_user.gridx = 1;
		gbc_panel_existing_user.gridy = 0;
		frmLogin.getContentPane().add(panel_existing_user, gbc_panel_existing_user);
		GridBagLayout gbl_panel_existing_user = new GridBagLayout();
		gbl_panel_existing_user.columnWidths = new int[]{77, 70, 70, 0};
		gbl_panel_existing_user.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0};
		gbl_panel_existing_user.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_existing_user.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_existing_user.setLayout(gbl_panel_existing_user);
		
		lbluserlogin = new JLabel("User:");
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
		
		lblpsswdlogin = new JLabel("Password:");
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
		
		btnlogin = new JButton("LOG-IN");
		GridBagConstraints gbc_btnlogin = new GridBagConstraints();
		gbc_btnlogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnlogin.gridx = 1;
		gbc_btnlogin.gridy = 5;
		panel_existing_user.add(btnlogin, gbc_btnlogin);
		
		panel_new_user = new JPanel();
		panel_new_user.setBackground(Color.CYAN);
		panel_new_user.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "New User?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panel_new_user = new GridBagConstraints();
		gbc_panel_new_user.insets = new Insets(0, 0, 5, 0);
		gbc_panel_new_user.fill = GridBagConstraints.BOTH;
		gbc_panel_new_user.gridx = 1;
		gbc_panel_new_user.gridy = 1;
		frmLogin.getContentPane().add(panel_new_user, gbc_panel_new_user);
		GridBagLayout gbl_panel_new_user = new GridBagLayout();
		gbl_panel_new_user.columnWidths = new int[]{0, 69, 60, 0};
		gbl_panel_new_user.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_new_user.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_new_user.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_new_user.setLayout(gbl_panel_new_user);
		
		lblnewuser = new JLabel("User:");
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
		
		buttonregister = new JButton("SIGN-UP");
		GridBagConstraints gbc_buttonregister = new GridBagConstraints();
		gbc_buttonregister.insets = new Insets(0, 0, 5, 5);
		gbc_buttonregister.gridx = 1;
		gbc_buttonregister.gridy = 3;
		panel_new_user.add(buttonregister, gbc_buttonregister);
		
		lblnewname = new JLabel("Name:");
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
		
		lblnewpasswd = new JLabel("Password:");
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
	}

}

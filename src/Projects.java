import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class Projects {

	private JFrame frame;
	private JPanel pnl_projects;
	private JPanel panel;
	private JPanel[] pnl_project;
	private JTextField txtSearch;
	private JButton btn_search;
	private JLabel lbl_filter;
	private JLabel lbl_settings;
	private JButton btnAddNewProject;
	private JLabel lbl_projects_selected;
	private JLabel lbl_Delete;
	
	private int num_selected_projects;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projects window = new Projects();
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
	public Projects() {
		pnl_project = new JPanel[8];
		num_selected_projects = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1250, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{168, 114, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search:");
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearch.gridx = 0;
		gbc_txtSearch.gridy = 0;
		panel.add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);
		
		btn_search = new JButton("Search");
		GridBagConstraints gbc_btn_search = new GridBagConstraints();
		gbc_btn_search.insets = new Insets(0, 0, 5, 5);
		gbc_btn_search.gridx = 1;
		gbc_btn_search.gridy = 0;
		panel.add(btn_search, gbc_btn_search);
		
		lbl_filter = new JLabel("");
		lbl_filter.setIcon(new ImageIcon(Projects.class.getResource("/resources/filter.png")));
		GridBagConstraints gbc_lbl_filter = new GridBagConstraints();
		gbc_lbl_filter.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_filter.gridx = 2;
		gbc_lbl_filter.gridy = 0;
		panel.add(lbl_filter, gbc_lbl_filter);
		
		lbl_settings = new JLabel("");
		lbl_settings.setIcon(new ImageIcon(Projects.class.getResource("/resources/settings.png")));
		GridBagConstraints gbc_lbl_settings = new GridBagConstraints();
		gbc_lbl_settings.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_settings.gridx = 3;
		gbc_lbl_settings.gridy = 0;
		panel.add(lbl_settings, gbc_lbl_settings);
		
		lbl_projects_selected = new JLabel("");
		GridBagConstraints gbc_lbl_projects_selected = new GridBagConstraints();
		gbc_lbl_projects_selected.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_projects_selected.gridx = 4;
		gbc_lbl_projects_selected.gridy = 0;
		panel.add(lbl_projects_selected, gbc_lbl_projects_selected);
		
		lbl_Delete = new JLabel("");
		lbl_Delete.setIcon(new ImageIcon(Projects.class.getResource("/resources/trash.png")));
		lbl_Delete.setVisible(false);
		GridBagConstraints gbc_lbl_Delete = new GridBagConstraints();
		gbc_lbl_Delete.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Delete.gridx = 5;
		gbc_lbl_Delete.gridy = 0;
		panel.add(lbl_Delete, gbc_lbl_Delete);
		
		pnl_projects = new JPanel();
		pnl_projects.setBorder(new TitledBorder(null, "Projects", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnl_projects = new GridBagConstraints();
		gbc_pnl_projects.insets = new Insets(0, 0, 5, 0);
		gbc_pnl_projects.fill = GridBagConstraints.BOTH;
		gbc_pnl_projects.gridx = 0;
		gbc_pnl_projects.gridy = 1;
		frame.getContentPane().add(pnl_projects, gbc_pnl_projects);
		pnl_projects.setLayout(new GridLayout(2, 3, 0, 0));
		
		btnAddNewProject = new JButton("Add Project");
		GridBagConstraints gbc_btnAddNewProject = new GridBagConstraints();
		gbc_btnAddNewProject.gridx = 0;
		gbc_btnAddNewProject.gridy = 3;
		frame.getContentPane().add(btnAddNewProject, gbc_btnAddNewProject);
		
		for (int i = 0; i < 8; i++) {
			pnl_project[i] = new MyProjectPanel();
			pnl_projects.add(pnl_project[i], "Project");
			((MyProjectPanel) pnl_project[i]).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
		}
		
	}
	
	private class ChckbxSelectProjectItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent arg0) {
			if (((AbstractButton) arg0.getItem()).isSelected()) {
				num_selected_projects += 1;
			} else {
				num_selected_projects -= 1;
			}
			if (num_selected_projects > 0) {
				txtSearch.setVisible(false);
				lbl_Delete.setVisible(true);
				btn_search.setVisible(false);
				lbl_filter.setVisible(false);
				lbl_settings.setVisible(false);
				lbl_projects_selected.setVisible(true);
				lbl_projects_selected.setText("");
				lbl_projects_selected.setText(num_selected_projects + " Project Selected");
			} else {
				lbl_projects_selected.setVisible(false);
				txtSearch.setVisible(true);
				btn_search.setVisible(true);
				lbl_filter.setVisible(true);
				lbl_settings.setVisible(true);
				lbl_Delete.setVisible(false);
			}
		}
	}
}

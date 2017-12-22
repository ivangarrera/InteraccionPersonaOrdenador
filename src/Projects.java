import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.Icon;
import java.awt.BorderLayout;

import java.util.ArrayList;

public class Projects {

	public JFrame frame;
	private JPanel pnl_projects;
	private JPanel panel;
	private ArrayList<MyProjectPanel> pnl_project;
	private JTextField txtSearch;
	private JButton btn_search;
	private JLabel lbl_filter;
	private JLabel lbl_settings;
	private JButton btnAddNewProject;
	private JLabel lbl_projects_selected;
	private JLabel lbl_Delete;
	
	private ArrayList<MyProjectPanel> panels_selected; 
	
	private JPanel pnl_view_project;
	private JLabel lbl_view_image;
	private JLabel lbl_view_name;
	private JLabel lbl_view_created;
	private JLabel lbl_view_manager;
	private JTextField txt_view_name;
	private JTextField txt_view_created;
	private JTextField txt_view_manager;
	private JLabel lbl_members;
	private JLabel lbl_view_description;
	private JTextPane textPane_description;
	private JList list;
	private JPanel pnl_auxiliar;
	private JButton btnEditProjectInfo;

	/**
	 * Create the application.
	 */
	public Projects() {
		pnl_project = new ArrayList<>();
		panels_selected = new ArrayList<>();
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
		gridBagLayout.columnWidths = new int[]{0, 310, 0};
		gridBagLayout.rowHeights = new int[]{44, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{168, 114, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search:");
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
		lbl_Delete.addMouseListener(new Lbl_DeleteMouseListener());
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
		gbc_pnl_projects.insets = new Insets(0, 0, 5, 5);
		gbc_pnl_projects.fill = GridBagConstraints.BOTH;
		gbc_pnl_projects.gridx = 0;
		gbc_pnl_projects.gridy = 1;
		frame.getContentPane().add(pnl_projects, gbc_pnl_projects);
		pnl_projects.setLayout(new GridLayout(3, 3, 0, 0));
		ImageIcon imageIcon_view = new ImageIcon(Projects.class.getResource("/resources/trash.png")); 
		Icon icon = new ImageIcon(imageIcon_view.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		
		pnl_auxiliar = new JPanel();
		GridBagConstraints gbc_pnl_auxiliar = new GridBagConstraints();
		gbc_pnl_auxiliar.insets = new Insets(0, 0, 5, 0);
		gbc_pnl_auxiliar.fill = GridBagConstraints.BOTH;
		gbc_pnl_auxiliar.gridx = 1;
		gbc_pnl_auxiliar.gridy = 1;
		frame.getContentPane().add(pnl_auxiliar, gbc_pnl_auxiliar);
		pnl_auxiliar.setLayout(new BorderLayout(0, 0));
		
		pnl_view_project = new JPanel();
		pnl_auxiliar.add(pnl_view_project, BorderLayout.NORTH);
		pnl_view_project.setVisible(false);
		GridBagLayout gbl_pnl_view_project = new GridBagLayout();
		gbl_pnl_view_project.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnl_view_project.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnl_view_project.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnl_view_project.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0};
		pnl_view_project.setLayout(gbl_pnl_view_project);
		
		lbl_view_image = new JLabel("");
		lbl_view_image.setIcon(new ImageIcon(Projects.class.getResource("/resources/user.png")));
		GridBagConstraints gbc_lbl_view_image = new GridBagConstraints();
		gbc_lbl_view_image.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_view_image.gridx = 1;
		gbc_lbl_view_image.gridy = 0;
		pnl_view_project.add(lbl_view_image, gbc_lbl_view_image);
		
		btnEditProjectInfo = new JButton("EDIT");
		GridBagConstraints gbc_btnEditProjectInfo = new GridBagConstraints();
		gbc_btnEditProjectInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditProjectInfo.gridx = 1;
		gbc_btnEditProjectInfo.gridy = 8;
		pnl_view_project.add(btnEditProjectInfo, gbc_btnEditProjectInfo);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Item1", "Item2", "Item3", "Item4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 1;
		pnl_view_project.add(list, gbc_list);
		
		textPane_description = new JTextPane();
		GridBagConstraints gbc_textPane_description = new GridBagConstraints();
		gbc_textPane_description.gridheight = 3;
		gbc_textPane_description.gridwidth = 4;
		gbc_textPane_description.fill = GridBagConstraints.BOTH;
		gbc_textPane_description.gridx = 1;
		gbc_textPane_description.gridy = 4;
		pnl_view_project.add(textPane_description, gbc_textPane_description);
		
		lbl_view_description = new JLabel("Description:");
		GridBagConstraints gbc_lbl_view_description = new GridBagConstraints();
		gbc_lbl_view_description.anchor = GridBagConstraints.EAST;
		gbc_lbl_view_description.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_view_description.gridx = 0;
		gbc_lbl_view_description.gridy = 4;
		pnl_view_project.add(lbl_view_description, gbc_lbl_view_description);
		
		lbl_members = new JLabel("Members:");
		GridBagConstraints gbc_lbl_members = new GridBagConstraints();
		gbc_lbl_members.anchor = GridBagConstraints.EAST;
		gbc_lbl_members.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_members.gridx = 2;
		gbc_lbl_members.gridy = 2;
		pnl_view_project.add(lbl_members, gbc_lbl_members);
		
		lbl_view_name = new JLabel("Name:");
		GridBagConstraints gbc_lbl_view_name = new GridBagConstraints();
		gbc_lbl_view_name.anchor = GridBagConstraints.EAST;
		gbc_lbl_view_name.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_view_name.gridx = 0;
		gbc_lbl_view_name.gridy = 1;
		pnl_view_project.add(lbl_view_name, gbc_lbl_view_name);
		
		lbl_view_created = new JLabel("Created At:");
		GridBagConstraints gbc_lbl_view_created = new GridBagConstraints();
		gbc_lbl_view_created.anchor = GridBagConstraints.EAST;
		gbc_lbl_view_created.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_view_created.gridx = 0;
		gbc_lbl_view_created.gridy = 2;
		pnl_view_project.add(lbl_view_created, gbc_lbl_view_created);
		
		lbl_view_manager = new JLabel("Manager:");
		GridBagConstraints gbc_lbl_view_manager = new GridBagConstraints();
		gbc_lbl_view_manager.anchor = GridBagConstraints.EAST;
		gbc_lbl_view_manager.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_view_manager.gridx = 0;
		gbc_lbl_view_manager.gridy = 3;
		pnl_view_project.add(lbl_view_manager, gbc_lbl_view_manager);
		
		txt_view_name = new JTextField();
		GridBagConstraints gbc_txt_view_name = new GridBagConstraints();
		gbc_txt_view_name.insets = new Insets(0, 0, 5, 5);
		gbc_txt_view_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_view_name.gridx = 1;
		gbc_txt_view_name.gridy = 1;
		pnl_view_project.add(txt_view_name, gbc_txt_view_name);
		txt_view_name.setColumns(10);
		
		txt_view_created = new JTextField();
		GridBagConstraints gbc_txt_view_created = new GridBagConstraints();
		gbc_txt_view_created.insets = new Insets(0, 0, 5, 5);
		gbc_txt_view_created.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_view_created.gridx = 1;
		gbc_txt_view_created.gridy = 2;
		pnl_view_project.add(txt_view_created, gbc_txt_view_created);
		txt_view_created.setColumns(10);
		
		txt_view_manager = new JTextField();
		GridBagConstraints gbc_txt_view_manager = new GridBagConstraints();
		gbc_txt_view_manager.insets = new Insets(0, 0, 5, 5);
		gbc_txt_view_manager.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_view_manager.gridx = 1;
		gbc_txt_view_manager.gridy = 3;
		pnl_view_project.add(txt_view_manager, gbc_txt_view_manager);
		txt_view_manager.setColumns(10);
		
		btnAddNewProject = new JButton("Add Project");
		btnAddNewProject.addMouseListener(new BtnAddNewProjectMouseListener());
		GridBagConstraints gbc_btnAddNewProject = new GridBagConstraints();
		gbc_btnAddNewProject.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddNewProject.gridx = 0;
		gbc_btnAddNewProject.gridy = 2;
		frame.getContentPane().add(btnAddNewProject, gbc_btnAddNewProject);
		
		for (int i = 0; i < 9; i++) {
			pnl_project.add(new MyProjectPanel());
			pnl_projects.add(pnl_project.get(i), "Project");
			pnl_project.get(i).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
			pnl_project.get(i).getLabelImage().addMouseListener(new LblProjectImageMouseListener());
		}
		
	}
	
	private class ChckbxSelectProjectItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent arg0) {
			panels_selected.clear();
			// Obtain the selected panels.
			for (int i = 0; i < pnl_project.size(); i++) {
				if (pnl_project.get(i).getCheckBox().isSelected()) {
					panels_selected.add(pnl_project.get(i));
				}
			}
			
			if (panels_selected.size() > 0) {
				txtSearch.setVisible(false);
				lbl_Delete.setVisible(true);
				btn_search.setVisible(false);
				lbl_filter.setVisible(false);
				lbl_settings.setVisible(false);
				lbl_projects_selected.setVisible(true);
				lbl_projects_selected.setText("");
				lbl_projects_selected.setText(panels_selected.size() + " Project Selected");
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
	
	private class LblProjectImageMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent event) {
			pnl_view_project.setVisible(true);
			txt_view_name.setText("Project1");
			txt_view_created.setText("01/01/2000");
			textPane_description.setText("Little description");
			txt_view_manager.setText("Foo Bar");
		}
	}
	private class Lbl_DeleteMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent mouse_event) {
			for (int i = 0; i < panels_selected.size(); ) {
				MyProjectPanel my_panel = panels_selected.get(i);
				my_panel.getCheckBox().setSelected(false);
				pnl_projects.remove(my_panel);
				pnl_project.remove(my_panel);
			}
			panels_selected.clear();
		}
	}
	private class BtnAddNewProjectMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int len = pnl_project.size();
			if (len < 9) {
				pnl_project.add(new MyProjectPanel());
				pnl_projects.add(pnl_project.get(len));
				pnl_project.get(len).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
				pnl_project.get(len).getLabelImage().addMouseListener(new LblProjectImageMouseListener());
				frame.repaint();
				frame.revalidate();
			}
		}
	}
}

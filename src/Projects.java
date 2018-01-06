import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	private JSONArray projects;
	private JSONObject obj;
	private String new_path;
	
	private Project current_proj;
	private JLabel lblInfo;
	
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
	
		try {
			StringBuilder sb = new StringBuilder();

		    String line;
		    BufferedReader br = new BufferedReader(new FileReader(MyProjectPanel.class.getResource("data.json").getPath()));
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
			obj = new JSONObject(sb.toString());
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
		btn_search.addMouseListener(new Btn_searchMouseListener());
		GridBagConstraints gbc_btn_search = new GridBagConstraints();
		gbc_btn_search.insets = new Insets(0, 0, 5, 5);
		gbc_btn_search.gridx = 1;
		gbc_btn_search.gridy = 0;
		panel.add(btn_search, gbc_btn_search);
		
		lbl_filter = new JLabel("");
		lbl_filter.addMouseListener(new Lbl_filterMouseListener());
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
		lbl_view_image.addMouseListener(new Lbl_view_imageMouseListener());
		if (current_proj != null) {
			ImageIcon init_icon = new ImageIcon(current_proj.getImage_path());
			Image img = init_icon.getImage();
			Image scaled = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
			ImageIcon scaled_icon = new ImageIcon(scaled);
			lbl_view_image.setIcon(scaled_icon);
		} else { 
			ImageIcon init_icon = new ImageIcon(Projects.class.getResource("/resources/user.png"));
			Image img = init_icon.getImage();
			Image scaled = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
			ImageIcon scaled_icon = new ImageIcon(scaled);
			lbl_view_image.setIcon(scaled_icon);
		}
		GridBagConstraints gbc_lbl_view_image = new GridBagConstraints();
		gbc_lbl_view_image.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_view_image.gridx = 1;
		gbc_lbl_view_image.gridy = 0;
		pnl_view_project.add(lbl_view_image, gbc_lbl_view_image);
		
		btnEditProjectInfo = new JButton("EDIT");
		btnEditProjectInfo.addMouseListener(new BtnEditProjectInfoMouseListener());
		GridBagConstraints gbc_btnEditProjectInfo = new GridBagConstraints();
		gbc_btnEditProjectInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditProjectInfo.gridx = 1;
		gbc_btnEditProjectInfo.gridy = 8;
		pnl_view_project.add(btnEditProjectInfo, gbc_btnEditProjectInfo);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Item1", "Item2", "Item3", "Item4"};
			@Override
			public int getSize() {
				return values.length;
			}
			@Override
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
		gbc_btnAddNewProject.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddNewProject.gridx = 0;
		gbc_btnAddNewProject.gridy = 2;
		frame.getContentPane().add(btnAddNewProject, gbc_btnAddNewProject);
		
		lblInfo = new JLabel("");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 0, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 2;
		frame.getContentPane().add(lblInfo, gbc_lblInfo);
		
		for (int i = 0; i < projects.length(); i++) {
			try {
				pnl_project.add(new MyProjectPanel(new Project(projects.getJSONObject(i).getString("name"),
						projects.getJSONObject(i).getString("image_path"), 
						projects.getJSONObject(i).getString("created_at"), 
						projects.getJSONObject(i).getString("manager"), 
						projects.getJSONObject(i).getString("description"))));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pnl_projects.add(pnl_project.get(i), "Project");
			pnl_project.get(i).addMouseListener(new PnlProjectMouseListener());
			pnl_project.get(i).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
		}
		
	}
	
	// Select a project to delete it
	private class ChckbxSelectProjectItemListener implements ItemListener {
		@Override
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
	
	// View a specific project
	private class PnlProjectMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent event) {
			pnl_view_project.setVisible(true);
			
			current_proj = ((MyProjectPanel) event.getSource()).associated_project;
			if (current_proj.getImage_path().contains("resources/")) {
				ImageIcon init_icon = new ImageIcon(MyProjectPanel.class.getResource(current_proj.getImage_path()));
				Image img = init_icon.getImage();
				Image scaled = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
				ImageIcon scaled_icon = new ImageIcon(scaled);
				lbl_view_image.setIcon(scaled_icon);
			}
			else {
				ImageIcon init_icon = new ImageIcon(current_proj.getImage_path());
				Image img = init_icon.getImage();
				Image scaled = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
				ImageIcon scaled_icon = new ImageIcon(scaled);
				lbl_view_image.setIcon(scaled_icon);
			}
			txt_view_name.setText(((MyProjectPanel) event.getSource()).associated_project.getName());
			txt_view_created.setText(((MyProjectPanel) event.getSource()).associated_project.getCreated_at());
			textPane_description.setText(((MyProjectPanel) event.getSource()).associated_project.getDescription());
			txt_view_manager.setText(((MyProjectPanel) event.getSource()).associated_project.getManager());
			frame.repaint();
			frame.revalidate();
		}
	}
	
	// Delete selected projects
	private class Lbl_DeleteMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent mouse_event) {
			for (int i = 0; i < panels_selected.size(); ) {
				MyProjectPanel my_panel = panels_selected.get(i);
				projects.remove(i);
				// Save changes on disk
				try {
					obj.put("projects", projects);
					FileWriter file = new FileWriter(MyProjectPanel.class.getResource("data.json").getPath());
					BufferedWriter outstream = new BufferedWriter(file);
					outstream.write(obj.toString());
					outstream.close();
					showStatusInfo(Color.GREEN, "Projects have been removed.");
				} catch (JSONException | IOException e) {
					showStatusInfo(Color.RED, "Projects have not been removed correctly");
					e.printStackTrace();
				}
				my_panel.getCheckBox().setSelected(false);
				pnl_projects.remove(my_panel);
				pnl_project.remove(my_panel);
			}
			panels_selected.clear();
			
		}
	}
	// Add a new project
	private class BtnAddNewProjectMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int len = pnl_project.size();
			if (len < 9) {
				JSONObject proj = new JSONObject();
				try {
					proj.put("name", "Default");
					proj.put("id", pnl_project.size() + 1);
					proj.put("image_path", "/resources/project.png");
					proj.put("created_at", new Date().toString());
					proj.put("manager", "Default");
					proj.put("description", "empty");
					projects.put(proj);
					obj.put("projects", projects);
					FileWriter file = new FileWriter(MyProjectPanel.class.getResource("data.json").getPath());
					BufferedWriter outstream = new BufferedWriter(file);
					outstream.write(obj.toString());
					outstream.close();
					showStatusInfo(Color.GREEN, "Project has been added");
				} catch (JSONException | IOException e) {
					showStatusInfo(Color.RED, "Project has not been added correctly.");
					e.printStackTrace();
				}
				
				try {
					Project p = new Project(proj.getString("name"), proj.getString("image_path"), proj.getString("created_at"), 
							proj.getString("manager"), proj.getString("description"));
					pnl_project.add(new MyProjectPanel(p));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pnl_projects.add(pnl_project.get(len));
				pnl_project.get(len).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
				pnl_project.get(len).addMouseListener(new PnlProjectMouseListener());
				frame.repaint();
				frame.revalidate();
			}
		}
	}
	// Edit a project
	private class BtnEditProjectInfoMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			MyProjectPanel panel_to_change = null;
			for (int i = 0; i < pnl_project.size(); i++) {
				if (pnl_project.get(i).associated_project.equals(current_proj)) {
					panel_to_change = pnl_project.get(i);
					break;
				}
			}
			if (!txt_view_name.getText().equals("")) {
				current_proj.setName(txt_view_name.getText());
				panel_to_change.lblProjectName.setText(txt_view_name.getText());
			}
			if (!txt_view_manager.getText().equals(""))
				current_proj.setManager(txt_view_manager.getText());
			if (!txt_view_created.getText().equals(""))
				current_proj.setCreated_at(txt_view_created.getText());
			if (!textPane_description.getText().equals(""))
				current_proj.setDescription(textPane_description.getText());
			
			try {
				JSONObject proj = projects.getJSONObject(ThreadLocalRandom.current().nextInt(0, projects.length() + 1));
				proj.put("name", current_proj.getName());
				proj.put("created_at", current_proj.getCreated_at());
				proj.put("manager", current_proj.getManager());
				proj.put("description", current_proj.getDescription());
				// If image has been modified
				if (new_path != null) {
					// Save image into MyProjectPanel
					if (new_path.contains("resources/")) {
						ImageIcon icon = new ImageIcon(MyProjectPanel.class.getResource(new_path));
						Image img = icon.getImage();
						Image scaled = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
						ImageIcon scaled_icon = new ImageIcon(scaled);
						panel_to_change.lblProjectImage.setIcon(scaled_icon);
					} else {
						ImageIcon icon = new ImageIcon(new_path);
						Image img = icon.getImage();
						Image scaled = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
						ImageIcon scaled_icon = new ImageIcon(scaled);
						panel_to_change.lblProjectImage.setIcon(scaled_icon);
					}
					// Save path into JSON object
					current_proj.setImage_path(new_path);
					proj.put("image_path", current_proj.getImage_path());
					new_path = null;
				}
				
				FileWriter file = new FileWriter(MyProjectPanel.class.getResource("data.json").getPath());
				BufferedWriter outstream = new BufferedWriter(file);
				outstream.write(obj.toString());
				outstream.close();
				showStatusInfo(Color.GREEN, "Project has been edited");
			} catch (JSONException | IOException e) {
				showStatusInfo(Color.RED, "Project has not been edited correctly");
				e.printStackTrace();
			}
			repaintPanels();
		}
	}
	// Change image
	private class Lbl_view_imageMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
		   JFileChooser file_chooser = new JFileChooser();
		   file_chooser.showOpenDialog(panel);
		   FileFilter imageFilter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
		   file_chooser.setFileFilter(imageFilter);
		   new_path = file_chooser.getSelectedFile().getAbsolutePath();
		}
	}
	// Search a project
	private class Btn_searchMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String text_to_search = txtSearch.getText();
			ArrayList<MyProjectPanel> panels_according_search = new ArrayList<>();
			// Get panels that match with the search
			for (int i = 0; i < pnl_project.size(); i++) {
				if (pnl_project.get(i).associated_project.getName().contains(text_to_search)) {
					panels_according_search.add(pnl_project.get(i));
				}
			}
			// Paint the panels
			pnl_projects.removeAll();
			if (text_to_search.isEmpty()) {
				repaintPanels();
			} else {
				for (int i = 0; i < panels_according_search.size(); i++) {
					pnl_projects.add(panels_according_search.get(i), "Project");
					pnl_project.get(i).addMouseListener(new PnlProjectMouseListener());
					pnl_project.get(i).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
				}
			}
			pnl_projects.updateUI();
		}
	}
	private class Lbl_filterMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			MyProjectInfo window = new MyProjectInfo();
			window.frame.setVisible(true);
			frame.setVisible(false);
			frame.dispose();
		}
	}
	
	private void showStatusInfo(Color color, String text_to_show) {
		lblInfo.setForeground(color);
		lblInfo.setText(text_to_show);
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblInfo.setText("");
			}
		};
		javax.swing.Timer timer = new javax.swing.Timer(2500, taskPerformer);
		timer.setRepeats(false);
		timer.start();
	}
	
	private void repaintPanels() {
		pnl_projects.removeAll();
		for (int i = 0; i < pnl_project.size(); i++) {
			pnl_projects.add(pnl_project.get(i), "Project");
			pnl_project.get(i).addMouseListener(new PnlProjectMouseListener());
			pnl_project.get(i).getCheckBox().addItemListener(new ChckbxSelectProjectItemListener());
		}
		pnl_projects.updateUI();
	}
}

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyProjectPanel extends JPanel{
	private JLabel lblProjectImage;
	private JLabel lblProjectName;
	public Project associated_project;
	private JCheckBox chckbxSelectProject;
	
	/**
	 * Create the application.
	 */
	public MyProjectPanel(Project project) {
		associated_project = project;
		
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 247, 0};
		gridBagLayout.rowHeights = new int[]{0, 1, 21, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblProjectImage = new JLabel("");
		if (associated_project.getImage_path().contains("resources/"))
			lblProjectImage.setIcon(new ImageIcon(MyProjectPanel.class.getResource(associated_project.getImage_path())));
		else
			lblProjectImage.setIcon(new ImageIcon(associated_project.getImage_path()));
		GridBagConstraints gbc_lblProjectImage = new GridBagConstraints();
		gbc_lblProjectImage.fill = GridBagConstraints.BOTH;
		gbc_lblProjectImage.insets = new Insets(0, 0, 5, 0);
		gbc_lblProjectImage.gridx = 1;
		gbc_lblProjectImage.gridy = 1;
		add(lblProjectImage, gbc_lblProjectImage);
		
		chckbxSelectProject = new JCheckBox("");
		chckbxSelectProject.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_chckbxSelectProject = new GridBagConstraints();
		gbc_chckbxSelectProject.anchor = GridBagConstraints.EAST;
		gbc_chckbxSelectProject.gridx = 1;
		gbc_chckbxSelectProject.gridy = 2;
		add(chckbxSelectProject, gbc_chckbxSelectProject);
		
		lblProjectName = new JLabel(associated_project.getName());
		lblProjectName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblProjectName = new GridBagConstraints();
		gbc_lblProjectName.fill = GridBagConstraints.BOTH;
		gbc_lblProjectName.gridx = 1;
		gbc_lblProjectName.gridy = 2;
		add(lblProjectName, gbc_lblProjectName);
	}	
	
	public JCheckBox getCheckBox() {
		return chckbxSelectProject;
	}
	
	public JLabel getLabelImage() {
		return lblProjectImage;
	}
	
}

package com.ipo;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Chat {

	public JFrame frame;
	private JLabel icon_send;
	private JLabel icon_clip;
	private JLabel icon_chat;
	private JTextField txt_msg;
	private JLabel lblTasks;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	private JLabel getIcon_chat() {
		if (icon_chat == null) {
			icon_chat = new JLabel("");
			icon_chat.setIcon(new ImageIcon(Chat.class.getResource("/resources/harry_potter_icon.png")));
		}
		return icon_chat;
	}
	private JLabel getIcon_clip() {
		if (icon_clip == null) {
			icon_clip = new JLabel("");
			icon_clip.setIcon(new ImageIcon(Chat.class.getResource("/resources/icon-clip.png")));
		}
		return icon_clip;
	}
	private JLabel getIcon_send() {
		if (icon_send == null) {
			icon_send = new JLabel("");
			icon_send.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String txt = getTxt_msg().getText();
					textArea.append(txt+"\n");
					txt_msg.setText("");	
				}
			});
			icon_send.setIcon(new ImageIcon(Chat.class.getResource("/resources/icon_send.png")));
		}
		return icon_send;
	}
	private JLabel getLblTasks() {
		if (lblTasks == null) {
			lblTasks = new JLabel("Tasks");
		}
		return lblTasks;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setAutoscrolls(true);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JTextField getTxt_msg() {
		if (txt_msg == null) {
			txt_msg = new JTextField();
			txt_msg.setColumns(10);
		}
		return txt_msg;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{37, 23, 301, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 204, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblTasks = new GridBagConstraints();
		gbc_lblTasks.insets = new Insets(0, 0, 5, 5);
		gbc_lblTasks.gridx = 1;
		gbc_lblTasks.gridy = 0;
		frame.getContentPane().add(getLblTasks(), gbc_lblTasks);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(getScrollPane(), gbc_scrollPane);
		GridBagConstraints gbc_icon_clip = new GridBagConstraints();
		gbc_icon_clip.insets = new Insets(0, 0, 0, 5);
		gbc_icon_clip.gridx = 0;
		gbc_icon_clip.gridy = 2;
		frame.getContentPane().add(getIcon_clip(), gbc_icon_clip);
		GridBagConstraints gbc_txt_msg = new GridBagConstraints();
		gbc_txt_msg.gridwidth = 2;
		gbc_txt_msg.insets = new Insets(0, 0, 0, 5);
		gbc_txt_msg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_msg.gridx = 1;
		gbc_txt_msg.gridy = 2;
		frame.getContentPane().add(getTxt_msg(), gbc_txt_msg);
		GridBagConstraints gbc_icon_send = new GridBagConstraints();
		gbc_icon_send.gridx = 3;
		gbc_icon_send.gridy = 2;
		frame.getContentPane().add(getIcon_send(), gbc_icon_send);
	}
}

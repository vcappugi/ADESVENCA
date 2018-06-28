package org.compiere.pos;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class migPOS extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public migPOS() {
		setLayout(new MigLayout("", "[117px]", "[25px][19px]"));
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, "cell 0 0,alignx left,aligny top");
		
		textField = new JTextField();
		add(textField, "cell 0 1,alignx left,aligny top");
		textField.setColumns(10);

	}

}

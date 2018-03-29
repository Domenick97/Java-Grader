package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Homework;

/**
 * The GUI for the HomeworkGUI
 * 
 * Modified from BinaryDecimalConverter in the BaseConvertor program
 * 
 * @author Domenick DiBiase
 *
 */
public class HomeworkGUI extends JFrame implements ActionListener {
	/** Serial version ID Number */
	private static final long serialVersionUID = 1L;
	/** Button to run the conversion */
	JButton btnRun = new JButton("Grade");

	/** Text box for assignment names */
	JTextField tbAssign1 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign2 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign3 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign4 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign5 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign6 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign7 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign8 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign9 = new JTextField();
	/** Text box for assignment names */
	JTextField tbAssign10 = new JTextField();
	/** Text area to paste in the assignment */
	JTextArea taInputMain = new JTextArea();
	/** Text area to paste in the assignment */
	JTextArea taOutputMain = new JTextArea();

	/** Panel for the prompt */
	JPanel pnlAssignments = new JPanel();
	/** Panel for the input fields */
	JPanel pnlInput = new JPanel();
	/** Panel for the run button */
	JPanel pnlRun = new JPanel();
	/** Panel for the output */
	JPanel pnlOutput = new JPanel();
	/** Label for the output */
	JLabel lblOut;

	public static void main(String[] args) {
		new HomeworkGUI();
	}

	public HomeworkGUI() {
		Container cont = getContentPane();

		setTitle("Homework Grader");
		setSize(800, 500);
		setLocation(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// GridBag Layout setup
		cont.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		lblOut = new JLabel();
		JLabel lblNumber = new JLabel("  Enter assignments below");
		
		
		pnlAssignments.setLayout(new GridBagLayout());

		tbAssign1.setColumns(10);
		tbAssign2.setColumns(10);
		tbAssign3.setColumns(10);
		tbAssign4.setColumns(10);
		tbAssign5.setColumns(10);
		tbAssign6.setColumns(10);
		tbAssign7.setColumns(10);
		tbAssign8.setColumns(10);
		tbAssign9.setColumns(10);
		tbAssign10.setColumns(10);

		taInputMain.setRows(15);
		taInputMain.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(taInputMain);
		//scroll.setPreferredSize(new Dimension(450, 150));
		taOutputMain.setRows(5);
		taOutputMain.setLineWrap(true);
		//taOutputMain.setHorizontalAlignment(JTextField.CENTER);// setAlignment(Component.CENTER);
		taOutputMain.setEditable(false);
			
		//pnlAssignments.add(lblNumber);
		pnlRun.add(btnRun, BorderLayout.WEST);
		btnRun.addActionListener(this);
		pnlOutput.add(lblOut, BorderLayout.NORTH);
		
		c.insets = new Insets(2,60, 2, 2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		pnlAssignments.add(lblNumber, c);
		
		c.insets = new Insets(2, 2, 2, 2);
		/* Row 1 */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 1;
		pnlAssignments.add(tbAssign1, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 1;
		pnlAssignments.add(tbAssign2, c);

		/* Row 2 */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 2;
		pnlAssignments.add(tbAssign3, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 2;
		pnlAssignments.add(tbAssign4, c);
		
		
		/* Row 3 */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 3;
		pnlAssignments.add(tbAssign5, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 3;
		pnlAssignments.add(tbAssign6, c);

		/* Row 4 */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 4;
		pnlAssignments.add(tbAssign7, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 4;
		pnlAssignments.add(tbAssign8, c);

		/* Row 5 */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 5;
		pnlAssignments.add(tbAssign9, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 5;
		pnlAssignments.add(tbAssign10, c);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 2;
		c.gridheight = 3;
		c.gridx = 0;
		c.gridy = 1;
		cont.add(pnlAssignments, c);

		// Input Text Area
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 2;
		c.gridheight = 4;
		c.gridx = 3;
		c.gridy = 1;
		cont.add(scroll, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 3;
		c.gridy = 6;
		cont.add(pnlRun, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 4;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 7;
		cont.add(taOutputMain, c);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRun) {
			System.out.println("Button \"Grade\" *click*");
			taOutputMain.setText(Homework.getInstance()
					.scan(new String[] { tbAssign1.getText(), tbAssign2.getText(), tbAssign3.getText(),
							tbAssign4.getText(), tbAssign5.getText(), tbAssign6.getText(), tbAssign7.getText(),
							tbAssign8.getText(), tbAssign9.getText(), tbAssign10.getText() },
							taInputMain.getText().replaceAll("[^\\x20-\\x7e]", "")));
			taOutputMain.setEditable(false);
		}
	}
}

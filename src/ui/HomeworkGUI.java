package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Homework;

/**
 * The GUI for the HomeworkGUI
 * 
 * Date Created: January 7, 2018
 * 
 * Update: April, 3, 2018
 * 
 * @version 1.5
 * 
 * @author Domenick DiBiase
 */
public class HomeworkGUI extends JFrame implements ActionListener {
	/** Serial version ID Number */
	private static final long serialVersionUID = 1L;
	/** Button to run the grading sequence */
	JButton btnRun = new JButton("Grade");
	/** Button to clear the input panel */
	JButton btnClear = new JButton("Clear");

	/** Array of text box assignment inputs */
	JTextField tbAssignments[] = new JTextField[10];

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

	/**
	 * Main method that is run upon start of the program Creates an instance of the
	 * Homework GUI
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		new HomeworkGUI();
	}

	/**
	 * Graphical User Interface for the homework grader
	 */
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

		// Initializes the input text boxes for assignment names
		for (int i = 0; i < tbAssignments.length; i++) {
			tbAssignments[i] = new JTextField();
			tbAssignments[i].setColumns(10);
		}

		taInputMain.setRows(15);
		taInputMain.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(taInputMain);
		taOutputMain.setRows(5);
		taOutputMain.setLineWrap(true);
		taOutputMain.setEditable(false);

		pnlRun.add(btnRun, BorderLayout.WEST);
		pnlRun.add(btnClear, BorderLayout.EAST);
		btnRun.addActionListener(this);
		pnlOutput.add(lblOut, BorderLayout.NORTH);

		c.insets = new Insets(2, 60, 2, 2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		pnlAssignments.add(lblNumber, c);

		c.insets = new Insets(2, 2, 2, 2);

		// Adds the assignment input text boxes to the assignments panel
		for (int i = 0; i < tbAssignments.length; i += 2) {
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.weighty = 1;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 0;
			c.gridy = i + 1;
			pnlAssignments.add(tbAssignments[i], c);

			// If the number of assignments is odd then don't add the second box on the last
			// row
			if (i + 1 < tbAssignments.length) {
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 1;
				c.weighty = 1;
				c.gridwidth = 1;
				c.gridheight = 1;
				c.gridx = 1;
				c.gridy = i + 1;
				pnlAssignments.add(tbAssignments[i + 1], c);
			}
		}

		// Adds the assignment panel to the container
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 2;
		c.gridheight = 3;
		c.gridx = 0;
		c.gridy = 1;
		cont.add(pnlAssignments, c);

		// Adds the input text area to the container
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 2;
		c.gridheight = 4;
		c.gridx = 3;
		c.gridy = 1;
		cont.add(scroll, c);

		// Adds the run button to the container
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 3;
		c.gridy = 6;
		cont.add(pnlRun, c);

		// Adds the output text area to the container
		c.insets = new Insets(2, 100, 2, 100);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 7;
		cont.add(taOutputMain, c);

		setVisible(true);
	}

	/**
	 * Action listener method that calls the grade method from the homework class
	 * when the grade button is clicked. When the clear button is clicked it clears
	 * the text from the input text area.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRun) {
			System.out.println("Button \"Grade\" *click*");
			ArrayList<String> assignList = new ArrayList<String>();

			for (JTextField k : tbAssignments) {
				String next = k.getText().trim();
				if (next != null && !next.equals("")) {
					assignList.add(next);
				}
			}
			taOutputMain.setText(
					Homework.getInstance().grade(assignList, taInputMain.getText().replaceAll("[^\\x20-\\x7e]", " ")));
			taOutputMain.setEditable(false);
		}
		
		if (e.getSource() == btnClear) {
			
		}
		}
	}

}

package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

    /** Panel for the prompt */
    JPanel pnlPrompt = new JPanel();
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
        setSize(600, 300);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //GridBag Layout setup
        cont.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lblOut = new JLabel();
        JLabel lblNumber = new JLabel("Enter assignments below (only enter one)");
        //TODO: GridBag Layout for the panel
//        c.fill = GridBagConstraints.BOTH;
//        c.weightx = .0;
//        c.gridx = 0;
//        c.gridy = 0;
//        //c.anchor = GridBagConstraints.CENTER;
//        pnlInput.add(lblNumber, c);
//        
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = .0;
//        c.weighty = .0;
//        
//        c.gridx = 1;
//        c.gridy = 0;
//        pnlInput.add(tbNumber, c);
//        
//        c.weightx = .25;
//        c.weighty = .25;
//        c.gridx = 0;
//        c.gridy = 1;
//        pnlInput.add(lblBaseTen, c);
        
        
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
        pnlPrompt.add(lblNumber);
        pnlInput.add(tbAssign1);
        pnlInput.add(tbAssign2);
        pnlInput.add(tbAssign3);
        pnlInput.add(tbAssign4);
        pnlInput.add(tbAssign5);
        pnlInput.add(tbAssign6);
        pnlInput.add(tbAssign7);
        pnlInput.add(tbAssign8);
        pnlInput.add(tbAssign9);
        pnlInput.add(tbAssign10);
        pnlRun.add(btnRun, BorderLayout.NORTH);
        btnRun.addActionListener(this);
        pnlOutput.add(lblOut, BorderLayout.NORTH);

        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .0;
        c.weighty = .0;
        
        c.gridx = 0;
        c.gridy = 0;
        cont.add(pnlPrompt, c);
                
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .0;
        c.weighty = .0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        cont.add(pnlInput, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .0;
        c.weighty = .0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        cont.add(pnlRun, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .0;
        c.weighty = .0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        cont.add(pnlOutput, c);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnRun) {
            System.out.println("Button \"Grade\" *click*");
            try{
                lblOut.setText(Homework.getInstance().scan(new String[] {tbAssign1.getText(),tbAssign2.getText(),
                        tbAssign3.getText(),tbAssign4.getText(),tbAssign5.getText(),tbAssign6.getText(),
                        tbAssign7.getText(),tbAssign8.getText(),tbAssign9.getText(),tbAssign10.getText()}));
            } catch(FileNotFoundException p){
                JOptionPane.showMessageDialog(null, p, "Error Message" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

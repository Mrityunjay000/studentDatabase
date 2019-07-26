package studentDatabase;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

public class StudentGUI {
	private static JFrame frame = new JFrame("CHS Student Database");
	private static JPanel panel, panel2;
	private static JLabel fName, lName, age, grade, welcomeMsg;
	private static JTextField fieldNameFirst, fieldNameSecond, fieldAge, fieldGrade; 
	private static JButton seeInfo;
	private static JButton add = new JButton("Add Student");
	private static JButton back= new JButton("Go Back");
	private static JTable table;
	private static JScrollPane sp;
	private static String[] column = {"First Name", "Last Name", "Age", "Grade"};
	
	public StudentGUI() {
		/*
		 * String[][] data = {};
		 * 
		 * frame = new JFrame("CHS Student Database"); panel2 = new JPanel(); panel =
		 * new JPanel();
		 * 
		 * 
		 * fieldNameFirst = new JTextField("Enter First Name", 20); fieldNameSecond =
		 * new JTextField("Enter Last Name", 20); fieldAge = new JTextField("Enter Age",
		 * 20); fieldGrade = new JTextField("Enter Grade", 20);
		 * 
		 * add = new JButton("Add Student"); back = new JButton("Go Back"); seeInfo =
		 * new JButton("View all students");
		 * 
		 * fName = new JLabel("First Name"); lName = new JLabel("Last Name"); age = new
		 * JLabel("Age"); grade = new JLabel("Grade"); welcomeMsg = new
		 * JLabel("Welcome to the CHS Student Database! Please enter the information below"
		 * + " to add a new student.");
		 * 
		 * panel.add(welcomeMsg); panel.add(fName); panel.add(fieldNameFirst);
		 * panel.add(lName); panel.add(fieldNameSecond); panel.add(age);
		 * panel.add(fieldAge); panel.add(grade); panel.add(fieldGrade);
		 * 
		 * panel.add(add); panel.add(seeInfo);
		 * 
		 * panel2.add(back);
		 * 
		 * 
		 * frame.add(panel2); frame.setSize(675, 500);
		 * frame.setLocationRelativeTo(null); frame.setResizable(false);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setVisible(true);
		 */
		panel = new JPanel();

		fieldNameFirst = new JTextField("Enter First Name", 20);
		fieldNameSecond = new JTextField("Enter Last Name", 20);
		fieldAge = new JTextField("Enter Age", 20);
		fieldGrade = new JTextField("Enter Grade", 20);
		
		//add 
		seeInfo = new JButton("View all students");
		//back 
		
		fName = new JLabel("First Name");
		lName = new JLabel("Last Name");
		age = new JLabel("Age");
		grade = new JLabel("Grade");
		welcomeMsg = new JLabel("Welcome to the CHS Student Database! Please enter the information below"
				+ " to add a new student.");
		buildPanel();
		frame.add(panel);
		frame.setSize(675, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(add);

        //System.out.println(back);
	}
	
	public void inputInfo() {
		/*
		 * fieldNameFirst.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * System.out.println(fieldNameFirst.getText()); } });
		 * fieldNameSecond.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * System.out.println(fieldNameSecond.getText()); } });
		 * fieldAge.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { System.out.println(fieldAge.getText()); }
		 * }); fieldGrade.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { System.out.println(fieldGrade.getText()); }
		 * });
		 */
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connector.input(fieldNameFirst.getText(), fieldNameSecond.getText(), fieldAge.getText(), fieldGrade.getText());
			}
	    });
	}
	
	public void outputInfo() {
		seeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(welcomeMsg);
				panel.remove(fName);
				panel.remove(fieldNameFirst);
				panel.remove(lName);
				panel.remove(fieldNameSecond);
				panel.remove(age);
				panel.remove(fieldAge);
				panel.remove(grade);
				panel.remove(fieldGrade);
				panel.remove(add);
				panel.remove(seeInfo);
				System.out.println(add);
				panel2.add(add);
				frame.repaint();
			}
	    });
	}
	
	public static void buildPanel() {
		panel.add(welcomeMsg);
		panel.add(fName);
		panel.add(fieldNameFirst);
		panel.add(lName);
		panel.add(fieldNameSecond);
		panel.add(age);
		panel.add(fieldAge);
		panel.add(grade);
		panel.add(fieldGrade);
		panel.add(add);
		panel.add(seeInfo);	
	}
	
	public static void buildPanelTwo() {
		
		panel2.add(back);
		frame.add(panel2);
		frame.setSize(675, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public static void goBack() {
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel2);
				buildPanel();
				frame.repaint();
			}
	    });
	}
}

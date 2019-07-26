package studentDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentDB {

	private static JFrame frame = new JFrame("CHS Student Database");
	private static JPanel panel = new JPanel();
	private static JLabel fName = new JLabel("First Name"), 
			lName = new JLabel("Last Name"), 
			age = new JLabel("Age"), 
			grade = new JLabel("Grade"), 
			welcomeMsg = new JLabel("Welcome to the CHS Student Database! Please enter the information below"
					+ " to add a new student.");
	private static JTextField fieldNameFirst = new JTextField("Enter First Name", 20), 
			fieldNameSecond = new JTextField("Enter Last Name", 20), 
			fieldAge = new JTextField("Enter Age", 20),
			fieldGrade = new JTextField("Enter Grade", 20); 
	private static JButton add = new JButton("Add Student");
	private static JTable table = getJTable();
	private static JScrollPane sp = new JScrollPane(table);
	private static String[] column = {"First Name", "Last Name", "Age", "Grade"};
	
	public StudentDB() {
		
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
		panel.add(sp);
		frame.add(panel);
		frame.setSize(675, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}
	
	private static JTable getJTable() {
	    String[] col = {"First Name", "Last Name", "Age", "Grade"};
	    JTable jTable = new JTable(); 
	           
	    DefaultTableModel contactTableModel = (DefaultTableModel) jTable.getModel();
	    contactTableModel.setColumnIdentifiers(col);
	    jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    return jTable;
	    
	}
	
	public static void updateTable() {
		//table.getMod
		DefaultTableModel ctable = (DefaultTableModel)table.getModel();
		ctable.setColumnIdentifiers(column);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    ctable.setRowCount(0);
	    //table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password"); 
			 
			Statement myStat2 = myConn.createStatement();
			
			ResultSet myRs = myStat2.executeQuery("select * from studentInfo");
			
			//ArrayList<String> holder = new ArrayList<String>();
			Object[] holder = new Object[4];
			int j = 0;
			while (myRs.next()) {
				//list.add(new ArrayList<String>());
				holder[0] = myRs.getString("first_name");
				holder[1] = myRs.getString("last_name");
				holder[2] = myRs.getString("age");
				holder[3] = myRs.getString("grade");
				
				ctable.addRow(holder);
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
			
	}
	
	public void inputInfo() {
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connector.input(fieldNameFirst.getText(), fieldNameSecond.getText(), fieldAge.getText(), fieldGrade.getText());
				updateTable();
			}
	    });
	}
	
	
}

package studentDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTable {
	private static JTable table;
	private static JScrollPane pane;
	private static JButton add;
	private static JPanel panel;
	private static String[] column = {"First Name", "Last Name", "Age", "Grade"};


	public static void main(String[] args) {
		String[][] data = {};
		JFrame frame = new JFrame();
		table = getJTable();
		pane = new JScrollPane(table);
		add = new JButton("add");
		panel = new JPanel();
		
	    panel.add(add);
	    panel.add(pane);
		frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
	    });
	}
	
	private static JTable getJTable() {
	    String[] colName = { "Name", "Email", "Contact No. 1", "Contact No. 2",
	            "Group"};
	    
	    JTable jTable = new JTable(); 
	           
	    DefaultTableModel contactTableModel = (DefaultTableModel) jTable.getModel();
	    contactTableModel.setColumnIdentifiers(colName);
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
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
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
	
	

}

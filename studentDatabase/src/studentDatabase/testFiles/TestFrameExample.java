package studentDatabase;

import java.awt.FlowLayout;
 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class TestFrameExample {
 
    public static void main(String s[]) {
 
        JFrame frame = new JFrame("JFrame Example");
 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
 
        JLabel label = new JLabel("This is a label!");
 
        JButton button = new JButton();
        button.setText("add table");
        
        JTextField field = new JTextField("Hello", 20);
        
        String[][] data = {{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"},
        		{"Tony", "Stark", "5", "5"}};
        String[] column = {"First Name", "Last Name", "Age", "Grade"};
        panel.add(label);
        panel.add(button);
        panel.add(field);
        
		/*
		 * button.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { JTable table = new JTable(data, column);
		 * 
		 * //table.setBounds(30,40,200,300); JScrollPane sp = new JScrollPane(table);
		 * 
		 * 
		 * panel.add(sp); frame.repaint(); } });
		 */
        JTable table = new JTable();
        DefaultTableModel ctable = (DefaultTableModel) table.getModel();
        
        //field.getT
        
       field.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(field.getText());
		}
    	   
       });
    
			
        
        //panel.setLayout(null);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
    }
 
}
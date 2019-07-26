package studentDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class Connector {
	
	public static void input(String fName, String lName, String age, String grade) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password"); 
			 
			Statement myStat = myConn.createStatement();
			
			//ResultSet myRs = myStat.executeQuery("select * from employees");
			
			myStat.executeUpdate("insert into studentInfo values ('" + fName + "', '" + lName + "', " + age + ", " + grade + ");");
			

			/*
			 * while (myRs.next()) { System.out.println(myRs.getString("last_name") + ", " +
			 * myRs.getString("first_name")); }
			 */
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static String[][] output() {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password"); 
			 
			Statement myStat2 = myConn.createStatement();
			
			ResultSet myRs = myStat2.executeQuery("select * from studentInfo");
			
			ArrayList<String> holder = new ArrayList<String>();
			int j = 0;
			while (myRs.next()) {
				list.add(new ArrayList<String>());
				list.get(j).add(myRs.getString("first_name"));
				list.get(j).add(myRs.getString("last_name"));
				list.get(j).add(myRs.getString("age"));
				list.get(j).add(myRs.getString("grade"));

				
				/*
				holder.add(myRs.getString("first_name"));
				holder.add(myRs.getString("last_name"));
				holder.add(myRs.getString("age"));
				holder.add(myRs.getString("grade"));
				//System.out.println(holder);
				list.add(new ArrayList<String>(holder.size()));
				for(int i = 0; i < list.get(j).size(); i++) {
					list.get(j).add(e);
				}
				//System.out.println(list + "this is list");
				//System.out.println(holder + "holder before cleared");
				holder.clear();*/
				j++;
				//break;
				//System.out.println(holder + "holder after cleared");

			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		//System.out.println(list.get(1));
		//System.out.println(list.size());
		//System.out.println(list.get(0).size());
		//System.out.println(list);
		
		String[][] result = new String[list.size()][4];
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < 4; j++) {
				result[i][j] = list.get(i).get(j);
			}
		}
		//System.out.println(Arrays.deepToString(result));		
		return result;
		//return "";
	}
	

}

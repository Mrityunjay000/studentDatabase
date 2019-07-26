 package studentDatabase;
 
 import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password"); 
			//jdbc:mysql://localhost:3306/demo -- from a video. 
			//jdbc:mysql://localhost/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			//the line above is the one that needs to be used since MySQL 5.1.33 because of
			//"Apparently, to get version 5.1.33 of MySQL JDBC driver to work with UTC time zone, one has to specify the serverTimezone explicitly in the connection string."
			//above from "https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue". 
			
			//2. Create a statement
			Statement myStat = myConn.createStatement();
			Statement myStat2 = myConn.createStatement();

			
			//myStat.executeUpdate("insert into employees values ('Stark', 'Tony', 'stgmailcom')");
			
			//3. Execute a SQL Query
			ResultSet myRs = myStat.executeQuery("select * from employees");
			
			//ResultSetMetaData metadata = myRs.getMetaData();
			//int columnCount = metadata.getColumnCount();
			//System.out.println(columnCount);
			
			//adding a value into the table employees
			//myStat.executeQuery();
			//myStat2.executeUpdate("insert into employees values ('Wayne', 'Bruce', 'stgmailcom')");

			
			//4. Process the result set
			//System.out.println(myRs.getMetaData()); 
			while(myRs.next()) {
				System.out.println(myRs.getInt(1));
			}
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}

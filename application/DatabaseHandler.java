package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
	
	Connection dbConnection;
	
	public Connection getdbConnection() 
			throws ClassNotFoundException, SQLException{
		
		String connectionString = "jdbc:oracle:thin:@" + dbHost + ":" + dbPort + ":" + dbName;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
		
		return dbConnection;
	}
	
	public void signUpUser(User user)  {
		String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
	            Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
				Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
	            Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" +
	            "VALUES(?,?,?,?,?,?)";
		
		PreparedStatement prSt;
		try {
			prSt = getdbConnection().prepareStatement(insert);
			prSt.setString(1, user.getFirstName());
			prSt.setString(2, user.getLastName());
			prSt.setString(3, user.getUserName());
			prSt.setString(4, user.getPassword());
			prSt.setString(5, user.getLocation());
			prSt.setString(6, user.getGender());
			
			prSt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

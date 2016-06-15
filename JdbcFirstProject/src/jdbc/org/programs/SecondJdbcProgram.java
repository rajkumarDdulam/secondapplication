package jdbc.org.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SecondJdbcProgram {
	
	Connection con;
	DriverManager driver;
	Statement state;
	PreparedStatement prepare;
	
	
	public void withdrawCheckings(int withdraw) throws SQLException{
		
		
		String query1="update bankaccount set checkings=checkings - "+withdraw+" where id = 1 ";
		state.addBatch(query1);
	}
	
public void depositInSavings(int deposit) throws SQLException{
		
		
		String query2="update bankccount set savings=savings + "+deposit+" where id = 1 ";
		state.addBatch(query2);
	}

	
	public void connectingToDatabase() throws SQLException{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=driver.getConnection("jdbc:mysql://localhost:3306/rajkumar","root","root");
			
			con.setAutoCommit(false);
			
			state=con.createStatement();
			
			
			withdrawCheckings(50);
			depositInSavings(50);			
			state.executeBatch();
			con.commit();
			System.out.println("Succesfully done");
			
			
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
			con.rollback();
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		
SecondJdbcProgram second=new SecondJdbcProgram();

second.connectingToDatabase();
	}

}

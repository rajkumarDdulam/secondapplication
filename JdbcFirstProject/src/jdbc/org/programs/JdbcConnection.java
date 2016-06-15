package jdbc.org.programs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcConnection {
	
	public static void preparedStatementPractise(Connection con2,String name1, String author2,int id2) throws SQLException{
		PreparedStatement ps=con2.prepareStatement("insert into firsttable(author,name,id) values (?,?,?)");
		
		ps.setString(1, author2);
		ps.setString(2, name1);
		ps.setInt(3, id2);
		ps.executeUpdate();
		
		Statement sta=con2.createStatement();
		String query1="select * from firsttable";
		 ResultSet rs2=sta.executeQuery(query1);
		 rs2.first();
		 rs2.deleteRow();
		 rs2.close();
		 
		 
		/* while(rs2.next()){
			 System.out.println("Author: "+rs2.getString("author")+"\n"+"Name: "+rs2.getString("name"));
		 }*/
		
	}

	public static void main(String[] args) {
		
		
	Connection con=null;
		DriverManager driver=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
		con=driver.getConnection("jdbc:mysql://localhost:3306/jdbcconnection", "root", "root");
		
		
		
		preparedStatementPractise(con,"Raju3","Iowa3",888);
		//preparedStatementPractise(con,"Raju4","Iowa4",796);*/
		System.out.println("Successfully inserted");
		
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Please add the correct Driver");
		} catch (SQLException e) {
			System.out.println("error occured in get connection command");
			System.out.println(e.getMessage());
		}
	}

}

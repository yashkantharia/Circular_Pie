package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {
	 public static void main(String[] args) throws SQLException {
		   String url = "jdbc:oracle:thin:@localhost:1521:xe";
		   String uname = "system";
		   String password = "admin";
		   String query = "select * from customer"; 
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(ClassNotFoundException e){
			   e.printStackTrace();
		   }
		    try{

		    	Connection conn = DriverManager.getConnection(url,uname,password);
		    	Statement  statement = conn.createStatement();
		    	ResultSet result = statement.executeQuery(query);
		    	while(result.next()) {
		    		String id,name;
		    			id = result.getString("customer_id") + "" ;
		    			name = result.getString("first_name");
		    		System.out.println(id+ " " +name);
		    	}

		    } catch (SQLException e) {
		    	e.printStackTrace();
		    } 
		  }
}

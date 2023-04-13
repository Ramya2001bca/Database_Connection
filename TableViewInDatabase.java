package database_connection;
import java.sql.*;
import java.sql.Connection;
public class TableViewInDatabase {
        private final String url="jdbc:postgresql://localhost/student";
		private final String user="postgres";
		private final String password="muthu@123";
		
private void connect() {			
try(Connection con=DriverManager.getConnection(url,user,password);){
	if(con!=null)
		  {
			System.out.println("connectedd to postgresql server");
			}
	     else {
				System.out.println("failed to connect postgres server");
			}
	Statement stm=con.createStatement();
	ResultSet rs=stm.executeQuery("select* from student");
	while(rs.next()) {
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	}
	
         }
	catch(SQLException e)
	{
		e.printStackTrace();
	}
			}
		
		public static void main(String[] args) {
			TableViewInDatabase obj=new TableViewInDatabase();
			obj.connect();
		

	}

}

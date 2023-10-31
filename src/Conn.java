

import java.sql.*;

/*
 * Steps of JDBC Connectivity
 * 1. Register the driver class (optional step) 
 *  Code for registering : 
 * Class.forName("com.mysql.cj.jdbc.Driver");
 * 2. Create the connection
 * 3. Create Statement object
 * 4. Execute MySQL queries 
 * 5. Closing the connection
 */
public class Conn {

    Connection c; // 2
    Statement s; // 3
    Conn () {
        try {
            
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "password"); // 2
            s = c.createStatement();//3

        } catch(Exception e) {
            e.printStackTrace();
        }
    
        
    }
}

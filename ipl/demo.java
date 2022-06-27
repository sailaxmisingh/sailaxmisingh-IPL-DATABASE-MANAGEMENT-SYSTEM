
package ipl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import    java.sql.*;

public class demo {
Connection con=null;
    public static Connection  db() {
    	try{  
    		//step1 load the driver class  
    		Class.forName("oracle.jdbc.driver.OracleDriver");  
    		     		  
    		   //step2 create  the connection sailobject  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","sailaxmi","vasavi"); 
       //JOptionPane.showMessageDialog(null, "success");
    		    		return con;
    		}catch(Exception e){ System.out.println(e);
    		return null;}  
    		  

 }
    

}
import java.sql.*;  
class Connect{  
public static void main(String args[]){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","tanmay","T24091996");  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  

 
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  


class ViewEmployee extends JFrame{

Container c;
JLabel txtview;
JPanel spEmployee;
ResultSet s;

ViewEmployee(){
super("Employee Details");
c= getContentPane();

txtview= new JLabel();


spEmployee= new JPanel();
spEmployee.add(txtview);
//spEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
///spEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

c.add(spEmployee);


Connection con;
Statement stmt;
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
 con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","tanmay","T24091996");  
  
  
   
//step3 create the statement object  
 stmt=con.createStatement(); 
String list = new String("<html>"); 
 	ResultSet rs=stmt.executeQuery("select * from employee");  
	
	
	while(rs.next())  
		list += rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+" <br />";  
	
	list += "</html>";
	txtview.setText(list);
	
  
}catch(Exception e){ System.out.println(e);} 

 


setSize(500,150 );
setResizable(false);
setLocationRelativeTo(null);
setVisible(true);

this.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
HomeFrame h = new HomeFrame();
dispose();
}
});

}


}
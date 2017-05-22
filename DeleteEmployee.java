import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  


class DeleteEmployee extends JFrame{

Container c;
JTextField txtId;
JLabel lblId;
JButton btnDelete;
JPanel p1,p2;
Connection con;
Statement stmt;



DeleteEmployee(){
super("Delete  Employee Details");
c= getContentPane();
p1= new JPanel();
p1.setLayout(new FlowLayout());
lblId= new JLabel("Delete Employee Id: ");
txtId= new JTextField(4);
p1.add(lblId);
p1.add(txtId);
c.add(p1);

p2= new JPanel();
//setLayout(new FlowLayout());
btnDelete = new JButton("Delete");
p2.add(btnDelete);
JLabel result = new JLabel();
p2.add(result);

c.add("South",p2);
setSize(400,100 );
setResizable(false);
setLocationRelativeTo(null);
setVisible(true);

this.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
HomeFrame h = new HomeFrame();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){

int id = Integer.parseInt(txtId.getText());

String sql= "DELETE FROM Employee WHERE id="+id;
	System.out.println(sql);
	try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
 con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","tanmay","T24091996");  
  
//step3 create the statement object  
 stmt=con.createStatement();  
 	ResultSet s=stmt.executeQuery(sql);  
  
 result.setText("EMP ID : "+id+ " is Deleted"); 
}catch(Exception e){ System.out.println(e);} 





}
});



}


}
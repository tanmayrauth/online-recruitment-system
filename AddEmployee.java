import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  


class AddEmployee extends JFrame{
Container c;
JLabel lblId, lblName, lblPhone, lblAddress, lblEmail;
JTextField txtId, txtName, txtPhone, txtAddress, txtEmail;
JButton btnSave, btnBack;
JPanel p1,p2;
Connection con;
Statement stmt;

// adding employee constructor	
AddEmployee(){
super("Register Employee");
c= getContentPane();
c.setLayout(null);
lblId= new JLabel("ID:  ");
txtId= new JTextField(4);
lblName= new JLabel("Name: ");
txtName= new JTextField(15);
lblEmail= new JLabel("Email: ");
txtEmail= new JTextField(15);
lblPhone= new JLabel("Phone: ");
txtPhone= new JTextField(15);
lblAddress= new JLabel("Address: ");
txtAddress= new JTextField(15);

lblId.setBounds(100,50,80,30);
txtId.setBounds(200,50,110,30);
lblName.setBounds(100,100,80,30);
txtName.setBounds(200,100,110,30);
lblEmail.setBounds(100,150,80,30);
txtEmail.setBounds(200,150,110,30);
lblPhone.setBounds(100,200,80,30);
txtPhone.setBounds(200,200,110,30);
lblAddress.setBounds(100,250,80,30);
txtAddress.setBounds(200,250,110,30);


// adding components to jframe
c.add(lblId);
c.add(txtId);
c.add(lblName);
c.add(txtName);
c.add(lblEmail);
c.add(txtEmail);
c.add(lblPhone);
c.add(txtPhone);
c.add(lblAddress);
c.add(txtAddress);




btnSave = new JButton("Save");
btnBack= new JButton("Back");
btnBack.setBounds(100,300,80,30);
btnSave.setBounds(200,300,80,30);
JLabel result = new JLabel();
result.setBounds(100,350,280,30);

c.add(btnSave);
c.add(btnBack);
c.add(result);

setSize(400,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

btnBack.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
HomeFrame e = new HomeFrame();
dispose();
}
});



btnSave.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){

	int id = Integer.parseInt(txtId.getText());
	String name = txtName.getText();
	String address = txtAddress.getText();
	String email = txtEmail.getText();
	int phoneno = Integer.parseInt(txtPhone.getText());
	String sql= "INSERT INTO Employee values("+id+", '"+name+"', '"+email+"', "+phoneno+", '"+address+"')";
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
  
   result.setText("EMP Name : "+name+ " is Registered"); 

  
}catch(Exception e){ System.out.println(e);} 


}
});

}
}

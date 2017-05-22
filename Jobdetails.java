import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  

class Jobdetails extends JFrame{
Container c;
JLabel lblId, lblPost, lblCriteria, lblSalary, lblVacancy, result;
JTextField txtId, txtPost, txtCriteria, txtSalary, txtVacancy;
JButton btnSave, btnBack;
JPanel p1,p2;
//JTextView txtview;
Connection con;
Statement stmt;


Jobdetails(){
super("Post Job Details");


 
  
 


c= getContentPane();
c.setLayout(null);
JLabel header = new JLabel("Fill form to Post Job Details: ");
lblId= new JLabel("ID:  ");
txtId= new JTextField(4);
lblPost= new JLabel("Post: ");
txtPost= new JTextField(15);
lblCriteria= new JLabel("Criteria: ");
txtCriteria= new JTextField(15);
lblVacancy= new JLabel("Vacancy: ");
txtVacancy= new JTextField(15);
lblSalary= new JLabel("Salary: ");
txtSalary= new JTextField(15);
btnSave = new JButton("Save");
btnBack= new JButton("Back");
result = new JLabel();
c.add(lblId);
c.add(txtId);
c.add(lblPost);
c.add(txtPost);
c.add(lblCriteria);
c.add(txtCriteria);
c.add(lblVacancy);
c.add(txtVacancy);
c.add(lblSalary);
c.add(txtSalary);
c.add(btnSave);
c.add(btnBack);
c.add(header);
c.add(result);

lblId.setBounds(100,50,80,30);
txtId.setBounds(200,50,80,30);
lblPost.setBounds(100,100,80,30);
txtPost.setBounds(200,100,80,30);
lblCriteria.setBounds(100,150,80,30);
txtCriteria.setBounds(200,150,80,30);
lblVacancy.setBounds(100,200,80,30);
txtVacancy.setBounds(200,200,80,30);
lblSalary.setBounds(100,250,80,30);
txtSalary.setBounds(200,250,80,30);
btnBack.setBounds(100,300,80,30);
btnSave.setBounds(200,300,80,30);
header.setBounds(100,10,250,30);
result.setBounds(100,350,250,30);



setSize(400,450);
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
	String post = txtPost.getText();
	String criteria = txtCriteria.getText();
	int vacancy = Integer.parseInt(txtVacancy.getText());
	int salary = Integer.parseInt(txtSalary.getText());
	String sql= "INSERT INTO Job_details values("+id+", '"+post+"', '"+criteria+"', "+vacancy+", "+salary+")";
	System.out.println(sql);

	
	try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	
	//step2 create  the connection object  
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tanmay","T24091996");  
  
	//step3 create the statement object  
	stmt=con.createStatement();  
 	ResultSet s=stmt.executeQuery(sql);  
	
	result.setText("Advertisement Posted Sucessfully"); 
	txtId.setText("");
	txtPost.setText("");
	txtCriteria.setText("");
	txtVacancy.setText("");
	txtSalary.setText("");

	
}catch(Exception e){ System.out.println(e);} 


  
/*ResultSet rs=stmt.executeQuery("select * from Job_details");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
  
//step5 close the connection object  
con.close(); */
}


});
}
}
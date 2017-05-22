import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  


class UpdateJobdetails extends JFrame{
Container c;
JLabel lblId, lblVacancy, lblSalary;
JTextField txtId, txtVacancy, txtSalary;
JButton btnSave, btnBack;
JPanel p1,p2;

UpdateJobdetails(){
super("Update Jobdetails");

JLabel result = new JLabel();

c= getContentPane();
c.setLayout(null);
lblId= new JLabel("ID:  ");
txtId= new JTextField(4);
lblVacancy= new JLabel("Vacancy: ");
txtVacancy= new JTextField(15);
lblSalary= new JLabel("Salary: ");
txtSalary= new JTextField(15);
c.add(lblId);
c.add(txtId);
c.add(lblVacancy);
c.add(txtVacancy);
c.add(lblSalary);
c.add(txtSalary);
c.add(result);

btnSave = new JButton("Update Details");
btnBack= new JButton("Back");
c.add(btnSave);
c.add(btnBack);

lblId.setBounds(100,50,80,30);
txtId.setBounds(200,50,80,30);
lblVacancy.setBounds(100,100,80,30);
txtVacancy.setBounds(200,100,80,30);
lblSalary.setBounds(100,150,80,30);
txtSalary.setBounds(200,150,80,30);
btnBack.setBounds(100,200,80,30);
btnSave.setBounds(200,200,120,30);
result.setBounds(100,250,200,30);


setSize(400,400);
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
	int vacancy = Integer.parseInt(txtVacancy.getText());
	int salary = Integer.parseInt(txtSalary.getText());
	String sql= "UPDATE Job_details SET vacancy="+vacancy+", salary="+salary+" WHERE id="+id;
	System.out.println(sql);

	
	try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con;
	Statement stmt;
	//step2 create  the connection object  
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tanmay","T24091996");  
  
	//step3 create the statement object  
	stmt=con.createStatement();  
 	ResultSet s=stmt.executeQuery(sql);  
	
	result.setText("Job Details Updated");
  
}catch(Exception e){ System.out.println(e);} 




}
});

}
}
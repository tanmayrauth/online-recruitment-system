import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  


class Searchjob extends JFrame{

Container c;
JLabel txtview,msg,lbl;
JTextField sal1,sal2;
ResultSet s;
Connection con;
Statement stmt;
JButton btnSearch;

Searchjob(){
super("Job Search");
c= getContentPane();
c.setLayout(null);

txtview= new JLabel();
lbl= new JLabel("Select Salary Range: ");
sal1= new JTextField(6);
sal2= new JTextField(6);
msg = new JLabel(" - ");
btnSearch = new JButton("Search");

lbl.setBounds(80,10,120,30);
sal1.setBounds(205,10,40,30);
msg.setBounds(250,10,15,30);
sal2.setBounds(265,10,40,30);
btnSearch.setBounds(320,10,100,30);

c.add(lbl);
c.add(sal1);
c.add(msg);
c.add(sal2);
c.add(btnSearch);

txtview.setBounds(100,20,300,300);
c.add(txtview);


//spEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
///spEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
setSize(500,500 );
setResizable(false);
setLocationRelativeTo(null);
setVisible(true);


btnSearch.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	//step2 create  the connection object  
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tanmay","T24091996");  
	//step3 create the statement object  
	stmt=con.createStatement(); 
	int s1 = Integer.parseInt(sal1.getText());
	int s2 = Integer.parseInt(sal2.getText());

	
	
	String list = new String("<html><h4>(Job Id, Designation, Vacancy, Salary)</h4>"); 
 	ResultSet rs=stmt.executeQuery("SELECT * FROM Job_details WHERE salary >= "+s1+" AND salary <= "+s2);  
	while(rs.next())  
		list += rs.getInt(1)+" \t    "+rs.getString(2)+" \t    "+rs.getString(4)+"   \t  "+rs.getString(5)+" <br />";  
	
	list += "</html>";
	txtview.setText(list);
  
}catch(Exception e){ System.out.println(e);} 
}
});



this.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
HomeFrame h = new HomeFrame();
dispose();
}
});

}


}
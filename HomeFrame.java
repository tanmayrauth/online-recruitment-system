import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomeFrame extends JFrame{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete,btnPost,btnSearch;
HomeFrame(){
super("Home");

c= getContentPane();
c.setLayout(null);
JLabel header = new JLabel("Please Choose your Command: ");
btnAdd= new JButton("Register an Employee");
btnView= new JButton("View Employees");
btnUpdate= new JButton("Update Job Details");
btnDelete= new JButton("Delete an Employee");
btnPost= new JButton("Post Job Details");
btnSearch= new JButton("Search a new Job");



header.setBounds(100,10,250,30);
btnAdd.setBounds(100,50,180,30);
btnDelete.setBounds(100,100,180,30);
btnPost.setBounds(100,150,180,30);
btnView.setBounds(100,200,180,30);
btnUpdate.setBounds(100,250,180,30);
btnSearch.setBounds(100,300,180,30);

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnPost);
c.add(btnSearch);
c.add(header);

setSize(400,400 );
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setLocationRelativeTo(null);
setVisible(true);

btnAdd.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
AddEmployee e = new AddEmployee();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
UpdateJobdetails e = new UpdateJobdetails();
dispose();
}
});


btnView.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
ViewEmployee e = new ViewEmployee();
dispose();
}
});


btnDelete.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
DeleteEmployee e = new DeleteEmployee();
dispose();
}
});

btnPost.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
Jobdetails e = new Jobdetails();
dispose();
}
});

btnSearch.addActionListener(new ActionListener(){
public  void actionPerformed(ActionEvent a){
Searchjob e = new Searchjob();
dispose();
}
});

}// end of constructor

public static void main(String args[]){
HomeFrame h=new HomeFrame();
}// end of main
}// end of class
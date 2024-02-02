package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
private int studentid;
private String name,email,phno;
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
//there are 5 steps to connect DB
public static Connection getDBConnect() throws SQLException{
//1.Register Driver(DriverManager/class)
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//2.Connection(URL,user,password)
	String url="jdbc:mysql://localhost:3306/eg_javasb01_fiem";
	String user="root";
	String password="";
	Connection conn=DriverManager.getConnection(url,user,password);
	return conn;
}
public int addStudent() throws SQLException{
	Connection conn=getDBConnect();
//3.SQL query(insert,update,delete,read etc)
	String sql="insert into student() values(?,?,?,?)";
//4.prepare and execute
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, studentid);
	ps.setString(2, name);
	ps.setString(3, email);
	ps.setString(4, phno);
	int response=ps.executeUpdate();
//5.close connection
	conn.close();
	return response;
	}
public int updateStudent() throws SQLException{
	Connection conn=getDBConnect();
	String sql="update student set name = ?, email = ?, phno = ? where studentid = ?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, phno);
	ps.setInt(4, studentid);
	int response=ps.executeUpdate();
	conn.close();
	return response;
	}
public int deleteStudent() throws SQLException{
	Connection conn=getDBConnect();
	String sql="delete from student where studentid=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, studentid);
	int response=ps.executeUpdate();
	conn.close();
	return response;
	}
public void getAllStudent() throws SQLException{
	Connection conn=getDBConnect();
	String sql="select *from student";
	PreparedStatement ps=conn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		studentid=rs.getInt("studentid");
		name=rs.getString("name");
		email=rs.getString("email");
		phno=rs.getString("phno");
		System.out.println(studentid+" "+name+" "+email+" "+phno);
	}
	conn.close();
	
	}
public void getStudentById() throws SQLException{
	Connection conn=getDBConnect();
	String sql="select *from student where studentid=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1,studentid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		studentid=rs.getInt("studentid");
		name=rs.getString("name");
		email=rs.getString("email");
		phno=rs.getString("phno");
		System.out.println(studentid+" "+name+" "+email+" "+phno);
	}
	else {
		System.out.println("sorry "+studentid+" not exist");
	}
	conn.close();
	
	}
}

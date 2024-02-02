package Test;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class TestStudentData {
//public static void main(String[] args) throws SQLException {
//	int sid;
//	String name,email,phno;
//	Scanner sc=new Scanner(System.in);
//	System.out.println("enter student id:");
//	sid=sc.nextInt();
////	System.out.println("enter student name:");
////	name=sc.next();
////	System.out.println("enter student email:");
////	email=sc.next();
////	System.out.println("enter student phno:");
////	phno=sc.next();
//	Student s=new Student();
//	s.setStudentid(sid);
////	s.setName(name);
////	s.setEmail(email);
////	s.setPhno(phno);
////	int response=s.addStudent();
////	if(response==1) {
////		System.out.println("registration succesfully");
////	}
////	else {
////		System.out.println("registration failed");
////	}
//	s.getStudentById();
//}
//}
import java.sql.SQLException;
import java.util.Scanner;

public class TestStudentData {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.println("Choose an action:");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. get all student");
        System.out.println("5. Get Student by ID");

        int choice = sc.nextInt();
         switch (choice) {
            case 1:
                // Add Student
                System.out.println("Enter student id:");
                int sid = sc.nextInt();
                System.out.println("Enter student name:");
                String name = sc.next();
                System.out.println("Enter student email:");
                String email = sc.next();
                System.out.println("Enter student phno:");
                String phno = sc.next();

                s.setStudentid(sid);
                s.setName(name);
                s.setEmail(email);
                s.setPhno(phno);

                int response = s.addStudent();
                if (response == 1) {
                    System.out.println("Registration successful");
                } else {
                    System.out.println("Registration failed");
                }
                break;

            case 2:
                // Update Student
                System.out.println("Enter student id to update:");
                int updateSid = sc.nextInt();
                System.out.println("Enter updated student name:");
                String updateName = sc.next();
                System.out.println("Enter updated student email:");
                String updateEmail = sc.next();
                System.out.println("Enter updated student phno:");
                String updatePhno = sc.next();

                s.setStudentid(updateSid);
                s.setName(updateName);
                s.setEmail(updateEmail);
                s.setPhno(updatePhno);

                int updateResponse = s.updateStudent();
                if (updateResponse == 1) {
                    System.out.println("Update successful");
                } else {
                    System.out.println("Update failed");
                }
                break;

            case 3:
                // Delete Student
                System.out.println("Enter student id to delete:");
                int deleteSid = sc.nextInt();
                s.setStudentid(deleteSid);

                int deleteResponse = s.deleteStudent();
                if (deleteResponse == 1) {
                    System.out.println("Deletion successful");
                } else {
                    System.out.println("Deletion failed");
                }
                break;

            case 4:
            	//get all student
            	s.getAllStudent();
            	break;
            case 5:
                // Get Student by ID
                System.out.println("Enter student id:");
                int getSid = sc.nextInt();
                s.setStudentid(getSid);
                s.getStudentById();
                break;

            default:
                System.out.println("Invalid choice");
        }
     }
}


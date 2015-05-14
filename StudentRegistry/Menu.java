import java.util.*;

public class Menu {

	Operation op = new Operation ();
	Scanner scan = new Scanner (System.in);
	public void menu (){
	
		System.out.println("1. Adding Operations");
		System.out.println("2. Deleting Operations");
		System.out.println("3. Listing Operations");
		System.out.println("4. Exit");
		
		Scanner scan = new Scanner (System.in);
		int value = scan.nextInt();
		
		switch (value){
		
		case 1:
			add();
			break;
		case 2:
			delete();
			break;
		case 3:	
			list();
			break;
			
		case 4:
			System.out.println("Goodbye");
			System.exit(0);
			break;
		
		default:
			System.out.println("Please select operation 1-4");
			menu();
			break;
			
		}		
	}
	
	public void add(){
	
		System.out.println("1. Add a student");
		System.out.println("2. Add a student to a specified course");
		System.out.println("3. Add a course");
		System.out.println("4. Return to main menu");
		
		int add = scan.nextInt();
		
		switch (add){
		
		case 1:
			op.addstudent();
			add();
			break;
		case 2:
			op.addspecified();
			add();
			break;
		case 3:	
			op.addcourse();
			add();
			break;
			
		case 4:
			menu();
			break;
		default:
			System.out.println("Please select operation 1-4");
			add();
			break;
		}
	}
	public void delete(){
			
		System.out.println("1. Delete a student by student ID");
		System.out.println("2. Delete a student by student ID from a specified course");
		System.out.println("3. Delete a course by course ID");
		System.out.println("4. Return to main menu");
		
		int delete = scan.nextInt();
		
		switch (delete){
			
		case 1:
			op.deleteStud();
			delete();	
			break;
		case 2:
			op.deleteSpec();
			delete();	
			break;
		case 3:	
			op.deleteCo();
			delete();	
			break;	
		case 4:
			menu();
			break;
		default:
			System.out.println("Please select operation 1-4");
			delete();
			break;
		}
	}
	public void list(){
				
		System.out.println("1. List all students who registered a specified course");
		System.out.println("2. List all courses that a student registered");
		System.out.println("3. List all students");
		System.out.println("4. List all courses");
		System.out.println("5. Return to main menu");
		
		int list = scan.nextInt();
				
		switch (list){
				
		case 1:
			op.listSpecCrs();
			list();		
			break;
		case 2:
			op.listSpecStd();
			list();		
			break;
		case 3:	
			op.listStud();	
			list();
			break;
				
		case 4:
			op.listCourse();
			list();
			break;
		case 5:
			menu();
			break;	
		default:
			System.out.println("Please select operation 1-5");
			list();
			break;
	
		}
	}
}

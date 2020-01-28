package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		/*System.out.println("\n\n----------------- TESTS DEPARTMENT --------------------\n\n");
		
		System.out.println("\n=== Test #1: department insert ===");
		
		System.out.print("Enter department name: ");
		Department dep = new Department(null, sc.nextLine());
		departmentDao.insert(dep);
		
		System.out.println("Date entered successfully! ID: " + dep.getId());
		
		System.out.println("\n=== Test #2: department update ===");
		
		System.out.print("Enter department id: ");
		dep = departmentDao.findById(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter a change name: ");
		dep.setName(sc.nextLine());
		departmentDao.update(dep);*/
		
		System.out.println("\n=== Test #3: department delete ===");
		
		System.out.print("Enter department id: ");
		departmentDao.deleteById(sc.nextInt());
		sc.nextLine();
		
		System.out.println("\n=== Test #4: department findById ===");
		
		System.out.print("Enter department id: ");
		System.out.println(departmentDao.findById(sc.nextInt()));
		sc.nextLine();
		
		System.out.println("\n=== Test #5: department findAll ===");
		
		for (Department obj : departmentDao.findAll()) {
			System.out.println(obj);
		}

	}

}

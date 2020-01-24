package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n\n----------------- TESTS SELLER --------------------\n\n");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println("=== Test #1: seller findById ===");
		
		System.out.println(seller);
		
		System.out.println("\n=== Test #2: seller findByDepartment ===");
		
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test #3: seller findByDepartment ===");
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test #4: seller insert ===");
		
		Seller newSeller = new Seller(null,"Theo Benjamim Oliveira Stella", "theo.stella@gmail.com", 
				sdf.parse("26/04/2014"), 2200.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID: " + newSeller.getId());
		
		System.out.println("\n=== Test #5: seller update ===");
		
		seller = sellerDao.findById(8);
		seller.setName("Thais Duarte Oliveira");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== Test #6: seller delete ===");
		System.out.print("Enter an id: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Data successfully deleted!");
		
		System.out.println("\n\n----------------- TESTS DEPARTMENT --------------------\n\n");
		
		System.out.println("\n=== Test #1: department insert ===");
		
		System.out.print("Enter department name: ");
		dep = new Department(null, sc.nextLine());
		departmentDao.insert(dep);
		
		System.out.println("Date entered successfully! ID: " + dep.getId());

	}

}

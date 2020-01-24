package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
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
		

	}

}

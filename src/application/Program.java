package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.UsedProduct;
import entities.importedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (typeProduct == 'i') {
				System.out.print("Customs fee: ");
				double customsfee = sc.nextDouble();
				list.add(new importedProduct(name, price, customsfee));
			}
			else if (typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufacture = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufacture));
			}
			else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product pdt : list) {
			System.out.println(pdt.priceTag());
		}
		
		sc.close();
	}

}

package domain;

import java.util.*;


public class Ticket {
	
	//sql asign the value autoincrement
	private int id;
	
	private ArrayList<Product> product = new ArrayList<Product>();
	
	
	public Ticket() {
			
	}
	// Getters Setteres
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
	public ArrayList<Product> getProduct() {
		return product;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	// to add a single product to the ticket
	public void addProduct(Product p) {
		product.add(p);
	} 

	//method to find the total price of the ticket 
	public Double totalPrice() {
		double total = 0;
		for(Product p : product) {
			total+=p.getPrice();
		}
		return total;
		
	}
	
	
	

}

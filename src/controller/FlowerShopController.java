package controller;

import java.sql.SQLException;
import java.util.*;

import domain.*;
import repository.*;

public class FlowerShopController {

	private FlowerShopRepository repository = new FlowerShopRepository();
	private FlowerShopSales sellRepository = new FlowerShopSales();
	
	
	public FlowerShopController() {
		
	}
	
	
	//Flower methods
	public List<Flower>getFlower() throws SQLException {
		
		return repository.getFlower();
	}
	
	public void saveFlower(Flower flower) {
		 repository.saveFlower(flower);
	}
	
	public void deleteFlower(int flowerId) {
		repository.deleteFlower(flowerId);
	}
	
	//Tree methods
	
	public List<Tree> getTree() throws SQLException {
		
		return repository.getTree();
	}
	
	public void saveTree(Tree tree) {
		 repository.saveTree(tree);
	}
	
	public void deleteTree(int treeId) {
		repository.deleteTree(treeId);
	}
	
	//Decoration methods
	
	public List<Decoration> getDecoration() throws SQLException {
		
		return repository.getDecoration();
	}
	
	public void saveDecoration(Decoration decoration) {
		 repository.saveDecoration(decoration);
	}
	
	public void deleteDecoration(int decorationId) {
		repository.deleteDecoration(decorationId);
	}
	
	//print by quantity
	public void printByQuantity() {
		System.out.println("There are "+repository.getFlower().size()+" flowers in stock.");
		System.out.println("There are "+repository.getTree().size()+" trees in stock.");
		System.out.println("There are "+repository.getDecoration().size()+" decorations in stock.");
	}
	
	//total value of the stock
	public double totalValue(){
		double value = 0;
		for (Flower f:repository.getFlower()) {value+=f.getPrice();}
		for (Tree t:repository.getTree()) {value+=t.getPrice();}
		for (Decoration d:repository.getDecoration()) {value+=d.getPrice();}
		
		return value;
		
	}
	
	//save sell
	public void saveSell(Ticket ticket) {
		
		sellRepository.saveSell(ticket);
		
	}
	
	public void showSells() {
		
		List <Ticket> sells = sellRepository.getSells();
		
		for (Ticket t:sells) {
			System.out.println("\nTicket with id: "+t.getId());
			for (Product p:t.getProduct()) {
				System.out.println("Name: "+ p.getName()+", category: "+p.getCategory()+ ", price: "+p.getPrice());
			}
			
		}
	}
	
	public Double totalSells() {
		double result = 0;
		for(Ticket t : sellRepository.getSells()) 
		{result+=t.totalPrice();}
			
		return result;
	}
		
	

	public void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue.");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		}


	}



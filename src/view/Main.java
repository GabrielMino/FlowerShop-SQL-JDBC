package view;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.FlowerShopController;
import domain.*;
import enums.*;
import enums.Category;
import view.method.Method;

public class Main {

	public static FlowerShopController controller = new FlowerShopController();

	public static void main(String[] args) throws Exception {
				
		
		//pop up en primer término
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		Scanner reader = new Scanner(System.in);
		boolean continue_ = true;
		while(continue_) {
		
		System.out.println("1.Exit");
		System.out.println("2. Add Tree");
		System.out.println("3. Add Flower");
		System.out.println("4. Add Decoration");
		System.out.println("5. Stock: Print on screen all the trees, flowers and decoration that the flowershop has. ");
		System.out.println("6. Remove Tree");
		System.out.println("7. Remove Flower");
		System.out.println("8. Remove Decoration");
		System.out.println("9. Print on screen, the quantities of the stock order by category");
		System.out.println("10. Print on screen the total value of the stock. ");
		System.out.println("11. Create a purchase tickets with multiple objects ");
		System.out.println("12. Show a list that includes all the purchases done");
		System.out.println("13. View the total money earned with all sales");
			
		System.out.println("Choose the option");
		int option = reader.nextInt();
		switch(option) {
		
		case 1:
			continue_=false;
			reader.close();
			break;
			
			
		case 2:
			//this try-catch has been implemented to come back to the menu, in case the client wants to cancel this operation catching de NullPointerException
			try {
				
				String product = "tree";
				//Select Name
				String treeName = Method.getCharacEnum(TreeName.class,product, "name");
				//Enter Height
				Double treeHeight = Method.getCharacDouble(product, "height");
				//Enter price
				Double treePrice = Method.getCharacDouble(product, "price");
				
				//create product
				Tree tree = new Tree(treeName,treeHeight,treePrice);
				controller.saveTree(tree);
				controller.promptEnterKey();
			
			}catch (NullPointerException e){
				controller.promptEnterKey();
			}
			break;
		
		case 3:
			try {
				
				String product = "flower";
				//Select Name
				String flowerName = Method.getCharacEnum(FlowerName.class,product, "name");
				//Select Color
				String flowerColor = Method.getCharacEnum(FlowerColor.class,product, "color");
				//Enter price
				Double flowerPrice = Method.getCharacDouble(product, "price");
			
				Flower flower = new Flower(flowerName, flowerColor, flowerPrice);
				controller.saveFlower(flower);
				controller.promptEnterKey();
			
			}catch (NullPointerException e){
				controller.promptEnterKey();
			}
			break;
		case 4:
			
			try {
				
				String product = "decoration";
				//Select Name
				String decorationName = Method.getCharacEnum(DecorationName.class,product, "name");
				//Select Material
				String decorationMaterial = Method.getCharacEnum(DecorationMaterial.class,product, "material");
				//Enter price
				Double decorationPrice = Method.getCharacDouble(product, "price");
				Decoration decoration = new Decoration(decorationName, decorationMaterial,decorationPrice);
				controller.saveDecoration(decoration);
				controller.promptEnterKey();
			
			}catch (NullPointerException e){
				controller.promptEnterKey();
			}
			break;	
			
			
		case 5:
			try {
			// Print Flower Stock
			System.out.println("Actual stock of flowers: ");
			controller.getFlower().forEach(f -> System.out.println(f.toString()));
			
			//Print Tree Stock 
			System.out.println("\nActual stock of trees: ");
			controller.getTree().forEach(t->System.out.println(t.toString()));
			
			//Print Decoration Stock
			System.out.println("\nActual stock of decorations: ");
			controller.getDecoration().forEach(d->System.out.println(d.toString()));
			controller.promptEnterKey();
			}catch(SQLException e) {}
			break;
		
		
		case 6:
			ArrayList<Integer> idTrees= new ArrayList<Integer>();
			try {
			//Get all the ids for the product
			for(Tree t: controller.getTree()) {idTrees.add(t.getProductId());}
			// apply the method to select the id
			int treeId = Method.selectId(idTrees, "tree");
			// delete the id
			controller.deleteTree(treeId);
			
			controller.promptEnterKey();}
			catch(NullPointerException e ) {
				controller.promptEnterKey();
				idTrees.clear();
			}
			break;
				
		case 7:
			try {
				//Get all the ids for the product
				ArrayList<Integer> idFlowers= new ArrayList<Integer>();
				controller.getFlower().forEach(c -> idFlowers.add(c.getProductId()));
				// apply the method to select the id
				int flowerId = Method.selectId(idFlowers, "flower");
				// delete the id
				controller.deleteFlower(flowerId);
				controller.promptEnterKey();}
				catch(NullPointerException e ) {
					controller.promptEnterKey();
				}
				break;
					
				
		
		case 8:
			try {
				//Get all the ids for the product
				ArrayList<Integer> idDecoration= new ArrayList<Integer>();
				controller.getDecoration().forEach(c -> idDecoration.add(c.getProductId()));
				// apply the method to select the id
				int decorationId = Method.selectId(idDecoration, "flower");
				// delete the id
				controller.deleteDecoration(decorationId);
				controller.promptEnterKey();}
				catch(NullPointerException e ) {
					controller.promptEnterKey();
				}
				break;
		
		case 9:
			//Print by quantity
			System.out.println("\nStock quantity order by category");
			controller.printByQuantity();
			controller.promptEnterKey();
			break;
				
		case 10:
			System.out.println("The total value of the stock is: "+controller.totalValue()+ "€");
			controller.promptEnterKey();
			break;
		
			
		case 11:
			boolean purchase = true;
			
			int id;
			int dialogButton = JOptionPane.YES_NO_OPTION;
			Ticket ticket = new Ticket();
			List<Tree> trees;
			List<Flower> flowers;
			List <Decoration> decorations;
			int index = 0;
			try {
				do {
					String category = Method.getCategory(Category.class);
					if (category=="Tree") {
						ArrayList<Integer> idTree= new ArrayList<Integer>();
						controller.getTree().forEach(c -> idTree.add(c.getProductId()));
						id = Method.selectId(idTree, category);
						//Add product to the ticket
						trees = controller.getTree();
						while(id !=trees.get(index).getProductId()) {index++;}
						ticket.addProduct(trees.get(index));
						// Delete form stock
						controller.deleteTree(id);
					
					}else if(category=="Flower"){
						ArrayList<Integer> idFlower= new ArrayList<Integer>();
						controller.getFlower().forEach(c -> idFlower.add(c.getProductId()));
						id = Method.selectId(idFlower, category);
						//Add product to the ticket
						flowers = controller.getFlower();
						while(id !=flowers.get(index).getProductId()) {index++;}
						ticket.addProduct(flowers.get(index));
						// Delete form stock
						controller.deleteFlower(id);
						
					}else {
						ArrayList<Integer> idDecoration= new ArrayList<Integer>();
						controller.getDecoration().forEach(c -> idDecoration.add(c.getProductId()));
						id = Method.selectId(idDecoration, category);
						//Add product to the ticket
						decorations = controller.getDecoration();
						while(id !=decorations.get(index).getProductId()) {index++;}
						ticket.addProduct(decorations.get(index));
						// Delete form stock
						controller.deleteDecoration(id);
					}
					//reboot the index
					index=0;
					//Ask if wants to add another product
		            int answer = JOptionPane.showConfirmDialog (dialog, "Do you want to add another product","Please Answer", dialogButton);
		            if(answer == JOptionPane.NO_OPTION) {purchase = false;}
				}while(purchase);}
			catch (NullPointerException e) {
			}
			controller.saveSell(ticket);
			System.out.println("Sell done");
			controller.promptEnterKey();
			break;
		
		case 12:
			//"13. Show a list that includes all the purchases done");
			controller.showSells();
			controller.promptEnterKey();
			break;
			
		case 13:
			System.out.println("The total value of the sells is : "+controller.totalSells());
			controller.promptEnterKey();
			break;
		
			
		}
		
		}
		
		}
			
	
		
	}
	

			
			
		
	
	



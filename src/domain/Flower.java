package domain;

import enums.Category;

public class Flower extends Product{
	
	private String color;
	
	//Constructor
	public Flower() {}
	
	//Constructor using field and superclass
	public Flower(String name,String color,double price) throws Exception {
		super(name,price,Category.Flower);
		this.color=color;
		
	}
	//getters and setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Name: "+ getName()+ " color: " + color + ", price " + getPrice()+", and id:"+ getProductId();
	}

	
	
	
	
	

}

package domain;

import enums.Category;

public class Tree extends Product{
	
	private double height;

	//Constructor
	public Tree() {}
	//Constructor with fields and super class
	public Tree(String name,double height,double price) throws Exception {
		super(name,price,Category.Tree);
		if (height<=0) throw new Exception();
		this.height=height;

	}
	
	//Getters and Setters
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Name: "+ getName()+", height: " + height +", price " + getPrice()+", and id:"+ getProductId();
	}
	
	
	

}

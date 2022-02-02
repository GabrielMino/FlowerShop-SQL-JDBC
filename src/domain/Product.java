package domain;

import enums.*;


public class Product {
	
	private int productId;
	private String name;
	private double price;
	private Category category;
	
	
    protected Product(){}
    
    //Constructor to set Price
	protected Product(String name, double price, Category category)throws Exception{
        if(price < 0) throw new Exception();
        this.price = price;
        this.category = category;
        this.name = name;
        
    }

	//getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

 

}

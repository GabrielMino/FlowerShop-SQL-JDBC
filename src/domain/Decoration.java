package domain;

import enums.Category;

public class Decoration extends Product{
	
	private String material;
	

	public Decoration(String name,String material, double price) throws Exception {
		super(name,price,Category.Decoration);
	     this.material = material;
		
	     
	}

	//getters and setters

	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	};
	
	//toString
	
		@Override
		public String toString() {
			return "Name: "+ getName()+ ", material: " + material + ", price " + getPrice()+", and id:"+ getProductId();
		}

	

	}
		
	
	


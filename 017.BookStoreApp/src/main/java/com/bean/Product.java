package com.bean;

public class Product {
	 private String code;
	   private String name;
	   private String edition;
	   private String author;
	   private int quantity;
	   private float price;

	   public Product() {

	   }

	   public Product(String code, String name,String edition,String author,int quantity,float price) {
	       this.code = code;
	       this.name = name;
	       this.edition=edition;
	       this.author=author;
	       this.quantity=quantity;
	       this.price = price;
	   }

	 

	public String getCode() {
	       return code;
	   }

	   public void setCode(String code) {
	       this.code = code;
	   }

	   public String getName() {
	       return name;
	   }

	   public void setName(String name) {
	       this.name = name;
	   }
	   public String getEdition() {
	       return edition;
	   }

	   public void setEdition(String edition) {
	       this.edition = edition;
	   }
	   

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
	       return price;
	   }

	   public void setPrice(float price) {
	       this.price = price;
	   }

	

}

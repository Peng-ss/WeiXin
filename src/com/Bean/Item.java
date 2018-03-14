package com.Bean;

public class Item {
    
	private String value;
    private String color;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Item [value=" + value + ", color=" + color + "]";
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

    
}

package com.doe.nutrininja;

public class ItemLocation {
	
	private String item;
	private String aisle;
	
	public ItemLocation(String item, String aisle){
		this.item = item;
		this.aisle = aisle;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

}

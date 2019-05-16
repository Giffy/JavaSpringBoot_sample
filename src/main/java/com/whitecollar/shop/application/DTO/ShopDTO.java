package com.whitecollar.shop.application.DTO;

import com.whitecollar.shop.domain.Shop;

public class ShopDTO {

	private String shopName;
	private int maxCapacity;
	private String shopID;
	
	public ShopDTO ( String shopName, int maxCapacity) {
		this.shopName = shopName;
		this.maxCapacity = maxCapacity;
	}
	
	public ShopDTO( Shop shop) {	
		this.shopName = shop.getShopName();
		this.maxCapacity = shop.getMaxCapacity();
		this.shopID = shop.getShopID();
	}
	public String getShopName() {
		return shopName;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public String getShopID() {
		return shopID;
	}	
}
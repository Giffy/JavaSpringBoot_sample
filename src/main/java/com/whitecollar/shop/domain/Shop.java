package com.whitecollar.shop.domain;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.shop.application.DTO.ShopDTO;
import com.whitecollar.shop.utilities.InvalidParamException;

public class Shop {
	
	private String ShopName;
	private int maxCapacity;
	private String shopID;
	private List<Picture> pictures = new ArrayList<>();
	
	private static int counter = 0;
	
	public Shop(String shopName, int maxCapacity) {
		ShopName = shopName;
		this.maxCapacity = maxCapacity;
	}
	
	public Shop(ShopDTO shopDTO) throws InvalidParamException {
		if (shopDTO == null) throw new InvalidParamException();
		this.ShopName = shopDTO.getShopName();
		this.maxCapacity = shopDTO.getMaxCapacity();
		this.shopID = "" + counter;
		counter++;
	}

	public String getShopName() {
		return ShopName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public String getShopID() {
		return shopID;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public Picture addPicture(Picture picture) throws InvalidParamException {
		if ( picture == null ) throw new InvalidParamException();
		pictures.add(picture);
		return picture;
	}

	public void deleteAllPictures() {
		pictures.clear();		
	}
}
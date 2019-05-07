package com.whitecollar.project.persistence;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.project.domain.Shop;
import com.whitecollar.project.utilities.InvalidParamException;
import com.whitecollar.project.utilities.NotFoundException;

public class ShopRepository {

	private static List<Shop> shops = new ArrayList<>();
	
	public static List<Shop> getAllShops() {
		return new ArrayList<Shop>(shops);
	}

	public static void saveShop(Shop shop) throws InvalidParamException {
		if (shop == null) throw new InvalidParamException();
		shops.add(shop);
		
	}

	public static Shop getShopById(String shopId) throws InvalidParamException, NotFoundException {
		if (shopId == null) throw new InvalidParamException();
		for (Shop shop : shops) {
			if(shop.getShopId().equals(shopId)) {
				return shop;
			}			
		}
		
		throw new NotFoundException();
	}

}

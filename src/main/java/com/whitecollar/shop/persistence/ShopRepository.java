package com.whitecollar.shop.persistence;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.shop.domain.Shop;
import com.whitecollar.shop.utilities.InvalidParamException;
import com.whitecollar.shop.utilities.NotFoundException;

public class ShopRepository {
	
	private static List<Shop> shops = new ArrayList<>();

	public static List<Shop> getAllShops() {
		return new ArrayList<>(shops);
	}

	public static void saveShop(Shop shop) throws InvalidParamException {
		if (shop == null) throw new InvalidParamException();
		shops.add(shop);		
	}

	public static Shop getShopById(String shopId) throws NotFoundException, InvalidParamException {
		if ( shopId == null ) throw new InvalidParamException();
		for (Shop shop : shops) {
			if (shop.getShopID().equals(shopId)){
				return shop;
			}
		}
		throw new NotFoundException();
	}

}

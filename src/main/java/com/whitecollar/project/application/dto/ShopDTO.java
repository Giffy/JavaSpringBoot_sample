package com.whitecollar.project.application.dto;

import com.whitecollar.project.domain.Shop;
import com.whitecollar.project.utilities.InvalidParamException;

public class ShopDTO {
	private String shopName;
	private int maxCapacity;
	private String shopId;

	public ShopDTO(String shopName, int maxCapacity, String shopId) {
		this.shopName = shopName;
		this.maxCapacity = maxCapacity;
		this.shopId = shopId;
	}

	public ShopDTO(Shop shop) throws InvalidParamException {
		if (shop == null)
			throw new InvalidParamException();
		this.shopName = shop.getShopName();
		this.maxCapacity = shop.getMaxCapacity();
		this.shopId = shop.getShopId();
	}

	public String getShopName() throws InvalidParamException {
		if (shopName.equals(""))
			throw new InvalidParamException();
		return this.shopName;
	}

	public int getMaxCapacity() throws InvalidParamException {
		if (maxCapacity < 0)
			throw new InvalidParamException();
		return this.maxCapacity;
	}
}

package com.whitecollar.project.domain;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.project.application.dto.PictureDTO;
import com.whitecollar.project.application.dto.ShopDTO;
import com.whitecollar.project.utilities.InvalidParamException;

public class Shop {

	private String shopName;
	private int maxCapacity;
	private String shopId;
	private List<Picture> pictures = new ArrayList<Picture>();
	private static int counter = 0;

	public Shop(ShopDTO shopDTO) throws InvalidParamException {
		if (shopDTO == null)
			throw new InvalidParamException();
		counter++;
		this.shopId = String.valueOf(counter);
		this.shopName = shopDTO.getShopName();
		this.maxCapacity = shopDTO.getMaxCapacity();
	}

	public String getShopName() {
		return shopName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public String getShopId() {
		return shopId;
	}

	public List<Picture> getAllPictures() {
		return new ArrayList<Picture>(pictures);
	}

	public void addPicture(Picture picture) throws InvalidParamException {
		if (picture == null)
			throw new InvalidParamException();
		if (pictures.size() >= maxCapacity)
			throw new InvalidParamException();
		pictures.add(picture);
	}

	public void deleteAllPictures() {
		pictures.clear();

	}

}

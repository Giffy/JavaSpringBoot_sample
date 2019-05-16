package com.whitecollar.shop.application;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.shop.application.DTO.ShopDTO;
import com.whitecollar.shop.domain.Shop;
import com.whitecollar.shop.persistence.ShopRepository;
import com.whitecollar.shop.utilities.InvalidParamException;

public class ShopController {

	public List<ShopDTO> getAllVideoClubs() {
		List<Shop> shops = ShopRepository.getAllShops();
		List<ShopDTO> result = new ArrayList<>();
		for (Shop shop : shops) {
			result.add(new ShopDTO(shop));
		}
		return result;
	}

	public ShopDTO createShop(ShopDTO shopDTO) throws InvalidParamException {
		Shop shop = new Shop (shopDTO);
		ShopRepository.saveShop(shop);
		return new ShopDTO(shop);
	}

	public ShopDTO createShop(String shopName, int maxCapacity) throws InvalidParamException {
		ShopDTO shopDTO = new ShopDTO (shopName, maxCapacity);
		Shop shop = new Shop (shopDTO);
		ShopRepository.saveShop(shop);
		return new ShopDTO(shop);
	}
}
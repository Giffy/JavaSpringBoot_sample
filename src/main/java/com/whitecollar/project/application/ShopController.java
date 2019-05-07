package com.whitecollar.project.application;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.project.application.dto.PictureDTO;
import com.whitecollar.project.application.dto.ShopDTO;
import com.whitecollar.project.domain.Shop;
import com.whitecollar.project.persistence.ShopRepository;
import com.whitecollar.project.utilities.InvalidParamException;

public class ShopController {

	public List<ShopDTO> getAllShops() throws InvalidParamException {
		List<Shop> shops = ShopRepository.getAllShops();
		List<ShopDTO> result = new ArrayList<>();
		for (Shop shop : shops) {
			result.add(new ShopDTO(shop));
		}
		return result;
	}

	public ShopDTO createShop(ShopDTO shopDTO) throws InvalidParamException {
		Shop shop = new Shop(shopDTO);
		ShopRepository.saveShop(shop);
		return new ShopDTO (shop);
	}


}

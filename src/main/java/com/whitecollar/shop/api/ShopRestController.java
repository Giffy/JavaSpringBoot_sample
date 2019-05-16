package com.whitecollar.shop.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.whitecollar.shop.application.ShopController;
import com.whitecollar.shop.application.DTO.ShopDTO;
import com.whitecollar.shop.utilities.InvalidParamException;

@RestController
@CrossOrigin
@RequestMapping("/shops")

public class ShopRestController {

	private ShopController controller = new ShopController();

	@GetMapping
	public String getAllShops() throws InvalidParamException {
		List<ShopDTO> allShops = controller.getAllVideoClubs();
		return new Gson().toJson(allShops);
	}

	@PostMapping("/create")
	public String createShop(@RequestBody String jShop) throws InvalidParamException {
		ShopDTO shop = new Gson().fromJson(jShop, ShopDTO.class);
		shop = controller.createShop(shop);
		return new Gson().toJson(shop);
	}

	@PostMapping
	public String createShop2(	@RequestParam(value = "shopName", defaultValue = "ss") String shopName,
								@RequestParam(value = "capacity", defaultValue = "0") int maxCapacity
								) throws InvalidParamException {
		ShopDTO shop = controller.createShop(shopName, maxCapacity);
		return new Gson().toJson(shop);
	}

}

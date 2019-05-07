package com.whitecollar.project.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.whitecollar.project.application.ShopController;
import com.whitecollar.project.application.dto.ShopDTO;
import com.whitecollar.project.utilities.InvalidParamException;

@RestController
@CrossOrigin
@RequestMapping("/shops")

public class ShopRestController {

	private ShopController controller = new ShopController();

	@GetMapping
	public String getAllShops() throws InvalidParamException {
		List<ShopDTO> shops = controller.getAllShops();
		return new Gson().toJson(shops);
	}
	
	@PostMapping
	public String createShop(@RequestBody String jShop) throws InvalidParamException {
		ShopDTO shopDTO = new Gson().fromJson(jShop, ShopDTO.class);
		shopDTO = controller.createShop(shopDTO);
		return new Gson().toJson(shopDTO);
	}
	
}

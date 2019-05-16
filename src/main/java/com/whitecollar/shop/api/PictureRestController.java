package com.whitecollar.shop.api;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.whitecollar.shop.application.PictureController;
import com.whitecollar.shop.application.DTO.PictureDTO;
import com.whitecollar.shop.utilities.InvalidParamException;
import com.whitecollar.shop.utilities.NotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/shops/{shopId}/pictures")
public class PictureRestController {

	private PictureController controller = new PictureController();	
	
	@GetMapping
	public String getAllPictures(@PathVariable String shopId) throws InvalidParamException, NotFoundException {
		List<PictureDTO> allPictures = controller.getAllPictures( shopId );
		return new Gson().toJson(allPictures);
	}
	
	@PostMapping("/create")
	public String createPicture(@PathVariable String shopId, @RequestBody String jPicture) throws InvalidParamException, NotFoundException {
		PictureDTO picture = new Gson().fromJson(jPicture, PictureDTO.class);
		picture = controller.createPicture(shopId , picture);
		return new Gson().toJson(picture);
	}
	
	@DeleteMapping
	public void deleteAllPictures(@PathVariable String shopId) throws InvalidParamException, NotFoundException {
		controller.deleteAllPictures( shopId );
	}
	
	@PostMapping
	public String createShop2(	@PathVariable String shopId,
								@RequestParam(value = "title", defaultValue = "") String title,
								@RequestParam(value = "authorName", defaultValue = "") String authorName,
								@RequestParam(value = "price", defaultValue = "0") int price)
							throws InvalidParamException, NotFoundException {
		PictureDTO picture = controller.createPicture(shopId, title, authorName, price);
		return new Gson().toJson(picture);
	}

	
	
	
}

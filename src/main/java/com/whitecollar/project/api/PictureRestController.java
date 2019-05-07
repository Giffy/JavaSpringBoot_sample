package com.whitecollar.project.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.whitecollar.project.application.PictureController;
import com.whitecollar.project.application.dto.PictureDTO;
import com.whitecollar.project.utilities.InvalidParamException;
import com.whitecollar.project.utilities.NotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/shops/{shopId}/pictures")

public class PictureRestController {
	private PictureController controller = new PictureController();

	@GetMapping
	public String getAllPictures(@PathVariable String shopId) throws InvalidParamException, NotFoundException {
		List<PictureDTO> pictures = controller.getAllPictures(shopId);
		return new Gson().toJson(pictures);
	}

	@PostMapping
	public String addNewPicture(@PathVariable String shopId, @RequestBody String jPicture)
			throws InvalidParamException, NotFoundException {
		PictureDTO pictureDTO = new Gson().fromJson(jPicture, PictureDTO.class);
		pictureDTO = controller.addNewPicture(shopId, pictureDTO);
		return new Gson().toJson(pictureDTO);
	}

	@DeleteMapping
	public void deleteAllPictures(@PathVariable String shopId) throws InvalidParamException, NotFoundException {
		controller.removeAllPictures(shopId);
	}
//	
//	@GetMapping("/{pictureId}")
//	public String getPicture

}

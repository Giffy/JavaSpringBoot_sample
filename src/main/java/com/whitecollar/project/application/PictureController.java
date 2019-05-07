package com.whitecollar.project.application;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.project.application.dto.PictureDTO;
import com.whitecollar.project.domain.Picture;
import com.whitecollar.project.domain.Shop;
import com.whitecollar.project.persistence.ShopRepository;
import com.whitecollar.project.utilities.InvalidParamException;
import com.whitecollar.project.utilities.NotFoundException;

public class PictureController {

	public List<PictureDTO> getAllPictures(String shopId) throws InvalidParamException, NotFoundException {
		Shop shop = ShopRepository.getShopById(shopId);
		List<Picture> pictures = shop.getAllPictures();
		List<PictureDTO> result = new ArrayList<PictureDTO>();
		for (Picture picture : pictures) {
			result.add(new PictureDTO(picture));
		}
		return result;
	}

	public PictureDTO addNewPicture(String shopId, PictureDTO pictureDTO) throws InvalidParamException, NotFoundException {
		Shop shop = ShopRepository.getShopById(shopId);
		Picture picture = new Picture (pictureDTO);
		shop.addPicture( picture );
		return new PictureDTO(picture);
	}

	public void removeAllPictures(String shopId) throws InvalidParamException, NotFoundException {
		Shop shop = ShopRepository.getShopById(shopId);
		shop.deleteAllPictures();	
	}

}

package com.whitecollar.shop.application;

import java.util.ArrayList;
import java.util.List;

import com.whitecollar.shop.application.DTO.PictureDTO;
import com.whitecollar.shop.application.DTO.ShopDTO;
import com.whitecollar.shop.domain.Picture;
import com.whitecollar.shop.domain.Shop;
import com.whitecollar.shop.persistence.ShopRepository;
import com.whitecollar.shop.utilities.InvalidParamException;
import com.whitecollar.shop.utilities.NotFoundException;

public class PictureController {

	public List<PictureDTO> getAllPictures(String shopId) throws NotFoundException, InvalidParamException {
		Shop shop = ShopRepository.getShopById(shopId);
		List<Picture> pictures = shop.getPictures();
		List<PictureDTO> result = new ArrayList<>();
		for (Picture picture : pictures) {
			result.add(new PictureDTO(picture));
		}
		return result;
	}

	public PictureDTO createPicture(String shopId, PictureDTO pictureDTO) throws NotFoundException, InvalidParamException {
		Shop shop = ShopRepository.getShopById(shopId);
		Picture picture = shop.addPicture( new Picture(pictureDTO) );
		return new PictureDTO(picture);
	}

	public void deleteAllPictures(String shopId) throws NotFoundException, InvalidParamException {
		Shop shop = ShopRepository.getShopById(shopId);
		shop.deleteAllPictures();		
	}

	public PictureDTO createPicture(String shopId, String title, String authorName, int price)
			throws NotFoundException, InvalidParamException {
		Shop shop = ShopRepository.getShopById(shopId);
		PictureDTO pictureDTO = new PictureDTO(title, authorName, price);
		Picture picture = shop.addPicture( new Picture(pictureDTO) );
		return new PictureDTO(picture);
	}

}

package com.whitecollar.shop.domain;

import java.util.Calendar;

import com.whitecollar.shop.application.DTO.PictureDTO;
import com.whitecollar.shop.utilities.InvalidParamException;

public class Picture {
	
	private String title;
	private String authorName;
	private String pictureId;
	private double price;
	private Calendar registrationDate;
		
	private static int counter = 0;	

	public Picture ( PictureDTO pictureDTO) throws InvalidParamException {
		if ( pictureDTO == null) throw new InvalidParamException();
		this.title = pictureDTO.getTitle();
		this.authorName = pictureDTO.getAuthorName();
		this.pictureId = "" + counter;
		counter++;
		this.registrationDate = Calendar.getInstance();
		this.price = pictureDTO.getPrice();		
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getPictureId() {
		return pictureId;
	}

	public double getPrice() {
		return price;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}
}

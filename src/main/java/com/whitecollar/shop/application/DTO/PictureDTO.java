package com.whitecollar.shop.application.DTO;

import java.util.Calendar;

import com.whitecollar.shop.domain.Picture;
import com.whitecollar.shop.utilities.InvalidParamException;

public class PictureDTO {

	private String title;
	private String authorName;
	private String pictureId;
	private double price;
	private Calendar registrationDate;
	
	private static final String ANONYM = "Anonymous";
	
	public PictureDTO (String title, String authorName, int price) {
		this.title = title;
		this.authorName = authorName;
		this.price = price;
	}
	
	public PictureDTO (Picture picture) throws InvalidParamException {
		if (picture == null ) throw new InvalidParamException();
		this.title = picture.getTitle();
		this.authorName = picture.getAuthorName();
		this.pictureId = picture.getPictureId();
		this.price = picture.getPrice();
		this.registrationDate = picture.getRegistrationDate();
		
	}	

	public String getTitle() throws InvalidParamException {
		if (this.title.equals("") || this.title == null) throw new InvalidParamException();
		return this.title;
	}

	public String getAuthorName() {
		if(this.authorName.equals("") || this.authorName == null) return ANONYM;
		return this.authorName;
	}

	public String getPictureId() {
		return pictureId;
	}

	public double getPrice() throws InvalidParamException {
		if(this.price <= 0) throw new InvalidParamException();
		return this.price;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}
}
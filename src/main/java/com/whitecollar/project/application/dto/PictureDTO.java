package com.whitecollar.project.application.dto;

import java.util.Calendar;

import com.whitecollar.project.domain.Picture;
import com.whitecollar.project.utilities.InvalidParamException;

public class PictureDTO {

	private String title;
	private String pictureId;
	private String authorName;
	private double price;
	private Calendar registrationDate;

	private static final String ANONYM = "Anonymous";

	public PictureDTO(String title, String pictureId, String authorName, double price, Calendar registrationDate) {
		this.title = title;
		this.pictureId = pictureId;
		this.authorName = authorName;
		this.price = price;
		this.registrationDate = registrationDate;
	}

	public PictureDTO(Picture picture) throws InvalidParamException {
		if (picture == null)
			throw new InvalidParamException();
		this.title=picture.getTitle();
		this.pictureId = picture.getPictureId();
		this.authorName = picture.getAuthorName();
		this.price = picture.getPrice();
		this.registrationDate = picture.getRegistrationDate();
	}

	public String getPictureId() {
		return this.pictureId;
	}

	public String getAuthorName() {
		if (this.authorName == null || this.authorName.equals("")) {
			return this.authorName = ANONYM;
		}
		return this.authorName;
	}

	public double getPrice() throws InvalidParamException {
		if (this.price < 0)
			throw new InvalidParamException();
		return this.price;
	}

	public String getTitle() throws InvalidParamException {
		if (this.title.equals(""))
			throw new InvalidParamException();
		return this.title;
	}

}

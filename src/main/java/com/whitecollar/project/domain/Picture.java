package com.whitecollar.project.domain;

import java.util.Calendar;

import com.whitecollar.project.application.dto.PictureDTO;
import com.whitecollar.project.utilities.InvalidParamException;

public class Picture {

	private String title;
	private String pictureId;
	private String authorName;
	private double price;
	private Calendar registrationDate;

	private static int counter = 0;

	public Picture(PictureDTO pictureDTO) throws InvalidParamException {
		if (pictureDTO == null)
			throw new InvalidParamException();
		this.title = pictureDTO.getTitle();
		this.authorName = pictureDTO.getAuthorName();
		this.price = pictureDTO.getPrice();
		this.registrationDate = Calendar.getInstance();
		this.pictureId = "" + counter;
		counter++;
	}

	public String getPictureId() {
		return this.pictureId;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public double getPrice() {
		return this.price;
	}

	public Calendar getRegistrationDate() {
		return this.registrationDate;
	}

	public String getTitle() {
		return this.title;
	}

}

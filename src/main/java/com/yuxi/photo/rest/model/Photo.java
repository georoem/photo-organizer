package com.yuxi.photo.rest.model;

import java.time.LocalDateTime;

/** Model for map file data
 * @author Jorge Aguirre
 *
 */
public class Photo {

	public static final String DOT = ".";
	
	private String photoName;
	private String extension;
	private String cityName;
	private LocalDateTime dateTaken;
	private int orderInFile;
	
	public Photo(String photoName, String extension, String cityName, LocalDateTime dateTaken, int orderInFile) {
		this.photoName = photoName;
		this.extension = extension;
		this.cityName = cityName;
		this.dateTaken = dateTaken;
		this.orderInFile = orderInFile;
	}

	public String getPhotoName() {
		return photoName;
	}
	
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public LocalDateTime getDateTaken() {
		return dateTaken;
	}
	
	public void setDateTaken(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}
	
	public String getPhotoFilename() {
		return this.photoName + DOT + this.extension;
	}

	public int getOrderInFile() {
		return orderInFile;
	}

	public void setOrderInFile(int orderInFile) {
		this.orderInFile = orderInFile;
	}
	
}

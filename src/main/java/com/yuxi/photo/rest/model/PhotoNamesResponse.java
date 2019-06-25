package com.yuxi.photo.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** Model for detail response
 * @author Jorge Aguirre
 *
 */
public class PhotoNamesResponse {

	private String oldName;
	private String newName;
	@JsonIgnore
	private int order;
	
	public PhotoNamesResponse(String oldName, String newName, int order) {
		this.oldName = oldName;
		this.newName = newName;
		this.order = order;
	}

	public String getOldName() {
		return oldName;
	}
	
	public String getNewName() {
		return newName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}

package com.codeknights.ProEstimates1.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ThingNotFoundX extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String thingName;
	private String stuffName;
	private Object stuffValue;
	
	public ThingNotFoundX(String thingName, String stuffName, Object stuffValue) {
		super(String.format("%s not found  with %s : '%s'", thingName, stuffName, stuffValue));
		this.thingName = thingName;
		this.stuffName = stuffName;
		this.stuffValue = stuffValue;
		}

	public String getThingName() {
		return thingName;
	}

	public String getStuffName() {
		return stuffName;
	}

	public Object getStuffValue() {
		return stuffValue;
	}
	
	
}

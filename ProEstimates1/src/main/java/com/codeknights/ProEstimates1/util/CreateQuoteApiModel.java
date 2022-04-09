package com.codeknights.ProEstimates1.util;

import com.codeknights.ProEstimates1.models.Quote;

public class CreateQuoteApiModel {
private Quote info;
private Integer quote_measurement;
private Integer quote_price;
private String user_comments;
private String quote_material;
public Quote getInfo() {
	return info;
}
public void setInfo(Quote info) {
	this.info = info;
}
public Integer getQuote_measurement() {
	return quote_measurement;
}
public void setQuote_measurement(Integer quote_measurement) {
	this.quote_measurement = quote_measurement;
}
public Integer getQuote_price() {
	return quote_price;
}
public void setQuote_price(Integer quote_price) {
	this.quote_price = quote_price;
}
public String getUser_comments() {
	return user_comments;
}
public void setUser_comments(String user_comments) {
	this.user_comments = user_comments;
}
public String getQuote_material() {
	return quote_material;
}
public void setQuote_material(String quote_material) {
	this.quote_material = quote_material;
}


}

package com.codeknights.ProEstimates1.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="quotes")
public class Quotes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="quote_id")
	private Integer quote_id;
	@Column(name="user_id")
	private Integer user_id;
	@Column(name="material_name")
	private String material_name;
	@Column(name="quote_measurement")
	private Integer quote_measurement;
	@Column(name="quote_price")
	private Integer quote_price;
	@Column(name="quote_material")
	private String quote_material;
	@Column(name="user_comments")
	private String user_comments;
	
	

	public Integer getQuote_id() {
		return quote_id;
	}
	public void setQuote_id(Integer quote_id) {
		this.quote_id = quote_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
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
	public String getQuote_material() {
		return quote_material;
	}
	public void setQuote_material(String quote_material) {
		this.quote_material = quote_material;
	}
	public String getUser_comments() {
		return user_comments;
	}
	public void setUser_comments(String user_comments) {
		this.user_comments = user_comments;
	}
	public void addAttribute(String string, List<Quotes> quote) {
		// TODO Auto-generated method stub
		
	}


}

package com.codeknights.ProEstimates1.models;

import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name="materials")
public class Materials {
	@Column(name="material_id")
	private int material_id;
	@Column(name="material_name")
	private String material_name;
	@Column(name="material_price")
	private int material_price;
	@Column(name="material_set_date")
	private Date material_set_date;
	
	public int getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public int getMaterial_price() {
		return material_price;
	}
	public void setMaterial_price(int material_price) {
		this.material_price = material_price;
	}
	public Date getMaterial_set_date() {
		return material_set_date;
	}
	public void setMaterial_set_date(Date material_set_date) {
		this.material_set_date = material_set_date;
	}
	


}
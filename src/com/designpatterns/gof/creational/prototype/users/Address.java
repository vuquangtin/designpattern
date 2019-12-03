package com.designpatterns.gof.creational.prototype.users;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Address {
	private String province;
	private String district;
	private String street;

	public Address(String province, String district, String street) {
		this.setProvince(province);
		this.setDistrict(district);
		this.setStreet(street);
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}

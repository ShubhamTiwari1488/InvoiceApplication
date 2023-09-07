package com.highradius.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shippers")
public class Shipper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipper_id")
	private int shipperId;
	@Column(name = "shipper_name")
	private String shipperName;
	private String phone;

	@OneToMany(mappedBy = "shipper", fetch = FetchType.EAGER)
	private List<Orders> order;

	public int getShipperId() {
		return shipperId;
	}

	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public Shipper(int shipperId, String shipperName, String phone) {
		super();
		this.shipperId = shipperId;
		this.shipperName = shipperName;
		this.phone = phone;

	}

	public Shipper(int shipperId, String shipperName, String phone, List<Orders> order) {
		super();
		this.shipperId = shipperId;
		this.shipperName = shipperName;
		this.phone = phone;
		this.order = order;
	}

	public Shipper() {

	}

}

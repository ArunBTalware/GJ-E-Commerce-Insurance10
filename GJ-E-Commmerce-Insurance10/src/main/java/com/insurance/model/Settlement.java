package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Settlement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int policyId;
	private int amount;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Settlement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Settlement(int id, int policyId, int amount, String description) {
		super();
		this.id = id;
		this.policyId = policyId;
		this.amount = amount;
		this.description = description;
	}
	

}

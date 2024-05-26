package com.insurance.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	private String policyNumber;
	private String pilicyDetails;

//	@ManyToOne
//	@JoinColumn(name = "userId")
//	private Users user;
	
//	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Settlement> settlements;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long id) {
		this.policyId = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPilicyDetails() {
		return pilicyDetails;
	}

	public void setPilicyDetails(String pilicyDetails) {
		this.pilicyDetails = pilicyDetails;
	}

}

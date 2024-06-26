package com.insurance.service;

import java.util.Optional;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.insurance.model.Policy;
import com.insurance.repository.PolicyRepository;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;

import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	// add policy
	public Policy createNewPolicy(Policy policy) {

		return policyRepository.save(policy);
	}

	// update policy
	public Policy updatePolicyById(Long policyId, Policy policy) {

		Optional<Policy> optional = policyRepository.findById(policyId);
		Policy existPolicy = optional.get();
		existPolicy.setPolicyNumber(policy.getPolicyNumber());
		existPolicy.setPilicyDetails(policy.getPilicyDetails());

		return policyRepository.save(existPolicy);

	}

	// get policy by id
	public Optional<Policy> getPolicyDetailsById(Long policyId) {

		Optional<Policy> optional = policyRepository.findById(policyId);

		return Optional.ofNullable(optional.get());
	}

	// get all policies
	public List<Policy> getAllPolicyDetails() {

		return policyRepository.findAll();

	}

	// delete policy by id
	public void deletePolicyById(Long policyId) {

		policyRepository.deleteById(policyId);

	}

	// create policy pdf
	

}

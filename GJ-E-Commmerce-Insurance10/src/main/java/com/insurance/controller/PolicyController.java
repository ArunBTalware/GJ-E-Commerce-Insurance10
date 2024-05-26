package com.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Policy;
import com.insurance.service.PolicyService;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	//get policy ById
	@GetMapping("/{id}")
	public Optional<Policy> getPolicyById(@PathVariable("id") Long policyId) {
		
		return policyService.getPolicyDetailsById(policyId);
	}
	
	//get All policies
	@GetMapping("/getAll")
	public List<Policy> getAllPolicy(){
		
		return policyService.getAllPolicyDetails();
		
	}
	
	//add policy rest api
	@PostMapping("/create")
	public Policy createPolicy(@RequestBody Policy policy) {
		
		return policyService.createNewPolicy(policy);
	}
	
	//update policy rest api
	@PutMapping("/update/{id}")
	public Policy updatePolicy(@PathVariable("id") Long policyId,@RequestBody Policy policy) {
		
		return policyService.updatePolicyById(policyId,policy);
	}
	
	//delete policy byid rest api
	@DeleteMapping("/delete/{id}")
	public void deletePolicy(@PathVariable("id") Long policyId) {
		
		policyService.deletePolicyById(policyId);
	}
	
}

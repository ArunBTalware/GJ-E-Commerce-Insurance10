package com.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Settlement;
import com.insurance.service.SettlementService;

@RestController
@RequestMapping("/settlement")
public class SettlementController {
	
	@Autowired
	private SettlementService settlementService ;
	
	// add settlement details
	@PostMapping("/adddetails")
	public ResponseEntity<Settlement> addSettlement(@RequestBody Settlement settlement) {
		Settlement settlement2 = settlementService.addDetails(settlement);
		return ResponseEntity.ok().body(settlement2);
	}
		
	
    // get settlement details
	
	@GetMapping("/getalldetails")
	public List<Settlement> getSettlement(){
		List<Settlement> settlements = settlementService.getDetails();
		return settlements;		
	}
	
	// get settlement details by id
	
	@GetMapping("/getsettlementbyid/{id}")
	public ResponseEntity<Optional<Settlement>> getEmployeeById(@PathVariable int id) {

		Optional<Settlement> settlement = settlementService.getSettlementById(id);

		return ResponseEntity.ok().body(settlement);

	}
	
	// delete settlement details by id
	@DeleteMapping("/deletesettlementbyid/{id}")
	public void deleteSettlementById(@PathVariable int id) {
        settlementService.deleteSettlementById(id);
	}

	// update settlement details
	@PutMapping("/updatesettlement")
	public Settlement updateDetails(@RequestBody Settlement settlement) {
		return settlementService.updateSettlement(settlement);
	}

}

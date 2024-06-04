package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.Settlement;
import com.insurance.repository.SettlementRepository;

@Service
public class SettlementService {

	@Autowired
	private SettlementRepository settlementRepository;

	// add settlement
	public Settlement addDetails(Settlement settlement) {
		return settlementRepository.save(settlement);
	}

	// get all Settlements

	public List<Settlement> getDetails() {
		return settlementRepository.findAll();
	}

	// get Settlement by id
	public Optional<Settlement> getSettlementById(int id) {
		return settlementRepository.findById(id);
	}

	// delete Settlement by id
	public void deleteSettlementById(int id) {
		settlementRepository.deleteById(id);
	}
	
	// update Settlement details
	
	public Settlement updateSettlement(Settlement settlement) {
		Settlement updateDetails = settlementRepository.findById(settlement.getId()).orElse(null);
		if(updateDetails == null) {
			return null ;
		}else {
			updateDetails.setPolicyId(settlement.getPolicyId());
			updateDetails.setAmount(settlement.getAmount());
			updateDetails.setDescription(settlement.getDescription());
			settlementRepository.save(updateDetails);
			return updateDetails;
		}
		
	}
	
}

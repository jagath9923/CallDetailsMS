package com.jaga.devops.calldetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaga.devops.calldetails.dto.CallDetailsDTO;
import com.jaga.devops.calldetails.entity.CallDetails;
import com.jaga.devops.calldetails.repository.CallDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CallDetailsService {

	@Autowired
	private CallDetailsRepository callDetailsRepo;
	
	@Autowired
	private ObjectMapper mapper;

	// Fetches call details of a specific customer
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {
		log.info("Calldetails request for customer {}", phoneNo);
		List<CallDetails> callDetails = callDetailsRepo.findByCalledBy(phoneNo);
		List<CallDetailsDTO> callsDTO = new ArrayList<CallDetailsDTO>();
		for (CallDetails call : callDetails) {
			callsDTO.add(CallDetailsDTO.valueOf(call));
		}
		log.info("Calldetails for customer : {}", callDetails);
		return callsDTO;
	}

	public CallDetailsDTO createCustomerCallDetails(CallDetailsDTO callDetailsDTO) {
		CallDetails entity = mapper.convertValue(callDetailsDTO, CallDetails.class);
		callDetailsRepo.saveAndFlush(entity);
		return mapper.convertValue(entity, CallDetailsDTO.class);
	}
}

package com.jaga.devops.calldetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jaga.devops.calldetails.dto.CallDetailsDTO;
import com.jaga.devops.calldetails.service.CallDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/calldetails")
public class CallDetailsController {

	@Autowired
	CallDetailsService callDetailsService;

	// Fetches call details of a specific customer
	@GetMapping(value = "/customers/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CallDetailsDTO>> getCustomerCallDetails(@PathVariable long phoneNo) {
		log.info("Calldetails request for customer {}", phoneNo);
		return new ResponseEntity<>(callDetailsService.getCustomerCallDetails(phoneNo), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<CallDetailsDTO> createCustomerCallDetails(@RequestBody CallDetailsDTO callDetailsDTO) {
		log.info("Save Calldetails request for customer {}", callDetailsDTO);
		return new ResponseEntity<>(callDetailsService.createCustomerCallDetails(callDetailsDTO), HttpStatus.CREATED);
	}

}

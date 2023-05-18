package com.jaga.devops.calldetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaga.devops.calldetails.dto.CallDetailsDTO;
import com.jaga.devops.calldetails.service.CallDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

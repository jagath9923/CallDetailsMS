package com.jaga.devops.calldetails.dto;


import java.time.LocalDateTime;

import com.jaga.devops.calldetails.entity.CallDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CallDetailsDTO {

	private Long calledBy;

	private Long calledTo;

	private LocalDateTime calledOn;

	private Integer duration;

	// Converts Entity into DTO
	public static CallDetailsDTO valueOf(CallDetails callDetails) {
		CallDetailsDTO callsDTO = new CallDetailsDTO();
		callsDTO.setCalledBy(callDetails.getCalledBy());
		callsDTO.setCalledOn(callDetails.getCalledOn());
		callsDTO.setCalledTo(callDetails.getCalledTo());
		callsDTO.setDuration(callDetails.getDuration());
		return callsDTO;
	}

	@Override
	public String toString() {
		return "CallDetailsDTO [calledBy=" + calledBy + ", calledTo=" + calledTo + ", calledOn=" + calledOn
				+ ", duration=" + duration + "]";
	}

}

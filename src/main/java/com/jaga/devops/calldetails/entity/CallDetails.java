package com.jaga.devops.calldetails.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calldetails")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CallDetails implements Serializable {

	private static final long serialVersionUID = -146976585924084640L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private Long calledBy;
	@Column(nullable = false)
	private Long calledTo;
	@Column(nullable = false)
	private LocalDateTime calledOn;
	@Column(nullable = false)
	private Integer duration;


}

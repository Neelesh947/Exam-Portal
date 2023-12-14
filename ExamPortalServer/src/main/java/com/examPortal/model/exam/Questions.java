package com.examPortal.model.exam;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quesid;
	private String content;
	private String image;
	
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	
	private String answer;
	
	@Transient
	private String givenAnswer;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
}

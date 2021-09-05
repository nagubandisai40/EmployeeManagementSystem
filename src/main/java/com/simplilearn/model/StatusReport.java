package com.simplilearn.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class StatusReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int status_report_id;

	@ManyToOne
	private Complience complienceId;

	@ManyToOne
	private Employee empId;

	@ManyToOne
	private Department department;

	private String comments;
	private Date date;

}

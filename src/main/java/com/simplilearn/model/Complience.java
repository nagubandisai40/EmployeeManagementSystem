package com.simplilearn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Complience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complienceId;

	@Column(name = "regulation_type")
	private String regulationType;

	@Column(name = "details")
	private String details;

	@Column(name = "date")
	private Date date;

	@ManyToOne
	private Department department;

}

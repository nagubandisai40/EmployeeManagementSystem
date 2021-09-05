package com.simplilearn.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int deptId;
	private String deptName;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees;


}

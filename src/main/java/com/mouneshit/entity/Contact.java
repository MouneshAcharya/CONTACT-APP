package com.mouneshit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CONTACT_DTLS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private Long phno;
	private String activeSw;
}

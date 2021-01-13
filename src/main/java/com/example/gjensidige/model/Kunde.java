package com.example.gjensidige.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kunder")
public class Kunde {

	private long id;
	private String fornavn;
	private String etternavn;
	private String email;
	
	public Kunde() {
		
	}
	
	public Kunde(String fornavn, String etternavn, String email) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "fornavn", nullable = false)
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	@Column(name = "etternavn", nullable = false)
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Kunde [id=" + id + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", email=" + email
				+ "]";
	}
	
}
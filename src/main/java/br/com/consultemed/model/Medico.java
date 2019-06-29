package br.com.consultemed.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Medico extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String crm;

	public Medico() {

	}

	public Medico(String crm) {
		super();
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
}

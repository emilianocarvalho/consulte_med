package br.com.consultemed.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Paciente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contatos;
	
	@Embedded
	private Endereco endereco;
}

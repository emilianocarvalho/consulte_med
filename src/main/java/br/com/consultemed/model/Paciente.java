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

	public Contato getContatos() {
		return contatos;
	}

	public void setContatos(Contato contatos) {
		this.contatos = contatos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}


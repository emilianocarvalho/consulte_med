package br.com.consultemed.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.consultemed.model.enums.TipoPessoa;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@ElementCollection
	@CollectionTable(name = "emails")
	private Set<String> emails;

	@ElementCollection
	@CollectionTable(name = "telefones")
	private Set<String> telefones;

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipo;

	public Pessoa() {

	}
	
	public Pessoa(Long id, String nome, TipoPessoa tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", emails=" + emails + ", telefones=" + telefones + ", tipo="
				+ tipo + "]";
	}	
	
}

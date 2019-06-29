package br.com.consultemed.utils;

import javax.persistence.EntityManager;

import br.com.consultemed.model.Contato;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager  = JPAUtils.getEntityManager();

		System.out.println("Criando o contato");
		Contato contato = new Contato();
		
		contato.setNome("Emiliano Fernandes");
		contato.setEmail("emilianocarvalho.dev@gmail.com");
		contato.setTelefones();
		contato.setTelefone("83 99692-3678");

		System.out.println("Contato criado!");

		entityManager.getTransaction().begin();
		entityManager.persist(contato);
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println(contato.toString() + " Cadastrado!");

	}
}

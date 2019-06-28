package br.com.consultemed.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.consultemed.model.Contato;

public class Main {

	public static void main(String[] args) {
		EntityManager factory  = JPAUtils.getEmf();

		System.out.println("Criando o contato");
		Contato contato = new Contato();
//		contato.setId(null);
		contato.setNome("Emiliano Fernandes");
		contato.setEmail("emilianocarvalho.dev@gmail.com");
		contato.setTelefone("83 99692-3678");

		System.out.println("Contato criado!");

		factory.getTransaction().begin();
		factory.persist(contato);
		factory.getTransaction().commit();
		factory.close();

		System.out.println(contato.toString() + "Cadatrado!");

	}
}

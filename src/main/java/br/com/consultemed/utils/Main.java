package br.com.consultemed.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import br.com.consultemed.model.Contato;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager  = JPAUtils.getEntityManager();

		System.out.println("Criando o contato");
		Contato contato = new Contato();
		
		contato.setNome("Emiliano Fernandes");
		contato.setEmail("emilianocarvalho.dev@gmail.com");
		  		
//        Set<String> telefones = Stream.of("83 99692-3678", "83 99692-3778", "83 99692-3878")
//        		  .collect(Collectors.toCollection(HashSet::new));

        Set<String> telefones = new HashSet<>(Arrays.asList("83 99692-3678", "83 99692-3778", "83 99692-3878"));
        
		contato.setTelefones(telefones);
		
		entityManager.getTransaction().begin();
		entityManager.persist(contato);
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println(contato.toString() + " Cadastrado!");

	}
}

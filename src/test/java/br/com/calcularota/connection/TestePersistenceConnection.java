package br.com.calcularota.connection;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class TestePersistenceConnection {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		factory = Persistence.createEntityManagerFactory("entrega_persistence_teste");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();

	}
	
	@Test
	public void teste_connection(){
		
	}

}

package projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonConection {
	public static EntityManagerFactory emf = Persistence.
			// mesmo nome colocado no Persistence.xml
			createEntityManagerFactory("groupDatabase");
	
	//fun��o para cria��o da instancia
	public static EntityManager getInstance(){
		return emf.createEntityManager();
	}
}

package util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("facemusicaJPA");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) {
		return emf.getPersistenceUnitUtil().getIdentifier(entity);
	}
}

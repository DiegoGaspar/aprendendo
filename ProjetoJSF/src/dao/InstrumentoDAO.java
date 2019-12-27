package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import elementos.Instrumento;
import util.JPAUtil;

public class InstrumentoDAO {
	
	public static void salvar(Instrumento i) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void remover(Instrumento i) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		
		Object id = JPAUtil.getPrimaryKey(i);
		em.createQuery("delete from " + i.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	public static void editar(Instrumento i) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Instrumento> listar(){
		EntityManager em = JPAUtil.createEntityManager();
		Query q = em.createQuery("select i from Instrumento i");
		return q.getResultList();
	}

}

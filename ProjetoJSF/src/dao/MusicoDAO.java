package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import elementos.Musico;
import util.JPAUtil;

public class MusicoDAO {
		public static void salvar(Musico m) {
			EntityManager em = JPAUtil.createEntityManager();
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			em.close();
		}
		
		public static void remover(Musico m) {
			EntityManager em = JPAUtil.createEntityManager();
			em.getTransaction().begin();
			
			Object id = JPAUtil.getPrimaryKey(m);
			em.createQuery(" delete from " + m.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
			em.getTransaction().commit();
			em.close();
		}
		
		public static void editar(Musico m) {
			EntityManager em = JPAUtil.createEntityManager();
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
			em.close();
		}
		
		

		@SuppressWarnings("unchecked")
		public static List<Musico> listar(){
			EntityManager em = JPAUtil.createEntityManager();
			Query q = em.createQuery("SELECT m FROM Musico m");
			return q.getResultList();
		}

		
		
		
		
		
		
		
}


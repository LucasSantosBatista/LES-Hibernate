package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Ator;

public class AtorDao implements IAtorDao {
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");


	public void inserir(Ator ator) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ator);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar(Ator ator) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(ator);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Ator ator = em.find(Ator.class, id);
		if (ator != null) {
			em.remove(ator);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Ator> pesquisarPorNome (String nome){
		EntityManager em = mf.createEntityManager();
		List<Ator> atores = em.createQuery("SELECT a FROM Ator a WHERE a.nome LIKE :nome", Ator.class)
				.setParameter("titulo", "%" + nome + "%")
				.getResultList();
		em.close();
		return atores;
	}	
}

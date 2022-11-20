package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


import model.Professor;

public class ProfessorControle {

	private EntityManager em;

	public ProfessorControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();

	}

	public void inserir(Professor objeto) {
		try {
			em.getTransaction().begin();
			em.persist(objeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void alterar(Professor objeto) {

		try {
			em.getTransaction().begin();
			em.merge(objeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void excluir(Professor objeto) {
		try {
			em.getTransaction().begin();
			em.remove(objeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void excluirPorId(Integer codigo) {

		try {
			Professor objeto = buscarPorId(codigo);
			excluir(objeto);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Professor buscarPorId(Integer codigo) {

		return em.find(Professor.class, codigo);
	}

	public List<Professor> buscarTodos() {
		String nomeClasse = Professor.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();
			

	}

}

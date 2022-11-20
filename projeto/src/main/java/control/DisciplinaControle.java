package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import model.Disciplina;
import model.Professor;

public class DisciplinaControle {
	private EntityManager em;

	public  DisciplinaControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();

		
		
	}
	public void inserir (Disciplina objeto) {
	    try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }

			
		}
		public void alterar(Disciplina objeto) {
			
			  try {
		            em.getTransaction().begin();
		            em.merge(objeto);
		            em.getTransaction().commit();
		         } catch (Exception ex) {
		            ex.printStackTrace();
		            em.getTransaction().rollback();
		         }

		}
		public void excluir(Disciplina objeto) {
		      try {
		            em.getTransaction().begin();
		            em.remove(objeto);
		            em.getTransaction().commit();
		         } catch (Exception ex) {
		            ex.printStackTrace();
		            em.getTransaction().rollback();
		         }

			
		}
	public void  excluirPorId (Integer codigo) {
		
	    try {
            Disciplina objeto = buscarPorId(codigo);
            excluir(objeto);
         } catch (Exception ex) {
            ex.printStackTrace();
         }


		
		
	}
		public Disciplina buscarPorId(Integer codigo) {
			
			
			
			return em.find(Disciplina.class, codigo);
		}
		
		
		
		public List<Disciplina> buscarTodos() {
			
			String nomeClasse = Disciplina.class.getName();
			return em.createQuery("FROM " + nomeClasse).getResultList();	
			
			
			
			
		}
		
		
		
		
		
		
	

}

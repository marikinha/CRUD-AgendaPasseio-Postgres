package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Agenda;
import util.JPAUtil;

public class AgendaDao {

	public static void salvar (Agenda ag) {
		EntityManager e = JPAUtil.criarEntityManager();
		e.getTransaction().begin();
		e.persist(ag);
		e.getTransaction().commit();
		e.close();
	}
	
	public static void editar(Agenda ag) {
		EntityManager e = JPAUtil.criarEntityManager();
		e.getTransaction().begin();
		e.merge(ag);
		e.getTransaction().commit();
		e.close();
	}
	
	public static void atualizar(Agenda ag) {
		EntityManager e = JPAUtil.criarEntityManager();
		e.getTransaction().begin();
		e.merge(ag);
		e.getTransaction().commit();
		e.close();
	}
	
	public static void excluir(Agenda ag) {
		EntityManager e = JPAUtil.criarEntityManager();
		e.getTransaction().begin();
		ag = e.find(Agenda.class, ag.getId());
		e.remove(ag);
		e.getTransaction().commit();
		e.close();
	}
	
	

	public static List<Agenda> listar() {
		EntityManager e = JPAUtil.criarEntityManager();
		Query q = e.createQuery("select ag1 from Agenda ag1");
		List<Agenda> resultado = q.getResultList();
		e.close();
		return resultado;
	}
}

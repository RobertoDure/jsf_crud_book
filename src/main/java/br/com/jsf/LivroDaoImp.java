package br.com.jsf;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;


       
	public class LivroDaoImp implements LivroDao {
		 
		public void save(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(livro);
		t.commit();
		}
		public Livro getLivro(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Livro) session.load(Livro.class, id);
		}
		@SuppressWarnings("null")
		public List<Livro> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Livro").list();
		t.commit();
	     return lista;
		}
		public void remove(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(livro);
		t.commit();
		}
		public void update(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(livro);
		t.commit();
		}
		public List<Livro> listaTitulos() {
			Session session = null;
			Livro titulo = new Livro();
			Criteria crit = session.createCriteria(Livro.class);
			crit.add(Restrictions.like("titulo",titulo.getTitulo()+"%"));
			List results = crit.list(); 

			return results;
		}

	}



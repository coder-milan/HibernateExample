package repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import entities.StudentLoginEntity;

@Repository
public class StudentLoginRepository {

	private SessionFactory sessionFactory;

	public void save(StudentLoginEntity studentLogin) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(studentLogin);
		session.getTransaction().commit();
		session.close();
	}

	public StudentLoginEntity getByUsername(String userid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query q = session.createQuery("From StudentLoginEntity cl where cl.username = :uname");
		q.setParameter("uname", userid);

		StudentLoginEntity loginEntity = (StudentLoginEntity) q.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return loginEntity;
	}

	public void update(StudentLoginEntity studentLogin) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.merge(studentLogin);

		session.getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

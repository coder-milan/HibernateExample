package repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import entities.StudentEntity;

@Repository
public class StudentRepository {

	private SessionFactory sessionFactory;

	public void save(StudentEntity student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public List<StudentEntity> getStudentByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from StudentEntity c where c.name =:firstName");
		query.setParameter("firstName", name);
		List<StudentEntity> studentList = query.list();

		session.getTransaction().commit();
		session.close();
		return studentList;
	}

	public StudentEntity getStudentById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		StudentEntity student = (StudentEntity) session.get(StudentEntity.class, id);
		session.getTransaction().commit();
		session.close();

		return student;
	}

	public void update(StudentEntity student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.merge(student);

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

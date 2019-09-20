package main;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.StudentEntity;
import entities.StudentLoginEntity;
import repositories.StudentLoginRepository;

public class StudentOneToOne {

	public static void main(String[] args) {

		StudentLoginEntity studentLogin = new StudentLoginEntity();
		studentLogin.setUsername("mil_sap");
		String password = DigestUtils.sha256Hex("7654321");
		studentLogin.setPassword(password);
		studentLogin.setCreatedAt(new Date());

		StudentEntity student = new StudentEntity();
		student.setName("33milan");
		student.setGrade("Grade-7");
		student.setPhone("45347839");
		student.setEmail("milan09@gmail.com");

		studentLogin.setStudent(student);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		StudentLoginRepository studentLoginRepository = (StudentLoginRepository) ctx.getBean("studentLoginRepository");
		studentLoginRepository.save(studentLogin);

		StudentLoginEntity st = studentLoginRepository.getByUsername("abcde");
		System.out.println("*************login get by username **********");
		System.out.println(st.toString());

		String password1 = DigestUtils.sha256Hex("08234721");
		st.setPassword(password1);
		st.setUpdatedAt(new Date());

		studentLoginRepository.update(st);

	}

}

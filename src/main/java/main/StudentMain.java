package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.StudentEntity;
import repositories.StudentRepository;

public class StudentMain {

	public static void main(String[] args) {
		StudentEntity student = new StudentEntity();
		student.setName("Yadav");
		student.setGrade("Grade-5");
		student.setPhone("5432178");
		student.setEmail("emai@gmail.com");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		StudentRepository studentRepository = (StudentRepository) ctx.getBean("studentRepository");
		studentRepository.save(student);

		System.out.println("**************************");
		List<StudentEntity> students = studentRepository.getStudentByName("Yadav");
		for (StudentEntity s : students) {
			System.out.println(s.toString());
		}

		System.out.println();
		System.out.println("**************************");

		StudentEntity student1 = studentRepository.getStudentById(4l);
		System.out.println(student1.toString());

		System.out.println("******* update example*********");
		StudentEntity studentUpdate = studentRepository.getStudentById(5l);
		studentUpdate.setGrade("Grade-5");
		studentUpdate.setPhone("340345678");
		studentRepository.update(studentUpdate);

	}

}

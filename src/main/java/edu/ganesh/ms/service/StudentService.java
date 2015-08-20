package edu.ganesh.ms.service;

import java.util.List;

import edu.ganesh.ms.domain.Student;

/**
 * @author Bharat
 *
 */
public interface StudentService {
	public void saveStudent(Student student);

	public Student getStudentById(int id);

	public List<Student> getAllStudent();

	public void deleteStudent(int id);

}

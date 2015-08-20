package edu.ganesh.ms.dao;

import java.util.List;
import edu.ganesh.ms.domain.Student;

/**
 * @author Bharat
 *
 */
public interface StudentDao {
	public void saveStudent(Student student);

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

	public void deleteStudent(Student student);

}

package edu.ganesh.ms.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import edu.ganesh.ms.dao.StudentDao;
import edu.ganesh.ms.dao.util.ConnectionUtil;
import edu.ganesh.ms.domain.Student;

/**
 * @author Bharat
 *
 */
@Repository
public class StudentDaoImpl extends ConnectionUtil implements StudentDao {

	public void saveStudent(Student student) {
		getSession().saveOrUpdate(student);
	}

	public Student getStudentById(int id) {
		return (Student) getSession().get(Student.class, id);

	}

	public List<Student> getAllStudents() {
		return getSession().createQuery("FROM Student").list();
	}

	public void deleteStudent(Student student) {
		getSession().delete(student);
	}

}

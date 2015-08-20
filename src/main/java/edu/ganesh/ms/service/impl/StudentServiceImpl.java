package edu.ganesh.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ganesh.ms.dao.StudentDao;
import edu.ganesh.ms.domain.Student;
import edu.ganesh.ms.service.StudentService;

/**
 * @author Bharat
 *
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);

	}

	public List<Student> getAllStudent() {
		return studentDao.getAllStudents();

	}

	public void deleteStudent(int id) {
		Student student = getStudentById(id);
		if (student != null) {
			studentDao.deleteStudent(student);
		}

	}

}

package edu.ganesh.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ganesh.ms.dao.TeacherDao;
import edu.ganesh.ms.domain.Teacher;
import edu.ganesh.ms.service.TeacherService;

/**
 * @author Bharat
 *
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;

	@Override
	public void saveTeacher(Teacher teacher) {
		teacherDao.saveTeacher(teacher);
	}

	@Override
	public Teacher getTeacherById(int id) {
		return teacherDao.getTeacherById(id);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherDao.getAllTeacher();
	}

	@Override
	public void deleteTeacher(int id) {
		Teacher teacher = getTeacherById(id);
		if (teacher != null)
			teacherDao.deleteTeacher(teacher);
	}

}

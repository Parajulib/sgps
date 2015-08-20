package edu.ganesh.ms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ganesh.ms.dao.TeacherDao;
import edu.ganesh.ms.dao.util.ConnectionUtil;
import edu.ganesh.ms.domain.Teacher;

/**
 * @author Bharat
 *
 */
@Repository
public class TeacherDaoImpl extends ConnectionUtil implements TeacherDao {

	@Override
	public void saveTeacher(Teacher teacher) {
		getSession().saveOrUpdate(teacher);
	}

	@Override
	public Teacher getTeacherById(int id) {
		return (Teacher) getSession().get(Teacher.class, id);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return getSession().createQuery("From Teacher").list();
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		getSession().delete(teacher);

	}

}

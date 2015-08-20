package edu.ganesh.ms.dao;

import java.util.List;

import edu.ganesh.ms.domain.Teacher;

/**
 * @author Bharat
 *
 */
public interface TeacherDao {
	public void saveTeacher(Teacher teacher);

	public Teacher getTeacherById(int id);

	public List<Teacher> getAllTeacher();

	public void deleteTeacher(Teacher teacher);

}

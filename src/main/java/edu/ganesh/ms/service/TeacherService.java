package edu.ganesh.ms.service;

import java.util.List;

import edu.ganesh.ms.domain.Teacher;

/**
 * @author Bharat
 *
 */
public interface TeacherService {
	public void saveTeacher(Teacher teacher);

	public Teacher getTeacherById(int id);

	public List<Teacher> getAllTeacher();

	public void deleteTeacher(int id);

}

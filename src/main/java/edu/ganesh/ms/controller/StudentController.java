package edu.ganesh.ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import edu.ganesh.ms.domain.Student;
import edu.ganesh.ms.service.StudentService;

/**
 * @author Bharat
 *
 */
@Controller
@SessionAttributes({ "student" })
public class StudentController {

	@Autowired
	StudentService studentService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());

		return "student/addStudent";
	}

	@RequestMapping(value = "/student/edit/{stdid}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("stdid") int stdid, Model model) {
		model.addAttribute("student", studentService.getStudentById(stdid));

		return "student/addStudent";
	}

	@RequestMapping(value = "/student/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);

		return "redirect:/student";
	}

	@RequestMapping(value = "/student")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudent());

		return "student/listStudents";
	}

	@RequestMapping(value = "/student/delete/{stdid}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("stdid") int stdid, Model model) {
		studentService.deleteStudent(stdid);

		return "redirect:/student";
	}

}

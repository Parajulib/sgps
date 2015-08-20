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

import edu.ganesh.ms.domain.Teacher;
import edu.ganesh.ms.service.TeacherService;


@Controller
@SessionAttributes("teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value="/teacher/add",method=RequestMethod.GET)
	public String addTeacher(Model model)
	{
		model.addAttribute("teacher", new Teacher());
		
		return "teacher/addTeacher";
	}
	
	@RequestMapping(value="/teacher/edit/{techid}",method=RequestMethod.GET)
	public String editTeacher(@PathVariable("techid") int techid, Model model)
	{
		model.addAttribute("teacher", teacherService.getTeacherById(techid));
		
		return "teacher/addTeacher";
	}
	
	@RequestMapping(value="/teacher/save", method = RequestMethod.POST)
	public String saveTeacher(@ModelAttribute Teacher teacher)
	{
		teacherService.saveTeacher(teacher);
		
		return "redirect:/teacher";
	}
	
	@RequestMapping(value="/teacher")
	public String listTeacher(Model model)
	{
		model.addAttribute("teacher", teacherService.getAllTeacher());
		
		return "teacher/listTeacher";
	}
	
	@RequestMapping(value="/teacher/delete/{techid}",method=RequestMethod.GET)
	public String deleteTeacher(@PathVariable("techid") int techid, Model model)
	{
		teacherService.deleteTeacher(techid);
		
		return "redirect:/teacher";
	}
	
	
}


	

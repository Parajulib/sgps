package edu.ganesh.ms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ganesh.ms.domain.Role;
import edu.ganesh.ms.domain.Student;
import edu.ganesh.ms.domain.UserLogin;
import edu.ganesh.ms.service.StudentService;
import edu.ganesh.ms.service.TeacherService;
import edu.ganesh.ms.service.UserService;

/**
 * @author Bharat
 *
 */
@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@Autowired
	StudentService studentService;

	@Autowired
	TeacherService teacherService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping("/")
	public String homePage() {

		return "index";
	}

	@RequestMapping("/login")
	public String loginPage() {

		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage() {

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPostPage(@RequestParam("user_type") String userType,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("retype_password") String retypePassword,
			@RequestParam("regNumber") int regNumber,
			@RequestParam("dateOfBirth") Date dateOfBirth, Model model,
			HttpSession session) {
		if (username.length() <= 6)

		{
			model.addAttribute("username_error",
					"Username must be atleast 6 character or more");
			return "signup";
		}
		UserLogin user = userService.getUserByUsername(username);

		if (user != null) {
			model.addAttribute("username_error",
					"Username already exist. Please choose different user name.");
			return "signup";
		}

		if (password.length() < 6) {
			model.addAttribute("password_error",
					"Password must be atleast 6 character or more.");
			return "signup";
		}

		if (!password.equals(retypePassword)) {
			model.addAttribute("retype_password_error",
					"Retype Password didn't match.");
			return "signup";
		}

		if (userType.equals("student")) {
			Student student = studentService.getStudentById(regNumber);
			if (student == null) {
				model.addAttribute("regNumber_error",
						"Student with given registration number not found.");
				return "signup";
			} else if (!student.getDateOfBirth().equals(dateOfBirth)) {
				model.addAttribute("dateOfBirth_error",
						"Date of Birth not valid.");
				return "signup";
			} else if (student.getUserLogin() != null) {

				model.addAttribute(
						"dateOfBirth_error",
						"You already have the user account created. Please try forget password to retrive.");
				return "signup";

			} else {

				UserLogin newUser = new UserLogin();
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setRole(Role.ROLE_STUDENT);
				newUser.setStudent(student);
				newUser.setEnabled(true);
				student.setUserLogin(newUser);
				userService.changePassword(newUser);
				studentService.saveStudent(student);
				session.setAttribute(
						"notification",
						"User Login Created Successfully. Please login with your username and Password.");
				return "redirect:/login";

			}
		}

		model.addAttribute("finalcheck", "Everything Good");
		return "signup";
	}

	@RequestMapping("/createadmin")
	public void createAdmin(HttpServletResponse response) {
		String result = "failed";
		try {

			UserLogin user = userService.getUserByUsername("admin");

			if (user == null) {
				user = new UserLogin();
				user.setUsername("admin");
				user.setPassword("admin");
				user.setEnabled(true);
				user.setRole(Role.ROLE_ADMIN);
				userService.changePassword(user);

				result = "Admin Created Successfully";

			} else {
				result = "Admin already exist";
			}

			response.getWriter().println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

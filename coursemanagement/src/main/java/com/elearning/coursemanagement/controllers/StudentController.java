package com.elearning.coursemanagement.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;
import com.elearning.coursemanagement.model.StudentLogin;
import com.elearning.coursemanagement.services.StudentServices;
@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentServices Services;
	
	@GetMapping("/studentlogin")

	public String studenLogin(Model model)
	{
	  StudentLogin std=new StudentLogin();
	  model.addAttribute("student1", std);
	  return "studentlogin";
	}

	
	@PostMapping("/studlogin")
	public String VerifyLogin(@Valid @ModelAttribute("student1") StudentLogin student, BindingResult result, Model model, HttpSession session)
	{
		
		if(result.hasErrors())
		{
			return "studentlogin";
		}
		else {
		
		if(Services.login(student))
		{
			session.setAttribute("studentname", student.getName());
			//session.setMaxInactiveInterval(120);
			//model.addAttribute("message", student.getName()+"successfully logged in");
			return "studenthome";
		}
		model.addAttribute("message", "Invalid UserName or Password");
		//System.out.println(admin);
		return "failure";
		}
	}
	
	@GetMapping("/studentregister")
	public String studentreg(Model model)
	{
		Student s=new Student();
		model.addAttribute("studreg",s);
		return "studentregister";
	}
	
	@PostMapping("/reg")
	public String verifystudentreg(@Valid @ModelAttribute("studreg") Student student, BindingResult result, Model model,HttpSession session) {
		if(result.hasErrors())
		{
			return "studentregister";
		}else
		{
			SimpleDateFormat s=new SimpleDateFormat();
			Date d=new Date();
			student.setDatecreated(d);
			int res=Services.register(student);
			if(res==1)
			{
				model.addAttribute("message","you already registerd.please login <a href='/studentlogin'>Login</a>");
				return "success";
			}
			else if(res==2)
			{
				model.addAttribute("message","successfully registerd.please login <a href='/studentlogin'>Login</a>");
				return "success";
			
		}
		return "failure";
	}
	}
	@GetMapping("/listcourse")
	
	public String findAllCourses(HttpSession session, Model model)
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		List<Course>  courses =Services.getAllCourses();
		
		
		
		model.addAttribute("courseList", courses);
		return "studenthome";
	}
	
	
	@GetMapping("/applycourse")
	public String applyCourse(@RequestParam("couresid") int id, HttpSession session, Model model)
	{
		System.out.println(id);
		//System.out.println(studentServices.getCourse(id));
	//	List<Course>  list = new ArrayList<Course>();
		
		
		String name = (String) session.getAttribute("studentname");
		
		    
 		Student s = Services.getStudent(name);  // 
 		List<Course>  list = s.getCourseList();
 		list.add(Services.getCourse(id));
 		  s.setCourseList(list);;
 		 boolean status =  Services.updateStudent(s);
 		 
 		 System.out.println(status);
		System.out.println((String) session.getAttribute("stusername"));
		return "studenthome";
	}

	@GetMapping("/mycourse")
	public String getStudentAppiesCourse(HttpSession session, Model model)
	
	{
		String name = (String)session.getAttribute("studentname");
		
	Student  s = Services.getStudent(name);
	
	
	model.addAttribute("courseList", s.getCourseList());
	
	return "studenthome";
		
	}
	
	/*
	 * @GetMapping("/viewprofile") public String viewProfile(HttpSession
	 * session,Model model) { return }
	 */	
	@GetMapping("/Logout")
	@ResponseBody
	public String logOut(HttpSession session)
	{
		session.invalidate();
		
		return "<h1>Logged out successfully <a href='/studentlogin/'>Login Again</a>";
	}

}

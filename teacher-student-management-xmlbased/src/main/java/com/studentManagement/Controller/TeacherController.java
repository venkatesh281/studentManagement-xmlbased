package com.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studentManagement.StudentDao;
import com.studentManagement.Teacher;
import com.studentManagement.TeacherDao;

@Controller
public class TeacherController {

	@Autowired
	TeacherDao teachObj;
	@Autowired
	StudentDao studObj;

	// url for registeration

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(@ModelAttribute("Teacher") Teacher teacher) {

		// m.addAttribute("teacher", new Teacher());
		// List<States> allStates = statesObj.getAllStates();
		// m.addAttribute("state", allStates);

		return "registrationform";
	}

	// url for save teacher
	@RequestMapping(value = "/saveteacher", method = RequestMethod.POST)
	public String saveTeacher(@ModelAttribute("teacher") Teacher teach, Model m) {

		teachObj.save(teach);

		return "redirect:/viewteacher";
	}

	@RequestMapping(value = "/editteacher/{id}")
	public String edit(@PathVariable int id, Model m) {
		Teacher teach = teachObj.getTeacherById(id);
		m.addAttribute("teacher", teach);
		return "teachereditform";
	}

	@RequestMapping(value = "/editsaveteacher", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("teacher") Teacher teacherinfo) {
		teachObj.update(teacherinfo);
		return "redirect:/viewteacher";
	}

	// url for viewTeacher
	@RequestMapping(value = "/viewteacher", method = RequestMethod.GET)
	public String viewTeacher(Model m) {

		List<Teacher> teacherlist = teachObj.getAllTeacher();

		m.addAttribute("teacherInfo", teacherlist);

		return "teacherview";
	}

}

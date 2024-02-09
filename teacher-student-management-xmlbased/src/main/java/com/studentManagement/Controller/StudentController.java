package com.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studentManagement.Student;
import com.studentManagement.StudentDao;
import com.studentManagement.TeacherDao;


@Controller
public class StudentController {
	
	
	@Autowired
	TeacherDao teachObj;
	@Autowired
	StudentDao studObj;
	
	
	
//		if(null!= teachInfo) {
//			
//			mav = new ModelAndView("welcome");
//			mav.addObject("message", teachInfo.getName());
//		}
//		else {
//			mav = 
//		}
		
    
    
   
    
    
    @RequestMapping(value="/savestudent",method = RequestMethod.POST) 
    public String saveStudent(@ModelAttribute("student")Student stud) {
    	
    	studObj.save(stud);
    	
    	return "redirect:/viewstudent";
    	
    	
    }
    
    @RequestMapping(value ="/viewstudent",  method = RequestMethod.GET)
	public String viewStudent(Model m) {
        
		List<Student> studlist = studObj.getStudents();
		m.addAttribute("studentInfo", studlist);
		String message = "Student Added successfully";
    	m.addAttribute("message", message);
		return "studentview";
	}
    
   
    
    @RequestMapping(value="/editstudent/{rollnum}")    
    public String edit(@PathVariable int rollnum, Model m){    
        Student stud=studObj.getStudentByRollNum(rollnum);    
        m.addAttribute("student",stud);  
        return "editStudentForm";    
    } 
    
    @RequestMapping(value="/editsavestudent",method = RequestMethod.POST)    
    public String editSaveStudent(@ModelAttribute("student") Student studinfo, Model m){    
        studObj.update(studinfo);    
        
        return  "redirect:/viewstudent";    
    }  
    
    
    @RequestMapping(value="/deletestudent/{rollnum}",method = RequestMethod.GET)    
    public String deleteStudent(@PathVariable("rollnum") int rollnum){    
        studObj.delete(rollnum);    
        return "redirect:/viewstudent";  
    }
    
    
    
    
    @RequestMapping(value ="/addAnotherStud")
    public String addStudent(Model m) {
    	
    	m.addAttribute("student", new Student());
		return "studentform";
    	
    }
    
    
    
    
    
}

package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class HelloController {

	@Autowired
	Employee empl;
	@Autowired
	EmployeeDao employeedao;
	ModelAndView mav;
	String message;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView welcome() {
		mav=new ModelAndView();
		mav.setViewName("Welcome");
		return mav;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView welcome(@RequestParam("username") String username,@RequestParam("password") String password) {
		mav=new ModelAndView();
		mav.addObject("uname", username);
		mav.addObject("pass", password);
		mav.setViewName("Message");
		return mav;
	}
	
	@RequestMapping("getemployee")
	public ModelAndView getEmployee(@ModelAttribute("empl") Employee employee) {
		employee.setEmpname("999");
		empl=employee;
		System.out.println(empl.getEmpname());
		ModelAndView mav=new ModelAndView();
		/*validation.validate(emp, result);
		if(result.hasErrors()) {
			mav.setViewName("Employee");
			return mav;
		}*/
		int addEmpl = employeedao.addEmpl(employee);
		if(addEmpl>0)
			mav.setViewName("Welcome");
		else
			mav.setViewName("Employee");
		mav.addObject("emp", employee);
		return mav;
	}	
	
	@RequestMapping("/employee")
	public ModelAndView employee() {
		ModelAndView mav=new ModelAndView();
		mav.addObject(empl);
		mav.setViewName("Employee");
		return mav;
	}
	
	@RequestMapping("viewEmp")
	public ModelAndView viewEmployee() {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("empls", employeedao.getAllEmployee());
		mav.setViewName("viewallemployee");
		return mav;
	}
}

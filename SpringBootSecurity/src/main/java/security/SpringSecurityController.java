package security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SpringSecurityController {

	@RequestMapping("/userlogin")
	@ResponseBody
	public String userValidation() {
		return "User successfully logged in";
	}
	
	@RequestMapping("/adminlogin")
	public String adminValidation() {
		return "Admin successfully loggin in";
	}
}

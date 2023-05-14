package data.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.entity.UserEntity;
import data.repository.UserRepository;


@Controller
@RequestMapping("/signup")
public class signupController {
	@Autowired
	private UserRepository userRe;
	
	public void setInfor(UserRepository userRe) {
		this.userRe = userRe;
	}
	@GetMapping("/add")
	public String signup(Model model) {	
		return "signupForm";
	}
	@PostMapping
	public String addUser(@RequestParam("email")String email,
			@RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName,
			@RequestParam("password")String password,
			UserEntity user, Model model) {  
	   if(userRe.findByEmail(email)==null) {	  
		   userRe.save(new UserEntity(email,firstName,lastName,password));
		   return "redirect:/logins/check";
	   }
	   else if(userRe.findByEmail(email)!=null) {	   
		   model.addAttribute("error","Tài khoản đã tồn tại!"); 
	   }
	   
	   return "signupForm";
	   
	}
}


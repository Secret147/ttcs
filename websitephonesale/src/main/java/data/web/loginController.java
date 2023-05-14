package data.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.entity.ProductEntity;
import data.entity.UserEntity;
import data.repository.ProductRepository;
import data.repository.UserRepository;

@Controller
@RequestMapping("/logins")
public class loginController {
	@Autowired
	private UserRepository userRe;
	
	private ProductRepository productRe;
	
	public void setUserRe(UserRepository userRe) {
		this.userRe = userRe;
	}
	@GetMapping("/check")
	public String login() {
		return "login";
	}

	@PostMapping
	public String loginacc(@RequestParam("email")String email,
			@RequestParam("password")String password ,ModelMap model, HttpSession session,
			HttpServletRequest request,HttpServletResponse response) {
	    UserEntity user= userRe.findByEmail(email);
	    
	    if(user!=null && user.getPassword()!=null && user.getPassword().equals(password) && user.getEmail()!=null ) {  
	    	session.setAttribute("username", email);
	    	session.setAttribute("id_user", user.getId());
	    	
	    	return "redirect:/home/view";	    	
	    }
	    else {
	    	model.addAttribute("error","Tên đăng nhập hoặc mật khẩu không chính xác !");
	    
	    }
	    return "login";
		
	}
	@PostMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		session.removeAttribute("username"); 
		session.removeAttribute("id_user");
		return "redirect:/";
	}
}

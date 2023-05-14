package data.web;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import data.entity.CartEntity;
import data.entity.OderEntity;
import data.entity.UserEntity;
import data.repository.OrderRepository;
import data.repository.UserRepository;

@Controller
@RequestMapping("/checkorder")
public class checkOrderController {
	@Autowired
	private OrderRepository orderRe;
	@Autowired
	private UserRepository userRe;
	
	
	public void setOrderRe(OrderRepository orderRe) {
		this.orderRe = orderRe;
	}


	@GetMapping("/views")
	public String checkOrder(Model model,HttpSession session){
		Long id_user = (Long) session.getAttribute("id_user");

		List<OderEntity> orders = orderRe.findByUseridOrderByIdDesc(id_user);
		model.addAttribute("orders",orders);
		return "checkorder";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id){
		orderRe.deleteById(id);
		return "redirect:/checkorder/views";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long id,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		OderEntity order = orderRe.findById(id).get();	
		Long id_user = (Long) session.getAttribute("id_user");
		UserEntity user = userRe.findById(id_user).get();
		model.addAttribute("user",user);
		model.addAttribute("orders",order);
		return "editorder";
	}
	@PostMapping("/edit")
	public String edit (@ModelAttribute("orders") OderEntity order) {	
		orderRe.save(order);
		return "redirect:/checkorder/views";
	}
	

}

package data.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import data.entity.ProductEntity;
import data.repository.OrderRepository;
import data.repository.ProductRepository;
import data.repository.UserRepository;

@Controller
@RequestMapping("/order")
public class oderController {
	@Autowired
	private ProductRepository productRe ;
	
	@Autowired
	private OrderRepository orderRe;
	
	@Autowired
	private UserRepository userRe;
	
	
	public void setProductRe(ProductRepository productRe) {
		this.productRe = productRe;
	}


	public void setOrderRe(OrderRepository orderRe) {
		this.orderRe = orderRe;
	}


	@GetMapping("/views/{id}")
	public String order(@PathVariable("id") Long id,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		ProductEntity product = productRe.findById(id).get();
		model.addAttribute("product",product);
		Long id_user = (Long) session.getAttribute("id_user");
		UserEntity user = userRe.findById(id_user).get();
		model.addAttribute("user",user);
		model.addAttribute("order",new OderEntity(null,null,null,null,product.getId(),product.getCost(),product.getBrand(),product.getImg(),null,user.getId()));
		return "order";
	}
	@PostMapping
	public String saveorder(Model model,OderEntity order) {	
		model.addAttribute(order);	
		orderRe.save(order);
		return "redirect:/checkorder/views";
	}
	

}

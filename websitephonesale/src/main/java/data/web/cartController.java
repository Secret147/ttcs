package data.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import data.entity.CartEntity;
import data.entity.ProductEntity;
import data.repository.CartRepository;
import data.repository.ProductRepository;

@Controller
@RequestMapping("/cart")
public class cartController {
	@Autowired
	private ProductRepository productRe;
	
	@Autowired
	private CartRepository cartRe;
	
	public void setCartRe(CartRepository cartRe) {
		this.cartRe = cartRe;
	}
	public void setProductRe(ProductRepository productRe) {
		this.productRe = productRe;
	}
	
	@GetMapping("/views")
	public String cart(Model model,HttpSession session) {
		Long id_user = (Long) session.getAttribute("id_user");
		List<CartEntity> cartitems = cartRe.findByUseridOrderByIdDesc(id_user);
		model.addAttribute("cartitems",cartitems);
		return "cart";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		CartEntity cartitem=cartRe.findById(id).get();
		cartRe.delete(cartitem);
		return "redirect:/cart/views";
	}
	@GetMapping("/add/{id}")
	public String addCart(@PathVariable("id") Long id,HttpSession session) {
		ProductEntity product=productRe.findById(id).get();
		Long id_user = (Long) session.getAttribute("id_user");
		cartRe.save(new CartEntity(product.getImg(), product.getBrand(), product.getCost(),product.getId(),id_user));
		return "redirect:/cart/views";
	}
	

}

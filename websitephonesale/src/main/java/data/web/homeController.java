package data.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.entity.CartEntity;
import data.entity.ProductEntity;
import data.repository.CartRepository;
import data.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


@Controller
public class homeController {
	@Autowired
	private ProductRepository productRe;
	
	public void setProductRe(ProductRepository productRe) {
		this.productRe = productRe;
	}
	@GetMapping
	public String home() {
		return "index";
	}
    @GetMapping("/")
    public String products(Model model,HttpSession session) {
    	List<ProductEntity> products = productRe.findAll();
    	model.addAttribute("products",products);
    	return "index";
    }
}
    

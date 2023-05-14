package data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")

public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String img; 
    
    private String brand; 
    
    private Long cost;
    
    private Long product_id;
    
    private Long userid;
    
    @OneToMany(mappedBy = "cart")
	private List<ProductEntity> products = new ArrayList<>();
    
    @ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity usercart;
 
	private Integer quantity;
	public CartEntity() {
	    // default constructor with no arguments
	  }


	public CartEntity(String img, String brand, Long cost, Long product_id,Long userid) {
		this.img = img;
		this.brand = brand;
		this.cost = cost;
		this.product_id=product_id;
		this.userid=userid;
	}
	
	

}
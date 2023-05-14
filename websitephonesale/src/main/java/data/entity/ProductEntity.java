package data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long cost;
	
	private String memory;
	
	private String brand;
	
	private String img;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OderEntity order;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private CartEntity cart;
	
	

}

package data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="order_product")
public class OderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String numberphone;
	
	private String email;
	
	private String address;
	
	private String payment;
	
	private Long id_product;
	
	private Long sum;
	
	private String brand;
	
	private String img;
	
	private Long userid;
	
	
	@OneToMany(mappedBy = "order")
	private List<ProductEntity> products = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userorder;

	public OderEntity(String fullName, String numberphone, String email, String address, Long id_product, Long sum,String brand, String img, String payment,Long userid) {
		super();
		this.fullName = fullName;
		this.numberphone = numberphone;
		this.email = email;
		this.address = address;
		this.id_product = id_product;
		this.sum = sum;
		this.brand = brand;
		this.img = img;
		this.payment=payment;
		this.userid=userid;
	}
	public OderEntity() {
		
	}

}

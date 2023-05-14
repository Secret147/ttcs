package data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String fullName;
	
	@OneToMany(mappedBy = "userorder")
	private List<OderEntity> orders = new ArrayList<>();
	
	@OneToMany(mappedBy = "usercart")
	private List<CartEntity> carts = new ArrayList<>();

	public UserEntity(String email, String firstName, String lastName, String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.fullName= firstName + " " + lastName;
	}
	public UserEntity() {
		
	}
	

}

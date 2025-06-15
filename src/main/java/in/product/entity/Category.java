package in.product.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Entity class for product category with bidirectional realtion to
 * productEntity
 * 
 */
@Entity
@Table(name = "category")
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Category cant be blank")
	@Column(unique = true)
	private String name;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<product> products = new ArrayList<>();

}

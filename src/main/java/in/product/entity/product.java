package in.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a product in inventory system Map to product table
 * in mysql with auto-generated Id
 * 
 * 
 */
@Entity
@Table(name = "product")
@Data
@ToString
@Builder
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtc_id")
	private Integer id;
	@NotBlank(message = "Product name cant be blank")
	@Column(nullable = false, length = 100)
	private String name;
	@NotBlank(message = "Product must be positive or zero")
	@Column(precision = 10, scale = 2)
	private BigDecimal price;
	@ManyToOne(fetch = FetchType.LAZY) // optimize performace
	@JoinColumn(name = "category_Id", nullable = false)
	private Category category;
	@Column(name = "isActive", columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean isActive;
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

}

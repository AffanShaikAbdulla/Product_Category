package in.product.entity.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * DTo for accepting prodcut creation/update request from API Includes
 * validation annotation for buisness rules
 * 
 */
public class ProductRequestDTO {
	@NotBlank(message = "Prouct name is mandatory")
	@Size(max = 30, message = "Name cant be exceed 30 charecters")
	private String name;
	@DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0")
	private BigDecimal price;
	@NotNull(message = "Category Id is reqired")
	@Positive(message = "Category Id must be positive integer")
	private Integer category_Id;

}

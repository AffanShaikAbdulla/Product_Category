package in.product.dto;

import lombok.Data;

/**
 * DTO for sening product deatls in API response includes computed feilds(eg:
 * formated prices)
 * 
 */
@Data
public class ProductResponseDTO {

	private Integer productId;
	private String name;
	private String formatedPrice;
	private String categoryName;
	private Boolean isActive;
	private String createdAt;

}

package in.product.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO for sening product deatls in API response includes computed feilds(eg:
 * formated prices)
 * 
 */
@Data
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

	private Integer productId;
	private String name;
	private String formatedPrice;
	private String categoryName;
	private Boolean isActive;
	private String createdAt;

}

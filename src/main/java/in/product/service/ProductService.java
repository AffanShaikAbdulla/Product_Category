package in.product.service;

import java.util.List;

import in.product.dto.ProductRequestDTO;
import in.product.dto.ProductResponseDTO;

/**
 * contract for product operations Implementation can be swapped
 * 
 */
public interface ProductService {
	ProductResponseDTO addProduct(ProductRequestDTO request);

	void softdelete(Integer productId);

	List<ProductResponseDTO> getActiveProductsByCategory(Integer categoryId);
}

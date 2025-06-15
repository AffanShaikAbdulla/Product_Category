package in.product.service;

import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import in.product.dto.ProductRequestDTO;
import in.product.dto.ProductResponseDTO;
import in.product.entity.Category;
import in.product.entity.Product;
import in.product.entity.*;
import in.product.excetion.ResourceNotFoundException;
import in.product.repository.CategoryRepository;
import in.product.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public ProductResponseDTO addProduct(ProductRequestDTO request) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(request.getCategory_Id())
				.orElseThrow(() -> new ResourceNotFoundException("Catgory not found"));

		Product product = Product.builder().name(request.getName()).price(request.getPrice()).category(category)
				.isActive(true).build();
		Product savedProduct = productRepository.save(product);

		return convertTODTO(savedProduct);
	}

	@Override
	public void softdelete(Integer productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductResponseDTO> getActiveProductsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	private ProductResponseDTO convertTODTO(Product product) {
		ProductResponseDTO dto = new ProductResponseDTO();
		dto.setProductId(product.getId());
		dto.setName(product.getName());
		dto.setFormatedPrice("$" + product.getPrice().setScale(2, RoundingMode.HALF_UP));
		dto.setCategoryName(product.getCategory().getName());
		dto.setIsActive(product.getIsActive());
		dto.setCreatedAt(product.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return dto;

	}

}

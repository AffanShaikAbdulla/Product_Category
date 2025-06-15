package in.product.service;

import org.springframework.stereotype.Service;

import in.product.entity.Category;
import in.product.repository.CategoryRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImple implements CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryServiceImple(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category findCategoryById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

}

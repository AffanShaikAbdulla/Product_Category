package in.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.product.entity.product;

public interface ProductRepository extends JpaRepository<product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.categoryId = :categoryId AND p.isActive = true")
	List<product> findProductByCategory(@Param("categoryd") Integer categoryId);

	// soft delete(update isActive flag)
	@Modifying
	@Query("UPDATE Product p SET p.isActive = false WHERE p.productId = :productId")
	void softDelte(@Param("productId") Integer productId);

}

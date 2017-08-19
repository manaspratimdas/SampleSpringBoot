package manas.springboot.sampe.myapp.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import manas.springboot.sampe.myapp.beans.Product;

public interface ProductRepository extends Repository<Product, Long> {

	Product findById(Long id);

	Product save(Product product);

	void delete(Long id);

	List<Product> findAll();
}

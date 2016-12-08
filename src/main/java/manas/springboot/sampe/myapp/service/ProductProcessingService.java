package manas.springboot.sampe.myapp.service;

import java.util.List;

import manas.springboot.sampe.myapp.beans.Product;

public interface ProductProcessingService {
	
	public Product getProductById(Long id);

	public Product save(Product product);

	public void delete(Long id);

	public List<Product> findAll();

}

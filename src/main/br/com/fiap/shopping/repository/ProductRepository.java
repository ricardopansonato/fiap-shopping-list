package br.com.fiap.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.shopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findById(Long id);
	Product findByName(String name);
}
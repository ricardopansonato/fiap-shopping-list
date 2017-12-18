package br.com.fiap.shopping.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.fiap.shopping.model.Product;
import br.com.fiap.shopping.repository.ProductRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private ProductRepository productRepository;

	@Autowired
	public DataLoader(ProductRepository userRepository) {
		this.productRepository = userRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Product product = new Product();
		product.setName("Milk");
		productRepository.save(product);
		
		product = new Product();
		product.setName("Rice");
		productRepository.save(product);
		
		product = new Product();
		product.setName("Egg");
		productRepository.save(product);
		
	}

}

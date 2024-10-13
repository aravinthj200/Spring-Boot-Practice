package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.javaexpress.entities.Product;

import com.javaexpress.repository.ProductRepository;
import com.javaexpress.response.ProductBoResponse;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product createProduct(Product product) {
		product.setBarcode(UUID.randomUUID().toString());
		Product dbProduct = productRepository.save(product);
		return dbProduct;
	}

	public List<Product> findAllProduct(Product product) {
		return productRepository.findAll().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
	}

	public Product findProductById(Long prodId) {
		return productRepository.findById(prodId).orElseThrow(() -> new EntityNotFoundException("Product not foound"));
	}

	public void deleteByID(Long id) {
		productRepository.deleteById(id);
	}

	public Product updateProduct(Long id, Product product) {
		Product prod = findProductById(id);
		prod.setPrice(product.getPrice());
		prod.setProdName(product.getProdName());
		prod.setProDescription(product.getProDescription());
		prod.setInStock(product.getInStock());
		prod.setProdQuantity(product.getProdQuantity());
		productRepository.save(prod);
		return prod;

	}

	public ProductBoResponse fetchProducts(PageRequest pageRequest) {
		// T ODO Auto-generated method stub
		Page<Product> page = productRepository.findAll(pageRequest);
		ProductBoResponse productResponse = new ProductBoResponse();
		productResponse.setTotalNoOfPages(page.getTotalPages());
		productResponse.setTotaNoOfElements(page.getTotalElements());
		productResponse.setProduct(page.getContent());
		return productResponse;
	}

}

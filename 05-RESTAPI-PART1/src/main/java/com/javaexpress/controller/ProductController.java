package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entities.Product;
import com.javaexpress.response.ProductBoResponse;
import com.javaexpress.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping
	public ResponseEntity<String> CreateProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public List<Product> getAllProduct(Product product) {
		return productService.findAllProduct(product);
	}

	@GetMapping("{id}")
	public Product findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	@PutMapping("{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteByID(id);
	}

	@GetMapping("/pagination")
	public ProductBoResponse fetchProducts(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "DESC") String sortBy) {
		if (sortBy.equals("ASC")) {
			return productService.fetchProducts(PageRequest.of(pageNo, pageSize, Direction.ASC, "price"));
		} else {
			return productService.fetchProducts(PageRequest.of(pageNo, pageSize, Direction.DESC, "price"));
		}

	}
}

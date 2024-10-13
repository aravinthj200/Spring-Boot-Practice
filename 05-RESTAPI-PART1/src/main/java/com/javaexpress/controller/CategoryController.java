package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entities.Category;
import com.javaexpress.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping
	public ResponseEntity<String> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@GetMapping
	public List<Category> getAllCategory(Category caetgory) {
		return categoryService.getCategory(caetgory);

	}

}

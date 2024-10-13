package com.javaexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entities.Category;
import com.javaexpress.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category updateCategory(Long id, Category category) {
		Category dbCat = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		dbCat.setCategoryId(category.getCategoryId());
		dbCat.setCategoryName(category.getCategoryName());
		return categoryRepository.save(dbCat);

	}

	public List<Category> getCategory(Category category) {

		return categoryRepository.findAll();
	}
}

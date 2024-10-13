package com.javaexpress.response;

import java.util.List;

import com.javaexpress.entities.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBoResponse {

	int totalNoOfPages;
	Long totaNoOfElements;
	List<Product> product;

}

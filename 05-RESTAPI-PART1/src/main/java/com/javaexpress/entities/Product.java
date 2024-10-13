package com.javaexpress.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prodId;

	@Column(name = "ProductQuantity")
	private Integer prodQuantity;

	@Column(name = "ProductName", unique = true)
	private String prodName;

	@Column(name = "ProductDescription")
	private String proDescription;

	private Boolean inStock;

	@Column(name = "ProductPrice")
	private double price;

	private String barcode;
	
	@ManyToOne
	@JoinColumn(name = "catId",nullable = false)
	//@JsonBackReference
	private Category category;
	
//	@PrePersist
//    public void generateBarcode() {
//        if (this.barcode == null) {
//            this.barcode = UUID.randomUUID().toString();
//        }
//    }


}

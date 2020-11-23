package com.order.management.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.order.management.domain.Category;
import com.order.management.entities.Product;
import com.order.management.repositories.ProductDAO;
import com.order.management.services.Products;

@Service("products")
public class ProductsImpl implements Products {

	private static Logger log = LoggerFactory.getLogger(ProductsImpl.class);

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Product addProduct(String name, Category category, int quantity, String brand, double price) {
		log.info("START addProduct: name={}", name);
		Product product = new Product();
		product.setName(name);
		product.setCategory(category);
		product.setQuantity(quantity);
		product.setBrand(brand);
		product.setPrice(price);
		productDAO.saveAndFlush(product);
		return product;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Product removeProduct(long id) throws EntityNotFoundException {
		log.info("START removeProduct: id={}", id);
		Optional<Product> product = productDAO.findById(id);
		if (!product.isPresent()) {
			log.error("Product with id {} does not exist", id);
			throw new EntityNotFoundException();
		}

		productDAO.delete(product.get());
		return product.get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void test() {

		Product product = new Product();
		product.setName("Mythos beer");
		product.setCategory(Category.BEVERAGES);
		product.setQuantity(20);
		product.setBrand("MYTHOS");
		product.setPrice(2.50);
		productDAO.saveAndFlush(product);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Product updateProduct(long id, String name, Category category, int quantity, String brand, double price)
			throws EntityNotFoundException {
		log.info("START updateProduct: id={}", id);
		Optional<Product> productOpt = productDAO.findById(id);
		if (!productOpt.isPresent()) {
			log.error("Product with id {} does not exist", id);
			throw new EntityNotFoundException();
		}

		Product product = productOpt.get();
		product.setName(name);
		product.setCategory(category);
		product.setQuantity(quantity);
		product.setBrand(brand);
		product.setPrice(price);
		productDAO.saveAndFlush(product);
		return product;
	}

	@Override
	public Optional<Product> retrieveProduct(long id) {
		log.debug("START retrieveProduct: id={}", id);
		return productDAO.findById(id);
	}

	@Override
	public List<Product> retrieveAllProducts() {
		log.debug("START retrieveAllProducts");
		return productDAO.findAll();
	}

}

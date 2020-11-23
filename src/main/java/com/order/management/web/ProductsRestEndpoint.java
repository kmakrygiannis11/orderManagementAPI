package com.order.management.web;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entities.Product;
import com.order.management.services.Products;
import com.order.management.web.dto.ProductRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductsRestEndpoint {

	@Autowired
	private Products service;

	@ApiOperation(value = "addProduct")
	@PostMapping("/")
	public Product addProduct(@RequestBody ProductRequest request) throws EntityExistsException {
		return service.addProduct(request.getName(), request.getCategory(), request.getQuantity(), request.getBrand(),
				request.getPrice());
	}

	@ApiOperation(value = "removeProduct")
	@DeleteMapping("/{id}")
	public Product removeProduct(@PathVariable long id) throws EntityNotFoundException {
		return service.removeProduct(id);
	}

	@ApiOperation(value = "updateProduct")
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody ProductRequest request)
			throws EntityNotFoundException {
		return service.updateProduct(id, request.getName(), request.getCategory(), request.getQuantity(),
				request.getBrand(), request.getPrice());
	}

	@ApiOperation(value = "retrieveProduct")
	@GetMapping("/{id}")
	public Optional<Product> retrieveProduct(@PathVariable long id) {
		return service.retrieveProduct(id);
	}

	@ApiOperation(value = "retrieveAllProducts")
	@GetMapping
	public List<Product> retrieveAllProducts() {
		return service.retrieveAllProducts();
	}

}

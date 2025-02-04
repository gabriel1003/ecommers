package com.ecommers.services;

import com.ecommers.entities.ProductEntity;
import com.ecommers.exception.UserNotFoundException;
import com.ecommers.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProductService {

private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity productEntity) {
        productRepository.persist(productEntity);
        return productEntity;
    }

    public List<ProductEntity> findAll(Integer page, Integer pageSize) {
        return productRepository.findAll().page(page, pageSize).list();
    }

    public ProductEntity findById(Long productId) {
        return (ProductEntity) productRepository.findByIdOptional(productId).orElseThrow(UserNotFoundException::new);
    }

    public ProductEntity updateProduct(Long productId, ProductEntity productEntity) {
        var product = findById(productId);

        product.setName(productEntity.getName());
        productRepository.persist(product);
        return product;
    }

    public void deletById(Long productId) {
        var product = findById(productId);
productRepository.deleteById(product.getId());
    }
}

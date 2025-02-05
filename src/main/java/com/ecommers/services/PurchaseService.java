package com.ecommers.services;

import com.ecommers.entities.ProductEntity;
import com.ecommers.entities.PurchaseEntity;
import com.ecommers.entities.UserEntity;
import com.ecommers.exception.InsufficientStockException;
import com.ecommers.exception.UserNotFoundException;
import com.ecommers.repositories.ProductRepository;
import com.ecommers.repositories.PurchaseRepository;
import com.ecommers.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PurchaseService {

    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    PurchaseRepository purchaseRepository;

    @Transactional
    public PurchaseEntity createPurchase(String userCpf, List<String> productNames) {
        UserEntity userEntity = userRepository.find("cpf", userCpf).firstResultOptional().orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o CPF: " + userCpf));

        List<ProductEntity> productToPurchase = new ArrayList<>();
        List<String> unavailableProducts = new ArrayList<>();

        double totalAmout = 0.0;

        for (String productName: productNames) {
            ProductEntity product = productRepository.find("name", productName).firstResultOptional().orElseThrow(() -> new UserNotFoundException("Produto não encontrado: " + productName));

            if (product.getQuantity() <= 0) {
                unavailableProducts.add(productName);
            }

            productToPurchase.add(product);
        }

        if (unavailableProducts.isEmpty()) {
            throw new InsufficientStockException("Produto em falta: " + String.join(", ", unavailableProducts));
        }

        for (ProductEntity product: productToPurchase) {
            product.setQuantity(product.getQuantity() - 1);
            productRepository.persist(product);
            totalAmout += product.getPrice();
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setUser(userEntity);
        purchaseEntity.setProducts(productToPurchase);
        purchaseEntity.setTotalAmount(totalAmout);

        purchaseRepository.persist(purchaseEntity);

        return purchaseEntity;
    }

    public List<PurchaseEntity> findAll(Integer page, Integer pageSize) {
        return purchaseRepository.findAll().page(page, pageSize).list();
    }

    public PurchaseEntity findById(Long purchaseId) {
        return purchaseRepository.findByIdOptional(purchaseId).orElseThrow(RuntimeException::new);
    }
}

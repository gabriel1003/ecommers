package com.ecommers.services;

import com.ecommers.dto.PurchaseDTO;
import com.ecommers.dto.ProductRequestDTO;
import com.ecommers.entities.ProductEntity;
import com.ecommers.entities.PurchaseEntity;
import com.ecommers.entities.UserEntity;
import com.ecommers.exception.InsufficientStockException;
import com.ecommers.exception.ProductAlreadyExistsException;
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
    public PurchaseEntity createPurchase(PurchaseDTO purchaseDTO) {
        String userCpf = purchaseDTO.getCpf();
        List<ProductRequestDTO> productRequests = purchaseDTO.getProducts();

        UserEntity user = userRepository.find("cpf", userCpf).firstResultOptional()
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o CPF: " + userCpf));

        List<ProductEntity> productsToPurchase = new ArrayList<>();
        int totalQuantity = 0;

        for (ProductRequestDTO productRequest : productRequests) {
            String productName = productRequest.name();
            Integer quantityToPurchase = productRequest.quantity();

            ProductEntity product = productRepository.find("name", productName).firstResultOptional()
                    .orElseThrow(() -> new ProductAlreadyExistsException("Produto não encontrado: " + productName));

            if (product.getQuantity() < quantityToPurchase) {
                throw new InsufficientStockException("Estoque insuficiente para o produto " + productName +
                        ". Estoque disponível: " + product.getQuantity() +
                        ", Quantidade solicitada: " + quantityToPurchase);
            }

            product.setQuantity(product.getQuantity() - quantityToPurchase);
            productRepository.persist(product);

            productsToPurchase.add(product);
            totalQuantity += quantityToPurchase;
        }

        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setUser(user);
        purchase.setProducts(productsToPurchase);
        purchase.setTotalQuantity(totalQuantity);
        purchaseRepository.persist(purchase);

        return purchase;
    }
}

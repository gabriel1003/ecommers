package com.ecommers.repositories;

import com.ecommers.entities.PurchaseEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PurchaseRepository implements PanacheRepositoryBase<PurchaseEntity, Long> {
}

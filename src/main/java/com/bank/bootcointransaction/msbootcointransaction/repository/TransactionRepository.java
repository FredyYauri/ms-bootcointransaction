package com.bank.bootcointransaction.msbootcointransaction.repository;

import com.bank.bootcointransaction.msbootcointransaction.entity.PurchaseRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<PurchaseRequest, Integer> {
}

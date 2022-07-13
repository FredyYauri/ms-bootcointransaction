package com.bank.bootcointransaction.msbootcointransaction.service;

import com.bank.bootcointransaction.msbootcointransaction.dto.PayApplication;
import com.bank.bootcointransaction.msbootcointransaction.entity.PurchaseRequest;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Flux<PurchaseRequest> getPurchase();
    Mono<PurchaseRequest> savePurchase (PurchaseRequest purchaseRequest);
    Mono<PurchaseRequest> modifyPurchaseAccepted (Integer idPurchases);
    Mono<PayApplication> payApplication(@RequestBody PayApplication payApplication);

}

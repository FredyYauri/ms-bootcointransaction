package com.bank.bootcointransaction.msbootcointransaction.controller;

import com.bank.bootcointransaction.msbootcointransaction.dto.PayApplication;
import com.bank.bootcointransaction.msbootcointransaction.entity.PurchaseRequest;
import com.bank.bootcointransaction.msbootcointransaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class transactionController {
    @Autowired
    TransactionService transactionService;
    /**
     * Método para solicitar todas las compra de bootcoin
     */
    @GetMapping
    public Flux<PurchaseRequest> getPurchase() {
        return transactionService.getPurchase();
    }


    /**
     * Método para solicitar compra de bootcoin
     */
    @PostMapping
    public Mono<PurchaseRequest> savePurchase(@RequestBody PurchaseRequest purchaseRequest) {
        return transactionService.savePurchase(purchaseRequest);
    }

    /**
     * Método para aceptar compra
     */
    @PutMapping("/{idPurchases}")
    public Mono<PurchaseRequest> modifyPurchaseAccepted(@PathVariable Integer idPurchases) {
        return transactionService.modifyPurchaseAccepted(idPurchases);
    }

    /**
     * Método para realizar pago
     */
    @PostMapping("/payapplication")
    public Mono<PayApplication> payApplication(@RequestBody PayApplication payApplication) {
        return transactionService.payApplication(payApplication);
    }
}

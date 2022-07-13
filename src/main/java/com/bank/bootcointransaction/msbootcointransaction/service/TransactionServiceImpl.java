package com.bank.bootcointransaction.msbootcointransaction.service;

import com.bank.bootcointransaction.msbootcointransaction.dto.PayApplication;
import com.bank.bootcointransaction.msbootcointransaction.entity.PurchaseRequest;
import com.bank.bootcointransaction.msbootcointransaction.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Flux<PurchaseRequest> getPurchase() {
        return transactionRepository.findAll();
    }

    @Override
    public Mono<PurchaseRequest> savePurchase(PurchaseRequest purchaseRequest) {
        return transactionRepository.save(purchaseRequest);
    }

    @Override
    public Mono<PurchaseRequest> modifyPurchaseAccepted(Integer idPurchases) {
        log.info("modifyPurchaseAccepted");
        return transactionRepository.findById(idPurchases)
                .filter(result -> result.getStatus().equals("SOLICITADO"))
                .flatMap(newPurchase -> {
                    log.info("encontro solicitado");
                    String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
                    int myindex = (int)(theAlphaNumericS.length() * Math.random());
                    log.info("transferencia " + myindex);
                    newPurchase.setTransaction(myindex);
                    newPurchase.setStatus("ACEPTADO");
                    return transactionRepository.save(newPurchase);
                });
    }
    @Override
    public Mono<PayApplication> payApplication(@RequestBody PayApplication payApplication) {
        Mono<PayApplication> payApplicationMono = null;
        //Actualizar a pagado
        modifyPurchasePay(payApplication);
        //validar si el cliente tiene cuenta bootcoin

        //registrar bootcoin
        //actualizar bootcoin
        return payApplicationMono;
    }


    private void modifyPurchasePay(PayApplication payApplication) {
        log.info("modifyPurchaseAccepted");
         transactionRepository.findById(payApplication.getIdPurchases())
                .filter(result -> result.getStatus().equals("ACEPTADO"))
                .flatMap(newPurchase -> {
                    log.info("encontro aceptado");
                    newPurchase.setStatus("PAGADO");
                    return transactionRepository.save(newPurchase);
                });
    }

}

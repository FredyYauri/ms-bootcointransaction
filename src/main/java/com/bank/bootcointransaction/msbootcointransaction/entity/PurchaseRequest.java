package com.bank.bootcointransaction.msbootcointransaction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "purchases")
public class PurchaseRequest {
    @Id
    private int idPurchases;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private Double amount; // monto a comprar
    private String payMode; //tipo de pago
    private String status; //SOLICITADO, ACEPTADO, PAGADO
    private Integer transaction; //NUM TRANSACCIÓN LUEGO DE ACEPTAR
}

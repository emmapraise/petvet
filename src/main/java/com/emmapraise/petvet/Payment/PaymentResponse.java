package com.emmapraise.petvet.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentResponse {
    private int Amount;
    private String CardNumber;
    private String MerchantReference;
    private String PaymentReference;
    private String RetrievalReferenceNumber;
    private String SplitAccounts;
    private String TransactionDate;
    private String ResponseCode;
    private String ResponseDescription;
    private String AccountNumber;
}

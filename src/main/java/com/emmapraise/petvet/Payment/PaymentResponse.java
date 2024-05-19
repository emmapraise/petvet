package com.emmapraise.petvet.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PaymentResponse {
    private int Amount;
    private String CardNumber;
    private String MerchantReference;
    private String PaymentReference;
    private String RetrievalReferenceNumber;
    private List<String> SplitAccounts;
    private Date TransactionDate;
    private String ResponseCode;
    private String ResponseDescription;
    private String AccountNumber;
}

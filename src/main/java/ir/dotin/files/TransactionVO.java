
package ir.dotin.files;

import ir.dotin.business.TransactionProcessor;

import java.math.BigDecimal;

public class TransactionVO extends TransactionProcessor {

    BigDecimal amount;
    String debtorDepositNumber;
    String creditorDepositNumber;

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionVO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }


    @Override
    public String toString() {
        return "{ debtorDepositNumber:" + debtorDepositNumber +
                "creditorDepositNumber:" + creditorDepositNumber +
                ",amount:" + amount +
                "}";
    }
}



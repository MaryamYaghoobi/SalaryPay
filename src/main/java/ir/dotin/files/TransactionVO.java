
package ir.dotin.files;

import ir.dotin.business.TransactionProcessor;

import java.math.BigDecimal;

public class TransactionVO extends TransactionProcessor {

    private  BigDecimal amount;
   public static String debtorDepositNumber;
    public static String creditorDepositNumber;

    public static String getDebtorDepositNumber() {
        return debtorDepositNumber;
    }

    public TransactionVO setDebtorDepositNumber(String debtorDepositNumber) {
        this.debtorDepositNumber=debtorDepositNumber;
        return this;
    }

    public static String getCreditorDepositNumber() {
        return creditorDepositNumber;
    }

    public TransactionVO setCreditorDepositNumber(String creditorDepositNumber) {
        this.creditorDepositNumber=creditorDepositNumber;
        return this;
    }


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



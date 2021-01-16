package ir.dotin;

import java.util.List;

public class Deposit {
    private int initialBalance; // موجودی اولیه
    private String depositNumber;
    private String depositType;
    private int upperBound;

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;

    }


    public int getInitialBalance() {
        return initialBalance;
    }

    public void setInitalBalance(int initalBalance) {
        this.initialBalance = initalBalance;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;

    }


    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;

    }

    public List<Transaction> doWithdrawTransaction(Transaction transaction) {

        int withdrawamount = getInitialBalance() - transaction.getAmount();
        setInitalBalance(withdrawamount);
        return null;
    }


    public List<Transaction> doDepositTransaction(Transaction transaction) {

        int depositAmount = getInitialBalance() + transaction.getAmount();
        setInitalBalance(depositAmount);

        // return false;
        return null;
    }


}



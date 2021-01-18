package ir.dotin;

import ir.dotin.exception.InadequateInitialBalanceException;
import ir.dotin.exception.ViolatedUpperBoundException;

import java.math.BigDecimal;
import java.util.List;

public class TransactionProcessor extends TransactionVO {
    private static List<TransactionProcessor> deposits;

    public static List<TransactionProcessor> getDeposits() {
        return deposits;
    }

    //---------------------------------------------------
//Variable Deposit
    private BigDecimal initialBalance; // موجودی اولیه
    private String depositNumber;
    private depositType depositType;

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitalBalance(BigDecimal initalBalance) {
        this.initialBalance = initalBalance;
    }

    public depositType getDepositType() {
        return depositType;
    }

    public void setDepositType(depositType depositType) {
        this.depositType = depositType;

    }


    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;

    }

    //------------------------------------------------------
    //Deposit
    public List<TransactionVO> doWithdrawTransaction(TransactionVO transactionVO) {

        BigDecimal withdrawamount = getInitialBalance() - transactionVO.getAmount();
        setInitalBalance(withdrawamount);
        return null;
    }

    //-------------------------------------------------------
//Deposit
    public  List<TransactionVO> doDepositTransaction(TransactionVO transactionVO) {

        BigDecimal depositAmount = getInitialBalance() + transactionVO.getAmount();
        setInitalBalance(depositAmount);

        // return false;
        return null;
    }


    //---------------------------------------------
    public static boolean validateWithdraw(TransactionProcessor deposit) {

        return true;
        // return getAmount() <= deposit.getInitialBalance();

    }

    //----------------------------------------------
    public List<TransactionVO> prcessPaymentRecord(List<BalanceVO> depositBalances, List<PaymentVO> paymentVOS)
            throws ViolatedUpperBoundException, InadequateInitialBalanceException {
        List<TransactionProcessor> depositList = TransactionProcessor.getDeposits();

        BigDecimal debtorBalance = BigDecimal.valueOf(0);
        BigDecimal creditorBalance = BigDecimal.valueOf(0);
        for (TransactionProcessor deposit : depositList) {
            if (depositType.DEBTOR.equals(deposit.getDepositType())) {
                debtorBalance = deposit.getInitialBalance();
            } else {
                creditorBalance += deposit.getInitialBalance();
            }

            if (debtorBalance > 0 && debtorBalance < creditorBalance) {
                throw new InadequateInitialBalanceException("Not enough balance!");

            } else
                // return false;

                //  System.out.println("Upper bound balance restriction violated!");  // log4j]
                //   else
                if (validateWithdraw(deposit)) {
                    //      List<TransactionVO> transactionVOS = deposit.doWithdrawTransaction(TransactionVO deposit);
                    //     return transactionVOS;

                } else {
                    throw new ViolatedUpperBoundException("Upper bound balance restriction violated!");
                }

        }


//-----------------------

        return null;
    }
}
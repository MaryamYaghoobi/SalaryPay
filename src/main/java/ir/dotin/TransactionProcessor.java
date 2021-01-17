package ir.dotin;

import ir.dotin.exception.InadequateInitialBalanceException;
import ir.dotin.exception.ViolatedUpperBoundException;

import java.util.List;

public class TransactionProcessor extends Transaction {
    private static List<Deposit> deposits;

    public static List<Deposit> getDeposits() {
        return deposits;
    }

    //public static List<Transaction> prcessPaymentRecord(List<PaymentRecord> paymentRecords, List<PaymentRecord> depositBalances) {
    //}

    //--------------------------------------------------------
   /* public boolean validateDeposit(Deposit deposit) {

      return getAmount() + deposit.getInitialBalance() <= deposit.getUpperBound();
       // return false;
    }*/

    //---------------------------------------------
    public static boolean validateWithdraw(Deposit deposit) {

        return getAmount() <= deposit.getInitialBalance();
        //return false;//TODO
    }

    //----------------------------------------------
    public static List<Transaction> prcessPaymentRecord(List<BalanceRecord> depositBalances, List<PaymentRecord> paymentRecords)
            throws ViolatedUpperBoundException, InadequateInitialBalanceException {
        List<Deposit> depositList = TransactionProcessor.getDeposits();

        int debtorBalance = 0;
        int creditorBalance = 0;
        for (Deposit deposit : depositList) {
            if (depositType.DEBTOR.equals(deposit.getDepositType())) {
                debtorBalance = deposit.getInitialBalance();
            } else {
                creditorBalance += deposit.getInitialBalance();
            }

            if (debtorBalance > 0 && debtorBalance < creditorBalance) {
                throw new InadequateInitialBalanceException("Not enough balance!");
                //    } else if (validateDeposit(deposit)) {
//                List<Transaction> transactions = deposit.doDepositTransaction(this);
//                return transactions;
                //return null;//TODO
            } else
                // return false;

                //  System.out.println("Upper bound balance restriction violated!");  // log4j]
                //   else
                if (validateWithdraw(deposit)) {
                    List<Transaction> transactions = deposit.doWithdrawTransaction((Transaction) deposit);
                    return transactions;

                } else {
                    throw new ViolatedUpperBoundException("Upper bound balance restriction violated!");
                }

        }


//-----------------------
        //prcessPaymentRecord
        return null;
    }
}
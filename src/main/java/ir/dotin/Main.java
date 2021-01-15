package ir.dotin;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            List<PaymentRecord> paymentRecords = PaymentFileHandler.createpaymentFile();
            List<PaymentRecord> depositBalances = BalanceFileHandler.createInitialBalanceFile(paymentRecords);
            List<Transaction> transactions = TransactionProcessor.prcessPaymentRecord(paymentRecords, depositBalances);
            TransactionFileHandler.createTransactionFile(transactions);
            BalanceFileHandler.createFinalBalanceFile(depositBalances);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



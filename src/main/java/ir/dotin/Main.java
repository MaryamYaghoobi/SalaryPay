package ir.dotin;

import java.util.List;

import static ir.dotin.BalanceFileHandler.balanceRecords;


public class Main {
    public static void main(String[] args) {
        try {
            List<PaymentRecord> paymentRecords = PaymentFileHandler.createPaymentFile_New("1.10.100.1", "1.20.100.", 1000);
            List<BalanceRecord> depositBalances = BalanceFileHandler.createInitialBalanceFile(balanceRecords);
            List<Transaction> transactions = TransactionProcessor.prcessPaymentRecord(depositBalances, paymentRecords);
            TransactionFileHandler.createTransactionFile(transactions);
            BalanceFileHandler.createFinalBalanceFile(depositBalances);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



package ir.dotin.files;

import ir.dotin.business.TransactionProcessor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransactionFileHandler extends TransactionProcessor {
    private static final String TRANSACTION_FILE_PATH = "B://Transactions.txt";

    //createTransactionFile
    public static void createTransactionFile(List<TransactionVO> list) throws IOException {


        String debtorDepositNumber = "";
        String resultText = "";
        BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_FILE_PATH));
        for (TransactionProcessor deposit : list) {
            // if ("debtor".equals(deposit.getDepositType()))
            if (doWithdrawTransaction)
                debtorDepositNumber = deposit.getDepositNumber();
            else if (doDepositTransaction)
                deposit.getDepositNumber();
            resultText += debtorDepositNumber + "\t" + deposit.getDepositNumber() + "\t" + deposit.getInitialBalance() + "\n";
        }
        writer.write(resultText);
        writer.newLine();
        writer.close();
    }
}


package ir.dotin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ir.dotin.PaymentFileHandler.generateRandomAmount;

public class BalanceFileHandler {
    private static final String BALANCE_FILE_PATH = "B://Balance.txt";
    static List<BalanceRecord> balanceRecords = new ArrayList<>();
    static String debtorDepositNumber;
    static String creditorDepositNumberPrefix;
/*
    public static void main(String[] args) throws IOException {
        createInitialBalanceFile(balanceRecords);
    }*/

    public static List<BalanceRecord> createInitialBalanceFile(List<BalanceRecord> balanceRecords) throws FileNotFoundException {
        balanceRecords.add(new BalanceRecord(debtorDepositNumber, generateRandomAmount()));
        for (int i = 1; i <= 1000; i++) {
            balanceRecords.add(new BalanceRecord(creditorDepositNumberPrefix, generateRandomAmount()));
        }
        writeBalanceRecordsToFile(balanceRecords);
        return balanceRecords;
    }

    //--------------------------------
    private static void writeBalanceRecordsToFile(List<BalanceRecord> balanceRecords) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(BALANCE_FILE_PATH)) {
            for (BalanceRecord balanceRecord : balanceRecords) {
                printWriter.println(balanceRecord.toString());
            }
            printWriter.close();
        }
    }

    //----------------------------------------
    public static String createFinalBalanceFile(List<BalanceRecord> depositBalances)
            throws IOException {
        String resultFinalBalance = "";

        Path pathBalanceUpdate = Paths.get("B://BalanceUpdate.txt");
        Files.createFile(pathBalanceUpdate);
        writeBalanceRecordsToFile(balanceRecords);
        resultFinalBalance += debtorDepositNumber + "\t" + creditorDepositNumberPrefix + "\t" + depositBalances + "\n";

        return resultFinalBalance;
    }

//----------------------------------------------------------------------------------------
/*

   /* public static List<PaymentRecord> createInitialBalanceFile(List<PaymentRecord> paymentRecords) throws IOException {
        Random random = new Random();
        //   final int depositRandom = random.nextInt(1000);
        final double amountRandom = random.nextInt(1000000 - 100000) + 100000;
        Path pathInvent = Paths.get("B://InventoryFile.txt");
        Files.createFile(pathInvent);
        Deposit deposit = new Deposit();
        List<Deposit> deposits = new ArrayList<>();

        FileOutputStream InventoryFile = new FileOutputStream("B://InventoryFile.txt", true);
        BufferedReader readerInvent = null;

        readerInvent = Files.newBufferedReader(pathInvent, Charset.forName("UTF-8"));


        String currentLine = null;

        currentLine = readerInvent.readLine();

        String[] ingredients = currentLine.split("\t");
        // if (ingredients[1].matches("^[0-9].*$")) {

        deposit.setDepositNumber(String.valueOf(paymentRecords));
        // deposit.setDepositNumber((ingredients[1].trim()));
        deposit.setInitalBalance((int) amountRandom);
        deposits.add(deposit);


        currentLine = readerInvent.readLine();
        return paymentRecords;
    }
    // return deposits;}
    // else{
    //  throw new InadequateInitialBalanceException("Not enough balance!");

    // return paymentRecords;
    //-------------------------------
    public static List<Transaction> createFinalBalanceFile(List<PaymentRecord> depositBalances)
            throws IOException {
        Path pathInventupdate = Paths.get("B://InventoryFileUpdate.txt");
        Files.createFile(pathInventupdate);
        Deposit deposit = new Deposit();
        List<Deposit> deposits = new ArrayList<>();

        FileOutputStream InventoryFile = new FileOutputStream("B://InventoryFileUpdate.txt", true);
        BufferedReader readerInvent = null;

        readerInvent = Files.newBufferedReader(pathInventupdate, Charset.forName("UTF-8"));


        String currentLine = null;
        String resultText = "";

        currentLine = readerInvent.readLine();

        String[] ingredients = currentLine.split("\t");
        // if (ingredients[1].matches("^[0-9].*$")) {

        /*deposit.setDepositNumber(String.valueOf(paymentRecords));
        // deposit.setDepositNumber((ingredients[1].trim()));
        deposit.setInitalBalance((int) depositBalances);*/
      /*  deposits.add(deposit);


        currentLine = readerInvent.readLine();
        // return depositBalances;
        resultText += deposit.getDepositNumber() + "\t" + deposit.getInitialBalance() + "\n";

        return null;
    }
    */


}





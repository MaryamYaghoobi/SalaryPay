package ir.dotin;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BalanceFileHandler {

    public static List<PaymentRecord> createInitialBalanceFile(List<PaymentRecord> paymentRecords) throws IOException {
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
        deposits.add(deposit);


        currentLine = readerInvent.readLine();
        // return depositBalances;
        resultText += deposit.getDepositNumber() + "\t" + deposit.getInitialBalance() + "\n";

        return null;
    }
}










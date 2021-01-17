package ir.dotin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentFileHandler {
    private static final String DEBTOR = "debtor";
    private static final String CREDITOR = "creditor";
    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 10000;
    private static final String PAYMENT_FILE_PATH = "B://Payment.txt";
    private static final Random random = new Random();

    /*  public static void main_(String[] args) throws IOException {
          createPaymentFile_New("1.10.100.1", "1.20.100.", 1000);
      }
  */
    public static List<PaymentRecord> createPaymentFile_New(String debtorDepositNumber, String creditorDepositNumberPrefix, int creditorCount) throws IOException {
        List<PaymentRecord> paymentRecords = new ArrayList<>();
        paymentRecords.add(new PaymentRecord(DEBTOR, debtorDepositNumber, generateRandomAmount()));
        for (int i = 1; i <= creditorCount; i++) {
            paymentRecords.add(new PaymentRecord(CREDITOR, creditorDepositNumberPrefix + i, generateRandomAmount()));

        }
        writePaymentRecordsToFile(paymentRecords);
        return paymentRecords;
    }

    public static int generateRandomAmount() {
        int rand = 0;
        do {
            rand = random.nextInt((MAX_AMOUNT - MIN_AMOUNT) + 1) + MIN_AMOUNT;
        } while (rand % 100 != 0);
        return rand;
    }


    private static void writePaymentRecordsToFile(List<PaymentRecord> paymentRecords) throws IOException {
      //  PrintWriter printWriter = new PrintWriter(PAYMENT_FILE_PATH);
        FileWriter fileWriter=new FileWriter(PAYMENT_FILE_PATH,true);
        for (PaymentRecord paymentRecord : paymentRecords) {
          //  printWriter.println(paymentRecord.toString());
            fileWriter.write(paymentRecord.toString());
        }

      //  printWriter.close();
        fileWriter.close();
    }


    //<editor-fold desc="Old Code">
 /*   static Path path = Paths.get("B://PaymentFile.txt");

    public static List<PaymentRecord> createpaymentFile() throws NumberFormatException, IOException, FileNotFoundException {
        Random random = new Random();
        final int depositRandom = random.nextInt(1000);
        final double amountRandom = random.nextInt(1000000 - 100000) + 100000;
        Files.createFile(path);
        FileOutputStream PaymentFile;

        PaymentFile = new FileOutputStream("B://PaymentFile.txt", true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(PaymentFile));
        int debtor = Integer.parseInt("debtor 1.10.1001.1" + "  " + amountRandom);
        bw.write(debtor);
        bw.newLine();
        for (int i = 1; i <= 1000; i++) {
            int creditor = Integer.parseInt("creditor  1.20.100." + depositRandom + " " + amountRandom);
            bw.write(creditor);
            bw.newLine();
        }

        bw.close();

        //   return null;


        return null;
    }*/
    //</editor-fold>
}
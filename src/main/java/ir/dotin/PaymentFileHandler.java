package ir.dotin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ir.dotin.depositType.CREDITOR;
import static ir.dotin.depositType.DEBTOR;

public class PaymentFileHandler {
    // private static final String DEBTOR = "debtor";
    // private static final String CREDITOR = "creditor";
    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 10000;
    private static final String PAYMENT_FILE_PATH = "B://Payment.txt";
    private static final Random random = new Random();

    public static List<PaymentVO> createPaymentFile_New(String debtorDepositNumber, String creditorDepositNumberPrefix, int creditorCount) throws IOException {
        List<PaymentVO> paymentVOs = new ArrayList<>();
        paymentVOs.add(new PaymentVO(DEBTOR, debtorDepositNumber, generateRandomAmount()));
        for (int i = 1; i <= creditorCount; i++) {
            paymentVOs.add(new PaymentVO(CREDITOR, creditorDepositNumberPrefix + i, generateRandomAmount()));

        }
        writePaymentRecordsToFile(paymentVOs);
        // read and output
        FileReader payReader = new FileReader(PAYMENT_FILE_PATH);
        BufferedReader pr = new BufferedReader(payReader);
        String s;
        while ((s = pr.readLine()) != null) {
            System.out.println(s);
        }
        payReader.close();
        return paymentVOs;

    }


    public static BigDecimal generateRandomAmount() {
        BigDecimal rand = BigDecimal.valueOf(0);

        rand = BigDecimal.valueOf(random.nextInt((MAX_AMOUNT - MIN_AMOUNT) + 1) + MIN_AMOUNT);
        return rand;
    }


    private static void writePaymentRecordsToFile(List<PaymentVO> paymentVOs) throws IOException {
        //  PrintWriter printWriter = new PrintWriter(PAYMENT_FILE_PATH);
        FileWriter fileWriter = new FileWriter(PAYMENT_FILE_PATH, true);
        for (PaymentVO paymentVO : paymentVOs) {
            //  printWriter.println(paymentRecord.toString());
            fileWriter.write(paymentVO.toString());
        }

        //  printWriter.close();
        fileWriter.close();
    }


}
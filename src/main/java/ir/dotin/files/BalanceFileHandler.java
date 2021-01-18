package ir.dotin.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ir.dotin.files.PaymentFileHandler.generateRandomAmount;

public class BalanceFileHandler {
    private static final String BALANCE_FILE_PATH = "B://Balance.txt";
    static List<BalanceVO> balanceVOs = new ArrayList<>();
    static String debtorDepositNumber;
    static String creditorDepositNumberPrefix;


    public static List<BalanceVO> createInitialBalanceFile(List<BalanceVO> balanceVOs) throws IOException {
        balanceVOs.add(new BalanceVO(debtorDepositNumber, generateRandomAmount()));
        for (int i = 1; i <= 1000; i++) {
            balanceVOs.add(new BalanceVO(creditorDepositNumberPrefix, generateRandomAmount()));
        }
        writeBalanceRecordsToFile(balanceVOs);
        // read and output
        FileReader balanceReader = new FileReader(BALANCE_FILE_PATH);
        BufferedReader br = new BufferedReader(balanceReader);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        balanceReader.close();

        return balanceVOs;
    }

    //--------------------------------
    private static void writeBalanceRecordsToFile(List<BalanceVO> balanceVOs) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(BALANCE_FILE_PATH)) {
            for (BalanceVO balanceVO : balanceVOs) {
                printWriter.println(balanceVO.toString());
            }
            // printWriter.close();
        }
    }

    //----------------------------------------
    public static String createFinalBalanceFile(List<BalanceVO> depositBalances)
            throws IOException {
        String resultFinalBalance = "";

        Path pathBalanceUpdate = Paths.get("B://BalanceUpdate.txt");
        Files.createFile(pathBalanceUpdate);
        writeBalanceRecordsToFile(balanceVOs);
        resultFinalBalance += debtorDepositNumber + "\t" + creditorDepositNumberPrefix + "\t" + depositBalances + "\n";

        return resultFinalBalance;
    }

//----------------------------------------------------------------------------------------


}





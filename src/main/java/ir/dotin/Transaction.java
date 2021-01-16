package ir.dotin;

public class Transaction extends Deposit {
    private String transactionType;
    private static int amount;

    public String getTransactionType() {
        return transactionType;
    }

    public Transaction setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public static int getAmount() {
        return amount;
    }

    public Transaction setAmount(int amount) {
        this.amount = amount;
        return this;
    }


    @Override
    public String toString() {
        return "{ transactionType:" + transactionType +
                ",amount:" + amount +
                "}";
    }
}

/*

    public boolean validateDeposit(Deposit deposit) {

        return getAmount() + deposit.getInitialBalance() <= deposit.getUpperBound();
    }
*/

/*
    public boolean validateWithdraw(Deposit deposit) {

        return getAmount() <= deposit.getInitialBalance();
    }*/

    //===================================================
//isValidAmount(List<Transaction> list )
   /* private boolean isValidAmount(List<Deposit> list) throws ViolatedUpperBoundException, InadequateInitialBalanceException {
        List<Deposit> depositList = ioInfo.getDeposits();

        int debtorBalance = 0;
        int creditorBalance = 0;
        for (Deposit deposit : depositList) {

            if (depositType.DEBTOR.equals(deposit.getDepositType())) {
                debtorBalance = deposit.getInitialBalance();
            } else {
                creditorBalance += deposit.getInitialBalance();
            }
//-------------
            if (debtorBalance > 0 && debtorBalance < creditorBalance){
                throw new InadequateInitialBalanceException("Not enough balance!");
            }
            else if (validateDeposit(deposit)) {
                return deposit.doDepositTransaction(this);
            } else
                // return false;

              //  System.out.println("Upper bound balance restriction violated!");  // log4j]
//-----------------
      //   else
             if (validateWithdraw(deposit)) {
                return deposit.doWithdrawTransaction(this);
            } else {
                 throw new ViolatedUpperBoundException("Upper bound balance restriction violated!");
             }
              //  System.out.println("Not enough balance!");  // log4j]

            }
        return false;
    }
*/
       // return false;


    //=================================================
// فایل تراکنش

  /*  private static void createTransactionFile(List<Deposit> list) throws IOException {


        String debtorDepositNumber = "";
        String resultText = "";
        BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"));
        for (Deposit deposit : list) {
            if ("debtor".equals(deposit.getDepositType()))
                debtorDepositNumber = deposit.getDepositNumber();
            else
                resultText += debtorDepositNumber + "\t" + deposit.getDepositNumber() + "\t" + deposit.getInitialBalance() + "\n";
        }
        writer.write(resultText);
        writer.newLine();
        writer.close();
    }
}*/
//===================================================


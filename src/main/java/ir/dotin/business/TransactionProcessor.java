package ir.dotin.business;

import ir.dotin.exception.InadequateInitialBalanceException;
import ir.dotin.files.BalanceVO;
import ir.dotin.files.PaymentVO;
import ir.dotin.files.TransactionVO;

import java.math.BigDecimal;
import java.util.List;

public class TransactionProcessor {

   /* private static List<TransactionProcessor> deposits;

    public static List<TransactionProcessor> getDeposits() {
        return deposits;
    }*/

    //---------------------------------------------------
//Variable Deposit
    private BigDecimal initialBalance; // موجودی اولیه
    private String depositNumber;
    private static ir.dotin.business.depositType depositType;

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public  void setInitalBalance(BigDecimal initalBalance) {
        this.initialBalance = initalBalance;
    }

    public depositType getDepositType() {
        return depositType;
    }

    public void setDepositType(depositType depositType) {
        this.depositType = depositType;

    }


    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;

    }

    //------------------------------------------------------

    //Deposit
   // public List<TransactionVO> doWithdrawTransaction(TransactionVO transactionVO) {
    private static void doWithdrawTransaction() {
        PaymentVO pay = new PaymentVO();
        int withdrawamount = getInitialBalance() - pay.getAmount();
        return  setInitalBalance(BigDecimal.valueOf(withdrawamount));
       // return null;



    }
//======================================

    //Deposit
   // public List<TransactionVO> doDepositTransaction(TransactionVO transactionVO) {
    private static BigDecimal doDepositTransaction() {
        PaymentVO pay = new PaymentVO();
        BigDecimal depositAmount = getInitialBalance() + pay.getAmount();
        return  setInitalBalance(depositAmount);

        // return false;

    }


    //---------------------------------------------
    public static boolean validateWithdraw(TransactionProcessor deposit) {


        // return getAmount() <= deposit.getInitialBalance();
        PaymentVO pay = new PaymentVO();
         BigDecimal f = pay.getAmount();
        BigDecimal s =  deposit.getInitialBalance();

        if (f <= s)
        return true;
        else
        return false;
    }

    //----------------------------------------------
    public static List<TransactionVO> prcessPaymentRecord(List<BalanceVO> depositBalances, List<PaymentVO> paymentVOS)
            throws  InadequateInitialBalanceException {
        //  List<TransactionProcessor> depositList = TransactionProcessor.getDeposits();

        BigDecimal debtorBalance = BigDecimal.valueOf(0);
        BigDecimal creditorBalance = BigDecimal.valueOf(0);
        //   for (TransactionProcessor deposit : depositList) {
        for (PaymentVO paymentVO : paymentVOS) {
            if (!validateWithdraw(paymentVO)) {
                throw new InadequateInitialBalanceException("Not enough balance!");
            } else
                // if (depositType.DEBTOR.equals(deposit.getDepositType())) {
                if (depositType.DEBTOR.equals(paymentVO.getType())) {
                    // debtorBalance = deposit.getInitialBalance();
                    //debtorBalance = paymentVO.getAmount();
                   debtorBalance= doWithdrawTransaction();
                } else {
                    //  creditorBalance += deposit.getInitialBalance();
                  //  creditorBalance += paymentVO.getAmount();
                    creditorBalance=doDepositTransaction();
                }
           /* if (debtorBalance > 0 && debtorBalance < creditorBalance) {
                throw new InadequateInitialBalanceException("Not enough balance!");*/
            }

            //      List<TransactionVO> transactionVOS = deposit.doWithdrawTransaction(TransactionVO deposit);
            //     return transactionVOS;

        return null;
    }

    }






//-----------------------




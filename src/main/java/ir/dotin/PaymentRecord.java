package ir.dotin;

public class PaymentRecord {
    String type;
    String depositNumber;
    Integer amount;

    public PaymentRecord(String type, String depositNumber, Integer amount) {
        this.type = type;
        this.depositNumber = depositNumber;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + "\t" + depositNumber + "\t" + amount;
    }

    //<editor-fold desc="Old Code">
    /*public static List<Deposit> readDepositsFromFile() throws IOException, URISyntaxException {

        //   Logger logger = Logger.getLogger("IoInfoLog");
        List<Deposit> deposits = new ArrayList<>();
        Deposit deposit = new Deposit();
        BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] ingredients = currentLine.split("\t");
            if (ingredients[1].matches("^[0-9].*$")) {

                deposit.setDepositType(ingredients[0].trim());
                deposit.setDepositNumber((ingredients[1].trim()));
                deposit.setInitalBalance(Integer.parseInt(ingredients[2].trim()));
                deposits.add(deposit);
            }
            currentLine = reader.readLine();
       // }


        }
        return deposits;
    }*/
    //</editor-fold>
}

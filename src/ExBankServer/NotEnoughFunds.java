package ExBankServer;

class NotEnoughFunds extends Exception {
    public NotEnoughFunds() {
    }

    public String getErrorMsg(int id) {
        return "Error, not enough funds in account (ID = " + id + ").\n";
    }
}

package ExBankServer;

class InvalidAccount extends Exception {
    private int id;

    public InvalidAccount() {
        System.out.println("Error, invalid account.");
    }

    public InvalidAccount(int id) {
        this.id = id;
    }

    public String getErrorMsg(int id) {
        return "Error, account with ID = " + id + " does'nt exist or is closed.\n";
    }
}

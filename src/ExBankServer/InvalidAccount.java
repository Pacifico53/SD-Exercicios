package ExBankServer;

class InvalidAccount extends Exception {

    public InvalidAccount() {
        System.out.println("Error, invalid account.");
    }

    public InvalidAccount(int id) {
        System.out.println("Error, account with id = " + id + " does'nt exist or is closed.");
    }
}

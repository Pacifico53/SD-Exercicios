package Ex4_BancoLocks;

class InvalidAccount extends Exception {

    public InvalidAccount() {
        System.out.println("Error, invalid account.");
    }

    public InvalidAccount(int id) {
        System.out.println("Error, account with id = " + id + "doesnt exist or is closed.");
    }
}

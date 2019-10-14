package Ex4_BancoLocks;

class InvalidAccount extends Exception {
    public InvalidAccount() {
        System.out.println("Error, invalid account.");
    }
}

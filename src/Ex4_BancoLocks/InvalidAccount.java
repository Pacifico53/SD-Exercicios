package Ex4_BancoLocks;

public class InvalidAccount extends Exception {
    public InvalidAccount() {
        System.out.println("Error, invalid account.");
    }
}

package Ex4_BancoLocks;

public class NotEnoughFunds extends Exception {
    public NotEnoughFunds() {
        System.out.println("Error not enough funds.");
    }
}

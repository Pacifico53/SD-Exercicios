package ExBankServer;

class NotEnoughFunds extends Exception {
    public NotEnoughFunds() {
        System.out.println("Error not enough funds.");
    }
}

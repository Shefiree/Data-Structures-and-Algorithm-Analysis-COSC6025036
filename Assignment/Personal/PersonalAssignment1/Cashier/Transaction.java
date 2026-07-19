package Assignment.Personal.PersonalAssignment1.Cashier;

public class Transaction {
    String id;
    String noAntrian;
    String namaCustomer;
    double totalBelanja;

    public Transaction() {
    }

    public Transaction(int noAntrian, String namaCustomer, double totalBelanja) {
        this.id = "[TRX-" + String.format("%03d", noAntrian) + "]";
        this.noAntrian = "[AA-" + String.format("%03d", noAntrian) + "]";
        this.namaCustomer = namaCustomer;
        this.totalBelanja = totalBelanja;
    }

    @Override
    public String toString() {
        return noAntrian + " | " + namaCustomer + " | " + totalBelanja;
    }
}
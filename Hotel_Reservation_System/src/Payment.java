
public class Payment {

    private Reservation reservation;
    private PaymentStatus status;
    private double amount;

    public Payment(Reservation reservation, PaymentStatus status, double amount) {
        this.reservation = reservation;
        this.status = status;
        this.amount = amount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
}

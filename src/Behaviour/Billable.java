package Behaviour;

public interface Billable {
    void calculateCharges();
    void generateBill();
    void processPayment(double amount);
}
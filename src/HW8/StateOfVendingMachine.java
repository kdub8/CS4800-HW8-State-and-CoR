package HW8;

public interface StateOfVendingMachine {
    void snackOptionPressed(VendingMachine vendingMachine, String snackName);
    void moneyInserted(VendingMachine vendingMachine, Double money);
    void dispenseSnack(VendingMachine vendingMachine);
    void processRefund(VendingMachine vendingMachine);
}
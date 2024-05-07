package HW8;
/**
 * Interface representing the different states of a vending machine.
 */
public interface StateOfVendingMachine {
    /**
     * Handles the event of a snack option being pressed.
     *
     * @param vendingMachine The vending machine.
     * @param snackName      The name of the snack.
     */
    void snackOptionPressed(VendingMachine vendingMachine, String snackName);
    /**
     * Handles the event of money being inserted.
     *
     * @param vendingMachine The vending machine.
     * @param money           The amount of money inserted.
     */
    void moneyInserted(VendingMachine vendingMachine, Double money);
    /**
     * Handles the event of dispensing a snack.
     *
     * @param vendingMachine The vending machine.
     */
    void dispenseSnack(VendingMachine vendingMachine);
    /**
     * Handles the event of a refund being requested.
     *
     * @param vendingMachine The vending machine.
     */
    void processRefund(VendingMachine vendingMachine);
}
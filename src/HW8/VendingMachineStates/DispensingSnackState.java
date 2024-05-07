package HW8.VendingMachineStates;
import HW8.StateOfVendingMachine;
import HW8.VendingMachine;
import HW8.Snack;

/**
 * The state representing the vending machine when a snack is being dispensed.
 */
public class DispensingSnackState implements StateOfVendingMachine {

    /**
     * {@inheritDoc}
     * In this state, selecting a snack is not allowed.
     */
    @Override
    public void snackOptionPressed(VendingMachine vendingMachine, String snackName) {
        System.out.println("Cannot select snack during dispensation");
    }
    /**
     * {@inheritDoc}
     * In this state, inserting more money than required is not allowed.
     */
    @Override
    public void moneyInserted(VendingMachine vendingMachine, Double money) {
        System.out.println("Cannot insert more money than required.");
    }
    /**
     * {@inheritDoc}
     * Dispenses the selected snack if available and updates the vending machine's state.
     */
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        Snack snackOption = vendingMachine.getSnackOptionChosen();

        boolean success = vendingMachine.getSnackDispenser().dispenseSnack(snackOption);
        double snackPrice = snackOption.getPrice();
        double moneyInserted = vendingMachine.getMoneyInserted();

        if (success){
            // Increment the total money earned by the vending machine
            vendingMachine.setMoneyEarned(vendingMachine.getMoneyEarned() + snackPrice);
            // Deduct the price of the snack from the total money inserted
            vendingMachine.setMoneyInserted(moneyInserted - snackPrice);
        }
        // Transition to the idle state after dispensing the snack
        vendingMachine.setState(new IdleState());
    }
    /**
     * {@inheritDoc}
     * Refunding is not possible while a snack is being dispensed.
     */
    @Override
    public void processRefund(VendingMachine vendingMachine) {
        System.out.println("Cannot issue refund. Snack is being dispensed...");
    }

}
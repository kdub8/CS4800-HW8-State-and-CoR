package HW8.ThreeVendingMachineStates;

import HW8.StateOfVendingMachine;
import HW8.VendingMachine;
/**
 * Represents the state of the vending machine when it is idle, waiting for user input.
 */
public class IdleState implements StateOfVendingMachine {

    /**
     * {@inheritDoc}
     * Checks if the selected snack option is valid. If valid, sets the vending machine's state
     * to WaitingForMoneyState and sets the selected snack option.
     */
    @Override
    public void snackOptionPressed(VendingMachine vendingMachine, String snackName) {
        // Check to see if snackName is valid.
        if (vendingMachine.isValidSnackOption(snackName)){
            vendingMachine.setState(new WaitingForMoneyState());
            vendingMachine.setSnackOptionChosen(vendingMachine.getSnack(snackName));
            System.out.println(vendingMachine.getSnackOptionChosen().getName() + " chosen.");
        } else {
            System.out.println(snackName + " is not a valid option!");
        }
    }
    /**
     * {@inheritDoc}
     * Prints a message indicating that a snack option must be selected before inserting money.
     */
    @Override
    public void moneyInserted(VendingMachine vendingMachine, Double money) {
        System.out.println("Please select a valid snack option before inserting money");
    }
    /**
     * {@inheritDoc}
     * Prints a message indicating that a snack and money must be selected before dispensing.
     */
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense snack before selecting snack and inserting money.");
    }
    /**
     * {@inheritDoc}
     * Empty implementation as refund is not applicable in the idle state.
     */
    @Override
    public void processRefund(VendingMachine vendingMachine) {
    }
}
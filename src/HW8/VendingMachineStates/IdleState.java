package HW8.VendingMachineStates;

import HW8.StateOfVendingMachine;
import HW8.VendingMachine;
public class IdleState implements StateOfVendingMachine {


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

    @Override
    public void moneyInserted(VendingMachine vendingMachine, Double money) {
        System.out.println("Please select a valid snack option before inserting money");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense snack before selecting snack and inserting money.");
    }

    @Override
    public void processRefund(VendingMachine vendingMachine) {
    }
}
package HW8.VendingMachineStates;

import HW8.StateOfVendingMachine;
import HW8.VendingMachine;
public class WaitingForMoneyState implements StateOfVendingMachine {

    @Override
    public void snackOptionPressed(VendingMachine vendingMachine, String snackName) {
        // This if customer changes their mind of what they want
        // Check to see if snackName is valid.
        if (vendingMachine.isValidSnackOption(snackName)){
            vendingMachine.setState(new WaitingForMoneyState());
            vendingMachine.setSnackOptionChosen(vendingMachine.getSnack(snackName));
        } else {
            System.out.println(snackName + " is not a valid option!");
        }
    }

    @Override
    public void moneyInserted(VendingMachine vendingMachine, Double money) {
        vendingMachine.setMoneyInserted(vendingMachine.getMoneyInserted() + money);
        Double moneyInserted = vendingMachine.getMoneyInserted();
        Double snackPrice = vendingMachine.getSnackOptionChosen().getPrice();
        System.out.println("Inserted Total: $" + moneyInserted);
        if (moneyInserted >= snackPrice){
            vendingMachine.setState(new DispensingSnackState());
            System.out.println("Required amount of $" +vendingMachine.getSnackOptionChosen().getPrice() + " fulfilled. Vending Machine is now ready to dispense.");
        } else {
            System.out.println("Not enough money inserted. Price for " + vendingMachine.getSnackOptionChosen().getName() +" is: $" + snackPrice);
        }
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense, not enough money! Money inserted: $" + vendingMachine.getMoneyInserted() +
                " Price for " + vendingMachine.getSnackOptionChosen().getName() + " is: $" + vendingMachine.getSnackOptionChosen().getPrice());
    }

    @Override
    public void processRefund(VendingMachine vendingMachine) {
        // Resets selection and keeps money in moneyInserted
        System.out.println("Snack option has been deselected, please collect your refund at the change dispenser.");
        vendingMachine.setState(new IdleState());
    }
}
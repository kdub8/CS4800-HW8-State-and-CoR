package HW8.VendingMachineStates;
import HW8.StateOfVendingMachine;
import HW8.VendingMachine;
import HW8.Snack;
public class DispensingSnackState implements StateOfVendingMachine {


    @Override
    public void snackOptionPressed(VendingMachine vendingMachine, String snackName) {
        System.out.println("Cannot select snack during dispensation");
    }

    @Override
    public void moneyInserted(VendingMachine vendingMachine, Double money) {
        System.out.println("Cannot insert more money than required.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        Snack snackOption = vendingMachine.getSnackOptionChosen();

        boolean success = vendingMachine.getSnackDispenser().dispenseSnack(snackOption);
        double snackPrice = snackOption.getPrice();
        double moneyInserted = vendingMachine.getMoneyInserted();

        if (success){
            vendingMachine.setMoneyEarned(vendingMachine.getMoneyEarned() + snackPrice);
            vendingMachine.setMoneyInserted(moneyInserted - snackPrice);
            // Change is still in moneyInserted
        } else {
            // Money is still in moneyInserted.
        }
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void processRefund(VendingMachine vendingMachine) {
        System.out.println("Cannot issue refund. Snack is being dispensed...");
    }

}
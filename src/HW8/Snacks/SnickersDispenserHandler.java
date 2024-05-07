package HW8.Snacks;

import HW8.Snack;
import HW8.SnackDispenseHandler;
public class SnickersDispenserHandler extends SnackDispenseHandler {

    public SnickersDispenserHandler(SnackDispenseHandler next) {
        super(next);
    }

    // Returns true if successful
    public boolean dispense(Snack snack){
        System.out.println("Vending Machine Mechanical Arm Moving to Snickers...");
        if (snack.getName().equals("Snickers") ){
            System.out.println("Please wait...Dispensing Snickers...");
            if (snack.getQuantity() > 0){
                System.out.println("Successfully dispensed Snickers.");
                snack.setQuantity(snack.getQuantity() - 1);
                return true;
            } else {
                System.out.println("Sorry, Vending Machine Out of Snickers. Your money will be returned soon...");
                return false;
            }
        } else {
            return super.dispense(snack);
        }
    }
}
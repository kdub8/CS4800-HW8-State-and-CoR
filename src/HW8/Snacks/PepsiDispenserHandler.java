package HW8.Snacks;
import HW8.Snack;
import HW8.SnackDispenseHandler;
public class PepsiDispenserHandler extends SnackDispenseHandler {
    public PepsiDispenserHandler(SnackDispenseHandler next) {
        super(next);
    }

    // Returns true if successful
    public boolean dispense(Snack snack){
        System.out.println("Vending Machine Mechanical Arm Moving to Pepsi...");
        if (snack.getName().equals("Pepsi")){
            System.out.println("Please wait...Dispensing Pepsi...");
            if (snack.getQuantity() > 0){
                System.out.println("Successfully dispensed Pepsi.");
                snack.setQuantity(snack.getQuantity() - 1);
                return true;
            } else {
                System.out.println("Sorry, Vending Machine Out of Pepsi. Your money will be returned soon...");
                return false;
            }
        } else {
            return super.dispense(snack);
        }
    }
}
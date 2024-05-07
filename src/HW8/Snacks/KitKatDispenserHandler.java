package HW8.Snacks;
import HW8.Snack;
import HW8.SnackDispenseHandler;
public class KitKatDispenserHandler extends SnackDispenseHandler {
    public KitKatDispenserHandler(SnackDispenseHandler next) {
        super(next);
    }

    // Returns true if successful
    public boolean dispense(Snack snack){
        System.out.println("Vending Machine Mechanical Arm Moving to KitKat...");
        if (snack.getName().equals("KitKat")){
            System.out.println("Please wait...Dispensing KitKat...");
            if (snack.getQuantity() > 0){
                System.out.println("Successfully dispensed KitKat.");
                snack.setQuantity(snack.getQuantity() - 1);
                return true;
            } else {
                System.out.println("Sorry, Vending Machine Out of KitKat. Your money will be returned soon...");
                return false;
            }
        } else {
            return super.dispense(snack);
        }
    }
}
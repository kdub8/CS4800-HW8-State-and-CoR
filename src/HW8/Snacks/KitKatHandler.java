package HW8.Snacks;
import HW8.Snack;
import HW8.SnackDispenseHandler;

/**
 * The type Kit kat dispenser handler.
 */
public class KitKatHandler extends SnackDispenseHandler {
    /**
     * Instantiates a new Kit kat dispenser handler.
     *
     * @param next the next
     */
    public KitKatHandler(SnackDispenseHandler next) {
        super(next);
    }


    /**
     * Dispenses the specified snack.
     *
     * @param snack the snack to dispense
     * @return true if the snack was successfully dispensed, false otherwise
     */
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
            // Pass the request to the next dispenser handler in the chain
            return super.dispense(snack);
        }
    }
}
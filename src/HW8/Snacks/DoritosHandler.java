package HW8.Snacks;
import HW8.Snack;
import HW8.SnackDispenseHandler;

/**
 * The type Doritos dispenser handler.
 */
public class DoritosHandler extends SnackDispenseHandler {
    /**
     * Instantiates a new Doritos dispenser handler.
     *
     * @param next the next dispenser handler in the chain
     */
    public DoritosHandler(SnackDispenseHandler next) {
        super(next);
    }

    /**
     * Dispenses the specified snack.
     *
     * @param snack the snack to dispense
     * @return true if the snack was successfully dispensed, false otherwise
     */
    public boolean dispense(Snack snack){
        System.out.println("Vending Machine Mechanical Arm Moving to Doritos...");
        if (snack.getName().equals("Doritos")){
            System.out.println("Please wait...Dispensing Doritos...");
            if (snack.getQuantity() > 0){
                System.out.println("Successfully dispensed Doritos.");
                snack.setQuantity(snack.getQuantity() - 1);
                return true;
            } else {
                System.out.println("Sorry, Vending Machine Out of Doritos. Your money will be returned soon...");
                return false;
            }
        } else {
            // Pass the request to the next dispenser handler in the chain
            return super.dispense(snack);
        }
    }
}
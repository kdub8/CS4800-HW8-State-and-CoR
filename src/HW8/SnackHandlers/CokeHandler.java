package HW8.SnackHandlers;
import HW8.Snack;
import HW8.SnackDispenseHandler;

/**
 * The type Coke dispenser handler.
 */
public class CokeHandler extends SnackDispenseHandler {

    /**
     * Instantiates a new Coke dispenser handler.
     *
     * @param next the next dispenser handler in the chain
     */
    public CokeHandler(SnackDispenseHandler next) {
        super(next);
    }

    /**
     * Dispenses the specified snack.
     *
     * @param snack the snack to dispense
     * @return true if the snack was successfully dispensed, false otherwise
     */
    public boolean dispense(Snack snack){
        System.out.println("Vending Machine Mechanical Arm Moving to Coke...");
        if (snack.getName().equals("Coke")){
            System.out.println("Please wait...Dispensing Coke...");
            if (snack.getQuantity() > 0){
                System.out.println("Successfully dispensed Coke.");
                snack.setQuantity(snack.getQuantity() - 1);
                return true;
            } else {
                System.out.println("Sorry, Vending Machine Out of Coke. Your money will be returned soon...");
                return false;
            }
        } else {
            // Pass the request to the next dispenser handler in the chain
            return super.dispense(snack);
        }
    }
}
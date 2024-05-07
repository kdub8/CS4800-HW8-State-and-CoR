package HW8.SnackHandlers;
import HW8.Snack;
import HW8.SnackDispenseHandler;

/**
 * The type Cheetos dispenser handler.
 */
public class CheetosHandler extends SnackDispenseHandler {
    /**
     * Instantiates a new Cheetos dispenser handler.
     *
     * @param next the next dispenser handler in the chain
     */
    public CheetosHandler(SnackDispenseHandler next) {
        super(next);
    }

    /**
     * Dispenses the specified snack.
     *
     * @param snack the snack to dispense
     * @return true if the snack was successfully dispensed, false otherwise
     */
    public boolean dispense(Snack snack){
        System.out.println("Vending Machine Mechanical Arm Moving to Cheetos...");
        if (snack.getName().equals("Cheetos")){
            System.out.println("Please wait...Dispensing Cheetos...");
            if (snack.getQuantity() > 0){
                System.out.println("Successfully dispensed Cheetos.");
                snack.setQuantity(snack.getQuantity() - 1);
                return true;
            } else {
                System.out.println("Sorry, Vending Machine Out of Cheetos. Your money will be returned soon...");
                return false;
            }
        } else {
            // Pass the request to the next dispenser handler in the chain

            return super.dispense(snack);
        }
    }
}
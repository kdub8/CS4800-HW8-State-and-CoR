package HW8;
/**
 * Abstract class representing a handler for dispensing snacks in a vending machine.
 */
public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack;
    /**
     * Constructs a new snack dispenser handler with the next handler in the chain.
     *
     * @param next The next handler in the chain.
     */
    public SnackDispenseHandler(SnackDispenseHandler next){
        this.next = next;
    }

    /**
     * Dispenses the specified snack, delegating to the next handler if necessary.
     *
     * @param snack The snack to dispense.
     * @return True if the snack was successfully dispensed, false otherwise.
     */
    public boolean dispense(Snack snack){
        if (next != null){
            return next.dispense(snack);
        }
        return false;
    }
}
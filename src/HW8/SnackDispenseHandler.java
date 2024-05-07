package HW8;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack;

    public SnackDispenseHandler(SnackDispenseHandler next){
        this.next = next;
    }

    // Returns true if successful
    public boolean dispense(Snack snack){
        if (next != null){
            return next.dispense(snack);
        }
        return false;
    }
}
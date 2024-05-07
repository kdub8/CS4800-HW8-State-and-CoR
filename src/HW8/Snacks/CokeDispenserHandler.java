package HW8.Snacks;
import HW8.Snack;
import HW8.SnackDispenseHandler;
public class CokeDispenserHandler extends SnackDispenseHandler {

    public CokeDispenserHandler(SnackDispenseHandler next) {
        super(next);
    }

    // Returns true if successful
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
            return super.dispense(snack);
        }
    }
}
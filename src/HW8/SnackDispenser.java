package HW8;

import HW8.SnackHandlers.*;
/**
 * Class representing a snack dispenser in a vending machine.
 */
public class SnackDispenser {

    private SnackDispenseHandler chainOfResponsibility =
            new CokeHandler(
                    new PepsiHandler(
                            new CheetosHandler(
                                    new DoritosHandler(
                                            new KitKatHandler(
                                                    new SnickersHandler(
                                                            null))))));
    /**
     * Dispenses the specified snack using the chain of responsibility.
     *
     * @param snack The snack to dispense.
     * @return True if the snack was successfully dispensed, false otherwise.
     */
    public boolean dispenseSnack(Snack snack){
        return chainOfResponsibility.dispense(snack);
    }
}
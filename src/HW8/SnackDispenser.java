package HW8;

import HW8.Snacks.*;
/**
 * Class representing a snack dispenser in a vending machine.
 */
public class SnackDispenser {

    private SnackDispenseHandler chainOfResponsibility =
            new CokeDispenserHandler(
                    new PepsiDispenserHandler(
                            new CheetosDispenserHandler(
                                    new DoritosDispenserHandler(
                                            new KitKatDispenserHandler(
                                                    new SnickersDispenserHandler(
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
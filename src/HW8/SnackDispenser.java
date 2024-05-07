package HW8;

import HW8.Snacks.*;

public class SnackDispenser {

    private SnackDispenseHandler chainOfResponsibility =
            new CokeDispenserHandler(
                    new PepsiDispenserHandler(
                            new CheetosDispenserHandler(
                                    new DoritosDispenserHandler(
                                            new KitKatDispenserHandler(
                                                    new SnickersDispenserHandler(
                                                            null))))));
    public boolean dispenseSnack(Snack snack){
        return chainOfResponsibility.dispense(snack);
    }
}
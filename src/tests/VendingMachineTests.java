package tests;

import HW8.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTests {
    private VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testInsertMoney() {
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(5.0);
        assertEquals(5.0, vendingMachine.getMoneyInserted(), 0.001);
    }

    @Test
    public void testSelectSnack() {
        vendingMachine.selectSnack("Snickers");
        assertEquals("Snickers", vendingMachine.getSnackOptionChosen().getName());
    }

    @Test
    public void testRetrieveChange() {
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(5.0);
        vendingMachine.dispenseSnack();
        double change = vendingMachine.retrieveChange();
        assertEquals(5.0 - 1.50, change, 0.001);

        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(10.0);
        vendingMachine.dispenseSnack();
        double change_2 = vendingMachine.retrieveChange();
        assertEquals(10.0 - 3.25, change_2, 0.001);
    }

    @Test
    public void testMoneyEarned() {
        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(5.0);
        vendingMachine.dispenseSnack();
        assertEquals(5.0 - vendingMachine.retrieveChange(), vendingMachine.getMoneyEarned());
    }

    @Test
    public void testGetSnackPrice () {
        assertEquals(2.25, vendingMachine.getSnackPrice("Cheetos"));
    }

    @Test
    public void testIsValidSnack() {
        assertEquals(true, vendingMachine.isValidSnackOption("Coke"));
        assertEquals(true, vendingMachine.isValidSnackOption("Cheetos"));
        assertEquals(true, vendingMachine.isValidSnackOption("Doritos"));
        assertEquals(true, vendingMachine.isValidSnackOption("Pepsi"));
        assertEquals(true, vendingMachine.isValidSnackOption("KitKat"));
        assertEquals(true, vendingMachine.isValidSnackOption("Snickers"));
        assertEquals(false, vendingMachine.isValidSnackOption("Funyuns"));
        assertEquals(false, vendingMachine.isValidSnackOption("Cookies"));
    }



}

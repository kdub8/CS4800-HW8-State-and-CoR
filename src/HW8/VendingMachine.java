package HW8;

import HW8.ThreeVendingMachineStates.IdleState;

import java.util.HashMap;
/**
 * Represents a vending machine that dispenses snacks.
 */
public class VendingMachine {

    private StateOfVendingMachine stateOfVendingMachine = new IdleState();
    private SnackDispenser snackDispenser = new SnackDispenser();
    private Snack snackOptionChosen;
    private Double moneyInserted = 0.0;
    private Double moneyEarned = 0.0;

    private static HashMap<String, Snack> snacks = new HashMap<>();
    static {
        // Initialize the snacks available in the vending machine
        // Format: Name, Price, Quantity
        Snack coke = new Snack("Coke", 3.50, 5);
        Snack pepsi = new Snack("Pepsi", 3.25, 2);
        Snack cheetos = new Snack("Cheetos", 2.25, 3);
        Snack doritos = new Snack("Doritos", 2.25, 1);
        Snack kitkat = new Snack("KitKat", 1.50, 6);
        Snack snickers = new Snack("Snickers", 1.50, 1);
        snacks.put("Coke", coke);
        snacks.put("Pepsi", pepsi);
        snacks.put("Cheetos", cheetos);
        snacks.put("Doritos", doritos);
        snacks.put("KitKat", kitkat);
        snacks.put("Snickers", snickers);
    }

    public VendingMachine() {
    }

    public StateOfVendingMachine getState(){
        return stateOfVendingMachine;
    }

    public void setState(StateOfVendingMachine state){
        this.stateOfVendingMachine = state;
    }
    /**
     * Insert money into the vending machine.
     *
     * @param money The amount of money to insert.
     */
    public void insertMoney(Double money){
        getState().moneyInserted(this, money);
    }
    /**
     * Select a snack from the vending machine.
     *
     * @param snackOption The name of the snack to select.
     */
    public void selectSnack(String snackOption){
        getState().snackOptionPressed(this, snackOption);
    }

    public Snack getSnackOptionChosen() {
        return snackOptionChosen;
    }

    public void setSnackOptionChosen(Snack snackOptionChosen) {
        this.snackOptionChosen = snackOptionChosen;
    }


    public Double getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(Double moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    public Double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(Double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public double getSnackPrice(String name){
        if (isValidSnackOption(name)){
            return snacks.get(name).getPrice();
        }
        return 0.0;
    }

    public Snack getSnack(String name){
        if (isValidSnackOption(name)){
            return snacks.get(name);
        }
        return null;
    }
    /**
     * Check if a snack option is valid.
     *
     * @param name The name of the snack option.
     * @return True if the snack option is valid, false otherwise.
     */
    public boolean isValidSnackOption(String name){
        return snacks.containsKey(name);
    }

    public SnackDispenser getSnackDispenser() {
        return snackDispenser;
    }
    /**
     * Dispense the selected snack.
     */
    public void dispenseSnack(){
        getState().dispenseSnack(this);
    }
    /**
     * Retrieve change from the vending machine.
     *
     * @return The amount of change retrieved.
     */
    public double retrieveChange(){
        getState().processRefund(this);
        if (this.moneyInserted <= 0) {
            System.out.println("Cannot issue refund.");
            this.moneyInserted = 0.0;
        } else {
            System.out.println("Giving $" + this.moneyInserted + " for change");
        }
        double change = this.moneyInserted;
        this.moneyInserted = 0.0;
        return change;
    }
}
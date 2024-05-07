package HW8;

public class Driver {

    public static void main(String[] args){
        System.out.println("----------Kevin's Vending Machine----------\n");
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertMoney(5.0);  //should print out "Please select an option before inserting money"
        vendingMachine.dispenseSnack();     //should print out "Cannot dispense snack before selecting snack and inserting money."
        vendingMachine.retrieveChange();    //prints "Giving 0.0 for change"
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.0);
        vendingMachine.insertMoney(1.0);    //rejected because snickers is $1 and change is given

        vendingMachine.dispenseSnack();
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        System.out.println();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(0.25);
        vendingMachine.dispenseSnack();     //prints out "Not enough money! Money given: 0.25 Price for Snickers is: 1.0"
        vendingMachine.insertMoney(0.25);
        vendingMachine.insertMoney(0.25);
        vendingMachine.insertMoney(0.25);
        vendingMachine.insertMoney(0.50);
        vendingMachine.dispenseSnack(); //snickers are out of stock
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        System.out.println();

        vendingMachine.insertMoney(20.0);
        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(20.0);
        vendingMachine.dispenseSnack();
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        System.out.println();

        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.0);
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        vendingMachine.dispenseSnack(); //attempt to dispense coke after getting change, should be rejected
        System.out.println();

        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(4.0);
        vendingMachine.dispenseSnack();
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        System.out.println();

        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(2.0);
        vendingMachine.insertMoney(0.25);
        vendingMachine.dispenseSnack();
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        System.out.println();

        vendingMachine.selectSnack("Funyuns");
        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(10.0);
        vendingMachine.dispenseSnack();
        System.out.println("Total change given: $" + vendingMachine.retrieveChange());
        System.out.println();

    }
}
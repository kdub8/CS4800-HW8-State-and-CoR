package HW8;

/**
 * Represents a snack item in the vending machine.
 */
public class Snack {
    int quantity;
    String name;

    Double price;


    /**
     * Default constructor.
     */
    public Snack() {
    }

    /**
     * Constructor to initialize a snack with name, price, and quantity.
     *
     * @param name     The name of the snack.
     * @param price    The price of the snack.
     * @param quantity The quantity of the snack available.
     */
    public Snack(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
public class CoffeeShopOrder {
    private String coffeeType;
    private String size;
    private String[] extras;
    private int extrasCount;
    private double totalCost;

    // Constructor
    public CoffeeShopOrder(String coffeeType, String size) {
        this.coffeeType = coffeeType;
        this.size = size;
        this.extras = new String[3];  //max 3 extras
        this.extrasCount = 0;
        this.totalCost = 0.0;
        updateTotalCost();
    }
    public void cancelOrder() {
        System.out.println("Canceling the following order: ");
        displayOrderSummary(); //notice how I used another method in a method?
        coffeeType = null;
        size = null;
        extras = new String[3];
        extrasCount = 0;
        totalCost = 0.0;
    }

    public void addExtra(String extra) {
        if (extrasCount < extras.length) {
            extras[extrasCount] = extra;
            extrasCount++;
            updateTotalCost();
        } else {
            System.out.println("Maximum extras reached for this order.");
        }
    }


    private void updateTotalCost() {
        // Assume base cost for coffee types and sizes
        double baseCost = 3.0;  // Base cost for a regular coffee


        if (coffeeType.equals("Latte")) {
            baseCost += 1.5;
        } else if (coffeeType.equals("Americano")) {
            baseCost += 1.0;
        }
        else { //idk im too lazy to list all the different types of coffee
            baseCost += 3.0;
        }

        if (size.equals("Large")) {
            baseCost += 1.0;
        }

        // Additional cost for each extra
        double extraCost = 0.5 * extrasCount;

        totalCost = baseCost + extraCost;
    }

    public void displayOrderSummary() {
        System.out.print(size + " " + coffeeType);
        for (int i = 0; i < extrasCount; i++) {
            if(i == 0)
            System.out.print(" with ");
            System.out.print(extras[i]);
            if (i < extrasCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Total Cost: $" + totalCost);
    }

    public static void main(String[] args) {
        CoffeeShopOrder order1 = new CoffeeShopOrder("Latte", "Medium");
        CoffeeShopOrder order2 = new CoffeeShopOrder("Americano", "Large");

        order1.addExtra("Whipped Cream");
        order1.addExtra("Caramel Drizzle");
        order2.addExtra("Chocolate Sprinkles"); 
        order2.addExtra("Cold Foam");
        //there's a maximum of 3 extras, each costs 0.50
        order1.displayOrderSummary();
        order2.displayOrderSummary();
        order2.cancelOrder();
        
    }
}

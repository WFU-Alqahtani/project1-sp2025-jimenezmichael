import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // hard code for items in a video game store
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Call of Duty", 69.99);
        store[1] = new Item ("EA FC 25", 34.99);
        store[2] = new Item("Fortnite", 0);
        store[3] = new Item("Rocket League", 19.99);
        store[4] = new Item("Plants vs. Zombies", 4.99);
        return store;
    }

    // creates cart using an ArrayList of type Item
    public static ArrayList<Item> createCart(String[] args) {
        ArrayList<Item> shoppingCart = new ArrayList<Item>();
        Item[] store = Main.setupStore();

        // for loop runs and adds all valid args to cart
        for (int i = 0; i < args.length; i++) {
            try {
                int itemIndex = Integer.parseInt(args[i]);
                shoppingCart.add(store[itemIndex]);
            }

            //catch statements control for possible exceptions
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("The store does not have an item of index " + args[i] + ".");
            }
            catch(NumberFormatException e) {
                System.out.println("\"" + args[i] + "\" is not a valid integer.");
            }

        }
        return shoppingCart;
    }

    // prints a receipt with names and prices of all items in cart, subtotal, tax amount, and total after tax
    public static void printReceiptInOrder(ArrayList<Item> shoppingCart) {

        // receipt prints only if cart has items
        if(shoppingCart.size() > 0) {
            System.out.println("Receipt");
            System.out.println("=========================");
            System.out.println("Item            Price");

            // for loop accesses cart and uses getter methods from Item class
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).getItemName() + "      " + shoppingCart.get(i).getItemPrice());
            }

            System.out.println("=========================");
            System.out.print("(a) Subtotal: ");

            double subtotal = 0;
            // for loop adds price of items using getter method from Item class
            for (int i = 0; i < shoppingCart.size(); i++) {
                subtotal += shoppingCart.get(i).getItemPrice();
            }

            System.out.printf("%.2f\n", subtotal);

            System.out.println("(b) Sales tax: (5%)");

            // 5% sales tax is equal to the price times 1.05
            double total = subtotal * 1.05;
            System.out.print("(c) Total: ");
            System.out.printf("%.2f\n", total);
        }

        // if user provided no valid input into the cart, no reciept prints
        else {
            System.out.println("No valid Input to cart");
        }
    }

    // empties the cart in reverse order
    public static void emptyCartReverseOrder (ArrayList<Item> shoppingCart) {

        // only empties cart if there were items in the cart
        if(shoppingCart.size() > 0) {
            System.out.println("Removing all items from the cart in \"Last In First Out\" order...");

            // i is the index of the last item in the ArrayList, therefore cart empties from last to first
            for(int i = shoppingCart.size() - 1; i >= 0; i--) {
                System.out.println("Removing: " + shoppingCart.get(i).getItemName());
            }
            System.out.println("Cart has been emptied.");
        }
    }

    // main method
    public static void main(String[] args) {
        Item[] store = setupStore();

        // createCart takes command line arguments
        ArrayList<Item> shoppingCart = createCart(args);
        printReceiptInOrder(shoppingCart);
        emptyCartReverseOrder(shoppingCart);
        }
    }

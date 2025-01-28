import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Call of Duty", 69.99);
        store[1] = new Item ("EA FC 25", 34.99);
        store[2] = new Item("Fortnite", 0);
        store[3] = new Item("Rocket League", 19.99);
        store[4] = new Item("Plants vs. Zombies", 4.99);
        return store;
    }

    public static ArrayList<Item> createCart(String[] args) {
        ArrayList<Item> shoppingCart = new ArrayList<Item>();
        Item[] store = Main.setupStore();

        for (int i = 0; i < args.length; i++) {
            try {
                int itemIndex = Integer.parseInt(args[i]);
                shoppingCart.add(store[itemIndex]);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception thrown: " + e);
            }
            catch(NumberFormatException e) {
                System.out.println("Exception thrown: " + e);
            }
            catch(NullPointerException e) {
                System.out.println("Exception thrown: " + e);
            }
            catch(StringIndexOutOfBoundsException e) {
                System.out.println("Exception thrown:" + e);
            }
        }
        return shoppingCart;
    }

    public static void printReceiptInOrder(ArrayList<Item> shoppingCart) {
        System.out.println("R e c e i p t");
        System.out.println("=========================");
        System.out.println("I t e m        P r i c e");
        for(int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i).getItemName());
        }
    }

    public static void main(String[] args) {
        Item[] store = setupStore();
        ArrayList<Item> shoppingCart = createCart(args);
        printReceiptInOrder(shoppingCart);
        }
    }

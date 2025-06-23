import java.util.Scanner;


class FoodItem {
    String name;
    double price;
    int stock;


    FoodItem(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    void showItem(int index) {
        System.out.println(index + ". " + name + " - Rs. " + price + " (Available: " + stock + ")");
    }

    
    void refill(int quantity) {
        stock += quantity;
    }

    
    boolean order(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            return true;
        } else {
            return false;
        }
    }
}

public class FoodRestaurantShow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to SHREEKRUSHNA Restaurant!");

        
        FoodItem[] menu = {
            new FoodItem("Veg Thali", 120, 5),
            new FoodItem("Veg Biryani", 150, 2),
            new FoodItem("Paneer Roll", 80, 3),
            new FoodItem("Cold Drink", 30, 10)
        };

        int choice;

        do {
            System.out.println("\n------ MENU OPTIONS ------");
            System.out.println("1. Show Menu");
            System.out.println("2. Order Food");
            System.out.println("3. Show Food Quantity");
            System.out.println("4. Refill Stock");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n Food Menu:");
                    for (int i = 0; i < menu.length; i++) {
                        menu[i].showItem(i + 1);
                    }
                    break;

                case 2:
                    System.out.print("Enter food item number to order (1-4): ");
                    int orderNum = sc.nextInt();
                    if (orderNum < 1 || orderNum > 4) {
                        System.out.println(" Invalid item number!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    FoodItem item = menu[orderNum - 1];

                    if (item.order(qty)) {
                        double total = qty * item.price;
                        System.out.println(" Ordered " + item.name + " x" + qty + " = Rs. " + total);
                    } else {
                        System.out.println(" Not enough stock! Available: " + item.stock);
                    }
                    break;

                case 3:
                    System.out.println("\n Available Stock:");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println((i + 1) + ". " + menu[i].name + " - Quantity: " + menu[i].stock);
                    }
                    break;

                case 4:
                    System.out.print("Enter item number to refill (1-4): ");
                    int refillNum = sc.nextInt();
                    if (refillNum < 1 || refillNum > 4) {
                        System.out.println(" Invalid item number!");
                        break;
                    }

                    System.out.print("Enter quantity to add: ");
                    int refillQty = sc.nextInt();
                    menu[refillNum - 1].refill(refillQty);
                    System.out.println(" Stock updated for " + menu[refillNum - 1].name);
                    break;

                case 0:
                    System.out.println(" Thank you for visiting SHREEKRUSHNA Restaurant!");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice!=0);
    }
}
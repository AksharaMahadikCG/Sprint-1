import java.util.*;

public class Pizzahut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean choice = true;

        while (choice) {
            System.out.println("do you want pizza choose from below : ");
            System.out.println("1 - Veg pizza\n" +
                    "2 - Chicken pizza\n" +
                    "3 - Mutton pizza\n" +
                    "other - exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    Pizza pz = new Pizza("Pizza base", 99);
                    pz.display();
                    break;
                case 2:
                    Pizza pz1 = new ChickenPizza("Chicken pizza base", 149);
                    pz1.display();
                    break;
                case 3:
                    ChickenPizza pz2 = new MuttonPizza("Mutton pizza base", 249);
                    pz2.display();
                    break;
                default:
                    choice = false;
                    System.out.println("Exited !!");
                    break;
            }
        }
    }
}

class Pizza {
    String pizzabase;
    int price;

    Pizza(String pizzabase, int price) {
        this.pizzabase = pizzabase;
        this.price = price;
    }

    void display() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("You have selected : ");
        System.out.println(pizzabase + " - Rs. " + price);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}


class ChickenPizza extends Pizza {
    String variable = "Chicken Topping";

    ChickenPizza(String pizzabase, int price) {
        super(pizzabase, price);
    }

    void display() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("You have selected : ");
        System.out.println(pizzabase + " with " + variable + " - Rs. " + price);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}

class MuttonPizza extends ChickenPizza {
    String variable = "Mutton Topping";

    MuttonPizza(String pizzabase, int price) {
        super(pizzabase, price);
    }

    void display() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("You have selected : ");
        System.out.println(pizzabase + " with " + variable + " - Rs. " + price);
        System.out.println("---------------------------------------------------------------------------------------------");

    }
}

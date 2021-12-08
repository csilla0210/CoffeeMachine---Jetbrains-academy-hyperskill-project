import java.util.Scanner;

public class CoffeeMachine {

    static Ingredient water = new Ingredient("water", 400, "ml");
    static Ingredient milk = new Ingredient("milk", 540, "ml");
    static Ingredient coffee = new Ingredient("coffee beans", 120, "g");
    static Ingredient cups = new Ingredient("disposable cups", 9, "");
    static Ingredient money = new Ingredient("money", 550, "$");

    public static Ingredient[] ingredients = {water, milk, coffee, cups, money};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action =sc.nextLine();
            boolean exit = false;
            switch (action) {
                case "exit":
                    exit = true;
                    break;
                case "buy":
                    String type = Actions.buyAsk();
                    Actions.buyExecute(type, ingredients);
                    break;
                case "fill":
                    int[] change = Actions.fillAsk();
                    Actions.fillExecute(ingredients, change);
                    break;
                case "take":
                    Actions.takeExecute(ingredients);
                    break;
                case "remaining":
                    Actions.availableAmounts(ingredients);
                    break;
            }
            if (exit) {
                break;
            }
            System.out.println();
        }
    }
}

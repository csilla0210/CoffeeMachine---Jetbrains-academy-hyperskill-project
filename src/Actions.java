import java.util.Scanner;

public class Actions {

    /**
     *
     * @return an array which should be used in fillExecute() method
     */
    public static int[] fillAsk() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int coffee = sc.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int cups = sc.nextInt();
        return new int[]{water, milk, coffee, cups, 0};
    }

    /**
     *
     * @return an action which should be used in buyExecute() method
     */
    public static String buyAsk() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        return sc.nextLine();
    }

    /**
     * Prints out the current state of CoffeeMachine ingredients
     * @param ingredients class variable of CoffeeMachine
     */
    public static void availableAmounts(Ingredient[] ingredients) {
        System.out.println();
        System.out.println("The coffee machine has:");
        for(Ingredient i: ingredients) {
            if (i.name.equals("money")) {
                System.out.printf("%s%d of %s%n", i.unit, i.amount, i.name);
            } else if (i.unit.equals("")) {
                System.out.printf("%d %s%n", i.amount, i.name);
            } else {
                System.out.printf("%d %s of %s%n", i.amount, i.unit, i.name);
            }
        }
    }

    /**
     * increases the CoffeeMachine ingredients
     * @param ingredients class variable of CoffeeMachine
     * @param change array comes from fillAsk() method
     *
     */
    public static void fillExecute(Ingredient[] ingredients, int[] change) {
        for (int i = 0; i < ingredients.length; i++) {
            ingredients[i].amount += change[i];
        }
    }

    /**
     * given by action parameter, decreases the CoffeeMachine ingredients or ignores executing
     * @param action comes from buyAsk() method; user input: 1,2 or 3 for coffee type or back to ignore this method
     * @param ingredients class variable of CoffeeMachine
     */
    public static void buyExecute(String action, Ingredient[] ingredients) {
        if (!action.equals("back")){
            int[] decreaseAmount = new int[ingredients.length];
            switch (action) {
                case "1":
                    decreaseAmount = Coffees.buyEspresso();
                    break;
                case "2":
                    decreaseAmount = Coffees.buyLatte();
                    break;
                case "3":
                    decreaseAmount = Coffees.buyCappuccino();
                    break;
            }
            boolean enoughResources = true;
            for (int i = 0; i < ingredients.length; i++) {
                if (ingredients[i].amount < Math.abs(decreaseAmount[i])) {
                    System.out.printf("Sorry, not enough %s!%n", ingredients[i].name);
                    enoughResources = false;
                    break;
                }
            }
            if (enoughResources) {
                for (int i = 0; i < ingredients.length; i++) {
                    ingredients[i].amount += decreaseAmount[i];
                }
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
    }

    /**
     * reset money to 0 in class variable of CoffeeMachine
     * @param ingredients class variable of CoffeeMachine
     */
    public static void takeExecute(Ingredient[] ingredients) {
        int takenAmount = ingredients[ingredients.length - 1].amount;
        ingredients[ingredients.length - 1].amount = 0;
        System.out.printf("I gave you $%d%n", takenAmount);
    }
}

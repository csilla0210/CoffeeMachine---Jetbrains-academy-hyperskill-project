
public enum Coffees {
    ESPRESSO("espresso", 250, 0, 16, 4),
    LATTE("latte", 350, 75, 20, 7),
    CAPPUCCINO("cappuccino", 200, 100, 12,6);

    String name;
    int water;
    int milk;
    int coffeeBeans;
    int cost;

    Coffees(String name, int water, int milk, int coffeeBeans, int cost) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    public static int[] buyEspresso() {
        int[] result = new int[5];
        result[0] = - ESPRESSO.water;
        result[1] = - ESPRESSO.milk;
        result[2] = - ESPRESSO.coffeeBeans;
        result[3] = - 1;
        result[4] = ESPRESSO.cost;
        return result;
    }

    public static int[] buyLatte() {
        int[] result = new int[5];
        result[0] = - LATTE.water;
        result[1] = - LATTE.milk;
        result[2] = - LATTE.coffeeBeans;
        result[3] = - 1;
        result[4] = LATTE.cost;
        return result;
    }

    public static int[] buyCappuccino() {
        int[] result = new int[5];
        result[0] = - CAPPUCCINO.water;
        result[1] = - CAPPUCCINO.milk;
        result[2] = - CAPPUCCINO.coffeeBeans;
        result[3] = - 1;
        result[4] = CAPPUCCINO.cost;
        return result;
    }
}
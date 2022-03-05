import java.util.Arrays;

class Item implements Comparable<Item> {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Item item) {
        return (this.weight* item.value - this.value* item.weight);
    }
}

public class FractionalKnapsackProblem {
    public static void main(String[] args) {
        Item[] items = new Item[]{new Item(10, 60), new Item(40, 40), new Item(20, 100), new Item(30, 120)};
        System.out.println(fracKnapsack(items, items.length, 50));
    }

    //  Time Complexity : O(nlog(n))
    //  Auxiliary Space : O(1)
    public static double fracKnapsack(Item[] items, int n, int weight) {
        Arrays.sort(items);
        double res = 0.0;

        for (int i=0; i<n; i++) {
            if (items[i].weight<=weight) {
                res += items[i].value;
                weight -= items[i].weight;
            }
            else {
                res += items[i].value*((double)weight/items[i].weight);
                break;
            }
        }

        return res;
    }
}

import javafx.scene.control.skin.SliderSkin;

import java.util.ArrayList;

public class RearrangeArrayInAlternatingPositiveAndNegative {

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void rearrange(int[] arr, int n) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (arr[i]<0) {
                negative.add(arr[i]);
            }
            else {
                positive.add(arr[i]);
            }
        }

        int i=0, j=0, k=0;
        while (i<positive.size() && j<negative.size()) {
            arr[k++] = positive.get(i++);
            arr[k++] = negative.get(j++);
        }

        while (i<positive.size()) {
            arr[k++] = positive.get(i++);
        }

        while (j<negative.size()) {
            arr[k++] = negative.get(j++);
        }
    }
}

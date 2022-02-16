public class CountMoreThanNK {
    static class compareAndCount {
        int element;
        int count;
    }

//     Time Complexity : O(nk)
//     Auxiliary Space : O(k)
    public static void moreThanNK(int[] arr, int k) {
        int n = arr.length;

//      Output is only applicable for k>2;
        if(k<2) {
            return;
        }

//      Creation and initialization of temporary array.
        compareAndCount[] temp = new compareAndCount[k-1];
        for (int i=0; i<k-1; i++) {
            temp[i] = new compareAndCount();
        }
        for (int i=0; i<k-1; i++) {
            temp[i].count = 0;
        }

//      Check whether the elements of the array exists in the temporary array or not.
//      If the elements already exist in the temporary element then increase the count.
        for (int i=0; i<arr.length; i++) {
            int j;
            for (j=0; j<k-1; j++) {
                if (temp[j].element == arr[i]) {
                    temp[j].count += 1;
                    break;
                }
            }

//          If arr[i] isn't present in the temporary array.
            if (j==k-1) {
//              if there's a place already present in the temporary array then place the arr[i] in the first available position and set l;
                int l;
                for (l = 0; l < k - 1; l++) {
                    if (temp[l].count == 0) {
                        temp[l].element = arr[i];
                        temp[l].count = 1;
                        break;
                    }
                }

                if (l==k-1) {
                    for (l=0; l<k-1; l++) {
                        temp[l].count -= 1;
                    }
                }
            }
        }

        for (int i=0; i<k-1; i++) {
            int count = 0;
            for (int j=0; j<arr.length; j++) {
                if (temp[i].element==arr[j]) {
                    count++;
                }
            }

            if (count>arr.length/k) {
                System.out.println("Number : " + temp[i].element + " count : " + count);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,2,1,2,3,3};
        int k = 3;
        moreThanNK(arr, k);
    }
}

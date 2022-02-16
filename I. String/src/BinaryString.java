public class BinaryString {
    public static void main(String[] args) {
        String str = "000100100000001";
        char charArray[] = str.toCharArray();
        System.out.println(count(charArray, charArray.length));
        System.out.println(countEfficient(charArray, charArray.length));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int count(char[] charArray, int n) {
        int count = 0;
        for (int i=0; i<n; i++) {
            if (charArray[i]=='1') {
                for (int j=i+1; j<n; j++) {
                    if (charArray[j]=='1') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int countEfficient(char[] charArray, int n) {
        int count = 0;
        for (int i=0; i<n; i++) {
            if (charArray[i]=='1') {
                count++;
            }
        }
        return count*(count-1)/2;
    }
}

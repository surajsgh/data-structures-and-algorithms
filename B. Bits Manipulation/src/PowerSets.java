public class PowerSets {
    public static void main(String[] args) {
        printPowerSet("bc");
    }

    //  Time Complexity : O(n*2^n)
    //  Auxiliary Space : O(1)
    public static void printPowerSet(String str) {
        int stringLength = str.length();
        int powerSet = (int)Math.pow(2, stringLength);

        for (int counter=0; counter<powerSet; counter++) {
            for (int i=0; i<stringLength; i++) {
                if ((counter&(1<<i)) != 0) {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}

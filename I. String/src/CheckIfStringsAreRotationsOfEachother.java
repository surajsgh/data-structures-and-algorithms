public class CheckIfStringsAreRotationsOfEachother {
    public static void main(String[] args) {
        System.out.println(areRotations("ABCD", "BDDA"));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static boolean areRotations(String str1, String str2) {
        if (str1.length()!=str2.length()) {
            return false;
        }
        return ((str1+str1).indexOf(str2)>=0);
    }
}

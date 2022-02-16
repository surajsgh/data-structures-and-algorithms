public class GenerateSubsets {
    public static void main(String[] args) {
        generateSubsetsFromTheGivenString("ABC", "", 0);
    }

    //  Time Complexity : O(2**n)
    //  Auxiliary Space : O(2**n)
    public static void generateSubsetsFromTheGivenString(String str, String currentString, int i) {
        if (str.length() == i) {
            System.out.println(currentString + " ");
            return;
        }
        generateSubsetsFromTheGivenString(str, currentString, i+1);
        generateSubsetsFromTheGivenString(str, currentString + str.charAt(i), i+1);
    }
}

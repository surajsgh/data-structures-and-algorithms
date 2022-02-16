public class CheckIfAStringIsRotatedByTwoPlaces {
    public static void main(String[] args) {
        System.out.println(isRotated("amazon", "azonam"));
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static boolean isRotated(String str1, String str2) {
        if(str1.length()!=str2.length()) {
            return false;
        }
        if(str1.length() < 2)
        {
            return str1.equals(str2);
        }
        String clockWiseDirection = "";
        String antiClockWiseDirection = "";
        int len = str2.length();

        clockWiseDirection += str2.substring(len-2, len) + str2.substring(0, len-2);
        antiClockWiseDirection += str2.substring(2) + str2.substring(0, 2);
        return (str1.equals(clockWiseDirection) || str1.equals(antiClockWiseDirection));
    }
}

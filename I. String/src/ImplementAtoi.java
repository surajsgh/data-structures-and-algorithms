public class ImplementAtoi {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        int sign = 1;
        int total = 0;

        //  Checks for the index
        if(n==0) return 0;

        //  Checks for the whitespaces
        while(index<n && s.charAt(index)==' ') {
            index++;
        }

        if(index==n) return 0;

        //  Checks for the sign
        if(s.charAt(index)=='+' || s.charAt(index)=='-') {
            sign = s.charAt(index)=='+' ? 1 : -1;
            index++;
        }

        while(index<n) {
            int digit = s.charAt(index) - '0';
            if(digit<0 || digit>9) break;

            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit) {
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total*10 + digit;
            index++;
        }

        return total*sign;
    }
}

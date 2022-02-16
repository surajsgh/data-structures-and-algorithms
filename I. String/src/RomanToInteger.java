public class RomanToInteger {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int romanToInt(String s) {
        int ans = 0;
        int num = 0;
        for(int i = s.length()-1; i>=0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C':num = 100; break;
                case 'D':num = 500; break;
                case 'M': num = 1000; break;
            }
            if(4*num<ans) {
                ans -= num;
            }
            else {
                ans += num;
            }
        }
        return ans;
    }

    public int value(char c) {
        if(c=='I') return 1;
        else if(c=='V') return 5;
        else if(c=='X') return 10;
        else if(c=='L') return 50;
        else if(c=='C') return 100;
        else if(c=='D') return 500;
        else if(c=='M') return 1000;
        return -1;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int romanToIntAlt(String s) {
        int n = s.length();
        int result = 0;

        for(int i=0; i<n; i++) {
            int s1 = value(s.charAt(i));

            if(i+1<n) {
                int s2 = value(s.charAt(i+1));

                if(s1>=s2) {
                    result += s1;
                }
                else {
                    result += s2-s1;
                    i++;
                }
            }
            else {
                result += s1;
            }
        }

        return result;
    }
}

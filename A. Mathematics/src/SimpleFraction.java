import java.util.HashMap;
import java.util.Map;

public class SimpleFraction {
    //  Time Complexity : O(k)
    //  Auxiliary Space : O(k)
    public String  fractionToDecimal(int numerator, int denominator)
    {
        if(numerator==0) {
            return "0";
        }
        if(denominator==0) {
            return "";
        }

        StringBuilder str = new StringBuilder();
        if((numerator<0)^(denominator<0)) {
            str.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long quo = (numerator/denominator);
        long rem = (numerator % denominator) * 10;
        str.append(String.valueOf(quo));
        if(rem==0) {
            return str.toString();
        }

        str.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while(rem!=0) {
            if(map.containsKey(rem)) {
                int index = map.get(rem);
                String part1 = str.substring(0, index);
                String part2 = "(" + str.substring(index, str.length()) +
                        ")";
                return part1 + part2;
            }
            map.put(rem, str.length());
            quo = rem/denominator;
            str.append(String.valueOf(quo));
            rem = (rem % denominator) * 10;
        }
        return str.toString();
    }
}

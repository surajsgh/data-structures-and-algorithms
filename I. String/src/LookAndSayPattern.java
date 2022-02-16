public class LookAndSayPattern {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";

        String str = "11";

        for(int i=3; i<=n; i++) {
            str += "$";
            int length = str.length();
            int count = 1;
            String temp = "";
            char[] charArray = str.toCharArray();

            for(int j=1; j<length; j++) {
                if(charArray[j]!=charArray[j-1]) {
                    temp += count+0;
                    temp += charArray[j-1];
                    count=1;
                }
                else {
                    count++;
                }
            }
            str = temp;
        }
        return str;
    }
}

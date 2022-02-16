public class KeypadTyping {
    public static void main(String[] args) {
        String str[] = {"2","22","222",
                "3","33","333",
                "4","44","444",
                "5","55","555",
                "6","66","666",
                "7","77","777","7777",
                "8","88","888",
                "9","99","999","9999"
        };
        System.out.println(type(str, "GEEKSFORGEEKS"));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static String type(String[] str, String input) {
        String output = "";
        int n = input.length();
        for (int i=0; i<n; i++) {
            if (input.charAt(i)==' ') {
                output += "0";
            }
            else {
                int position = input.charAt(i) - 'A';
                output += str[position];
            }
        }
        return output;
    }
}

public class CaesarCipherEncrypter {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        int n = str.length();
        char[] strCharacters = new char[n];
        int superKey = key % 26;
        String characterSet = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<n; i++) {
            strCharacters[i] = helper(characterSet, superKey, str.charAt(i));
        }
        return new String(strCharacters);
    }

    public static char helper(String characterSet, int superKey, char character) {
        int index = characterSet.indexOf(character) + superKey;
        return characterSet.charAt(index % 26);
    }
}

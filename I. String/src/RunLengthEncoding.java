public class RunLengthEncoding {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public String runLengthEncoding(String string) {
        // Write your code here.
        int n = string.length();
        StringBuilder characterResult = new StringBuilder();
        int characterLength = 1;

        for(int i=1; i<n; i++) {
            char currentCharacter = string.charAt(i);
            char previousCharacter = string.charAt(i-1);

            if(currentCharacter!=previousCharacter || characterLength==9) {
                characterResult.append(Integer.toString(characterLength));
                characterResult.append(previousCharacter);
                characterLength = 0;
            }

            characterLength += 1;
        }

        characterResult.append(Integer.toString(characterLength));
        characterResult.append(string.charAt(string.length()-1));

        return characterResult.toString();
    }
}

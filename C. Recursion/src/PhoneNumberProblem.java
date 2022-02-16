import java.util.*;

// Time Complexity : O((4^n)*n)
// Auxiliary Space : O((4^n)*n)
public class PhoneNumberProblem {
    public static void main(String[] args) {
        System.out.println(letterCombinations("289"));
    }

    public static Map<Character, String[]> mapCharacterToTheString = new HashMap<Character, String[]>();

    static {
        mapCharacterToTheString.put('2', new String[]{"a","b","c"});
        mapCharacterToTheString.put('3', new String[]{"d","e","f"});
        mapCharacterToTheString.put('4', new String[]{"g","h","i"});
        mapCharacterToTheString.put('5', new String[]{"j","k","l"});
        mapCharacterToTheString.put('6', new String[]{"m","n","o"});
        mapCharacterToTheString.put('7', new String[]{"p","q","r", "s"});
        mapCharacterToTheString.put('8', new String[]{"t","u","v"});
        mapCharacterToTheString.put('9', new String[]{"w","x","y", "z"});
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return new ArrayList<String>();
        }
        String[] phoneDigitsToBeFound = new String[digits.length()];
        Arrays.fill(phoneDigitsToBeFound, "0");

        List<String> currentPhoneDigits = new ArrayList<String>();
        possibleMnemonics(0, currentPhoneDigits, phoneDigitsToBeFound, digits);
        return currentPhoneDigits;
    }

    public static void possibleMnemonics(int index, List<String> currentPhoneDigits, String[] phoneDigitsToBeFound, String digits) {
        if(index==digits.length()) {
            String mnemonic = String.join("", phoneDigitsToBeFound);
            currentPhoneDigits.add(mnemonic);
        }
        else {
            char firstInput = digits.charAt(index);
            String[] letters = mapCharacterToTheString.get(firstInput);
            for(String letter : letters) {
                phoneDigitsToBeFound[index] = letter;
                possibleMnemonics(index+1, currentPhoneDigits, phoneDigitsToBeFound, digits);
            }
        }
    }
}

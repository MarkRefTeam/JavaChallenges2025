import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlgoritmicTask {

    //Given a string, find the length of the smallest substring
    //that contains all the unique characters from the original string.
    //Input: "aabcbcdbca" Output: 4 Explanation: The smallest substring containing all unique characters is "dbca"

    public static int findSmallestUniqueSubstringLength(String s) {
        Set<Character> uniqueChars = new HashSet<>();

        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int required = uniqueChars.size();

        Map<Character, Integer> windowsCount = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0;
        int minLen = s.length() + 1;
    }

}
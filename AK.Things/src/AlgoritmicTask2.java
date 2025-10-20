import java.util.*;

public class AlgoritmicTask2 {

    public static Character findFirstNonRepeatingChar(String s) {

        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for(char c: s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c,0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

    }
}

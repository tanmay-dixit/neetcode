package ArraysAndHashing.Easy;

import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {

    public void testValidAnagram() {

        boolean result1 = this.isAnagram("anagram", "nagaram");
        System.out.println("result1 = " + result1);

        boolean result2 = this.isAnagram("rat", "car");
        System.out.println("result2 = " + result2);

        boolean result3 = this.isAnagram("", "");
        System.out.println("result3 = " + result3);
    }

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        var frequencyByChar = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(Character c: t.toCharArray()) {
            frequencyByChar.computeIfPresent(c, (character, frequency) -> frequency - 1);
        }

        return frequencyByChar.values().stream().allMatch(frequency -> frequency == 0);

    }
}

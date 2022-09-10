package TwoPointers;

public class ValidPalindrome {

    public void testValidPalindrome() {

        boolean result1 = this.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("result1 = " + result1);

        boolean result2 = this.isPalindrome("race a car");
        System.out.println("result2 = " + result2);

        boolean result3 = this.isPalindrome("");
        System.out.println("result3 = " + result3);

    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int leftIndex = 0;
        int rightIndex = s.length()-1;
        Character leftChar;
        Character rightChar;

        while (leftIndex <= rightIndex) {
            leftChar = s.charAt(leftIndex);
            System.out.println("leftChar = " + leftChar);
            rightChar = s.charAt(rightIndex);
            System.out.println("rightChar = " + rightChar);

            if(!Character.isLetterOrDigit(leftChar)) {
                System.out.println("left char: " + leftChar + " is not letter or digit. skipping");
                leftIndex++;
                continue;
            }

            if(!Character.isLetterOrDigit(rightChar)) {
                System.out.println("right char: " + rightChar + " is not letter or digit. skipping");
                rightIndex--;
                continue;
            }

            if(!leftChar.equals(rightChar)) {
                System.out.println("left char: " + leftChar + " does not equal right char: " + rightChar);
                return  false;
            }

            leftIndex ++;
            rightIndex--;
        }

        System.out.println("String is anagram. returning true");
        return true;
    }
}

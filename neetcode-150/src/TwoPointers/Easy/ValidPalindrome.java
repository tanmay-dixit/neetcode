package TwoPointers.Easy;

public class ValidPalindrome {


    public void testValidPalindrome() {

        boolean result1 = this.isPalindrome("A man, a plan, a canal: Panama");
        assert result1;

        boolean result2 = this.isPalindrome("race a car");
        assert !result2;

        boolean result3 = this.isPalindrome(" ");
        assert result3;

    }

    public boolean isPalindrome(String s) {

        int leftIndex = 0;
        int rightIndex = s.length()-1;
        char leftChar;
        char rightChar;

        while (leftIndex <= rightIndex) {

            leftChar = s.charAt(leftIndex);
            rightChar = s.charAt(rightIndex);

            if(!Character.isLetterOrDigit(leftChar)) {
                leftIndex++;
                continue;
            }

            if(!Character.isLetterOrDigit(rightChar)) {
                rightIndex--;
                continue;
            }

            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return  false;
            }

            leftIndex ++;
            rightIndex--;

        }

        return true;
    }
}

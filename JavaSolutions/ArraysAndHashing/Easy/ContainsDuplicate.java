package ArraysAndHashing.Easy;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        var uniqueNumbers = new HashSet<Integer>();

        for(int currentNumber: nums) {
            if(uniqueNumbers.contains(currentNumber)) {
                return true;
            } else {
                uniqueNumbers.add(currentNumber);
            }
        }

        return false;

    }

}

import java.util.HashMap;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int currentNum;
        int missingNum;
        int missingNumIndex;
        var indexByNum = new HashMap<Integer, Integer>();

        for(int currentNumIndex=0; currentNumIndex<nums.length; currentNumIndex++) {
            currentNum = nums[currentNumIndex];
            indexByNum.put(currentNum, currentNumIndex);
        }

        for(int currentNumIndex=0; currentNumIndex<nums.length; currentNumIndex++) {

            currentNum = nums[currentNumIndex];
            missingNum = target - currentNum;

            if(indexByNum.containsKey(missingNum)) {
                missingNumIndex = indexByNum.get(missingNum);

                if(currentNumIndex != missingNumIndex) {
                    return new int[] { currentNumIndex , missingNumIndex };
                }
            }

        }

        return new int[] {-1, -1};

    }

}
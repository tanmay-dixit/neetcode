package arraysandhashing.easy;

public class BinarySearch {
    class Solution {

        private int currentIndex;

        public int search(int[] nums, int target) {
            currentIndex = 0;
            return searchRecursively(nums, 0, nums.length - 1, target);
        }

        public int searchRecursively(int[] nums, int startIndex, int endIndex, int target) {

            if (startIndex > endIndex) {
                return -1;
            }

            currentIndex = (startIndex + endIndex) / 2;

            if (nums[currentIndex] < target) {
                startIndex = currentIndex + 1;
            } else if (nums[currentIndex] > target) {
                endIndex = currentIndex - 1;
            } else {
                return currentIndex;
            }

            return searchRecursively(nums, startIndex, endIndex, target);
        }

        public int searchIterative(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int index;
            while (start <= end) {
                index = (start + end) / 2;
                if (nums[index] < target) {
                    start = index + 1;
                } else if (nums[index] > target) {
                    end = index - 1;
                } else {
                    return index;
                }
            }
            return -1;
        }

    }

}

package Algorithms;

/**
 * @Author: Chen Zixin
 * @Date: 2020/9/9 2:59 下午
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int mid;

        while(start <= end){
            mid = (start + end) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }
}

package LeetCode.array;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        r.rotate(nums,k);
    }
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i+k)%nums.length;
            result[index] = nums[i];
        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}

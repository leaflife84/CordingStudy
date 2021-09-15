package LeetCode.array;

public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        RemoveDuplicatesArray r = new RemoveDuplicatesArray();
        int[] nums = {1,1,2};
        r.removeDuplicates(nums);
    }
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[i])
                continue;
            nums[++i]=nums[j];
        }
        return i+1;
    }
}

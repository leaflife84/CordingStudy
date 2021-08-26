package LeetCode.sortAndSearch;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray v = new MergeSortedArray();
        int[] num1 = {-1,0,0,3,3,3,0,0,0};
        int m = 6;
        int[] num2 = {1,2,3};
        int n = 3;
        v.merge(num1,m,num2,n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int i = 0;
        int[] nums3 = new int[nums1.length];
        if(n == 0){
            return;
        }
        while(i+j < nums1.length){
            if(j < n && (nums1[i] >= nums2[j] || i >= m)){
                nums3[i+j] = nums2[j];
                j++;
            }else{
                nums3[i+j] = nums1[i];
                i++;
            }
        }
        for (int k = 0; k < nums3.length; k++) {
            nums1[k] = nums3[k];
        }
    }
}

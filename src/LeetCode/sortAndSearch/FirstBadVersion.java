package LeetCode.sortAndSearch;
//바이너리 서치
public class FirstBadVersion {
    public static void main(String[] args) {
        FirstBadVersion f = new FirstBadVersion();
        System.out.println(f.firstBadVersion(3));
    }
    public static boolean isBadVersion(int version){
        if(version >= 2){
            return true;
        }else{
            return false;
        }
    }
    public int firstBadVersion(int n) {
        int right = n;
        int left = 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;

    }
}

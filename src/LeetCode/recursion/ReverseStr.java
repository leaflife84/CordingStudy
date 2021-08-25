package LeetCode.recursion;

public class ReverseStr {
    public static void main(String[] args) {
        ReverseStr r = new ReverseStr();
        char[] s = {'h','e','l','l','o'};
        r.reverseString(s);
    }
    public void reverseString(char[] s) {
        char[] clone = s.clone();
        int j = 0;
        for(int i = clone.length-1; i >= 0; i--){
            s[j] = clone[i];
            j++;
        }

    }
}

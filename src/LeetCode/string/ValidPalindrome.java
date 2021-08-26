package LeetCode.string;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(v.isPalindrome(s));
        System.out.println(v.isPalindrome2(s));
    }

    public boolean isPalindrome(String s) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        StringBuilder str = new StringBuilder();
        Matcher m = p.matcher(s);
        while (m.find()) {
            str.append(m.group().toLowerCase(Locale.ROOT));
        }

        StringBuilder rev = new StringBuilder();
        rev.append(str).reverse();
        if(rev.toString().equals(str.toString())){
            return true;
        }else{
            return false;
        }
    }

    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}

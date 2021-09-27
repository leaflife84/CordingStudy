package LeetCode.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        UniqueEmailAddresses u = new UniqueEmailAddresses();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        u.numUniqueEmails(emails);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String[] email = emails[i].split("@");
            String first = email[0];
            StringBuilder st = new StringBuilder();
            for (int j = 0; j < first.length(); j++) {
                if(first.charAt(j) == '+'){
                    break;
                }else if(first.charAt(j) == '.'){
                    continue;
                }else{
                    st.append(first.charAt(j));
                }
            }
            st.append("@"+email[1]);
            result.add(st.toString());
        }
        return result.size();
    }
}

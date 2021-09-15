package kakao.mobility;

import java.util.HashMap;
import java.util.Locale;

public class test1 {
    public static void main(String[] args) {
        test1 t = new test1();
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Exam-ple";
        System.out.println(t.solution(S,C));

    }
    public String solution(String S, String C) {
        StringBuilder result = new StringBuilder();
        C = C.replace("-","").toLowerCase(Locale.ROOT);
        String[] user = S.split(", ");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < user.length; i++){
            String[] name = user[i].split(" ");
            String middleName = "";
            String lastName = "";
            if(name.length == 3){
                middleName = name[1].toLowerCase(Locale.ROOT).substring(0,1);
                lastName = name[2].replace("-","").toLowerCase(Locale.ROOT);

            }else{
                lastName = name[1].replace("-","").toLowerCase(Locale.ROOT);
            }

            if(lastName.length() < 8){
                lastName = lastName.substring(0,lastName.length());
            }else{
                lastName = lastName.substring(0,8);
            }
            String firstName = name[0].toLowerCase(Locale.ROOT).substring(0,1);
            String email = firstName+middleName+lastName+"@"+C+".com";
            map.put(email,map.getOrDefault(email,0)+1);
            if(map.get(email) > 1){
                email = firstName+middleName+lastName+map.get(email)+"@"+C+".com";
            }
            result.append(user[i] + " <" + email + ">, ");
        }
        return result.toString().substring(0,result.length()-2);
    }
}

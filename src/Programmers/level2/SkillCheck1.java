package Programmers.level2;

//https://programmers.co.kr/learn/courses/30/lessons/60058 (괄호변환)
public class SkillCheck1 {
    public static void main(String[] args) {
        SkillCheck1 skill = new SkillCheck1();
        String res = skill.solution("()))((()");
        System.out.println(res);
    }
    public String solution(String p) {
        String answer = "";
        answer = recu("",p);
        return answer;
    }
    public String recu(String u, String v){
        int left = 0; // (
        int right = 0; // )
        boolean chk = false;
        StringBuilder result = new StringBuilder();
        //올바른 괄호 문자열인지 체크
        if(u.length() > 0) {
            if ('(' == u.charAt(0)) {
                result.append(u);
            } else {
                result.append("(");
                chk = true;
            }
        }
        for(int i = 0; i < v.length(); i++){
            if('(' == v.charAt(i)){
                left++;
            }else{
                right++;
            }

            if(left !=0 && right != 0){
                if(left == right){ //균형잡힌 괄호 문자열이라면?
                    result.append(recu(v.substring(0,i+1),v.substring(i+1,v.length())));
                    break;
                }
            }
        }
        if(chk){
            result.append(")");
            u = u.substring(1,u.length()-1);
            for(int i = 0; i < u.length(); i++){
                if('(' == u.charAt(i)){
                    result.append(")");
                }else{
                    result.append("(");
                }
            }
        }
        return result.toString();
    }
}

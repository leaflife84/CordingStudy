package Programmers.level1;

public class SkillCheck2 {
    public static void main(String[] args) {
        SkillCheck2 skill = new SkillCheck2();
        String s = "one4seveneight";
        skill.solution(s);
    }
    static String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < str.length; i++){
            s = s.replaceAll(str[i],String.valueOf(i));
        }
        System.out.println(s);
        answer = Integer.parseInt(s);
        return answer;
    }
}

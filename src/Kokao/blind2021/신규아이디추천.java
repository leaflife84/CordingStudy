package Kokao.blind2021;

import java.util.Locale;


//https://programmers.co.kr/learn/courses/30/lessons/72410
public class 신규아이디추천 {
    public static void main(String[] args) {
        신규아이디추천 s = new 신규아이디추천();
        String new_id = "abcdefghijklmn.p";
        System.out.println(s.solution(new_id));

    }
    public String solution(String new_id) {
        //1단계
        StringBuilder id = new StringBuilder();
        new_id = new_id.toLowerCase(Locale.ROOT);

        //2단계 and 3단계 and 4단계
        int dot = 0;
        for(int i = 0; i < new_id.length(); i++){
            if('a' <= new_id.charAt(i) && 'z' >= new_id.charAt(i)){
                id.append(new_id.charAt(i));
                dot = 0;
            }else if('0' <= new_id.charAt(i) && '9' >= new_id.charAt(i)){
                id.append(new_id.charAt(i));
                dot = 0;
            }else if('-' == new_id.charAt(i) || '_' == new_id.charAt(i)){
                id.append(new_id.charAt(i));
                dot = 0;
            }else if('.' == new_id.charAt(i) && dot == 0){
                if(id.length() == 0){
                    continue;
                }else if(i == new_id.length()-1){
                    continue;
                }
                id.append(new_id.charAt(i));
                dot++;
            }
        }
        if(id.length() != 0) {
            if (id.charAt(0) == '.') {
                id.delete(0, 1);
            }
            if (id.charAt(id.length() - 1) == '.') {
                id.delete(id.length() - 1, id.length());
            }
        }

        if(id.length() == 0){
            id.append("a");
        }
        //     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(id.length() >= 16){
            String tmp = "";
            if(id.charAt(14) == '.'){
                tmp = id.substring(0,14);
            }else{
                tmp = id.substring(0,15);
            }
            id = new StringBuilder();
            id.append(tmp);
        }

        //     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(id.length() <= 2){
            while(id.length() < 3) {
                id.append(id.charAt(id.length() - 1));
            }
        }

        return id.toString();
    }
}

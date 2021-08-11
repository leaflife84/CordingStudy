package Programmers.level2;

import java.util.HashMap;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/17683 (방금그곡)
public class SkillCheck2 {
    public static void main(String[] args) {
        SkillCheck2 skill = new SkillCheck2();
        String m = "ABC";
        String[]musicinfos =  {"00:00,00:06,HI,ABC#ABC"};
        System.out.println(skill.solution(m,musicinfos));
    }

    public String solution(String m, String[] musicinfos) {
        int melodyLength = 0;
        String melodyName = "(None)";
        for(int i = 0; i < musicinfos.length; i++){
            String startTime = musicinfos[i].split(",")[0];
            String endTime = musicinfos[i].split(",")[1];
            int time = calTime(startTime,endTime);
            String musicName = musicinfos[i].split(",")[2];
            String melody = musicinfos[i].split(",")[3];
            //C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개
            melody = melody.replaceAll("C#","c");
            melody = melody.replaceAll("D#","d");
            melody = melody.replaceAll("F#","f");
            melody = melody.replaceAll("G#","g");
            melody = melody.replaceAll("A#","a");

            m = m.replaceAll("C#","c");
            m = m.replaceAll("D#","d");
            m = m.replaceAll("F#","f");
            m = m.replaceAll("G#","g");
            m = m.replaceAll("A#","a");
            StringBuilder resultMelody = new StringBuilder();
            int index = melody.length();
            if(time >= melody.length()){
                while(index <= time){
                    resultMelody.append(melody);
                    index += melody.length();
                }
                index -= melody.length();
            }
            for(int j = 0; j < time%melody.length(); j++){
                resultMelody.append(melody.charAt(j));
            }
            if(isOk(resultMelody,m)){
                if(melodyLength < time){
                    melodyLength = time;
                    melodyName = musicName;
                }
            }

        }
        return melodyName;
    }

    public boolean isOk(StringBuilder resultMelody, String m){
        int count = 0;
        for(int i = 0; i < resultMelody.length(); i++){
            if(m.charAt(0) == resultMelody.charAt(i)){
                for(int j = 0; j < m.length(); j++){
                    if(j+i < resultMelody.length() && m.charAt(j) == resultMelody.charAt(j+i)){
                        count++;
                    }
                }

                if(m.length() == count){
                    return true;
                }else{
                    count = 0;
                }
            }
        }
        return false;
    }

    public int calTime(String start, String end){
        int result = 0;
        int endH = Integer.parseInt(end.split(":")[0]);
        int startH = Integer.parseInt(start.split(":")[0]);
        int endM = Integer.parseInt(end.split(":")[1]);
        int startM = Integer.parseInt(start.split(":")[1]);

        result = (endH-startH)*60; //시간을 분으로 환산
        result += (endM-startM);
        return result;


    }
}

package WB_TEST;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.solution("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b");

    }
    static String[] music = new String[]{"mp3","aac","flac"};
    static String[] images = new String[]{"jpg", "bmp", "gif"};
    static String[] movies = new String[]{"mp4","avi","mkv"};
    public String solution(String S) {

        String[] fileN = S.split("\\n");
        String look = "";
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("music",0);
        map.put("images",0);
        map.put("movies",0);
        map.put("other",0);

        for(int n = 0; n < fileN.length; n++) {
            String[] file = fileN[n].split(" ");
            for(int i = 0; i < file.length; i++) {
                if (i % 2 == 0) { //파일명
                    int lastIndex = file[i].lastIndexOf(".");
                    String name = file[i].substring(lastIndex + 1, file[i].length());
                    look = checkFile(name);
                } else { //용량
                    String fileSize = file[i].substring(0, file[i].length() - 1);
                    map.put(look, map.get(look)+Integer.parseInt(fileSize));
                }
            }
        }
        result.append(mapInset("music",map));
        result.append(mapInset("images",map));
        result.append(mapInset("movies",map));
        result.append(mapInset("other",map));
        return result.toString();
    }

    public String checkFile(String name){
        for(String s : music){
            if(s.equals(name)){
                return "music";
            }
        }

        for(String s : images){
            if(s.equals(name)){
                return "images";
            }
        }

        for(String s : movies){
            if(s.equals(name)){
                return "movies";
            }
        }
        return "other";
    }

    public StringBuilder mapInset(String key, HashMap<String, Integer> map){
        StringBuilder result = new StringBuilder();
        result.append(key);
        result.append(" ");
        result.append(map.get(key));
        result.append("b");
        result.append("\n");
        return result;
    }
}


package kakao.enter;

public class test1 {
    public static void main(String[] args) {
        test1 t = new test1();
        System.out.println(t.solution("qyyigoptvfb","abcdefghijk",11));
    }

    public String solution(String encrypted_text, String  key, int rotation){
        char[] list = new char[encrypted_text.length()];
        for (int i = 0; i < encrypted_text.length(); i++) {
            int shift = Math.abs(i - rotation) % encrypted_text.length();
            if(rotation > 0) {
                if (i - rotation < 0 ) {
                    shift = encrypted_text.length() - shift;
                }
            }
            list[shift] = encrypted_text.charAt(i);
        }
        for (int i = 0; i < list.length; i++) {
            int index = list[i] - key.charAt(i) + 'a' - 1;
            if(index < 97){
                index += 26;
            }
            char test = (char)index;
            list[i] = (char)(index);
        }
        return String.valueOf(list);
    }
}

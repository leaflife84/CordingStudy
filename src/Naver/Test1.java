package Naver;
//
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t.solution("bb"));
    }
    public int solution(String S) {
        int count = 0;
        int total = 0;
        for(int i = 0; i < S.length(); i++){
            if(count == 3){
                return -1;
            }
            if(S.charAt(i) == 'a'){
                count++;
            }else{
                total += 2-count;
                count = 0;
            }
        }
        return total += 2-count;
    }
}

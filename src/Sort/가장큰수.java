package Sort;



import java.util.*;

class 가장큰수 {
    public static void main(String[] args) {
        가장큰수 s = new 가장큰수();
        int[] numbers = {0,0,0,0};
        System.out.println(s.solution(numbers));

    }


    public String solution(int[] numbers) {
        //실행한 결괏값 "9 5 3 34 30"이(가) 기댓값 "9 5 34 3 30"와(과) 다릅니다.
        String answer = "";
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(num, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if((o1+o2).compareTo(o2+o1) > 0){
                    return -1;
                }else if((o1+o2).compareTo(o2+o1) < 0){
                    return  1;
                }else{
                    return 0;
                }
            }

        });
        String s = String.valueOf(num[0]);
        for(int j = 0; j < num.length; j++) {
            String st = String.valueOf(num[j]);
            answer += st;
        }
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        return answer;
    }
}
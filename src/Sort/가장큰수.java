package Sort;



import java.util.*;

class 가장큰수 {
    public static void main(String[] args) {
        가장큰수 s = new 가장큰수();
        int[] numbers = {3, 30, 34, 5, 9};
        s.solution(numbers);

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
                int size = o1.length();
                if(size < o2.length()) {
                    size = o2.length();
                }
                //동일한 크기인 경우
                if(o1.length() == o2.length()) {
                    if(Integer.parseInt(o1) > Integer.parseInt(o2)) {
                        return -1;
                    }else if(Integer.parseInt(o1) > Integer.parseInt(o2)) {
                        return 1;
                    }else {
                        return 0;
                    }
                }
                //동일 크기가 아닌경우
                for(int i = 0; i < size; i++) { // 7, 91
                    if(o1.charAt(i) > o2.charAt(i)) {
                        if(o1.length() < o2.length()) { // 9, 71
                            return -1;
                        }else if(o1.length() > o2.length()) { // 7, 91 or 7, 71
                            return 1;
                        }else {

                        }

                    }
                }
                return 0;
            }

        });
        Arrays.sort(num, Collections.reverseOrder()); // 34, 30, 9, 5, 3
        String s = String.valueOf(num[0]);
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < num.length; j++) {
                String st = String.valueOf(num[j]);
                if(st.length() == i) {
                    answer += st;
                }
            }

        }
        return answer;
    }
}
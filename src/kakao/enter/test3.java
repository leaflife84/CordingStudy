package kakao.enter;

public class test3 {
    public static void main(String[] args) {
        test3 t = new test3();
        System.out.println(t.solution());
    }

    int solution () {
        int qq = 1000000000;
        int n = 15;
        int answer = -1;
        int index=1; //자릿수

        for (int i=1; i<100; i++) {
            if(n>9*i*Math.pow(10, i-1)) {
                n -= 9 * i * Math.pow(10, i - 1);
            }
            else {
                index=i; break;
            }
        }

        int num = (int)Math.pow(10, index-1);

        num += n/index;

        n -= (n/index) * index;

        if(n==0) {
            if(num-1>qq) {
                return answer;
            } else {
                char v = (((num-1)+"").charAt(index-1));
                answer = Character.getNumericValue(((num-1)+"").charAt(index-1));
                return answer;
            }
        }
        else {
            if(num>qq) {
                return answer;
            } else {
                answer = Character.getNumericValue((num+"").charAt(n-1));
                return answer;
            }
        }
    }
}

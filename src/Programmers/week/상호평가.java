package Programmers.week;

public class 상호평가 {
    public static void main(String[] args) {

        int[][] scores = {{75, 50, 100}, {75, 100, 20}, {100, 100, 20}};
        상호평가 s = new 상호평가();
        System.out.println(s.solution(scores));
    }
    public String solution(int[][] scores) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        double[] avg = new double[scores.length];

        for(int i = 0; i < scores.length; i++){
            boolean isCheck = false;
            int myScore = scores[i][i];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < scores.length; j++){
                if(i != j){
                    avg[i] += scores[j][i];
                    min = Math.min(min, scores[j][i]);
                    max = Math.max(max, scores[j][i]);
                }

            }
            if(min <= myScore && max >= myScore){
                avg[i] = (avg[i]+myScore)/scores.length;
            }else{
                avg[i] = (avg[i])/(scores.length-1);
            }

            if(avg[i] >= 90){
                result.append("A");
            }else if(avg[i] >= 80){
                result.append("B");
            }else if(avg[i] >= 70){
                result.append("C");
            }else if(avg[i] >= 50){
                result.append("D");
            }else{
                result.append("F");
            }
        }
        return result.toString();
    }
}

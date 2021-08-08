package WB_TEST;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        int[] C = {2,0,2,0};
        t.solution(2,2,C);

    }

    static ArrayList<String> zero = new ArrayList<>();
    static ArrayList<String> one = new ArrayList<>();
    static StringBuilder res = new StringBuilder();
    static int uValue;
    static int lValue;
    static boolean isTrue = false;
    //U = 3, L = 2, [2,1,1,0,1]
    public String solution(int U, int L, int[] C) {
        uValue = U;
        lValue = L;
        dfs(0,C);
        if(res.length() == 0){
            res.append("IMPOSSIBLE");
        }
        return res.toString();
    }

    public void dfs(int index,int[] C){
        if(uValue < 0 || lValue < 0 || isTrue){
            return;
        }else if(uValue == 0 && lValue == 0 && index > C.length-1){
            for(String s : zero){
                res.append(s);
            }
            res.append(", ");
            for(String s : one){
                res.append(s);
            }
            isTrue = true;
            return;
        }else if(index > C.length-1){
            return;
        }


        if(C[index] == 2){
            uValue--;
            lValue--;
            zero.add("1");
            one.add("1");
            dfs(index+1,C);
            zero.remove(zero.size()-1);
            one.remove(one.size()-1);
            uValue++;
            lValue++;
        }else if(C[index] == 1){
            uValue--;
            zero.add("1");
            one.add("0");
            dfs(index+1,C);
            zero.remove(zero.size()-1);
            one.remove(one.size()-1);
            uValue++;

            lValue--;
            zero.add("0");
            one.add("1");
            dfs(index+1,C);
            zero.remove(zero.size()-1);
            one.remove(one.size()-1);
            lValue++;
        }else{
            zero.add("0");
            one.add("0");
            dfs(index+1,C);
            zero.remove(zero.size()-1);
            one.remove(one.size()-1);
        }
    }
}

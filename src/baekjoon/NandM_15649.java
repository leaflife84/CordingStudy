package baekjoon;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NandM_15649 {
    static int N;
    static int M;

    static class Scan{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int nextInt() throws Exception {
            if( st == null || !st.hasMoreTokens() ){
                st = new StringTokenizer( in.readLine() );
            }
            return Integer.parseInt( st.nextToken() );
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/baekjoon/file/15649.txt")); //4 2
        //Scan sc = new Scan();
        N = sc.nextInt(); //4
        M = sc.nextInt(); //2
        dfs(new int[M], 0, new boolean[N]);


    }

    public static void dfs(int[] list, int num, boolean[] visited){
        if(M == num){
            for(Integer i : list){
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                list[num] = i+1;
                visited[i] = true;
                dfs(list, num + 1, visited);
                visited[i] = false;
            }
        }

    }
}

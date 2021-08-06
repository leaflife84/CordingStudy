package DFSandBFS;

import java.util.*;

/*
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
* */
public class 여행경로 {
    static ArrayList<String> result = new ArrayList<>();
    static String[] tmp;
    static int visit[];
    public static void main(String[] args) {
        Solution s = new Solution();
//        String[][] tic = {{"ICN", "B"},
//                          {"B", "ICN"},
//                          {"ICN", "A"},
//                          {"A", "D"},
//                          {"D", "A"}};
        String[][] tic = {{"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL","SFO"}};
        String[] answer = s.solution(tic);
        System.out.println(Arrays.asList(answer).toString());
    }

    static class Solution {
        public String[] solution(String[][] tickets) {
            visit = new int[tickets.length]; //티켓사용여부
            tmp = new String[tickets.length];
            dfs("ICN",0,tickets);

            //String[] answer = res.toArray(new String[res.size()]);
            String[] answer = tmp;
            return answer;
        }
        public void dfs(String start,int v, String[][] tickets){
            if(v == tickets.length){
                result.add(start);
                if(Arrays.asList(tmp).toString().compareTo(result.toString()) >= -1){
                    tmp = result.toArray(new String[result.size()]);
                }
                result.remove(result.size()-1);
                return;
            }
            for(int i = 0; i < tickets.length; i++){
                if(visit[i] == 0 && tickets[i][0].equals(start)){
                    result.add(start);
                    visit[i] = 1; //티켓 사용
                    dfs(tickets[i][1],v+1,tickets);
                    visit[i] = 0; //티켓 미사용
                    result.remove(result.size()-1);
                }
            }
        }


    }
}

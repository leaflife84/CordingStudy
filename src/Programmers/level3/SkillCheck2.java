import java.util.*;
class Solution {
    static class ANS implements Comparable<ANS> {
        int x;
        int y;
        int a;

        public ANS(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }

        @Override
        public int compareTo(ANS o) {
            if (this.x == o.x) {
                if (this.y == o.y) {
                    if (this.a > o.a)
                        return 1;
                    return -1;
                }

                if (this.y > o.y)
                    return 1;
                return -1;

            }
            if (this.x > o.x)
                return 1;
            return -1;
        }
    }

    static int map[][][];
    static int N;

    public int[][] solution(int n, int[][] build_frame) {
        map = new int[n + 1][n + 1][2];
        N = n;
        for (int s = 0; s < build_frame.length; s++) {
            int x = build_frame[s][0];
            int y = build_frame[s][1];
            int a = build_frame[s][2];
            int b = build_frame[s][3];

            // 제작 안될시 무시
            if (!check(x, y, a, b))
                continue;


            // 제거
            if (b == 0) {
                map[x][y][a] = 0;
            }
            // 설치
            else {
                map[x][y][a] = 1;
            }
        }

        List<ANS> ansList = new ArrayList<ANS>();

        // map을 돌면서 구조물 담기
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (map[i][j][0] == 1) {
                    ansList.add(new ANS(i, j, 0));
                }

                if (map[i][j][1] == 1) {
                    ansList.add(new ANS(i, j, 1));
                }
            }
        }

        Collections.sort(ansList);

        int[][] answer = new int[ansList.size()][3];

        for (int s = 0; s < ansList.size(); s++) {
            ANS l = ansList.get(s);
            answer[s][0] = l.x;
            answer[s][1] = l.y;
            answer[s][2] = l.a;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1] + " " + answer[i][2]);
        }

        return answer;
    }
    // 귀찮으니간 전수조사 함수 대체
    public static boolean check(int x, int y, int a, int b) {
        if (b == 0) {
            map[x][y][a] = 0;
        } else {
            map[x][y][a] = 1;
        }

        boolean isPossible = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (map[j][i][0] == 1) {
                    // 밑이 기둥
                    if(map[j][i-1][0]==1) {

                    }
                    // 왼쪽 보
                    else if(j>0&& map[j-1][i][1]==1) {

                    }
                    /// 현재 보
                    else if(j<N&& map[j][i][1]==1) {

                    }
                    //세개다 아니면 설치 X
                    else {
                        isPossible=false;
                        break;
                    }
                }

                if (map[j][i][1] == 1) {
                    // 밑이 기둥
                    if(map[j][i-1][0]==1) {

                    }
                    // 오른쪽 밑 기둥
                    else if(j<N&&map[j+1][i-1][0]==1) {

                    }
                    //양 옆이 보
                    else if(j>0 && j<N && map[j-1][i][1]==1 && map[j+1][i][1]==1) {

                    }
                    // 세개다 아니면 설치 X
                    else {
                        isPossible=false;
                        break;
                    }

                }
            }

            if (!isPossible)
                break;
        }

        System.out.println(isPossible);

        if (isPossible)
            return true;

        if (b == 0) {
            map[x][y][a] = 1;
        } else {
            map[x][y][a] = 0;
        }

        return false;
    }
}
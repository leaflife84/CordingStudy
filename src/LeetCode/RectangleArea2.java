package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class RectangleArea2 {
    public static void main(String[] args) {
        RectangleArea2 r = new RectangleArea2();
        int[][] rectangles = {{0,0,2,2},
                              {1,0,2,3},
                              {1,0,3,1}};
        r.rectangleArea(rectangles);
    }

    /*
    * 로직
    * 1. 겹치지 않는 2차원 배열 생성
    * 2. 기존 사각형 값 돌리면서 체크 시작(for)
    *    2.1 기존값과 비교하여 가로,세로 범위를 벗어나는 경우 사격형 값 그대로 유지
    *    2.2 기존값과 비교하여 겹치는 경우 발생 시 겹치지 않는 사격형으로 변환
    *    2.3 모든 값 확인 후 변경된 사각형을 겹치지 않는 2차원 배열에 넣어줌
    *    2.4 2차원 배열에 넣고 넣은 사각형의 크기를 저장장
   * */

    private class Rec{
        int x1;
        int x2;
        int y1;
        int y2;
        Rec(int _x1, int _x2, int _y1, int _y2){
            x1 = _x1;
            x2 = _x2;
            y1 = _y1;
            y2 = _y2;
        }
    }
    public int rectangleArea(int[][] rectangles) {
        ArrayList<Rec> list = new ArrayList<>();
        for(int i = 0; i < rectangles.length; i++){
            int size = (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
            if(list.size() == 0){
                list.add(new Rec(rectangles[i][0],rectangles[i][1],rectangles[i][2],rectangles[i][3]));
            }else{
                for(Rec rec : list){
                    //가로체크 (작은경우, 포함되는 경우, 큰 경우)
                }
            }
        }
        return 1;
    }
}

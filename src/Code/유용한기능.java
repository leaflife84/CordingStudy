package Code;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 유용한기능 {
    public static void main(String[] args) throws Exception {
        
        //텍스트파일을 읽어 넣는 기능
        System.setIn(new FileInputStream("input3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = Integer.parseInt(input);
    }

}

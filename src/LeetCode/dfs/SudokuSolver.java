package LeetCode.dfs;

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        s.solveSudoku(board);
        System.out.println(board);
    }

    public void solveSudoku(char[][] board) {
        backTracking(0,board);
    }
    public boolean backTracking(int index, char[][] board){
        if(index > 80){
            return true;
        }
        int h = index == 0 ? 0 : index/9;
        int w = index == 0 ? 0 : index%9;
//        if(index == 0){
//           // h = 0;
//            w = 0;
//        }else{
//            h = index/9;
//            w = index%9;
//        }
        if (board[h][w] == '.') {
            for(int i = 1; i <= 9; i++){
                board[h][w] = Character.forDigit(i,10);
                if(isValid(h,w,board)){
                    if(backTracking(index+1,board)){
                        return true;
                    }
                }
            }
            board[h][w] = '.';
            return false;
        }else{
            return backTracking(index + 1, board);
        }
    }

    public boolean isValid(int h, int w, char[][] board){
        char checkNumber = board[h][w];
        for(int i = 0; i < 9; i++){
            if(i!=w && board[h][i] == checkNumber){
                return false;
            }
            if(i!=h && board[i][w] == checkNumber){
                return false;
            }
            int checkHeight = i/3 + ((h/3)*3);
            int checkWidth = i%3 + ((w/3)*3);
            if(checkHeight != h && checkWidth != w && board[checkHeight][checkWidth] == checkNumber){
                return false;
            }
        }
        return true;
    }

}

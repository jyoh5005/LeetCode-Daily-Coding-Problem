class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<Character>();
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ceil = board[r][c];
                if(ceil > '0'){
                    if(hs.contains(ceil)) return false;
                    else hs.add(ceil);
                }
            }
            hs.clear();
        }
        for(int c = 0; c < 9; c++){
            for(int r = 0; r < 9; r++){
                char ceil = board[r][c];
                if(ceil > '0'){
                    if(hs.contains(ceil)) return false;
                    else hs.add(ceil);
                }
            }
            hs.clear();
        }
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                for(int r = 0; r < 3; r++){
                    for(int c = 0; c < 3; c++){
                        char ceil = board[row*3+r][col*3+c];
                        if(ceil > '0'){
                            if(hs.contains(ceil)) return false;
                            else hs.add(ceil);
                        }
                    }
                }
                hs.clear();
            }
        }
        return true;
    }
}
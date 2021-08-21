class Solution {
    private ArrayList<HashSet<Character>> row;
    private ArrayList<HashSet<Character>> col;
    private ArrayList<HashSet<Character>> cub;
    public void solveSudoku(char[][] board) {
        row = new ArrayList<>();
        col = new ArrayList<>();
        cub = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            row.add(new HashSet<Character>());
            col.add(new HashSet<Character>());
            cub.add(new HashSet<Character>());
        }
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char cell = board[r][c];
                if(cell > '0'){
                    row.get(r).add(cell);
                    col.get(c).add(cell);
                    cub.get((r/3)*3+c/3).add(cell);
                }
            }
        }
        solve(board, 0, 0);
    }
    private boolean solve(char[][] board, int r, int c){
        if(c == 9) return solve(board, r+1, 0);
        if(r == 9) return true;
        if(board[r][c] > '0') return solve(board, r, c+1);
        for(char x = '1'; x <= '9'; x++){
            if(row.get(r).contains(x)) continue;
            if(col.get(c).contains(x)) continue;
            if(cub.get((r/3)*3+c/3).contains(x)) continue;
            
            board[r][c] = x;
            row.get(r).add(x);
            col.get(c).add(x);
            cub.get((r/3)*3+c/3).add(x);
            
            if(solve(board, r, c)) return true;
            
            board[r][c] = '.';
            row.get(r).remove(x);
            col.get(c).remove(x);
            cub.get((r/3)*3+c/3).remove(x);
        }
        return false;
    }
}
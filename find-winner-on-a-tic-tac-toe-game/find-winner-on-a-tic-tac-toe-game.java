class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        int isA = 1;
        for(int[] move : moves){
            board[move[0]][move[1]] = isA;
            if(board[0][0]+board[0][1]+board[0][2] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[1][0]+board[1][1]+board[1][2] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[2][0]+board[2][1]+board[2][2] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[0][0]+board[1][0]+board[2][0] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[0][1]+board[1][1]+board[2][1] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[0][2]+board[1][2]+board[2][2] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[0][0]+board[1][1]+board[2][2] == isA * 3){
                isA *= 2;
                break;
            }
            if(board[0][2]+board[1][1]+board[2][0] == isA * 3){
                isA *= 2;
                break;
            }
            isA = -isA;
        }
        if(isA == 2) return "A";
        else if(isA == -2) return "B";
        else if(moves.length == 9) return "Draw";
        else return "Pending";
    }
}
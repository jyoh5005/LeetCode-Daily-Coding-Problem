class Solution {
    public int largestIsland(int[][] grid) {
        ArrayList<Integer> area = new ArrayList<Integer>();
        Stack<Integer> xStack = new Stack<Integer>();
        Stack<Integer> yStack = new Stack<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        int tag = 0;
        int rs = grid.length;
        int cs = grid[0].length;
        for(int i = 0; i < rs; i++){
            for(int j = 0; j < cs; j++){
                if(grid[i][j] == 1){
                    xStack.push(i);
                    yStack.push(j);
                    grid[i][j] = --tag;
                    int area_size = 0;
                    while(!xStack.empty()){
                        int x = xStack.peek();
                        int y = yStack.peek();
                        xStack.pop();
                        yStack.pop();
                        area_size++;
                        if(x > 0){
                            if(grid[x-1][y] == 1){
                                xStack.push(x-1);
                                yStack.push(y);
                                grid[x-1][y] = tag;
                            }
                            if(grid[x-1][y] == 0) grid[x-1][y] = 2;
                        }
                        if(y > 0){
                            if(grid[x][y-1] == 1){
                                xStack.push(x);
                                yStack.push(y-1);
                                grid[x][y-1] = tag;
                            }
                            if(grid[x][y-1] == 0) grid[x][y-1] = 2;
                        }
                        if(x < rs-1){
                            if(grid[x+1][y] == 1){
                                xStack.push(x+1);
                                yStack.push(y);
                                grid[x+1][y] = tag;
                            }
                            if(grid[x+1][y] == 0) grid[x+1][y] = 2;
                        }
                        if(y < cs-1){
                            if(grid[x][y+1] == 1){
                                xStack.push(x);
                                yStack.push(y+1);
                                grid[x][y+1] = tag;
                            }
                            if(grid[x][y+1] == 0) grid[x][y+1] = 2;
                        }
                    }
                    area.add(area_size);
                }
            }
        }
        
        if(area.size() == 0) return 1;
        if(area.get(0) == rs * cs) return rs * cs;
        
        tag = 0;
        for(int x = 0; x < rs; x++){
            for(int y = 0; y < cs; y++){
                if(grid[x][y] == 2){
                    int area_size = 1;
                    if(x > 0 && grid[x-1][y] < 0) set.add(-grid[x-1][y]-1);
                    if(y > 0 && grid[x][y-1] < 0) set.add(-grid[x][y-1]-1);
                    if(x < rs-1 && grid[x+1][y] < 0) set.add(-grid[x+1][y]-1);
                    if(y < cs-1 && grid[x][y+1] < 0) set.add(-grid[x][y+1]-1);
                    
                    for(Iterator<Integer> it = set.iterator();
                        it.hasNext();
                        area_size += area.get(it.next()));
                    set.clear();
                    if(tag < area_size) tag = area_size;
                }
            }
        }
        return tag;
    }
}
package Week_07;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    /*
    // DFS
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ++sum;
                    dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    public void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r >= nr || c >= nc || r < 0 || c < 0 || grid[r][c] == '0') {
            return ;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r , c - 1);
    }*/

    /*
    // BFS
    public int numIslands(char[][] grid) {
         if (grid == null || grid.length == 0) return 0;
         int isLandsSum = 0;
         int nr = grid.length;
         int nc = grid[0].length;
         Queue<Integer> queue = new LinkedList<>();
         for (int i = 0; i < nr; i++) {
             for (int j = 0; j < nc; j++) {
                 if (grid[i][j] == '1') {
                     ++isLandsSum;
                     grid[i][j] = '0';
                     queue.add(i * nc + j);
                     while (!queue.isEmpty()) {
                         int index = queue.remove();
                         int row = index / nc;
                         int column = index % nc;
                         if (row - 1 >= 0 && grid[row - 1][column] == '1') {
                             queue.add((row - 1) * nc + column);
                             grid[row - 1][column] = '0';
                         }
                         if (row + 1 < nr && grid[row + 1][column] == '1') {
                             queue.add((row + 1) * nc + column);
                             grid[row + 1][column] = '0';
                         }
                         if (column - 1 >= 0 && grid[row][column - 1] == '1') {
                             queue.add(row * nc + column - 1);
                             grid[row][column - 1] = '0';
                         }
                         if (column + 1 < nc && grid[row][column + 1] == '1') {
                             queue.add(row * nc + column + 1);
                             grid[row][column + 1] = '0';
                         }
                     }
                 }
             }
         }
         return isLandsSum;
     }*/
    // 并查集
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    ++rank[rootx];
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int isLandsNum = 0;
        UnionFind unionFind = new UnionFind(grid);
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        unionFind.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        unionFind.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        unionFind.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        unionFind.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

}
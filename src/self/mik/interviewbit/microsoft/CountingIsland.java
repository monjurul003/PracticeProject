package self.mik.interviewbit.microsoft;

public class CountingIsland {
    private boolean[][] visited;
    private int m, n;

    private void DFS(int[][] grid, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                visited[i][j] = true;
                DFS(grid, i - 1, j);
                DFS(grid, i + 1, j);
                DFS(grid, i, j - 1);
                DFS(grid, i, j + 1);
            }
        }
    }

    public int countIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    private void printMatrix(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public void testCountingIsland(){
        int[][] grid = {{1,0,1,1},{1,1,1,0}, {0,1,0,0}, {0,0,1,1}};
        printMatrix(grid);
        System.out.println();
        System.out.println("Number of Island: "+ countIsland(grid));

    }
}

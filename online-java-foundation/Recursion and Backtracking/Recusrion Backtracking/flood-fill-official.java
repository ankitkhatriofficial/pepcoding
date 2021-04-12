import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    public static void floodfill(int[][] maze, int sr, int sc, String psf, boolean[][] visited) {
        
        if(sr == maze.length - 1 && sc == maze[0].length - 1){
            System.out.println(psf);
            return;
        }else if(sr < 0 || sr == maze.length || sc < 0 || sc == maze[0].length || visited[sr][sc] == true || maze[sr][sc] == 1){
            return;
        }
        
        visited[sr][sc] = true;
        floodfill(maze, sr - 1, sc, psf + "t", visited);
        floodfill(maze, sr, sc - 1, psf + "l", visited);
        floodfill(maze, sr + 1, sc, psf + "d", visited);
        floodfill(maze, sr, sc + 1, psf + "r", visited);
        visited[sr][sc] = false;
    }
}
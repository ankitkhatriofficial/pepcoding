import java.io.*;
import java.util.*;

public class Main {

    public static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
            print(arr);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (isValidPlaceHorizontally(arr, i, j, word) == true) {
                        boolean[] wePlaced = placeHorizontally(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        unplaceHorizontally(arr, wePlaced, i, j);
                    }
                    if (isValidPlaceVertically(arr, i, j, word) == true) {
                        boolean[] wePlaced = placeVertically(arr, i, j, word);
                        solution(arr, words, vidx + 1);
                        unplaceVertically(arr, wePlaced, i, j);
                    }
                }
            }
        }
    }

    public static boolean isValidPlaceHorizontally(char[][] arr, int i, int j, String word) {
        /* looking for the Best fit */
        /* checking left side of placing the word */
        if (j - 1 >= 0 && arr[i][j - 1] != '+')
            return false;
        /* checking right side of placing the word */
        else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+')
            return false;

        for (int col = 0; col < word.length(); col++) {
            if (j + col >= arr[0].length)
                return false;
            else if (arr[i][j + col] != '-' && arr[i][j + col] != word.charAt(col))
                return false;
        }
        return true;
    }

    public static boolean[] placeHorizontally(char[][] arr, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int col = 0; col < word.length(); col++) {
            if (arr[i][j + col] == '-') {
                arr[i][j + col] = word.charAt(col);
                wePlaced[col] = true;
            }
        }
        return wePlaced;
    }

    public static void unplaceHorizontally(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int col = 0; col < wePlaced.length; col++) {
            if (wePlaced[col] == true)
                arr[i][j + col] = '-';
        }
    }

    public static boolean isValidPlaceVertically(char[][] arr, int i, int j, String word) {
        /* looking for the Best fit */
        /* checking Top side of placing the word */
        if (i - 1 >= 0 && arr[i - 1][j] != '+')
            return false;
        /* checking Bottom side of placing the word */
        else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+')
            return false;

        for (int row = 0; row < word.length(); row++) {
            if (i + row >= arr.length)
                return false;
            else if (arr[i + row][j] != '-' && arr[i + row][j] != word.charAt(row))
                return false;
        }
        return true;
    }

    public static boolean[] placeVertically(char[][] arr, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int row = 0; row < word.length(); row++) {
            if (arr[i + row][j] == '-') {
                arr[i + row][j] = word.charAt(row);
                wePlaced[row] = true;
            }
        }
        return wePlaced;
    }

    public static void unplaceVertically(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int row = 0; row < wePlaced.length; row++) {
            if (wePlaced[row] == true)
                arr[i + row][j] = '-';
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }

}
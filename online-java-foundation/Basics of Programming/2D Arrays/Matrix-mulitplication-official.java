import java.io.*;
import java.util.*;

public class Main {

    private static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            return null;
        } else {
            int[][] product = new int[matrix1.length][matrix2[0].length];

                for (int i = 0; i < product.length; i++) {
                    for (int j = 0; j < product[0].length; j++) {
                        for (int k = 0; k < matrix2.length; k++) {
                            product[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                return product;
            }
        }

        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] matrix1 = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix1[i][j] = sc.nextInt();
                }
            }

            row = sc.nextInt();
            col = sc.nextInt();

            int[][] matrix2 = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix2[i][j] = sc.nextInt();
                }
            }

            int[][] product = multiply(matrix1, matrix2);
            if (product == null) {
                System.out.println("Invalid input");
                return;
            }
            for (int i = 0; i < product.length; i++) {
                for (int j = 0; j < product[0].length; j++) {
                    System.out.print(product[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
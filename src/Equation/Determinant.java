/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equation;

/**
 *
 * @author Wandwilson Almeida Da Silva
 * Student name: Carolina Gomes Landim
 */
public class Determinant {

    static void Cofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
        int i = 0, j =0;
        for (int row = 0; row < n; row ++){
            for (int column = 0; column < n; column ++){
                if(row != p && column != q){
                    temp[i][j++] = matrix[row][column];
                    if(j == n-1){
                        j =0;
                        i++;
                    }
                }
                
            }
        }
    }

    static int determinantMatrix(int[][] matrix, int n) {
        int Determinant = 0;
        if(n == 1){
            return matrix[0][0];
        }
        int temp[][] = new int[n][n];
        int multiplicador =1;
        for(int f = 0; f<n; f++){
            Cofactor(matrix, temp, 0, f, n);
            Determinant += multiplicador * matrix[0][f] * determinantMatrix(temp, n-1);
            multiplicador = -multiplicador;
        }
        return Determinant;
    }
    
}

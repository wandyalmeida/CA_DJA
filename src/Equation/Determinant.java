/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equation;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public class Determinant {

    //This method will get the matrix to help the calculator
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

    /*
    This method will get the matrix to give the determinate.
    */
    static int determinantMatrix(int[][] matrix, int number) {
        int Determinant = 0;
        if(number == 1){
            return matrix[0][0];
        }
        int temp[][] = new int[number][number];
        int multiplier =1;
        for(int f = 0; f<number; f++){
            Cofactor(matrix, temp, 0, f, number);
            Determinant += multiplier * matrix[0][f] * determinantMatrix(temp, number-1);
            multiplier = -multiplier;
        }
        return Determinant;
    }
    
}

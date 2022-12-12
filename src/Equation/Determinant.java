/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equation;

/**
 *
 * @author wandw
 */
public class Determinant {

    static void obterCofactor(int[][] matriz, int[][] temp, int p, int q, int n) {
        int i = 0, j =0;
        for (int fila = 0; fila < n; fila ++){
            for (int columna = 0; columna < n; columna ++){
                if(fila != p && columna != q){
                    temp[i][j++] = matriz[fila][columna];
                    if(j == n-1){
                        j =0;
                        i++;
                    }
                }
                
            }
        }
    }

    static int determinantMatrix(int[][] matriz, int n) {
        int Determinant = 0;
        if(n == 1){
            return matriz[0][0];
        }
        int temp[][] = new int[n][n];
        int multiplicador =1;
        for(int f = 0; f<n; f++){
            obterCofactor(matriz, temp, 0, f, n);
            Determinant += multiplicador * matriz[0][f] * determinantMatrix(temp, n-1);
            multiplicador = -multiplicador;
        }
        return Determinant;
    }
    
}

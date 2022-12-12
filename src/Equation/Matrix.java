/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equation;

import LOGIN.login;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author wandw
 */
public class Matrix implements MatrixInterface {

    login lg = new login();
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void Matrix_2X2(int num, int id_user) {
        System.out.println(
            "Enter the coefficients variable");
        System.out.println(
            "Enter in the format shown below");
        System.out.println("ax + by + cz = d");
       
        // Input of coefficients from user
        int[][] matrix = new int[num][num];
        int[] constt = new int[num];
        int[][] matrix1 = new int[num][num];
        int[][] matrix2 = new int[num][num];
        
        for (int i = 0; i < num; i++) {
            
            for (int j = 0; j < num; j++) {

                System.out.println("matrix ["+i+"]["+j+"]");
                matrix[i][j] = sc.nextInt();
                
            }
            System.out.println("const ["+ i +"] =");
            constt[i] = sc.nextInt();
            
        }
        
        // Representation of linear equations in form of
        // matrix
        System.out.println(
            "Matrix representation of above linear equations is: ");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix1[i][j] = matrix[i][j];
                matrix1[i][0] = constt[i];
                matrix2[i][j] = matrix[i][j];
                matrix2[i][1] = constt[i];
                System.out.print(" " + matrix[i][j]);
                

            }
//            System.out.print("  " + variable[i]);
            System.out.print("  =  " + constt[i]);
            
            System.out.println();
        }
        int determitationM =Determinant.determinantMatrix(matrix, num);
        System.out.println("o determinant: " + determitationM);
        
        
        for (int i = 0; i < num; i++) {
        
            for (int j = 0; j < num; j++) {

                System.out.print(" " + matrix1[i][j]);
                
                

            }
            
            System.out.println();
        }
        int determitationX = Determinant.determinantMatrix(matrix1, num);
        System.out.println("o determinant: " + determitationX);
        
        
        for (int i = 0; i < num; i++) {
        
            for (int j = 0; j < num; j++) {
                System.out.print(" " + matrix2[i][j]);
               
                

            }
            
            System.out.println();
        }
        int determitationY =Determinant.determinantMatrix(matrix2, num);
        System.out.println("o determinant: " + determitationY);
              
        System.out.println("X: "+new DecimalFormat().format((double)determitationX / (double)determitationM) + ", Y: "+ new DecimalFormat("#.####").format((double)determitationY / (double)determitationM));
        lg.users(id_user);
    }

    @Override
    public void Matrix_3X3(int num, int id_user) {
        System.out.println(
            "Enter the coefficients variable");
        System.out.println(
            "Enter in the format shown below");
        System.out.println("ax + by + cz = d");
       
        // Input of coefficients from user
        int[][] matrix = new int[num][num];
        int[] constt = new int[num];
        int[][] matrix1 = new int[num][num];
        int[][] matrix2 = new int[num][num];
        int[][] matrix3 = new int[num][num];
  
        
        
        for (int i = 0; i < num; i++) {
            
            for (int j = 0; j < num; j++) {

                System.out.println("matrix ["+i+"]["+j+"]");
                matrix[i][j] = sc.nextInt();
                
            }
            System.out.println("const ["+ i +"] =");
            constt[i] = sc.nextInt();
            
        }
        
        // Representation of linear equations in form of
        // matrix
        System.out.println(
            "Matrix representation of above linear equations is: ");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix1[i][j] = matrix[i][j];
                matrix1[i][0] = constt[i];
                matrix2[i][j] = matrix[i][j];
                matrix2[i][1] = constt[i];
                matrix3[i][j] = matrix[i][j];
                matrix3[i][2] = constt[i];
                System.out.print(" " + matrix[i][j]);
                

            }
//            System.out.print("  " + variable[i]);
            System.out.print("  =  " + constt[i]);
            
            System.out.println();
        }
        int determitationM = Determinant.determinantMatrix(matrix, num);
        System.out.println("o determinant: " + determitationM);
        
        
    for (int i = 0; i < num; i++) {
        
            for (int j = 0; j < num; j++) {

                System.out.print(" " + matrix1[i][j]);
                
                

            }
            
            System.out.println();
        }
        int determitationX = Determinant.determinantMatrix(matrix1, num);
        System.out.println("o determinant: " + determitationX);
        
        
    for (int i = 0; i < num; i++) {

        for (int j = 0; j < num; j++) {

            System.out.print(" " + matrix2[i][j]);



        }

        System.out.println();
    }
    int determitationY = Determinant.determinantMatrix(matrix2, num);
    System.out.println("o determinant: " + determitationY);

    for (int i = 0; i < num; i++) {

         for (int j = 0; j < num; j++) {
        System.out.print(" " + matrix3[i][j]);




    }
    System.out.println();
    }
    DecimalFormat dc = new DecimalFormat();
    int determitationZ = Determinant.determinantMatrix(matrix3, num);
    System.out.println("o determinant: " + determitationZ);
    System.out.println("X: "+dc.format((double)determitationX / (double)determitationM) + ", Y: "+ dc.format((double)determitationY  / (double)determitationM) + ", Z: "+ dc.format((double)determitationZ / (double)determitationM));

//    System.out.println("X: "+new DecimalFormat().format((double)determitationX / (double)determitationM) + ", Y: "+ new DecimalFormat("#.####").format((double)determitationY / (double)determitationM));
        
    
    lg.users(id_user);
    }
    
}
